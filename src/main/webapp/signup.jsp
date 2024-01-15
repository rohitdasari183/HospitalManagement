<%-- 
    Document   : signup
    Created on : 23-Oct-2023, 17:43:01
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <%@ include file="component/allcss.jsp" %>
       <style type="text/css">
           .paint-card{
               box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
           }
       </style>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <div class="container p-5">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="fs-4 text-center">User Register</p>
                            <c:if test="${not empty succMsg}">
                                <p class="text-center text-success fs-3">${succMsg}</p>
                                <c:remove var="succMsg"/>
                            </c:if>
                            <c:if test="${not empty errorMsg}">
                                <p class="text-center text-success fs-3">${errorMsg}</p>
                                <c:remove var="errorMsg"/>
                            </c:if>
                            <form action="UserRegister" method="post">
                                <div class="mb-3">
                                    <label class="form-label">Full Name</label>
                                    <input type="text" name="fullname" required class="form-control"> 
                                </div>
                                 <div class="mb-3">
                                    <label class="form-label">Email Address</label>
                                    <input type="text" name="email" required class="form-control"> 
                                </div>
                               
                                <div class="mb-3">
                                    <label class="form-label">Password</label>
                                    <input type="password" name="password" required class="form-control"> 
                                </div>
                                <input  type="submit" class="btn btn-danger text-white col-md-12" value="Register">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      
    </body>
</html>
