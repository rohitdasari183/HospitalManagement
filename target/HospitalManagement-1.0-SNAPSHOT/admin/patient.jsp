<%-- 
    Document   : patient
    Created on : 08-Jan-2024, 22:05:58
    Author     : hp
--%>

<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.db.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="../component/allcss.jsp" %>
          <style type="text/css">
           .paint-card{
               box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
           }
       </style>
    </head>
    <body>
         <%@include file="navbar.jsp" %>
         <div class="col-md-12">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="text-center fs-3">Patient</p>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Full Name</th>
                                        <th scope="col">Gender</th>
                                        <th scope="col">Age</th>
                                        <th scope="col">Appointment Date</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Mobile Number</th>
                                        <th scope="col">Diseases</th>
                                        <th scope="col">Doctor Name</th>
                                        <th scope="col">Address</th>
                                        <th scope="col">Status</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <% 
                                      AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
                                      DoctorDao dao2=new DoctorDao(DBConnect.getConn());
                                      List<Appointment> list=dao.getAllDoctor();
                                      for(Appointment ap:list){
                                      Doctor d=dao2.getDoctorById(ap.getDoctorId());
                                    %>
                                     <tr>
                                            <td><%=ap.getFullname()%></td>
                                            <td><%=ap.getGender()%></td>
                                            <td><%=ap.getAge()%></td>
                                            <td><%=ap.getAppointData()%></td>
                                            <td><%=ap.getEmail()%></td>
                                            <td><%=ap.getContact()%></td>
                                            <td><%=ap.getDisease()%></td>
                                             <td><%=d.getFullname()%></td>
                                            <td><%=ap.getStatus()%></td>
                                           
                                            
                                        </tr>
                                    
                                     <%     
                                         }
                                    
                                    %>
                                 
                                       
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
    </body>
</html>
