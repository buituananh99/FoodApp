package com.example.foodsapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.foodsapp.adapters.CategoriesAdapter;
import com.example.foodsapp.adapters.ViewPagerHeaderAdapter;
import com.example.foodsapp.viewmodels.FoodsViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager_header)
    ViewPager viewPagerHeader;
    @BindView(R.id.rv_categories)
    RecyclerView rvCategory;

    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        getCategoriesInViewModel();
        getSliderMeals();

    }

    private void getSliderMeals() {
        FoodsViewModel foodsViewModel = ViewModelProviders.of(this).get(FoodsViewModel.class);
        foodsViewModel.initSlider();
        foodsViewModel.getMealsRepository().observe(this, sliderMeals -> {
            ViewPagerHeaderAdapter viewPagerHeaderAdapter = new ViewPagerHeaderAdapter(this, sliderMeals.getMeals());
            hideShimmerSlider();
            viewPagerHeader.setAdapter(viewPagerHeaderAdapter);
            viewPagerHeader.setPadding(20, 0, 150, 0);
            viewPagerHeaderAdapter.notifyDataSetChanged();
        });
    }

    private void getCategoriesInViewModel() {
        FoodsViewModel foodsViewModel = ViewModelProviders.of(this).get(FoodsViewModel.class);
        foodsViewModel.initCategory();
        foodsViewModel.getCategoriesRepository().observe(this, categoriesResponse -> {
            if (categoriesResponse == null) return;
            hideShimmerCategory();
            categoriesAdapter = new CategoriesAdapter(this, categoriesResponse.getCategories());
            setupRecyclerView();
        });
    }



    private void setupRecyclerView() {
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new GridLayoutManager(this, 3));
        rvCategory.setAdapter(categoriesAdapter);
        rvCategory.setItemAnimator(new DefaultItemAnimator());
    }

    private void hideShimmerCategory() {
        findViewById(R.id.shimmerCategory).setVisibility(View.GONE);
    }

    private void hideShimmerSlider() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
    }

}
