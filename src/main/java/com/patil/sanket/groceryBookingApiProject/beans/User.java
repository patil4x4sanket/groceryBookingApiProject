package com.patil.sanket.groceryBookingApiProject.beans;


import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private int uId;
    private String uName;
    private int uPhoneNo;
    private String uRole;


    public User() {
    }

    public User(int uId, String uName, int uPhoneNo, String uRole) {
        this.uId = uId;
        this.uName = uName;
        this.uPhoneNo = uPhoneNo;
        this.uRole = uRole;
    }


    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuPhoneNo() {
        return uPhoneNo;
    }

    public void setuPhoneNo(int uPhoneNo) {
        this.uPhoneNo = uPhoneNo;
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }


    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPhoneNo=" + uPhoneNo +
                ", uRole='" + uRole + '\'' +
                '}';
    }
}
