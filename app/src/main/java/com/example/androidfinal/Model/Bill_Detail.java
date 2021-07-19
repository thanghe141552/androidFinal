package com.example.androidfinal.Model;

import java.util.Date;

public class Bill_Detail {
    private int bill_id;
    private int quantity;
    private Bill bill;
    private Book book;

    public Bill_Detail() {
    }

    public Bill_Detail(int bill_id, int quantity, Bill bill, Book book) {
        this.bill_id = bill_id;
        this.quantity = quantity;
        this.bill = bill;
        this.book = book;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
