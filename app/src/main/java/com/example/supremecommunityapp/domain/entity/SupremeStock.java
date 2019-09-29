package com.example.supremecommunityapp.domain.entity;

public class SupremeStock {


    private String imageUrl;

    private String imageUrlHi;

    private String price;

    private Integer salePrice;

    private Boolean newItem;

    private Integer position;

    private Integer priceEuro;

    private Integer salePriceEuro;

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

    public String getPrice() {
        return  price;
    }

    public void setPrice(Integer price) {
        this.price = supremePriceConverter(price);
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

    private String supremePriceConverter(Integer price){
        String formattedPrice;
        formattedPrice = price.toString();
        //Last two digits cents, which supreme doesn't have))
        return price.toString().substring(0, formattedPrice.length() - 2);
    }

}
