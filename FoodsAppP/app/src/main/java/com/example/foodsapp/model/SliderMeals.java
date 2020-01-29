package com.example.foodsapp.model;

import java.util.List;

public class SliderMeals {

    List<Meals> meals;

    public SliderMeals(List<Meals> meals) {
        this.meals = meals;
    }

    public SliderMeals() {
    }

    public List<Meals> getMeals() {
        return meals;
    }

    public void setMeals(List<Meals> meals) {
        this.meals = meals;
    }
}


