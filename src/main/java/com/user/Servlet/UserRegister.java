/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.Servlet;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class UserRegister extends HttpServlet 
{
   protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
       try
       {
           String fullname=req.getParameter("fullname");
           String email=req.getParameter("email");
           String password=req.getParameter("password");
           
           User u=new User(fullname,email,password);
           UserDao dao=new UserDao(DBConnect.getConn());
           boolean f=dao.userRegister(u);
           
           HttpSession session=req.getSession();
           if(f)
           {
               session.setAttribute("succMsg","Data Inserted Successfully");
               res.sendRedirect("signup.jsp");
           }
           else
           {
               session.setAttribute("errorMsg","Data Not Inserted");
               res.sendRedirect("signup.jsp");
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
   

  

}
