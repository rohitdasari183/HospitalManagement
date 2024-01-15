<%-- 
    Document   : index
    Created on : 25-Oct-2023, 20:00:35
    Author     : hp
--%>

<%@page import="com.dao.DoctorDao"%>
<%@page import="com.db.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../component/allcss.jsp"%>
    </head>
    <body>
       <%@include file="navbar.jsp" %>
        <c:if test="${empty adminObj}">
            <c:redirect url="../admin_login.jsp"></c:redirect>
        </c:if>
        <c:if test="${not empty succMsg}">
                                <p class="text-center text-success fs-3">${succMsg}</p>
                                <c:remove var="succMsg"/>
                            </c:if>
                         
                             <c:if test="${not empty errorMsg}">
                                <p class="text-center text-danger fs-5">${errorMsg}</p>
                                <c:remove var="errorMsg"/>
                            </c:if>
        
       <% 
          DoctorDao dao=new DoctorDao(DBConnect.getConn());
          
       %>
       <div class="container p-5">
           <div class="text-center"><h1>Admin Dashboard</h1></div>
           <div class="row">
               <div class="col-md-4">
                   <div class="text-center">
                       
               <div class="card paint-card">
                   <div class="text-center">
                   <div class="card-body text-center text-success">
                       <i class="fas fa-user-md fa-3x"></i><br>
                       <p class="fs-4 text-center">
                           Doctor<br><%=dao.countDoctor()%>
                       </p>
                   </div>
               </div>
               </div>
                   </div>
               </div>
           </div>
           
       </div>
      
           
                <div class="container p-5">
           <div class="row">
               <div class="col-md-4">
               <div class="card paint-card">
                   <div class="card-body text-center text-success">
                       <i class="fas fa-user-cicle fa-3x"></i><br>
                       <p class="fs-4 text-center">
                           User<br><%=dao.countUser()%>
                       </p>
                   </div>
               </div>
               </div>
         
        
               <div class="col-md-4">
               <div class="card paint-card">
                   <div class="card-body text-center text-success">
                       <i class="fas fa-user-circle fa-3x"></i><br>
                       <p class="fs-4 text-center">
                           Total Appointment<br><%=dao.countAppointment()%>
                       </p>
                   </div>
               </div>
               </div>
               
               <div class="col-md-4 mt-2">
                   
               <div class="card paint-card" data-bs-toggle="modal" data-bs-target="#exampleModal" >
                   <div class="card-body text-center text-success">
                       <i class="fas fa-user-circle fa-3x"></i><br>
                       <p class="fs-4 text-center">
                           Specialist<br><%=dao.countSpecialist()%>
                       </p>
                   </div>
               </div>
        
               </div>
               
      </div>
           
                </div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Specialist</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form action="../AddSpecialist" method="post">
              <div class="form-group">
                  <label>Enter Specialist Name:</label>
                  <input type="text" name="specName" class="form-control">
              </div>
              <div class="text-center mt-3">
                  <button type="submit" class="btn btn-primary">Add</button>
              </div>
              
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      
      </div>
    </div>
  </div>
</div>
           
       
    </body>
</html>
