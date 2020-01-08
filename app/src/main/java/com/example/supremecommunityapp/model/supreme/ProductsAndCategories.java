package com.example.supremecommunityapp.model.supreme;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductsAndCategories {


    public ProductsAndCategories() {
    }

    private ArrayList<Product> products = new ArrayList<Product>();


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> convertAllToProducts() {
        if (jackets != null)
            products.addAll(jackets);
        if (sweatshirts != null)
            products.addAll(sweatshirts);
        if (shirts != null)
            products.addAll(shirts);
        if (pants != null)
            products.addAll(pants);
        if (topsSweaters != null)
            products.addAll(topsSweaters);
        if (bags != null)
            products.addAll(bags);
        if (accessories != null)
            products.addAll(accessories);
        if (skate != null)
            products.addAll(skate);
        if (hats != null)
            products.addAll(hats);
        if (_new != null)
            products.addAll(_new);
        if (TShirts != null)
            products.addAll(TShirts);

            return products;
    }

    @SerializedName("Shirts")
    @Expose
    private List<Product> shirts = null;
    @SerializedName("Bags")
    @Expose
    private List<Product> bags = null;
    @SerializedName("Accessories")
    @Expose
    private List<Product> accessories = null;
    @SerializedName("Pants")
    @Expose
    private List<Product> pants = null;
    @SerializedName("Jackets")
    @Expose
    private List<Product> jackets = null;
    @SerializedName("Skate")
    @Expose
    private List<Product> skate = null;
    @SerializedName("Hats")
    @Expose
    private List<Product> hats = null;
    @SerializedName("Sweatshirts")
    @Expose
    private List<Product> sweatshirts = null;
    @SerializedName("Tops/Sweaters")
    @Expose
    private List<Product> topsSweaters = null;
    @SerializedName("new")
    @Expose
    private List<Product> _new = null;
    @SerializedName("T-Shirts")
    @Expose
    private List<Product> TShirts = null;

    public List<Product> getShirts() {
        return shirts;
    }

    public void setShirts(List<Product> shirts) {
        this.shirts = shirts;
    }

    public List<Product> getBags() {
        return bags;
    }

    public void setBags(List<Product> bags) {
        this.bags = bags;
    }

    public List<Product> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Product> accessories) {
        this.accessories = accessories;
    }

    public List<Product> getPants() {
        return pants;
    }

    public void setPants(List<Product> pants) {
        this.pants = pants;
    }

    public List<Product> getJackets() {
        return jackets;
    }

    public void setJackets(List<Product> jackets) {
        this.jackets = jackets;
    }

    public List<Product> getSkate() {
        return skate;
    }

    public void setSkate(List<Product> skate) {
        this.skate = skate;
    }

    public List<Product> getHats() {
        return hats;
    }

    public void setHats(List<Product> hats) {
        this.hats = hats;
    }

    public List<Product> getSweatshirts() {
        return sweatshirts;
    }

    public void setSweatshirts(List<Product> sweatshirts) {
        this.sweatshirts = sweatshirts;
    }

    public List<Product> getTopsSweaters() {
        return topsSweaters;
    }

    public void setTopsSweaters(List<Product> topsSweaters) {
        this.topsSweaters = topsSweaters;
    }

    public List<Product> getNew() {
        return _new;
    }

    public void setNew(List<Product> _new) {
        this._new = _new;
    }

    public List<Product> getTShirts() {
        return TShirts;
    }

    public void setTShirts(List<Product> TShirts) {
        this.TShirts = TShirts;
    }

}

