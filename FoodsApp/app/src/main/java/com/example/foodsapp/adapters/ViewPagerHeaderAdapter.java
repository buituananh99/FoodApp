package com.example.foodsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.bumptech.glide.Glide;
import com.example.foodsapp.R;
import com.example.foodsapp.model.Meals;
import com.example.foodsapp.ui.DetailFoodActivity;

import java.util.List;

public class ViewPagerHeaderAdapter extends PagerAdapter {

    private Context context;
    private List<Meals> mealList;


    public ViewPagerHeaderAdapter(Context context, List<Meals> Meal) {
        this.context = context;
        this.mealList = Meal;
    }


    @Override
    public int getCount() {
        return mealList.size();
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_pager_header, container, false);

        ImageView mealThumb = view.findViewById(R.id.mealThumb);
        TextView mealName = view.findViewById(R.id.mealName);

        Glide.with(context).load(mealList.get(position).getStrMealThumb()).into(mealThumb);
        mealName.setText(mealList.get(position).getStrMeal());

        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailFoodActivity.class);
            intent.putExtra("CATEGORY_NAME", mealList.get(position).getStrMeal());
            context.startActivity(intent);
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
