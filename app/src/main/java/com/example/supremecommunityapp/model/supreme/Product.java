package com.example.supremecommunityapp.model.supreme;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.supremecommunityapp.model.base.BaseProduct;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product extends BaseProduct implements Serializable, Parcelable {


    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("image_url_hi")
    @Expose
    private String imageUrlHi;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("sale_price")
    @Expose
    private Integer salePrice;
    @SerializedName("new_item")
    @Expose
    private Boolean newItem;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("price_euro")
    @Expose
    private Integer priceEuro;
    @SerializedName("sale_price_euro")
    @Expose
    private Integer salePriceEuro;

    public Product(){

    }

    public Product(Parcel parcel){
        imageUrl = parcel.readString();
        imageUrlHi = parcel.readString();
        if (parcel.readByte() == 0) {
            price = null;
        } else {
            price = parcel.readInt();
        }
        if (parcel.readByte() == 0) {
            salePrice = null;
        } else {
            salePrice = parcel.readInt();
        }
        byte tmpNewItem = parcel.readByte();
        newItem = tmpNewItem == 0 ? null : tmpNewItem == 1;
        if (parcel.readByte() == 0) {
            position = null;
        } else {
            position = parcel.readInt();
        }
        if (parcel.readByte() == 0) {
            priceEuro = null;
        } else {
            priceEuro = parcel.readInt();
        }
        if (parcel.readByte() == 0) {
            salePriceEuro = null;
        } else {
            salePriceEuro = parcel.readInt();
        }
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getImageUrl() {
        return "https:" + imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrlHi() {
        return "https:" + imageUrlHi;
    }

    public void setImageUrlHi(String imageUrlHi) {
        this.imageUrlHi = imageUrlHi;
    }

    public Integer getPrice() {
        return  price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Boolean getNewItem() {
        return newItem;
    }

    public void setNewItem(Boolean newItem) {
        this.newItem = newItem;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPriceEuro() {
        return priceEuro;
    }

    public void setPriceEuro(Integer priceEuro) {
        this.priceEuro = priceEuro;
    }

    public Integer getSalePriceEuro() {
        return salePriceEuro;
    }

    public void setSalePriceEuro(Integer salePriceEuro) {
        this.salePriceEuro = salePriceEuro;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imageUrl);
        parcel.writeString(imageUrlHi);
        if (price == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(price);
        }
        if (salePrice == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(salePrice);
        }
        parcel.writeByte((byte) (newItem == null ? 0 : newItem ? 1 : 2));
        if (position == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(position);
        }
        if (priceEuro == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(priceEuro);
        }
        if (salePriceEuro == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(salePriceEuro);
        }
    }


}