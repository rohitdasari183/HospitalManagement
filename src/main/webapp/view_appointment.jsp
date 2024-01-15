<%@page import="com.entity.User"%>
<%@page import="com.entity.Appointment"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.db.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="component/allcss.jsp" %>
</head>
<body>
    <%@include file="component/navbar.jsp" %>
    <div class="container p-3">
        <div class="row">
            <div class="col-md-12">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="text-center fs-3">User Appointment</p>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col">Age</th>
                                    <th scope="col">Appointment Date</th>
                                    <th scope="col">Diseases</th>
                                    <th scope="col">Doctor name</th>
                                    <th scope="col">Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    User user = (User) session.getAttribute("userObj");
                                    AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
                                    DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
                                    List<Appointment> list = dao.getAllAppointment(user.getId());
                                    for (Appointment ap : list) {
                                        Doctor d = dao2.getDoctorById(ap.getDoctorId());
                                %>
                                    <tr>
                                        <td><%=ap.getFullname()%></td>
                                        <td><%=ap.getGender()%></td>
                                        <td><%=ap.getAge()%></td>
                                        <td><%=ap.getAppointData()%></td>
                                        <td><%=ap.getDisease()%></td>
                                        <td><%=d.getFullname()%></td>
                                        <td>
                                            <% if ("Pending".equals(ap.getStatus())) { %>
                                                <a href="#" class="btn btn-sm btn-warning">Pending</a>
                                            <% } else { %>
                                                <%=ap.getStatus()%>
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
