package com.example.login.ViewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.login.R;


public class ingDetailAdapter  extends RecyclerView.ViewHolder {


    public TextView ingDescription , prepTime , cookTime , totalIngrequired , stepsRequired , Process;


    public ingDetailAdapter(@NonNull View itemView) {

        super(itemView);
        ingDescription = itemView.findViewById(R.id.ingredient_desc);
        prepTime = itemView.findViewById(R.id.prep_time);
        cookTime = itemView.findViewById(R.id.cook_time);
        totalIngrequired = itemView.findViewById(R.id.total_ingredeints_required_number);
        stepsRequired = itemView.findViewById(R.id.total_steps_required);
        Process = itemView.findViewById(R.id.process);
    }
}


