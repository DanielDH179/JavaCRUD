<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://kit.fontawesome.com/4358b9453c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>JavaCRUD | Home</title>
  </head>
  <body>
    <header>
      <h1>JavaCRUD Homepage</h1>
      <nav>
        <a href="products?option=create">
          Add Item <i class="fa-solid fa-circle-plus"></i>
        </a>
        <a href="products?option=list">
          Manage <i class="fa-solid fa-list-check"></i>
        </a>
      </nav>
    </header>
    <div id="top">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
    </div>
    <pre id="logger">
      <c:choose>
        <c:when test="${msg != null}">
          <i class="fa-solid ${msg.isError() ? "fa-bug" : "fa-circle-info"} fa-fade"></i>
          ${msg.toString()}
        </c:when>
        <c:when test="${more != null}">
          <i class="fa-solid fa-bug fa-fade"></i> ${more}
        </c:when>
        <c:otherwise>
          <i class="fa-solid fa-gear fa-spin"></i>
          Welcome! All actions will be printed here :)
        </c:otherwise>
      </c:choose>
    </pre>
  </body>
</html>
