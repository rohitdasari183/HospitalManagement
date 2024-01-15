/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class UserDao 
{
   private Connection conn;
   public UserDao(Connection conn)
   {
       super();
       this.conn=conn;
   }
   public boolean userRegister(User u)
   {
       boolean f=false;
       try
       {
           String sql="insert into user_details(fullname,email,password) values(?,?,?)";
           PreparedStatement pstmt=conn.prepareStatement(sql);
           pstmt.setString(1,u.getFullname());
           pstmt.setString(2,u.getEmail());
           pstmt.setString(3,u.getPassword());
           int i=pstmt.executeUpdate();
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
   public User login(String em,String ps)
   {
       User u=null;
       try
       {
           String sql="select * from user_details where email=? and password=?";
           PreparedStatement pstmt=conn.prepareStatement(sql);
           pstmt.setString(1, em);
           pstmt.setString(2,ps);
           
           ResultSet rs=pstmt.executeQuery();
           while(rs.next())
           {
               u=new User();
               u.setId(rs.getInt(1));
               u.setFullname(rs.getString(2));
               u.setEmail(rs.getString(3));
               u.setPassword(rs.getString(4));
           }
           
           
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return u;
   }
   public boolean checkPassword(int userId,String oldPassword)
   {
       boolean f=false;
       try{
           String sql="select * from user_details where id=? and password=?";
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
           String sql="update doctor set password=? where id=?";
           PreparedStatement ps=conn.prepareStatement(sql);
          
           ps.setString(1,newPassword);
           ps.setInt(2,userId);
           
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
           
}
