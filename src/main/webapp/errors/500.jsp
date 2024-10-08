<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <script src="https://kit.fontawesome.com/4358b9453c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <title>500</title>
  </head>
  <body>
    <header>
 		  <h1>Error 500 :(</h1>
      <nav>
        <a id="home" href="${pageContext.request.contextPath}">
          Home <i class="fa-solid fa-right-from-bracket"></i>
        </a>
      </nav>
    </header>
    <div id="top">
      <div class="dot red"></div>
      <div class="dot amber"></div>
      <div class="dot green"></div>
    </div>
    <pre id="logger">
      <i class="fa-solid fa-bug fa-fade"></i>
      INTERNAL SERVER ERROR: Please try again later
    </pre>
  </body>
</html>
