<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://kit.fontawesome.com/4358b9453c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>JavaCRUD | Create</title>
	</head>
	<body>
    <header>
 		  <h1>Create Product</h1>
      <nav>
        <a id="home" href="${pageContext.request.contextPath}">
          Home <i class="fa-solid fa-right-from-bracket"></i>
        </a>
      </nav>
    </header>
 		<form action="products" method="post">
			<input type="hidden" name="option" value="register">
      <p>
        <i class="fa-solid fa-keyboard"></i>
        <input type="text" name="name" placeholder required>
        <label for="name">Name</label>
      </p>
   		<p>
        <i class="fa-solid fa-layer-group"></i>
        <input type="number" min="0" max="999.99" step="0.01" name="stock" placeholder required>
        <label for="stock">Stock</label>
      </p>
   		<p>
        <i class="fa-solid fa-cart-shopping"></i>
        <input type="number" min="0" max="999.99" step="0.01" name="price" placeholder required>
        <label for="price">Price</label>
      </p>
      <div class="buttons">
			  <input type="submit" value="Create Product">
			  <input type="reset" value="Clear">
      </div>
		</form>
	</body>
</html>
