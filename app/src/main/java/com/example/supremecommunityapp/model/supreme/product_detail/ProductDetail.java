package com.example.supremecommunityapp.model.supreme.product_detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ProductDetail {

    @SerializedName("styles")
    @Expose
    private List<ProductStyle> styles = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("can_add_styles")
    @Expose
    private Boolean canAddStyles;
    @SerializedName("can_buy_multiple")
    @Expose
    private Boolean canBuyMultiple;
    @SerializedName("ino")
    @Expose
    private String ino;
    @SerializedName("cod_blocked")
    @Expose
    private Boolean codBlocked;
    @SerializedName("canada_blocked")
    @Expose
    private Boolean canadaBlocked;
    @SerializedName("purchasable_qty")
    @Expose
    private Integer purchasableQty;
    @SerializedName("new_item")
    @Expose
    private Boolean newItem;
    @SerializedName("apparel")
    @Expose
    private Boolean apparel;
    @SerializedName("handling")
    @Expose
    private Integer handling;
    @SerializedName("no_free_shipping")
    @Expose
    private Boolean noFreeShipping;
    @SerializedName("can_buy_multiple_with_limit")
    @Expose
    private Integer canBuyMultipleWithLimit;
    @SerializedName("non_eu_blocked")
    @Expose
    private Boolean nonEuBlocked;
    @SerializedName("russia_blocked")
    @Expose
    private Boolean russiaBlocked;

    public List<ProductStyle> getStyles() {
        return styles;
    }

    public void setStyles(List<ProductStyle> styles) {
        this.styles = styles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCanAddStyles() {
        return canAddStyles;
    }

    public void setCanAddStyles(Boolean canAddStyles) {
        this.canAddStyles = canAddStyles;
    }

    public Boolean getCanBuyMultiple() {
        return canBuyMultiple;
    }

    public void setCanBuyMultiple(Boolean canBuyMultiple) {
        this.canBuyMultiple = canBuyMultiple;
    }

    public String getIno() {
        return ino;
    }

    public void setIno(String ino) {
        this.ino = ino;
    }

    public Boolean getCodBlocked() {
        return codBlocked;
    }

    public void setCodBlocked(Boolean codBlocked) {
        this.codBlocked = codBlocked;
    }

    public Boolean getCanadaBlocked() {
        return canadaBlocked;
    }

    public void setCanadaBlocked(Boolean canadaBlocked) {
        this.canadaBlocked = canadaBlocked;
    }

    public Integer getPurchasableQty() {
        return purchasableQty;
    }

    public void setPurchasableQty(Integer purchasableQty) {
        this.purchasableQty = purchasableQty;
    }

    public Boolean getNewItem() {
        return newItem;
    }

    public void setNewItem(Boolean newItem) {
        this.newItem = newItem;
    }

    public Boolean getApparel() {
        return apparel;
    }

    public void setApparel(Boolean apparel) {
        this.apparel = apparel;
    }

    public Integer getHandling() {
        return handling;
    }

    public void setHandling(Integer handling) {
        this.handling = handling;
    }

    public Boolean getNoFreeShipping() {
        return noFreeShipping;
    }

    public void setNoFreeShipping(Boolean noFreeShipping) {
        this.noFreeShipping = noFreeShipping;
    }

    public Integer getCanBuyMultipleWithLimit() {
        return canBuyMultipleWithLimit;
    }

    public void setCanBuyMultipleWithLimit(Integer canBuyMultipleWithLimit) {
        this.canBuyMultipleWithLimit = canBuyMultipleWithLimit;
    }

    public Boolean getNonEuBlocked() {
        return nonEuBlocked;
    }

    public void setNonEuBlocked(Boolean nonEuBlocked) {
        this.nonEuBlocked = nonEuBlocked;
    }

    public Boolean getRussiaBlocked() {
        return russiaBlocked;
    }

    public void setRussiaBlocked(Boolean russiaBlocked) {
        this.russiaBlocked = russiaBlocked;
    }
}
