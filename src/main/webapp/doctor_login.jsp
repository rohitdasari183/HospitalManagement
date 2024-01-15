<%-- 
    Document   : doctor_login
    Created on : 23-Oct-2023, 15:58:26
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <%@include file="component/allcss.jsp" %>
    </head>
    <body>
      <%@include file="component/navbar.jsp" %>
      
      <div class="container p-5">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="fs-4 text-center">Doctor Login</p>
                             <c:if test="${not empty succMsg}">
                                <p class="text-center text-success fs-3">${succMsg}</p>
                                <c:remove var="succMsg"/>
                            </c:if>
                         
                             <c:if test="${not empty errorMsg}">
                                <p class="text-center text-danger fs-5">${errorMsg}</p>
                                <c:remove var="errorMsg"/>
                            </c:if>
                            <form action="DoctorLogin" method="post">
                                <div class="mb-3">
                                    <label class="form-label">Email Address</label>
                                    <input type="email" name="email" required class="form-control"> 
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Password</label>
                                    <input type="password" name="password" required class="form-control"> 
                                </div>
                                <input type="submit"  class="btn btn-danger text-white col-md-12" value="Login">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
