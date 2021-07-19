package com.example.androidfinal.Model;

import java.util.Date;

public class Bill {
    private int bill_id;
    private Date date;
    private String name_user;
    private double total_price;
    private boolean paid;
    public Bill() {
    }

    public Bill(int bill_id, Date date, String name_user) {
        this.bill_id = bill_id;
        this.date = date;
        this.name_user = name_user;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
