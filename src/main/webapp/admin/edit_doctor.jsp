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
               <div class="col-md-4 offset-md-4">
                   <div class="card paint-card">
                       <div class="card-body">
                           <p class="fs-3 text-center">Edit Doctor Details</p>
                            <c:if test="${not empty succMsg}">
                                <p class="text-center text-success fs-3">${succMsg}</p>
                                <c:remove var="succMsg"/>
                            </c:if>
                         
                             <c:if test="${not empty errorMsg}">
                                <p class="text-center text-danger fs-5">${errorMsg}</p>
                                <c:remove var="errorMsg"/>
                            </c:if>
                                
                                <% 
                                    int id=Integer.parseInt(request.getParameter("id"));
                                    DoctorDao dao3=new DoctorDao(DBConnect.getConn());
                                    Doctor d=dao3.getDoctorById(id);
                                    
                                %>
                                <form action="../UpdateDoctor" method="post">
                                    <div class="md-3">
                                        <label class="form-label">Full name</label>
                                        <input type="text" name="fullname" value="<%=d.getFullname()%>" class="form-control" required>
                                    </div>
                                     <div class="md-3">
                                        <label class="form-label">DOB</label>
                                        <input type="date" value="<%=d.getDob()%>" name="dob" class="form-control" required>
                                    </div>
                                    <div class="md-3">
                                        <label class="form-label">Qualification</label>
                                        <input type="text" value="<%=d.getQualification()%>"name="qualification" class="form-control" required>
                                    </div>
                                     <div class="md-3">
                                        <label class="form-label">Specialist</label>
                                       <select name="specName" value="<%=d.getSpecName()%>"required class="form-control">
                                           <option>
                                               --Select--
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
                                    <div class="md-3">
                                        <label class="form-label">Email:</label>
                                        <input type="email" value="<%=d.getEmail()%>" name="email" class="form-control" required>
                                    </div>
                                     <div class="md-3">
                                        <label class="form-label">Mobile Number:</label>
                                        <input type="text" value="<%=d.getMobno()%>" name="mobno" class="form-control" required>
                                    </div>
                                    <div class="md-3">
                                        <label class="form-label">Password</label>
                                        <input type="password" value="<%=d.getPassword()%>" name="password" class="form-control" required>
                                    </div>
                                    <input type="hidden" value="<%=d.getId()%>" name="id">
                                    <button type="submit" class="btn btn-danger col-md-12">Update</button>
                                </form>
        
                       </div>
                   </div>
               </div>
             
           </div>
       </div>
    </body>
</html>
