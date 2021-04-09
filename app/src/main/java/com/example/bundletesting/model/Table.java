package com.example.bundletesting.model;

public class Table {
    private int resourceImage;
    private String numberTable;

    public Table(int resourceImage, String numberTable) {
        this.resourceImage = resourceImage;
        this.numberTable = numberTable;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getNumberTable() {
        return numberTable;
    }

    public void setNumberTable(String numberTable) {
        this.numberTable = numberTable;
    }
}
