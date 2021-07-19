package com.example.androidfinal.Model;

import java.util.Date;

public class Bill_Detail {
    private int bill_detail_id;
    private int bill_id;
    private int quantity;
    private int book_id;

    public Bill_Detail() {
    }

    public Bill_Detail(int bill_detail_id, int bill_id, int quantity, int book_id) {
        this.bill_detail_id = bill_detail_id;
        this.bill_id = bill_id;
        this.quantity = quantity;
        this.book_id = book_id;
    }

    public int getBill_detail_id() {
        return bill_detail_id;
    }

    public void setBill_detail_id(int bill_detail_id) {
        this.bill_detail_id = bill_detail_id;
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

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
