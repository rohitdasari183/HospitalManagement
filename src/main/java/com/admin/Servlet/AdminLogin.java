/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.admin.Servlet;

import com.entity.User;
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
public class AdminLogin extends HttpServlet {

   protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
       try{
       String email=req.getParameter("email");
       String password=req.getParameter("password");
       HttpSession session=req.getSession();
        System.out.println(email);
           System.out.println(password);
       
       if("admin@gmail.com".equals(email) && "admin".equals(password))
       {
          
           session.setAttribute("adminObj",new User());
           System.out.println("Redirecting to admin/index.jsp"); // Add this line for debugging

           res.sendRedirect("admin/index.jsp");
       }
       else
       {
           session.setAttribute("errorMsg","Invalid username or password");
           res.sendRedirect("admin_login.jsp");
       }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
           
   }

   

}
