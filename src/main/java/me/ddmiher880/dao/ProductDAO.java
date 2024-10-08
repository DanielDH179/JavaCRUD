package me.ddmiher880.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import me.ddmiher880.config.SQLConnection;
import me.ddmiher880.model.Product;
import me.ddmiher880.utils.ProductException;
import me.ddmiher880.utils.SortCriterion;

public class ProductDAO {
	
	private PreparedStatement ps;
	private String query;

  /**
   * Obtiene una conexión a la base de datos.
   * 
   * @return conexión de base de datos
   * @throws SQLException si ocurre un error de conexión
   */
	private Connection getConnection() throws SQLException {
		return SQLConnection.getConnection();
	}
	
  /**
   * Registra un nuevo producto en la base de datos.
   * 
   * @param p producto a registrar
   * @return true si se registra correctamente, false en caso contrario
   * @throws ProductException si ocurre un error en la consulta
   */
	public boolean register(Product p) throws ProductException {
		
		try (Connection conn = getConnection()) {
			query = "INSERT INTO product (id, name, stock, price, creation_date, modified_date) VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getStock());
			ps.setDouble(4, p.getPrice());
			ps.setTimestamp(5, p.getCreationDate());
			ps.setTimestamp(6, p.getModifiedDate());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// System.out.println(e.getMessage());
      throw new ProductException(e.getMessage());
		}
		
	}
	
  /**
   * Actualiza un producto en la base de datos.
   * 
   * @param p producto a actualizar
   * @return true si se actualiza correctamente, false en caso contrario
   * @throws ProductException si ocurre un error en la consulta
   */
	public boolean update(Product p) throws ProductException {
		
		try (Connection conn = getConnection()) {
			query = "UPDATE product SET name=?, stock=?, price=?, modified_date=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getStock());
			ps.setDouble(3, p.getPrice());
			ps.setTimestamp(4, p.getModifiedDate());
			ps.setInt(5, p.getId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// System.out.println(e.getMessage());
      throw new ProductException(e.getMessage());
		}
		
	}
	
  /**
   * Elimina un producto de la base de datos.
   * 
   * @param id identificador del producto
   * @return true si se elimina correctamente, false en caso contrario
   * @throws ProductException si ocurre un error en la consulta
   */
	public boolean delete(int id) throws ProductException {

		try (Connection conn = getConnection()) {
			query = "DELETE FROM product WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// System.out.println(e.getMessage());
      throw new ProductException(e.getMessage());
		}
		
	}
	
  /**
   * Obtiene una lista de productos según los criterios de ordenación.
   * 
   * @param sc criterio de ordenación
   * @return lista de productos
   * @throws ProductException si ocurre un error en la consulta
   */
	public List<Product> getProducts(SortCriterion sc) throws ProductException {
		
		List<Product> products = new ArrayList<>();
		
		try (Connection conn = getConnection()) {
			query = "SELECT * FROM product" + sc;
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double stock = rs.getDouble(3);
				double price = rs.getDouble(4);
				Timestamp creationDate = rs.getTimestamp(5);
				Timestamp modifiedDate = rs.getTimestamp(6);
				products.add(new Product(id, name, stock, price, creationDate, modifiedDate));
			}
		} catch (SQLException e) {
			// System.out.println(e.getMessage());
      throw new ProductException(e.getMessage());
		}
		
		return products;
		
	}
	
  /**
   * Obtiene un producto por su identificador.
   * 
   * @param id identificador del producto
   * @return producto encontrado o null si no existe
   * @throws ProductException si ocurre un error en la consulta
   */
	public Product getProductById(int id) throws ProductException {
		
		Product p = null;
		
		try (Connection conn = getConnection()) {
			query = "SELECT * FROM product WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString(2);
				double stock = rs.getDouble(3);
				double price = rs.getDouble(4);
				Timestamp creationDate = rs.getTimestamp(5);
				Timestamp modifiedDate = rs.getTimestamp(6);
				p = new Product(id, name, stock, price, creationDate, modifiedDate);
			}
		} catch (SQLException e) {
			// System.out.println(e.getMessage());
      throw new ProductException(e.getMessage());
		}
		
		return p;

	}

}
