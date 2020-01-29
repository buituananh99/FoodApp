package com.example.foodsapp.adapters;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodsapp.model.Categorie;
import com.example.foodsapp.ui.CategoryFragment;

import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    private List<Categorie> categories;

    public ViewPagerCategoryAdapter(FragmentManager fm, List<Categorie> categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int i) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();

        String strCategory = categories.get(i).getStrCategory();
        String strCategoryThumb = categories.get(i).getStrCategoryThumb();
        String strCategoryDescription = categories.get(i).getStrCategoryDescription();

        Categorie model = new Categorie(strCategory, strCategoryThumb, strCategoryDescription);

        args.putSerializable("DATA_CATEGORY", model);




        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getStrCategory();
    }
}
