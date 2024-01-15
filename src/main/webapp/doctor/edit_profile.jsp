<%-- 
    Document   : edit_profile
    Created on : 10-Jan-2024, 21:51:51
    Author     : hp
--%>

<%@page import="com.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.db.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="../component/allcss.jsp" %>
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
        
         
        
        <div class="col-md-8">
            <div class="card paint-card">
                <p class="text-center fs-3">Edit Profile</p>
                 <c:if test="${not empty succMsgd}">
                           <p class="text-center text-success fs-3">${succMsgd}</p>
                           <c:remove var="succMsgd" scope="session"></c:remove>
                       </c:if>
                       <c:if test="${not empty errorMsgd}">
                            <p class="text-center text-danger fs-3">${errorMsgd}</p>
                            <c:remove var="errorMsgd" scope="session"></c:remove>
                       </c:if>
                <div class="card-body">
                    <form action="../EditProfile" method="post">
                                    <div class="mb-3">
                                        <label class="form-label">Full name</label>
                                        <input type="text" name="fullname" class="form-control" value="${doctorObj.fullname}" required>
                                    </div>
                                     <div class="mb-3">
                                        <label class="form-label">DOB</label>
                                        <input type="date" name="dob" class="form-control" value="${doctorObj.dob}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Qualification</label>
                                        <input type="text" name="qualification" class="form-control" value="${doctorObj.qualification}" required>
                                    </div>
                                     <div class="mb-3">
                                        <label class="form-label">Specialist</label>
                                       <select name="specName" required class="form-control">
                                           <option>
                                               ${doctorObj.specName}
                                           </option>
                                          <% SpecialistDao dao=new SpecialistDao(DBConnect.getConn());
                                            List<Specialist> list=dao.getAllSpecialist();
                                            for(Specialist s:list)
                                            {%>
                                            <option><%=s.getSpecialistName() %></option>
                                            <%}
                                          
                                          %>
                                       </select>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Email:</label>
                                        <input type="text" name="email" class="form-control" value="${doctorObj.email}" readonly>
                                    </div>
                                     <div class="mb-3">
                                        <label class="form-label">Mobile Number:</label>
                                        <input type="text" name="mobno" class="form-control" value="${doctorObj.mobno}" required>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Mobile Number:</label>
                                        <input type="text" name="password" class="form-control" value="${doctorObj.password}" required>
                                    </div>
                                   <input type="hidden" name="id" value="${doctorObj.id}">
                                    <button type="submit" class="btn btn-danger col-md-12">Submit</button>
                                </form>
                </div>
            </div>
        </div>
    </body>
</html>
