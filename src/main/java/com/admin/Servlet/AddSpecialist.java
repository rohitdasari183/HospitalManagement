/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.admin.Servlet;

import com.dao.SpecialistDao;
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
public class AddSpecialist extends HttpServlet 
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        String specName=req.getParameter("specName");
        SpecialistDao dao=new SpecialistDao(DBConnect.getConn());
        
        boolean f=dao.addSpecialistName(specName);
        HttpSession session=req.getSession();
        if(f)
        {
            session.setAttribute("succMsg","Specialist Added Successfully");
            res.sendRedirect("admin/index.jsp");
        }
        else
        {
            session.setAttribute("errorMsg","Something wrong on server");
            res.sendRedirect("admin_login.jsp");
        }
    }
   

}
