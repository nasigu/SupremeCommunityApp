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

    public ArrayList<Product> convertAllToProducts(){
        products.addAll(shirts);
        products.addAll(bags);
        products.addAll(accessories);
        products.addAll(pants);
        products.addAll(jackets);
        products.addAll(skate);
        products.addAll(hats);
        products.addAll(sweatshirts);
        products.addAll(topsSweaters);
        products.addAll(_new);
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


//    public void getAllProducts(){
//        getProducts().add()
//    }

//    @SerializedName("Shirts")
//    @Expose
//    private List<Shirt> shirts = null;
//    @SerializedName("Bags")
//    @Expose
//    private List<Bag> bags = null;
//    @SerializedName("Accessories")
//    @Expose
//    private List<Accessory> accessories = null;
//    @SerializedName("Pants")
//    @Expose
//    private List<Pant> pants = null;
//    @SerializedName("Jackets")
//    @Expose
//    private List<Jacket> jackets = null;
//    @SerializedName("Skate")
//    @Expose
//    private List<Skate> skate = null;
//    @SerializedName("Hats")
//    @Expose
//    private List<Hat> hats = null;
//    @SerializedName("Sweatshirts")
//    @Expose
//    private List<Sweatshirt> sweatshirts = null;
//    @SerializedName("Tops/Sweaters")
//    @Expose
//    private List<TopsSweater> topsSweaters = null;
//    @SerializedName("new")
//    @Expose
//    private List<NewProduct> _new = null;



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

}

