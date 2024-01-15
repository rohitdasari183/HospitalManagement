/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.admin.Servlet;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class AddDoctor1 extends HttpServlet {

   protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
       try
       {
           String fullname=req.getParameter("fullname");
           String dob=req.getParameter("dob");
           String qualification=req.getParameter("qualification");
           String specName=req.getParameter("specName");
           String email=req.getParameter("email");
           String mobno=req.getParameter("mobno");
           String password=req.getParameter("password");
           
           Doctor d=new Doctor(fullname,dob,qualification,specName,email,mobno,password);
           DoctorDao dao=new DoctorDao(DBConnect.getConn());
           boolean f=dao.registerDoctor(d);
           HttpSession session=req.getSession();
           if(f)
           {
               session.setAttribute("succMsg","Doctor Added Successfully");
               res.sendRedirect("admin/doctor.jsp");
           }
           else
           {
               session.setAttribute("errorMsg","Something went wrong on server");
               res.sendRedirect("admin/doctor.jsp");
           }
           
           
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
 

}
