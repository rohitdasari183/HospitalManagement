/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.doctor.Servlet;

import com.dao.DoctorDao;
import com.dao.UserDao;
import com.db.DBConnect;
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
public class DoctorChangePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid=Integer.parseInt(req.getParameter("uid"));
        String oldPassword=req.getParameter("oldpassword");
        String newPassword=req.getParameter("newpassword");
        
        DoctorDao dao=new DoctorDao(DBConnect.getConn());
        HttpSession session=req.getSession();
        if(dao.checkPassword(uid, oldPassword))
        {
            if(dao.changePassword(uid, newPassword))
            {
                session.setAttribute("succMsg","Password Changed Successfully");
                resp.sendRedirect("doctor/edit_profile.jsp");
            }
            else
            {
                session.setAttribute("errorMsg","Password Changed Successfully");
                resp.sendRedirect("doctor/edit_profile.jsp");
            }
        }
        else
        {
            session.setAttribute("errorMsg","Old password incorrect");
            resp.sendRedirect("doctor/edit_profile.jsp");
        }
    }

    
}
