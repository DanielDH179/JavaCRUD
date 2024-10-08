package me.ddmiher880.model;

import java.sql.Timestamp;

public class Product implements Comparable<Product> {

	private Integer id;
	private String name;
	private Double stock, price;
	private Timestamp creationDate, modifiedDate;
	
  /**
   * Constructor con parámetros.
   * 
   * @param id identificador del producto
   * @param name nombre del producto
   * @param stock cantidad en inventario
   * @param price precio del producto
   * @param creationDate fecha de creación
   * @param modifiedDate fecha de última modificación
   */
	public Product(int id, String name, double stock, double price, Timestamp creationDate, Timestamp modifiedDate) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.creationDate = creationDate;
		this.modifiedDate = modifiedDate;
	}
	
  /** Constructor por defecto. */
	public Product() {
  }

  /** @return identificador del producto */
	public int getId() {
		return id;
	}

  /** @param id identificador del producto */
	public void setId(int id) {
		this.id = id;
	}

  /** @return nombre del producto */
	public String getName() {
		return name;
	}

  /** @param name nombre del producto */
	public void setName(String name) {
		this.name = name;
	}

  /** @return cantidad en inventario */
	public double getStock() {
		return stock;
	}

  /** @param stock cantidad en inventario */
	public void setStock(double stock) {
		this.stock = stock;
	}

  /** @return precio del producto */
	public double getPrice() {
		return price;
	}

  /** @param price precio del producto */
	public void setPrice(double price) {
		this.price = price;
	}

  /** @return fecha de creación */
	public Timestamp getCreationDate() {
		return creationDate;
	}

  /** @param creationDate fecha de creación */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

  /** @return fecha de última modificación */
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

  /** @param modifiedDate fecha de última modificación */
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

  /** @return representación del producto en String */
	@Override
	public String toString() {
		return "Product[" + id + ", " + name + ", " + stock + ", " + price + ", " + creationDate + ", " + modifiedDate + "]";
	}

  /**
   * Compara productos por su identificador.
   * 
   * @param other el producto a comparar
   * @return la diferencia de sus identificadores
   */
  @Override
  public int compareTo(Product other) {
    return this.id - other.id;
  }
	
}
