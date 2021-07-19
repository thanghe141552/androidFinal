package com.example.androidfinal.Model;

import java.util.Date;

public class Bill {
    private int bill_id;
    private Date date;
    private int user_id;
    private double total_price;
    private boolean paid;
    public Bill() {
    }


    public Bill(int bill_id, Date date, int user_id, double total_price, boolean paid) {
        this.bill_id = bill_id;
        this.date = date;
        this.user_id = user_id;
        this.total_price = total_price;
        this.paid = paid;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
