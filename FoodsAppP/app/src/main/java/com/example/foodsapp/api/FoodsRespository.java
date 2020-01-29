package com.example.foodsapp.api;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.foodsapp.model.Categories;
import com.example.foodsapp.model.DetailMeal;
import com.example.foodsapp.model.SliderMeals;

import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FoodsRespository {


    private static FoodsRespository categoriesRepository;
    private FoodApi foodApi;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public static FoodsRespository getInstance() {
        if (categoriesRepository == null) {
            categoriesRepository = new FoodsRespository();

        }
        return categoriesRepository;
    }


    public FoodsRespository() {
        foodApi = RetrofitService.getClient(context).create(FoodApi.class);
    }

    public MutableLiveData<Categories> getCategories() {
        MutableLiveData<Categories> categoriesData = new MutableLiveData<>();
        compositeDisposable.add(foodApi.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(categories -> {
                    categoriesData.setValue(categories);
                }));


        return categoriesData;
    }

    public MutableLiveData<SliderMeals> getQueryMeal(String name) {
        MutableLiveData<SliderMeals> mealsData = new MutableLiveData<>();

        compositeDisposable.add(foodApi.getQuerySlider(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(sliderMeals -> {
                    mealsData.setValue(sliderMeals);
                }));

        return mealsData;
    }

    public MutableLiveData<SliderMeals> getMealByCategory(String category) {
        MutableLiveData<SliderMeals> mealByCategory = new MutableLiveData<>();

        compositeDisposable.add(foodApi.getMealByCategory(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(sliderMeals -> {
                    mealByCategory.setValue(sliderMeals);
                }));

        return mealByCategory;
    }

    public MutableLiveData<DetailMeal> getMealDetailByName(String mealName) {

        MutableLiveData<DetailMeal> detailMealByName = new MutableLiveData<>();

        compositeDisposable.add(foodApi.getDetailMeal(mealName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(detailMeal -> {
                    detailMealByName.setValue(detailMeal);
                }));

        return detailMealByName;
    }

}
