package com.example.ewardrobeapp.models;

import java.util.List;

public class ClothesTypes {
    private List<ClothesCategory> top;
    private List<ClothesCategory> bottom;

    public ClothesTypes() {

    }

    public List<ClothesCategory> getTop() {
        return top;
    }

    public void setTop(List<ClothesCategory> top) {
        this.top = top;
    }

    public List<ClothesCategory> getBottom() {
        return bottom;
    }

    public void setBottom(List<ClothesCategory> bottom) {
        this.bottom = bottom;
    }


}
