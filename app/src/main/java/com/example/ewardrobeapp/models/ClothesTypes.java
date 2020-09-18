package com.example.ewardrobeapp.models;

import java.util.List;

public class ClothesTypes {
    private List<Clothes> top;
    private List<Clothes> bottom;

    public ClothesTypes() {

    }

    public List<Clothes> getTop() {
        return top;
    }

    public void setTop(List<Clothes> top) {
        this.top = top;
    }

    public List<Clothes> getBottom() {
        return bottom;
    }

    public void setBottom(List<Clothes> bottom) {
        this.bottom = bottom;
    }


}
