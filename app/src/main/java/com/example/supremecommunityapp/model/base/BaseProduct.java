package com.example.supremecommunityapp.model.base;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseProduct implements Serializable, Parcelable {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("category_name")
    @Expose
    private String categoryName;

    public BaseProduct(){

    }

    public BaseProduct(Parcel parcel){
        name = parcel.readString();
        id = parcel.readInt();
        categoryName = parcel.readString();
    }

    public static final Creator<BaseProduct> CREATOR = new Creator<BaseProduct>() {
        @Override
        public BaseProduct createFromParcel(Parcel in) {
            return new BaseProduct(in);
        }

        @Override
        public BaseProduct[] newArray(int size) {
            return new BaseProduct[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(categoryName);
    }
}
