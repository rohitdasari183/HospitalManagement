/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.Specialist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class SpecialistDao 
{
    private static Connection conn;
    public SpecialistDao(Connection conn)
    {
        super();
        this.conn=conn;
    }
    public boolean addSpecialistName(String spec)
    {
        boolean f=false;
        try
        {
            String sql="insert into specialist(specName) values(?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,spec);
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
    public List<Specialist> getAllSpecialist()
    {
        List<Specialist> list=new ArrayList<>();
        Specialist s=null;
        try{
            

        String sql="select * from specialist";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
           s=new Specialist();
           s.setId(rs.getInt(1));
           s.setSpecialistName(rs.getString(2));
           list.add(s);
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
