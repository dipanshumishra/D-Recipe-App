package com.example.login;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.login.Model.Category;
import com.example.login.Model.IngDetailModel;
import com.example.login.ViewHolder.CategoryViewHolder;
import com.example.login.ViewHolder.ingDetailAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class Ing_Recipe extends AppCompatActivity {

        ImageView detailimg,sideimg;
        TextView detailname;
        TextView ingredient_desc,total_ingredeints_required_number,ingredient_list_all,total_steps_required,process;
//        TextView total_time;
          TextView  prep_time,cook_time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing_recipe);
        try {
            getSupportActionBar().hide();
        }
        catch (Exception e)
        {}

        detailimg = findViewById(R.id.detailimg);
        detailname=findViewById(R.id.detailname);
        sideimg=findViewById(R.id.sideimg);

        ingredient_desc=findViewById(R.id.ingredient_desc);
        prep_time=findViewById(R.id.prep_time);
        cook_time=findViewById(R.id.cook_time);
        total_ingredeints_required_number=findViewById(R.id.total_ingredeints_required_number);
        ingredient_list_all=findViewById(R.id.ingredient_list_all);
        total_steps_required=findViewById(R.id.total_steps_required);
        process=findViewById(R.id.process);
//        total_time=findViewById(R.id.total_time);



        detailname.setText(getIntent().getStringExtra("recipename"));
        String recipeimg = getIntent().getStringExtra("recipeimg");
        Glide.with(this).load(recipeimg).into(detailimg);
        Glide.with(this).load(recipeimg).into(sideimg);



        String prepTime=getIntent().getStringExtra("prepTime");
        String cookTime=getIntent().getStringExtra("cookTime");
        String ingDescription=getIntent().getStringExtra("ingDescription");
        String ingList=getIntent().getStringExtra("ingList");
        String Process=getIntent().getStringExtra("Process");
        String stepsRequired=getIntent().getStringExtra("");
        String totalIngrequired=getIntent().getStringExtra("totalIngrequired");

                prep_time.setText(prepTime);
                cook_time.setText(cookTime);
                ingredient_desc.setText(ingDescription);
                ingredient_list_all.setText(ingList);
                process.setText(Process);
                total_steps_required.setText(stepsRequired);
                total_ingredeints_required_number.setText(totalIngrequired);

            }
 }







