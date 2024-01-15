/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.admin.Servlet;

import com.dao.DoctorDao;
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
public class DeleteDoctor extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String idParam = req.getParameter("id");
    
    if (idParam != null) {
        int id = Integer.parseInt(idParam);
        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        boolean f = dao.deleteDoctor(id);
        HttpSession session = req.getSession();

        if (f) {
            session.setAttribute("succMsg", "Doctor Deleted successfully");
            res.sendRedirect("admin/viewdoctor.jsp");
        } else {
            session.setAttribute("errorMsg", "Something went wrong on the server");
            res.sendRedirect("admin/viewdoctor.jsp");
        }
    } else {
        // Handle the case where "id" parameter is missing
        HttpSession session = req.getSession();
        session.setAttribute("errorMsg", "Missing 'id' parameter");
        res.sendRedirect("admin/viewdoctor.jsp");
    }
}



}
