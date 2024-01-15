<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-house-medical"></i>RMedi Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <c:if test="${ empty userObj }">
              <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="admin_login.jsp"><i class="fa-solid fa-right-to-bracket"></i>ADMIN</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="doctor_login.jsp">DOCTOR</a>
        </li>
<!--         <li class="nav-item">
          <a class="nav-link" href="user_appointment.jsp">APPOINTMENT</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="#">VIEW APPOINTMENT</a>
        </li>-->
        <li class="nav-item">
          <a class="nav-link" href="user_login.jsp">USER</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="signup.jsp">REGISTER </a>
        </li>
          </c:if>
              
          <c:if test="${not empty userObj }">
               <li class="nav-item">
          <a class="nav-link" href="user_appointment.jsp">APPOINTMENT</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="view_appointment.jsp">VIEW APPOINTMENT </a>
        </li>
              <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
   ${userObj.fullname}
  </button>
  
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="change_password.jsp">Change Password</a></li>
    <li><a class="dropdown-item" href="UserLogout1">Logout</a></li>
   
  </ul>
</div>
          </c:if>        
   
      
      
    </div>
  </div>
</nav>