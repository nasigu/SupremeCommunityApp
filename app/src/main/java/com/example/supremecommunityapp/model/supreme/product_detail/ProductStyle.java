package com.example.supremecommunityapp.model.supreme.product_detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductStyle {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("image_url_hi")
    @Expose
    private String imageUrlHi;
    @SerializedName("swatch_url")
    @Expose
    private String swatchUrl;
    @SerializedName("swatch_url_hi")
    @Expose
    private String swatchUrlHi;
    @SerializedName("mobile_zoomed_url")
    @Expose
    private String mobileZoomedUrl;
    @SerializedName("mobile_zoomed_url_hi")
    @Expose
    private String mobileZoomedUrlHi;
    @SerializedName("bigger_zoomed_url")
    @Expose
    private String biggerZoomedUrl;
    @SerializedName("sizes")
    @Expose
    private List<ProductSize> sizes = null;
    @SerializedName("additional")
    @Expose
    private List<ProductAdditional> additional = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
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

    public String getSwatchUrl() {
        return swatchUrl;
    }

    public void setSwatchUrl(String swatchUrl) {
        this.swatchUrl = swatchUrl;
    }

    public String getSwatchUrlHi() {
        return swatchUrlHi;
    }

    public void setSwatchUrlHi(String swatchUrlHi) {
        this.swatchUrlHi = swatchUrlHi;
    }

    public String getMobileZoomedUrl() {
        return mobileZoomedUrl;
    }

    public void setMobileZoomedUrl(String mobileZoomedUrl) {
        this.mobileZoomedUrl = mobileZoomedUrl;
    }

    public String getMobileZoomedUrlHi() {
        return mobileZoomedUrlHi;
    }

    public void setMobileZoomedUrlHi(String mobileZoomedUrlHi) {
        this.mobileZoomedUrlHi = mobileZoomedUrlHi;
    }

    public String getBiggerZoomedUrl() {
        return biggerZoomedUrl;
    }

    public void setBiggerZoomedUrl(String biggerZoomedUrl) {
        this.biggerZoomedUrl = biggerZoomedUrl;
    }

    public List<ProductSize> getSizes() {
        return sizes;
    }

    public void setSizes(List<ProductSize> sizes) {
        this.sizes = sizes;
    }

    public List<ProductAdditional> getAdditional() {
        return additional;
    }

    public void setAdditional(List<ProductAdditional> additional) {
        this.additional = additional;
    }
}
