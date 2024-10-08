SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123456');
FLUSH PRIVILEGES;

-- $ mysql -u root -p
-- $ mysql --skip-ssl

DROP DATABASE IF EXISTS DWES_JavaCrud;
CREATE DATABASE DWES_JavaCrud;
USE DWES_JavaCrud;

CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL UNIQUE,
	stock DECIMAL(5, 2) NOT NULL,
	price DECIMAL(5, 2) NOT NULL,
	creation_date DATETIME NULL,
	modified_date DATETIME NULL,
	PRIMARY KEY (id)
);

DELIMITER $$

CREATE TRIGGER insert_name
BEFORE INSERT ON product
FOR EACH ROW BEGIN
  DECLARE total INT;
  SELECT COUNT(*) INTO total FROM product WHERE name = NEW.name;
  IF total > 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'INSERT ERROR: Product name already exists';
  END IF;
  IF NEW.name = '' OR TRIM(NEW.name) = '' THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'INSERT ERROR: Product name was blank or empty';
  END IF;
END $$

CREATE TRIGGER update_name
BEFORE UPDATE ON product
FOR EACH ROW BEGIN
  DECLARE total INT;
  SELECT COUNT(*) INTO total FROM product WHERE id != NEW.id AND name = NEW.name;
  IF total > 0 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'UPDATE ERROR: Product name already exists';
  END IF;
  IF NEW.name = '' OR TRIM(NEW.name) = '' THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'UPDATE ERROR: Product name was blank or empty';
  END IF;
END $$

DELIMITER ;

INSERT INTO product (name, stock, price, creation_date) VALUES
  ('Wireless Mouse', 150.00, 25.99, '2024-10-04 15:30:00'),
  ('Mechanical Keyboard', 80.00, 79.99, '2024-10-03 10:45:00'),
  ('Gaming Monitor', 50.00, 199.99, '2024-10-02 14:00:00'),
  ('USB-C Cable', 300.00, 9.99, '2024-10-05 12:15:00'),
  ('External Hard Drive', 0.00, 99.49, '2024-10-01 09:20:00'),
  ('Laptop Stand', 120.00, 29.99, '2024-10-04 08:30:00'),
  ('Webcam HD', 60.00, 49.99, '2024-10-03 11:00:00'),
  ('Bluetooth Speaker', 75.00, 39.99, '2024-10-02 16:00:00'),
  ('Smartphone Holder', 200.00, 14.99, '2024-10-01 13:45:00'),
  ('Wireless Charger', 180.00, 19.99, '2024-10-03 17:20:00'),
  ('Portable SSD', 30.00, 129.99, '2024-10-05 09:30:00'),
  ('Noise-Cancelling Headphones', 40.00, 159.99, '2024-10-02 10:10:00'),
  ('Ergonomic Chair', 25.00, 249.99, '2024-10-01 14:30:00'),
  ('Standing Desk', 0.00, 499.99, '2024-10-03 09:00:00'),
  ('Smartwatch', 90.00, 199.99, '2024-10-04 12:50:00'),
  ('Graphics Tablet', 35.00, 99.99, '2024-10-02 11:20:00'),
  ('Power Bank', 250.00, 29.99, '2024-10-01 10:05:00'),
  ('Smart Light Bulb', 300.00, 12.99, '2024-10-04 16:10:00'),
  ('Virtual Reality Headset', 0.00, 299.99, '2024-10-03 15:45:00'),
  ('Fitness Tracker', 100.00, 49.99, '2024-10-05 11:35:00');
