package com.example.supremecommunityapp.model.supreme;

import com.example.supremecommunityapp.model.base.BaseProduct;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hat extends BaseProduct {

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrlHi() {
        return imageUrlHi;
    }

    public void setImageUrlHi(String imageUrlHi) {
        this.imageUrlHi = imageUrlHi;
    }

    public Integer getPrice() {
        return price;
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

}