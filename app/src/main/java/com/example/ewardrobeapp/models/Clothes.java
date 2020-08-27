package com.example.ewardrobeapp.models;

public class Clothes {
    private String id;
    private String name;
    private String clothes_url;
    private String category_id;

    public Clothes(String id, String name, String clothes_url, String category_id) {
        this.id = id;
        this.name = name;
        this.clothes_url = clothes_url;
        this.category_id = category_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClothes_url() {
        return clothes_url;
    }

    public void setClothes_url(String clothes_url) {
        this.clothes_url = clothes_url;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
