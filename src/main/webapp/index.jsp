<%-- 
    Document   : index.jsp
    Created on : 23-Oct-2023, 15:57:28
    Author     : hp
--%>

<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <%@include file="component/allcss.jsp" %>
    </head>
    <body>
      <%@include file="component/navbar.jsp" %>
     
      <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/p1.webp" class="d-block w-100" alt="..." height="550px">
    </div>
    <div class="carousel-item">
        <img src="img/p2.avif" class="d-block w-100" alt="..."  height="550px" >
    </div>
    <div class="carousel-item">
      <img src="img/p1.jpg" class="d-block w-100" alt="..."  height="550px">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
      <%@include file="component/footer.jsp" %>
    </body>
</html>
