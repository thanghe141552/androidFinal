package com.example.androidfinal.Model;

public class User {
    private int id;
    private String userName;
    private String phone;
    private String email;
    private String address;
    private String image;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String phone, String email, String address, String image) {
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public User(int id, String userName, String phone, String email, String address, String image) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return
                "" + userName + '\'' +
                "" + phone + '\'' +
                "" + email + '\'' +
                "" + address + '\'' +
                "" + image + '\'' ;
    }
}