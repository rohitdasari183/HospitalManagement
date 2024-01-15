<%-- 
    Document   : doctor
    Created on : 29-Oct-2023, 09:15:44
    Author     : hp
--%>

<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.db.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@include file="../component/allcss.jsp"%>
    </head>
    <body>
       <%@include file="navbar.jsp" %>
       <div class="container-fluid p-3">
           <div class="row">
               
               <div class="col-md-12">
                   <div class="card paint-card">
                       <div class="card-body">
                           <p class="fs-3 text-center">Doctor Details</p>
                           <table class="table">
                               <thead>
                                   <tr>
                                       <th scope="col">Full Name</th>
                                       <th scope="col">DOB</th>
                                       <th scope="col">Qualification</th>
                                       <th scope="col">Specialist</th>
                                       <th scope="col">Email</th>
                                       <th scope="col">Mobile Number</th>
                                       <th scope="col">Action</th>
                                   </tr>
                               </thead>
                               <tbody>
                                   <% 
                                     DoctorDao dao1=new DoctorDao(DBConnect.getConn());
                                     List<Doctor> list1=dao1.getAllDoctor();
                                     for(Doctor d:list1)
                                     {%>
                                     <tr>
                                         <td><%=d.getFullname()%></td>
                                         <td><%=d.getDob()%></td>
                                         <td><%=d.getQualification() %></td>
                                         <td><%=d.getSpecName()%></td>
                                         <td><%=d.getEmail()%></td>
                                         <td><%=d.getMobno()%></td>
                                         
                                         
                                         <td>
                                             <a href="edit_doctor.jsp?id=<%=d.getId()%>" class="btn btn-sm btn-primary">Edit</a>
                                            <a href="../DeleteDoctor?id=<%=d.getId()%>" class="btn btn-sm btn-danger">Delete</a>

                                         </td>
                                     </tr>
                                   <%}
                                   %>
                               </tbody>
                           </table>
                       </div>
                   </div>
               </div>
           </div>
       </div>
    </body>
</html>
