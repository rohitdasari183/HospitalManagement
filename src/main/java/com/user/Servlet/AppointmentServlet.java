/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.Servlet;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
@WebServlet(name = "AppointmentServlet", urlPatterns = {"/AppointmentServlet"})
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int userid=Integer.parseInt(req.getParameter("userid"));
       String fullname=req.getParameter("fullname");
       String gender=req.getParameter("gender");
       String age=req.getParameter("age");
       String appoint_date=req.getParameter("app_date");
       String email=req.getParameter("email");
       String contact=req.getParameter("contact");
       String disease=req.getParameter("disease");
       int doctor_id=Integer.parseInt(req.getParameter("doct"));
       String address=req.getParameter("address");
       
       Appointment ap=new Appointment(userid,fullname,gender,age,appoint_date,email,contact,disease,doctor_id,address,"Pending");
      
       AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
       HttpSession session=req.getSession();
       if(dao.addAppointment(ap))
       {
           session.setAttribute("succMsg","Appointment Successfull");
           resp.sendRedirect("user_appointment.java");
       }
       else
       {
           session.setAttribute("errorMsg","Something went wrong server");
           resp.sendRedirect("user_appointment.jsp");
       }
       
       
      
    }


}
