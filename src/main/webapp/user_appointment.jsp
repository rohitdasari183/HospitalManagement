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
            <div class="col-md-6">
                <img src="img/p1.avif" width="500" height="400" alt="alt"/>
             </div>
            <div class="col-md-6">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="text-center fs-3">User Appointment</p>
                        <c:if test="${not empty errorMsg}">
                            <p class="fs-4 text-center text-danger">${errorMsg}</p>
                            <c:remove var="errorMsg" scope="session"/>
                        </c:if>
                        <c:if test="${not empty succMsg}">
                            <p class="fs-4 text-center text-danger">${succMsg}</p>
                            <c:remove var="succMsg" scope="session"/>
                        </c:if>
                        <form class="row g-3" action="AppointmentServlet" method="post">
                            <input type="hidden" name="userid" value="${userObj.id}">
                            
                            <div class="col-md-6">
                                <label class="form-label">Full name</label>
                                <input required type="text" class="form-control" name="fullname">
                            </div>
                            <div class="col-md-6">
                                <label>Gender</label>
                                <select class="form-control" name="gender" required>
                                    <option value="male">Male</option>
                                    <option value="female">Female</option>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Age</label>
                                <input required type="text" class="form-control" name="age">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Appointment Date</label>
                                <input required type="date" class="form-control" name="app_date">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Email</label>
                                <input required type="email" class="form-control" name="email">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Contact</label>
                                <input required type="text" class="form-control" name="contact">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Diseases</label>
                                <input required type="text" class="form-control" name="disease">
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Doctor</label>
                                <select required class="form-control" name="doct">
                                 <option value="">--select--</option>
                                     <%
                                        DoctorDao dao = new DoctorDao(DBConnect.getConn());
                                        List<Doctor> list = dao.getAllDoctor();
                                        for (Doctor d : list) {
                                    %>
                                    <option value="<%=d.getId()%>"><%=d.getFullname()%> (<%=d.getSpecName()%>)</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Full Address</label>
                                <textarea required type="text" class="form-control" name="address"></textarea>
                            </div>
                            <input type="submit" class="btn btn-danger" value="submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
