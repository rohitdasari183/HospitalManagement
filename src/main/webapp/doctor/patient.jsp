<%-- 
    Document   : patient
    Created on : 07-Jan-2024, 12:29:14
    Author     : hp
--%>

<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <%@include file="../component/allcss.jsp" %>
        <style type="text/css">
            .paint-card {
                box-shadow: 0 0 10px 0 rgba(0,0,0,0.3);
            }
        </style>
    </head>
    
    <body>
        <c:if test="${empty doctorObj}">
            <c:redirect url="../doctor_login.jsp" />
        </c:if>
        <%@include file="navbar.jsp" %>
        <div class="container p-3">
            <div class="row">
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
                                        <th scope="col">Status</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Doctor d =(Doctor)session.getAttribute("doctorObj");
                                        AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
                                        List<Appointment> list=dao.getAllAppointment(d.getId());
                                        for(Appointment ap:list) {
                                    %>
                                        <tr>
                                            <td><%=ap.getFullname()%></td>
                                            <td><%=ap.getGender()%></td>
                                            <td><%=ap.getAge()%></td>
                                            <td><%=ap.getAppointData()%></td>
                                            <td><%=ap.getEmail()%></td>
                                            <td><%=ap.getContact()%></td>
                                            <td><%=ap.getDisease()%></td>
                                            <td><%=ap.getStatus()%></td>
                                            <td>
                                                <% if("Pending".equals(ap.getStatus())) { %>
                                                <a href="comment.jsp?id=<%=ap.getId() %>" class="btn btn-success btn-small">Comment</a>
                                                <% } else { %> 
                                                 <a href="#" class="btn btn-danger btn-sm">Comment</a>

                                                <% } %>
                                            </td>
                                            
                                        </tr>
                                    <%
                                        }
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
