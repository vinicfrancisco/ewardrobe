package com.example.ewardrobeapp.models;

public class Look {
    private String id;
    private String name;
    private String user_id;
    private String bottom_clothes_id;
    private String top_clothes_id;
    private String created_at;
    private String updated_at;
    private Clothes bottom;
    private Clothes top;

    public Look() {

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


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBottom_clothes_id() {
        return bottom_clothes_id;
    }

    public void setBottom_clothes_id(String bottom_clothes_id) {
        this.bottom_clothes_id = bottom_clothes_id;
    }

    public String getTop_clothes_id() {
        return top_clothes_id;
    }

    public void setTop_clothes_id(String top_clothes_id) {
        this.top_clothes_id = top_clothes_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Clothes getBottom() {
        return bottom;
    }

    public void setBottom(Clothes bottom) {
        this.bottom = bottom;
    }

    public Clothes getTop() {
        return top;
    }

    public void setTop(Clothes top) {
        this.top = top;
    }
}
