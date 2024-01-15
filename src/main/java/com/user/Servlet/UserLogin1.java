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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class UserLogin1 extends HttpServlet 
{

    protected void doPost(HttpServletRequest req,HttpServletResponse res ) throws ServletException,IOException
    {
        String email=req.getParameter("email");
        String pasword=req.getParameter("password");
        
        UserDao dao=new UserDao(DBConnect.getConn());
        User user=dao.login(email, pasword);
        HttpSession session=req.getSession();
        if(user!=null)
        {
            session.setAttribute("userObj",user);
            res.sendRedirect("index.jsp");
        }
        else
        {
            session.setAttribute("errorMsg","Invalid username or password");
            res.sendRedirect("user_login.jsp");
        }
    }
   
}
