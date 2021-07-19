package com.example.androidfinal.Model;

public class Book {
    private int code;
    private String name;
    private int quantity;
    private String category;
    private double price;

    public Book() {
    }

    public Book(int code,String name, int quantity, String category, double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
    }
    public Book(String name, int quantity, String category, double price) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
