package com.example.androidfinal.Model;

import java.util.Date;

public class Bill {
    private int bill_id;
    private Date date;
    private String user_name;
    private int quantity;
    private String book_name;
    private double total_price;
    private boolean paid;

    public Bill() {
    }

    public Bill(int bill_id, Date date, String user_name, int quantity, String book_name, double total_price, boolean paid) {
        this.bill_id = bill_id;
        this.date = date;
        this.user_name = user_name;
        this.quantity = quantity;
        this.book_name = book_name;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
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
