package com.example.bundletesting.listfood;

public class Food {

    String name;
    String description;
    int img;
    float price;

    public Food(){

    }

    public Food(String name, float price){
        this.name = name;
        this.price = price;
    }

    public Food(String name, String description, int img, float price){
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImg() {
        return img;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
