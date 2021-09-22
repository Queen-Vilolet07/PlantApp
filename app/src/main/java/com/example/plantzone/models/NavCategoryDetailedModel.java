package com.example.plantzone.models;

public class NavCategoryDetailedModel {
    String name,type,img_url;
    int price,quantity;

    public NavCategoryDetailedModel() {
    }

    public NavCategoryDetailedModel(String name, String type, String img_url,int  price,int quantity) {
        this.name = name;
        this.type = type;
        this.img_url = img_url;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
