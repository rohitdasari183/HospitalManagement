/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.doctor.Servlet;

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
public class DoctorLogin extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse res ) throws ServletException,IOException
    {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        
        HttpSession session=req.getSession();
        
        DoctorDao dao=new DoctorDao(DBConnect.getConn());
        Doctor d=dao.doctorLogin(email, password);
        if(d != null)
        {
            session.setAttribute("doctorObj", d);
            res.sendRedirect("doctor/index.jsp");
        }
        else
        {
            session.setAttribute("errorMsg","Error while logging");
            res.sendRedirect("doctor_login.jsp");
        }
    }


}
