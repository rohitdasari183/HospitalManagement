package com.doctor.Servlet;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EditProfile extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String fullname = req.getParameter("fullname");
            String dob = req.getParameter("dob");
            String qualification = req.getParameter("qualification");
            String specName = req.getParameter("specName");
            String email = req.getParameter("email");
            String mobno = req.getParameter("mobno");
            String password=req.getParameter("password");

            int id = Integer.parseInt(req.getParameter("id"));

            Doctor d = new Doctor(id, fullname, dob, qualification, specName, email, mobno, password);
            DoctorDao dao = new DoctorDao(DBConnect.getConn());
            boolean isDoctorUpdated = dao.updateDoctor(d);
            Doctor updatedDoctor = dao.getDoctorById(id);

            HttpSession session = req.getSession();

            if (isDoctorUpdated) {
                session.setAttribute("succMsgd", "Doctor Updated Successfully");
                res.sendRedirect("doctor/edit_profile.jsp");
            } else {
                session.setAttribute("errorMsgd", "Something went wrong on the server");
                res.sendRedirect("doctor/edit_profile.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
