/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class DoctorDao 
{
    private Connection conn;

    public DoctorDao(Connection conn) 
    {
        super();
        this.conn = conn;
    }
    
    public boolean registerDoctor(Doctor d)
    {
        boolean f=false;
        try
            
        {
 String sql="insert into doctor(fullname,dob,qualification,specName,email,mobno,password) values(?,?,?,?,?,?,?)";
 PreparedStatement ps=conn.prepareStatement(sql);
 ps.setString(1,d.getFullname());
 ps.setString(2,d.getDob());
 ps.setString(3,d.getQualification());
 ps.setString(4,d.getSpecName());
 ps.setString(5,d.getEmail());
 ps.setString(6,d.getMobno());
 ps.setString(7,d.getPassword());
 
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
          return f;  
    }
    public List<Doctor> getAllDoctor()
    {
        
        List<Doctor> list=new ArrayList<>();
        Doctor d=null;
        try
        {
            String sql="select * from doctor order by id desc";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                d=new Doctor();
                d.setId(rs.getInt(1));
                d.setFullname(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecName(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobno(rs.getString(7));
                d.setPassword(rs.getString(8));
                list.add(d);
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
     public Doctor getDoctorById(int id)
    {
        
       
        Doctor d=null;
        try
        {
            String sql="select * from doctor where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                d=new Doctor();
                d.setId(rs.getInt(1));
                d.setFullname(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecName(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobno(rs.getString(7));
                d.setPassword(rs.getString(8));
                
            }
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return d;
    }
      
    public boolean deleteDoctor(int id)
    {
        boolean f=false;
        try{
            String sql="delete from doctor where id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
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
        return f;
        
    }
    public Doctor doctorLogin(String em,String ps)
    {
        Doctor d=null;
        try{
            String sql="select * from doctor where email=? and password=?";
            PreparedStatement ps1=conn.prepareStatement(sql);
            ps1.setString(1,em);
            ps1.setString(2,ps);
            
            ResultSet rs=ps1.executeQuery();
            while(rs.next())
            {
                d=new Doctor();
                d.setId(rs.getInt(1));
                d.setFullname(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecName(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobno(rs.getString(7));
                d.setPassword(rs.getString(8));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return d;
    }
    public int countDoctor()
    {   int i=0;
        try{
            String sql="Select * from doctor";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
        return i;
    }
    public int countAppointment()
    {   int i=0;
        try{
            String sql="Select * from appointment";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
        return i;
    }
    public int countUser()
    {   int i=0;
        try{
            String sql="Select * from user_details";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
        return i;
    }
    public int countSpecialist()
    {   int i=0;
        try{
            String sql="Select * from specialist";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
        return i;
    }
    public int countAppointmentByDoctorIdID(int did)
    {   int i=0;
        try{
            String sql="Select * from appointment where doctorid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,did);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                i++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
        
        return i;
    }
    public boolean checkPassword(int userId,String oldPassword)
   {
       boolean f=false;
       try{
           String sql="select * from doctor where id=? and password=?";
           PreparedStatement ps=conn.prepareStatement(sql);
           ps.setInt(1,userId);
           ps.setString(2,oldPassword);
           
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               f=true;
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return f;
   }
     public boolean changePassword(int userId,String newPassword)
   {
       boolean f=false;
       try{
           String sql="update doctor set password=? and id=?";
           PreparedStatement ps=conn.prepareStatement(sql);
           ps.setInt(2,userId);
           ps.setString(1,newPassword);
           
           int i=ps.executeUpdate();
           while(i==1)
           {
               f=true;
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return f;
   }
     public boolean editDoctorProfile(Doctor d)
    {
        boolean f=false;
        try
            
        {
 String sql = "update doctor set fullname=?, dob=?, qualification=?, specName=?, email=?, mobno=?, password=? where id=?";

 PreparedStatement ps=conn.prepareStatement(sql);
 ps.setString(1,d.getFullname());
 ps.setString(2,d.getDob());
 ps.setString(3,d.getQualification());
 ps.setString(4,d.getSpecName());
 ps.setString(5,d.getEmail());
 ps.setString(6,d.getMobno());

 ps.setInt(7,d.getId());
 
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
          return f;  
    }
    
    public boolean updateDoctor(Doctor d) {
    boolean f = false;
    try {
        String sql = "update doctor set fullname=?, dob=?, qualification=?, specName=?, email=?, mobno=?, password=? where id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, d.getFullname());
        ps.setString(2, d.getDob());
        ps.setString(3, d.getQualification());
        ps.setString(4, d.getSpecName());
        ps.setString(5, d.getEmail());
        ps.setString(6, d.getMobno());
        ps.setString(7, d.getPassword());
        ps.setInt(8, d.getId());

        int i = ps.executeUpdate();
        if (i == 1) {
            f = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return f;
}

    
}
