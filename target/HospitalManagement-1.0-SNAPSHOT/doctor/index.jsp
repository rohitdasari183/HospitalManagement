<%-- 
    Document   : index
    Created on : 31-Oct-2023, 20:39:19
    Author     : hp
--%>

<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.db.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../component/allcss.jsp" %>
          <style type="text/css">
           .paint-card{
               box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
           }
       </style>
            </head>
    <body>
        <c:if test="${empty doctorObj}">
            <c:redirect url="../doctor_login.jsp"></c:redirect>
        </c:if>
        <%@include file="navbar.jsp" %>
    <p1 class="text-center fs-3">Doctor Dashboard</p1>
          
       <% 
           Doctor d=(Doctor)session.getAttribute("doctorObj");
          DoctorDao dao=new DoctorDao(DBConnect.getConn());
          
       %>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card paint-card">
                        <div class="card-body text-center text-success">
                            <i class="fas fa-user-md fa-3x"></i><br>
                            <p class="fs-4 text-center">
                                Doctor <br><%=dao.countDoctor()%>
                            </p>
                        </div>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="card paint-card">
                        <div class="card-body text-center text-success">
                            <i class="far fa-calendar-check fa-3x"></i><br>
                            <p class="fs-4 text-center">
                                Total Appointment <br><%=dao.countAppointmentByDoctorIdID(d.getId())%>
                            </p>
                        </div>
                     </div>
                </div>
            </div>
            
        </div>
    </body>
</html>
