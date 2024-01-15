<%@page import="com.entity.Appointment"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.db.DBConnect"%>
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
        <div class="container p-3">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card paint-card">
                        <div class="card-body">
                            <p class="text-center fs-4">Patient Comment</p>
                            <%
                                String idParam = request.getParameter("id");
                                int id = (idParam != null && !idParam.isEmpty()) ? Integer.parseInt(idParam) : 0;

                                if (id > 0) {
                                    AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
                                    Appointment ap = dao.getAppointmentById(id);
                            %>
                                    <form class="row" action="../UpdateStatus" method="post">
                                        <div class="col-md-6">
                                            <label>Patient Name</label> <input type="text" readonly value="<%=ap.getFullname() %>" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Age</label> <input type="text" readonly value="<%=ap.getAge() %>" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Mobile Number</label> <input type="text" readonly value="<%=ap.getContact()%>" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label>Diseases</label> <input type="text" readonly value="<%=ap.getDisease()%>" class="form-control">
                                        </div>
                                        <div class="col-md-12">
                                            <label>Comment</label> <textarea required name="comm" class="form-control" rows="3" cols=""></textarea>
                                        </div>
                                        <div>
                                            <input type="hidden" name="id" value="<%=ap.getId() %>"><input type="hidden" name="did" value="<%=ap.getDoctorId() %>">
                                            <button class="mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
                                        </div>
                                    </form>
                            <%
                                } else {
                            %>
                                    <p>Invalid appointment ID</p>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
