package com.ankita.thirdtask.modal;

public class FoodItem {
    private int  imgId;
    private String title;
    private String description;
    private int price;
    private int quantity;

    public FoodItem(int imgId, String title, String description, int price,int Qun) {
        this.imgId = imgId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity=Qun;
    }


    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
