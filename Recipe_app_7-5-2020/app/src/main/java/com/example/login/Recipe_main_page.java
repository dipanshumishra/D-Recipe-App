package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.login.Model.IngredientModel;
import com.example.login.ViewHolder.CategoryTwoViewHolder;
import com.example.login.ViewHolder.CategoryViewHolder;
import com.example.login.Model.Category;
import com.example.login.Model.CategoryTwo;
import com.example.login.ViewHolder.IngredientAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class Recipe_main_page extends AppCompatActivity {

    RecyclerView recyclerView;

    FirebaseDatabase database;
    DatabaseReference reference;

       //   Ingredient Recyclerview start
    RecyclerView IngredientRecyclerView;
    IngredientAdapter adapter3;
       //   Ingredient Recyclerview end

    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;
    FirebaseRecyclerAdapter<CategoryTwo, CategoryTwoViewHolder> adapter2;
    RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_main_page);
        try {
            getSupportActionBar().hide();
        }
        catch (Exception e)
        {}



        //bottom navigation working code start
        //  not working
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottomnavigation);

        bottomNavigationView.setSelectedItemId(R.id.home_navigation);
      bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

              switch (item.getItemId())
              {
                  case R.id.user_profile_navigation:
                      startActivity(new Intent(getApplicationContext(),user_profile.class));
                      overridePendingTransition(0,0);
                      return true;
              }
              return false;
          }
      });
        //bottom navigation working code end



        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Category");

        manager =new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(manager);

           //   Ingredient Recyclerview start
        IngredientRecyclerView = findViewById(R.id.IngredientRecyclerView);
        IngredientRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        FirebaseRecyclerOptions<IngredientModel> option3 = new FirebaseRecyclerOptions.Builder<IngredientModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Ingredients"),IngredientModel.class)
                .build();

        adapter3= new IngredientAdapter(option3);
        IngredientRecyclerView.setAdapter(adapter3);
        //   Ingredient Recyclerview end

        FirebaseRecyclerOptions<Category> options = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(reference,Category.class)
                .build();


        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position, @NonNull Category model) {

                holder.categoryName.setText(model.getCategoryName());
                FirebaseRecyclerOptions<CategoryTwo> options2 = new FirebaseRecyclerOptions.Builder<CategoryTwo>()
                        .setQuery(reference.child(model.getCategoryId()).child("data"),CategoryTwo.class)
                        .build();

                  String CategoryID = model.getCategoryId();

                adapter2 = new FirebaseRecyclerAdapter<CategoryTwo, CategoryTwoViewHolder>(options2) {
                    @Override
                    protected void onBindViewHolder(@NonNull CategoryTwoViewHolder holder, int position, @NonNull CategoryTwo model) {

                        holder.recipeName.setText(model.getRecipeName());
                        Glide.with(holder.recipeImg.getContext()).load(model.getRecipeImg()).into(holder.recipeImg);


                        holder.itemView.setOnClickListener(v -> {
                            Intent intent = new Intent(Recipe_main_page.this,Ing_Recipe.class);
                            intent.putExtra("recipename",model.getRecipeName());
                            intent.putExtra("recipeimg",model.getRecipeImg());
                            intent.putExtra("CategoryID",CategoryID);


                            FirebaseRecyclerOptions<CategoryTwo> options2 = new FirebaseRecyclerOptions.Builder<CategoryTwo>()
                                    .setQuery(reference.child(CategoryID).child("data"),CategoryTwo.class).build();
                            intent.putExtra("ingDescription",model.getIngDescription());
                            intent.putExtra("prepTime",model.getPrepTime());
                            intent.putExtra("cookTime",model.getCookTime());
                            intent.putExtra("totalIngrequired",model.getTotalIngrequired());
                            intent.putExtra("stepsRequired",model.getStepsRequired());
                            intent.putExtra("Process",model.getProcess());
                            intent.putExtra("ingList",model.getIngList());

                            intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                            startActivity(intent);
                        });

                    }

                    @NonNull
                    @Override
                    public CategoryTwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View v2 = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_view_two,parent,false);
                        return new CategoryTwoViewHolder(v2);
                    }
                };


                adapter2.startListening();
                adapter2.notifyDataSetChanged();
                holder.category_recyclerView.setAdapter(adapter2);

            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v1 = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_view_one,parent,false);
                return new CategoryViewHolder(v1);
            }
        };

        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    //   Ingredient Recyclerview start
   @Override
   protected void onStart(){
        super.onStart();
        adapter3.startListening();
   }

   @Override
    protected void onStop(){
        super.onStop();
        adapter3.stopListening();
   }
    //   Ingredient Recyclerview end

}