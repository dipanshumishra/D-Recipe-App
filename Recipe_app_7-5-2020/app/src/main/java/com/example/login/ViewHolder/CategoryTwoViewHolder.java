package com.example.login.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;

public class CategoryTwoViewHolder extends RecyclerView.ViewHolder {

    public TextView recipeName;
    public ImageView recipeImg;
    public  TextView ingredient_desc,prep_time,cook_time,total_ingredeints_required_number,ingredient_list_all,total_steps_required,process;



    public CategoryTwoViewHolder(@NonNull View itemView) {

        super(itemView);
        recipeName=itemView.findViewById(R.id.recipename);
        recipeImg=itemView.findViewById(R.id.recipeimage);
        ingredient_desc=itemView.findViewById(R.id.ingredient_desc);
        prep_time=itemView.findViewById(R.id.prep_time);
        cook_time=itemView.findViewById(R.id.cook_time);
        total_ingredeints_required_number=itemView.findViewById(R.id.total_ingredeints_required_number);
        ingredient_list_all=itemView.findViewById(R.id.ingredient_list_all);
        total_steps_required=itemView.findViewById(R.id.total_steps_required);
        process=itemView.findViewById(R.id.process);
    }
}