package com.example.supremecommunityapp.model.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseProduct {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("category_name")
    @Expose
    private String categoryName;

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
}
