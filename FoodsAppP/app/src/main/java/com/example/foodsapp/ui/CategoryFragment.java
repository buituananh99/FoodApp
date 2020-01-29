package com.example.foodsapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodsapp.R;
import com.example.foodsapp.adapters.CategoriesAdapter;
import com.example.foodsapp.adapters.MealByCategoryAdapter;
import com.example.foodsapp.model.Categorie;
import com.example.foodsapp.model.Categories;
import com.example.foodsapp.model.SliderMeals;
import com.example.foodsapp.viewmodels.FoodsViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends Fragment {


    @BindView(R.id.imageCategoryBg)
    ImageView imageCategoryBg;
    @BindView(R.id.imageCategory)
    ImageView imageCategory;
    @BindView(R.id.textCategory)
    TextView textCategory;
    @BindView(R.id.cardCategory)
    CardView cardCategory;
    @BindView(R.id.recyclerView)
    RecyclerView rvMealByCategory;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Categorie category;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ButterKnife.bind(this, view);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (view == null)
            return;


        if (getArguments() != null) {
            category = (Categorie) getArguments().getSerializable("DATA_CATEGORY");
            Glide.with(getActivity()).load(category.getStrCategoryThumb()).into(imageCategory);
            Glide.with(getActivity()).load(category.getStrCategoryThumb()).into(imageCategoryBg);
            textCategory.setText(category.getStrCategoryDescription());


            FoodsViewModel foodsViewModel = ViewModelProviders.of(this).get(FoodsViewModel.class);
            if (category.getStrCategory() != null) {

                foodsViewModel.initMealByCategory(category.getStrCategory());
                view.findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                foodsViewModel.getMealByCategoryRepository().observe(this, mealByCategory -> {
                    MealByCategoryAdapter adapter = new MealByCategoryAdapter(getActivity(), mealByCategory.getMeals());
                    view.findViewById(R.id.progressBar).setVisibility(View.GONE);
                    rvMealByCategory.setHasFixedSize(true);
                    rvMealByCategory.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    rvMealByCategory.setAdapter(adapter);
                    rvMealByCategory.setItemAnimator(new DefaultItemAnimator());
                });
            }


        }
    }


}
