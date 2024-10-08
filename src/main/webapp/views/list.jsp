<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="dateFormat" value="E d MMM yyyy HH:mm:ss" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://kit.fontawesome.com/4358b9453c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>JavaCRUD | Catalog</title>
	</head>
	<body>
    <header>
      <h1>${list.size()} Products</h1>
      <nav>
        <p>Sort By:</p>
        <a class="tooltip" href="products?option=list">
          <p>ID (Ascending)</p>
          <i class="fa-solid fa-arrow-down-1-9"></i>
        </a>
        <a class="tooltip" href="products?option=list&sortBy=name">
          <p>Name (A-Z)</p>
          <i class="fa-solid fa-arrow-down-a-z"></i>
        </a>
        <a class="tooltip" href="products?option=list&sortBy=stock">
          <p>Stock (Low-High)</p>
          <i class="fa-solid fa-layer-group"></i>
        </a>
        <a class="tooltip" href="products?option=list&sortBy=price">
          <p>Price (Low-High)</p>
          <i class="fa-solid fa-dollar-sign"></i>
        </a>
        <a class="tooltip" href="products?option=list&sortBy=creation_date&desc=true">
          <p>Recently Added</p>
          <i class="fa-regular fa-calendar-plus"></i>
        </a>
        <a class="tooltip" href="products?option=list&sortBy=modified_date&desc=true">
          <p>Recently Changed</p>
          <i class="fa-regular fa-calendar"></i>
        </a>
        <a id="home" href="${pageContext.request.contextPath}">
          Home <i class="fa-solid fa-right-from-bracket"></i>
        </a>
      </nav>
    </header>
    <c:forEach var="p" items="${list}">
      <div class="p-card">
        <img src="${pageContext.request.contextPath}/images/placeholder.png" alt="Product Image" />
        <div class="info">
          <h2><c:out value="${p.name}" /></h2>
          <a class="id">#ID <c:out value="${p.id}" /></a>
          <a class="edit" href="products?option=edit&id=${p.id}">Edit <i class="fa-regular fa-pen-to-square"></i></a>
          <a class="delete" href="products?option=delete&id=${p.id}" onclick="return confirm('Are you sure? This cannot be undone!')">
            Delete <i class="fa-regular fa-trash-can"></i>
          </a>
          <br />
          <br />
          <span class="stock ${p.stock > 0.5 ? "" : "empty"}">
            <fmt:formatNumber value="${p.stock}" type="number" maxFractionDigits="0" /> in stock 
            <i class="fa-solid ${p.stock > 0.5 ? "fa-circle-check" : "fa-circle-exclamation fa-beat"}"></i>
          </span>
          <br />
          <span class="price">
            &dollar;<fmt:formatNumber value="${p.price}" type="number" minFractionDigits="2" maxFractionDigits="2" />
          </span>
          <br />
          <div class="dates">
            <span>
              Created On <i class="fa-solid fa-clock"></i><hr />
              <fmt:formatDate value="${p.creationDate}" pattern="${dateFormat}" />
            </span>
            <span>
              Last Modified <i class="fa-solid fa-clock-rotate-left"></i><hr />
              <c:choose>
                <c:when test="${p.modifiedDate == null}">N/A</c:when>
                <c:otherwise>
                  <fmt:formatDate value="${p.modifiedDate}" pattern="${dateFormat}" />
                </c:otherwise>
              </c:choose>
            </span>
          </div>
        </div>
      </div>
      <br />
    </c:forEach>
	</body>
</html>
