package me.ddmiher880.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import me.ddmiher880.dao.ProductDAO;
import me.ddmiher880.model.Product;
import me.ddmiher880.utils.ProductException;
import me.ddmiher880.utils.ServerMessage;
import me.ddmiher880.utils.SortCriterion;

@WebServlet("/products")
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
  /** Constructor por defecto. */
	public ProductController() {
		super();
	}

  /**
   * Maneja las solicitudes GET para productos.
   * 
   * @param request solicitud HTTP
   * @param response respuesta HTTP
   * @throws ServletException en caso de error de servlet
   * @throws IOException en caso de error de entrada/salida
   */
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		String sortBy = request.getParameter("sortBy");
		String desc = request.getParameter("desc");
    SortCriterion sc = new SortCriterion(sortBy, desc);
		ProductDAO dao = new ProductDAO();
    boolean success;

    switch (option) {
      case "create":
        request.getRequestDispatcher("/views/create.jsp").forward(request, response);
        break;
      case "list":
        try {
          request.setAttribute("list", dao.getProducts(sc));
          request.getRequestDispatcher("/views/list.jsp").forward(request, response);
        } catch (ProductException e) {
          System.out.println(e.getMessage());
        }
        break;
      case "edit":
        int id = Integer.parseInt(request.getParameter("id"));
        try {
          request.setAttribute("product", dao.getProductById(id));
          request.getRequestDispatcher("/views/edit.jsp").forward(request, response);
        } catch (ProductException e) {
          System.out.println(e.getMessage());
        }
        break;
      case "delete":
        id = Integer.parseInt(request.getParameter("id"));
        try {
          success = dao.delete(id);
          request.setAttribute("msg", success ? ServerMessage.OK_DELETE : ServerMessage.ERROR_DELETE);
        } catch (ProductException e) {
          // System.out.println(e.getMessage());
          request.setAttribute("more", e.getMessage());
        } finally {
          request.getRequestDispatcher("/index.jsp").forward(request, response);				
        }
        break;
    }
		
	}

  /**
   * Maneja las solicitudes POST para productos.
   * 
   * @param request solicitud HTTP
   * @param response respuesta HTTP
   * @throws ServletException en caso de error de servlet
   * @throws IOException en caso de error de entrada/salida
   */	
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		ProductDAO dao = new ProductDAO();
		Date currentDate = new Date();
		Product p = new Product();
    boolean success;

    switch (option) {
      case "register":
        try {
          p.setName(request.getParameter("name"));
          p.setStock(Double.parseDouble(request.getParameter("stock")));
          p.setPrice(Double.parseDouble(request.getParameter("price")));
          p.setCreationDate(new Timestamp(currentDate.getTime()));
          success = dao.register(p);
          request.setAttribute("msg", success ? ServerMessage.OK_CREATE : ServerMessage.ERROR_CREATE);
        } catch (NumberFormatException | ProductException e) {
          // System.out.println(e.getMessage());
          request.setAttribute("more", e.getMessage());
        } finally {
          request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        break;
      case "edit":
        try {
          p.setId(Integer.parseInt(request.getParameter("id")));
          p.setName(request.getParameter("name"));
          p.setStock(Double.parseDouble(request.getParameter("stock")));
          p.setPrice(Double.parseDouble(request.getParameter("price")));
          p.setModifiedDate(new Timestamp(currentDate.getTime()));
          success = dao.update(p);
          request.setAttribute("msg", success ? ServerMessage.OK_UPDATE : ServerMessage.ERROR_UPDATE);
        } catch (NumberFormatException | ProductException e) {
          // System.out.println(e.getMessage());
          request.setAttribute("more", e.getMessage());
        } finally {
          request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        break;
    }
		
	}

}
