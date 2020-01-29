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
import com.example.foodsapp.model.Categorie;
import com.example.foodsapp.ui.CategoryActivity;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {


    private Context context;
    private List<Categorie> categorieList;

    public CategoriesAdapter(Context context, List<Categorie> categorieList) {
        this.context = context;
        this.categorieList = categorieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(categorieList.get(position).getStrCategoryThumb()).into(holder.imgCategorie);
        holder.tvNameCategorie.setText(categorieList.get(position).getStrCategory());

        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, CategoryActivity.class);

            i.putExtra("CATEGORY", (Serializable) categorieList);
            i.putExtra("POSITION", position);

            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return categorieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCategorie;
        private TextView tvNameCategorie;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategorie = itemView.findViewById(R.id.categoryThumb);
            tvNameCategorie = itemView.findViewById(R.id.categoryName);
        }
    }
}
