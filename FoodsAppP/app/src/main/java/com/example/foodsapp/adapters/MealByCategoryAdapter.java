package com.example.foodsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodsapp.R;
import com.example.foodsapp.model.Meals;
import com.example.foodsapp.ui.DetailFoodActivity;

import java.util.List;

public class MealByCategoryAdapter extends RecyclerView.Adapter<MealByCategoryAdapter.MyViewHolder> {

    private Context context;
    private List<Meals> mealList;

    public MealByCategoryAdapter(Context context, List<Meals> mealList) {
        this.context = context;
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_meal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(mealList.get(position).getStrMealThumb()).into(holder.imgMeal);
        holder.tvNameMeal.setText(mealList.get(position).getStrMeal());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailFoodActivity.class);
            intent.putExtra("CATEGORY_NAME", mealList.get(position).getStrMeal());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {

        return mealList == null ? 0 : mealList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMeal;
        TextView tvNameMeal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMeal = itemView.findViewById(R.id.mealThumb);
            tvNameMeal = itemView.findViewById(R.id.mealName);
        }
    }
}
