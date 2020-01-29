package com.example.foodsapp.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.foodsapp.api.FoodsRespository;
import com.example.foodsapp.model.Categories;
import com.example.foodsapp.model.DetailMeal;
import com.example.foodsapp.model.SliderMeals;


public class FoodsViewModel extends ViewModel {

    private MutableLiveData<Categories> mutableLiveCategoriData;
    private MutableLiveData<SliderMeals> mutableLiveMealData;
    private MutableLiveData<SliderMeals> mutableLiveMealByCategoryData;
    private MutableLiveData<DetailMeal> mutableLiveMealDetailData;

    private FoodsRespository categoriesRespository;


    public void initCategory(){
        if (mutableLiveCategoriData == null) {
            categoriesRespository = FoodsRespository.getInstance();
            mutableLiveCategoriData = categoriesRespository.getCategories();
        }
    }

    public void initSlider(){
        if (mutableLiveMealData == null) {
            categoriesRespository = FoodsRespository.getInstance();
            mutableLiveMealData = categoriesRespository.getQueryMeal("chicken");
        }
    }

    public void initMealByCategory(String category){
        if (mutableLiveMealByCategoryData == null) {
            categoriesRespository = FoodsRespository.getInstance();
            mutableLiveMealByCategoryData = categoriesRespository.getMealByCategory(category);
        }
    }

    public void initMealDetailByName(String mealName){
        if (mutableLiveMealByCategoryData == null) {
            categoriesRespository = FoodsRespository.getInstance();
            mutableLiveMealDetailData = categoriesRespository.getMealDetailByName(mealName);
        }
    }


    public LiveData<Categories> getCategoriesRepository() {
        return mutableLiveCategoriData;
    }

    public LiveData<SliderMeals> getMealsRepository() {
        return mutableLiveMealData;
    }

    public LiveData<SliderMeals> getMealByCategoryRepository() {
        return mutableLiveMealByCategoryData;
    }

    public LiveData<DetailMeal> getDetailMealRepository() {
        return mutableLiveMealDetailData;
    }
}
