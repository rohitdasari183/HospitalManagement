/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author hp
 */
public class Appointment 
{
    private int id;
    private int userid;
    private String fullname;
    private String gender;
    private String age;
    private String appointData;
    private String email;
    private String contact;
    private String disease;
    private int doctorId;
    private String address;
    private String status;
    
    public Appointment()
    {
        super();
    }

    public Appointment(int userid, String fullname, String gender, String age, String appointData, String email, String contact, String disease, int doctorId, String address,String status) {
        super();
        
        this.userid = userid;
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.appointData = appointData;
        this.email = email;
        this.contact = contact;
        this.disease = disease;
        this.doctorId = doctorId;
        this.address = address;
        this.status=status;
    }
   
  public void setId(int id)
  {
      this.id=id;
  }
  public int getId()
  {
      return id;
  }
    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAppointData() {
        return appointData;
    }

    public void setAppointData(String appointData) {
        this.appointData = appointData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
