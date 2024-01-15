/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.admin.Servlet;

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
public class AdminLogout extends HttpServlet 
{

   protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
       HttpSession session=req.getSession();
       session.removeAttribute("adminObj");
       session.setAttribute("succMsg","Admin logged out successfully");
       res.sendRedirect("admin_login.jsp");
   }

}
