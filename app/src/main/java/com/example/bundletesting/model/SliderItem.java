package com.example.bundletesting.model;

public class SliderItem {

    private int resourceId;

    public SliderItem(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getImageUrl() {
        return resourceId;
    }

    public void setImageUrl(int imageUrl) {
        this.resourceId = imageUrl;
    }
}
