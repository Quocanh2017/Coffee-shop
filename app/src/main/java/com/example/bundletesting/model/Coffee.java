package com.example.bundletesting.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "coffee")
public class Coffee implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int resourceId;
    private String name;
    private String description;
    private String price;

    @Ignore
    public Coffee(String name, String description, String price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Coffee(int resourceId, String name, String description, String price) {
        this.resourceId = resourceId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    protected Coffee(Parcel in) {
        id = in.readInt();
        resourceId = in.readInt();
        name = in.readString();
        description = in.readString();
        price = in.readString();
    }

    public static final Creator<Coffee> CREATOR = new Creator<Coffee>() {
        @Override
        public Coffee createFromParcel(Parcel in) {
            return new Coffee(in);
        }

        @Override
        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(resourceId);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(price);
    }
}
