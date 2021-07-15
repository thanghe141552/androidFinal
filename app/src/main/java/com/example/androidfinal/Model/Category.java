package com.example.androidfinal.Model;

public class Category {
    private int cateCode;
    private String cateName;
    private String cateDes;
    private String catePos;

    public Category() {
    }

    public Category(String cateName, String cateDes, String catePos) {
        this.cateName = cateName;
        this.cateDes = cateDes;
        this.catePos = catePos;
    }

    public Category(int cateCode, String cateName, String cateDes, String catePos) {
        this.cateCode = cateCode;
        this.cateName = cateName;
        this.cateDes = cateDes;
        this.catePos = catePos;
    }

    public int getCateCode() {
        return cateCode;
    }

    public void setCateCode(int cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDes() {
        return cateDes;
    }

    public void setCateDes(String cateDes) {
        this.cateDes = cateDes;
    }

    public String getCatePos() {
        return catePos;
    }

    public void setCatePos(String catePos) {
        this.catePos = catePos;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cateCode='" + cateCode + '\'' +
                ", cateName='" + cateName + '\'' +
                ", cateDes='" + cateDes + '\'' +
                ", catePos='" + catePos + '\'' +
                '}';
    }

}
