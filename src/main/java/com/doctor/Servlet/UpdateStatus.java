/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.doctor.Servlet;

import com.dao.AppointmentDao;
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
public class UpdateStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try{
          int id=Integer.parseInt(req.getParameter("id"));
          int did=Integer.parseInt(req.getParameter("did"));
          String comm=req.getParameter("comm");
          
          AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
          HttpSession session=req.getSession();
          if(dao.updateCommentStatus(id, did, comm))
          {
              session.setAttribute("succMsg","comment updated");
              resp.sendRedirect("doctor/patient.jsp");
          }
          else
          {
               session.setAttribute("errorMsg","wrong");
              resp.sendRedirect("doctor/patient.jsp");
          }
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
    }

  
}
