package com.example.foodsapp.model;

import java.util.List;

public class DetailMeal {

    private List<Meal> meals;

    public DetailMeal() {
    }

    public DetailMeal(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}

