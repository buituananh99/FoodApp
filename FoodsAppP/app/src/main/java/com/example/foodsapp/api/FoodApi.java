package com.example.foodsapp.api;

import com.example.foodsapp.model.Categories;
import com.example.foodsapp.model.DetailMeal;
import com.example.foodsapp.model.SliderMeals;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {

    @GET("categories.php")
    Observable<Categories> getCategories();

    @GET("filter.php")
    Observable<SliderMeals> getQuerySlider(@Query("i") String nameMeal);

    @GET("filter.php")
    Observable<SliderMeals> getMealByCategory(@Query("c") String category);

    @GET("search.php")
    Observable<DetailMeal> getDetailMeal(@Query("s") String mealName);



}
