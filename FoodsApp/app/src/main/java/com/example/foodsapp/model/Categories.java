package com.example.foodsapp.model;

import java.io.Serializable;
import java.util.List;

public class Categories implements Serializable {

    private List<Categorie> categories;


    public Categories() {
    }

    public Categories(List<Categorie> categories) {
        this.categories = categories;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
