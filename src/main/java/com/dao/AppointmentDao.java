/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class AppointmentDao 
{
    private Connection conn;
    public AppointmentDao(Connection conn)
    {
        this.conn=conn;
    }
    public boolean addAppointment(Appointment ap) {
    boolean f = false;

    try {
        String sql = "INSERT INTO `appointment` (`userid`, `fullname`, `gender`, `age`, `appoint_date`, `email`, `contact`, `disease`, `doctorid`, `address`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, ap.getUserId());
        ps.setString(2, ap.getFullname());
        ps.setString(3, ap.getGender());
        ps.setString(4, ap.getAge());
        ps.setString(5, ap.getAppointData()); // Corrected method name
        ps.setString(6, ap.getEmail());
        ps.setString(7, ap.getContact());
        ps.setString(8, ap.getDisease());
        ps.setInt(9, ap.getDoctorId());
        ps.setString(10, ap.getAddress());
        ps.setString(11, ap.getStatus());

        int i = ps.executeUpdate();
        if (i == 1) {
            f = true;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return f;
}

    public List<Appointment> getAllAppointment(int userid)
    {
        List<Appointment> list=new ArrayList<Appointment>();
        Appointment ap=null;
        try{
            String sql="select * from appointment where userid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,userid);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullname(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointData(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setContact(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));
                list.add(ap);
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
     public List<Appointment> getAllAppointmentByDoctor(int doctorId)
    {
        List<Appointment> list=new ArrayList<Appointment>();
        Appointment ap=null;
        try{
            String sql="select * from appointment where doctorid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,doctorId);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullname(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointData(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setContact(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));
                list.add(ap);
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
     public Appointment getAppointmentById(int id)
    {
        
        Appointment ap=null;
        try{
            String sql="select * from appointment where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullname(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointData(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setContact(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));
               
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ap;
    }
     public boolean updateCommentStatus(int id,int doctorid,String comm)
     {
         boolean f=false;
         try{
             String sql="update appointment set status=? where id=? and doctorid=?";
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setString(1,comm);
             ps.setInt(2,id);
             ps.setInt(3,doctorid);
             int i=ps.executeUpdate();
             if(i==1)
             {
                 f=true;
             }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return false;
     }
     public List<Appointment> getAllDoctor()
    {
        List<Appointment> list=new ArrayList<Appointment>();
        Appointment ap=null;
        try{
            String sql="select * from appointment where doctorid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                ap=new Appointment();
                ap.setId(rs.getInt(1));
                ap.setUserId(rs.getInt(2));
                ap.setFullname(rs.getString(3));
                ap.setGender(rs.getString(4));
                ap.setAge(rs.getString(5));
                ap.setAppointData(rs.getString(6));
                ap.setEmail(rs.getString(7));
                ap.setContact(rs.getString(8));
                ap.setDisease(rs.getString(9));
                ap.setDoctorId(rs.getInt(10));
                ap.setAddress(rs.getString(11));
                ap.setStatus(rs.getString(12));
                list.add(ap);
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
