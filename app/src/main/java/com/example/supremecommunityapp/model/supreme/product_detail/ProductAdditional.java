package com.example.supremecommunityapp.model.supreme.product_detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductAdditional {

    @SerializedName("swatch_url")
    @Expose
    private String swatchUrl;
    @SerializedName("swatch_url_hi")
    @Expose
    private String swatchUrlHi;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("image_url_hi")
    @Expose
    private String imageUrlHi;
    @SerializedName("zoomed_url")
    @Expose
    private String zoomedUrl;
    @SerializedName("zoomed_url_hi")
    @Expose
    private String zoomedUrlHi;
    @SerializedName("bigger_zoomed_url")
    @Expose
    private String biggerZoomedUrl;

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

    public String getZoomedUrl() {
        return zoomedUrl;
    }

    public void setZoomedUrl(String zoomedUrl) {
        this.zoomedUrl = zoomedUrl;
    }

    public String getZoomedUrlHi() {
        return zoomedUrlHi;
    }

    public void setZoomedUrlHi(String zoomedUrlHi) {
        this.zoomedUrlHi = zoomedUrlHi;
    }

    public String getBiggerZoomedUrl() {
        return biggerZoomedUrl;
    }

    public void setBiggerZoomedUrl(String biggerZoomedUrl) {
        this.biggerZoomedUrl = biggerZoomedUrl;
    }
}
