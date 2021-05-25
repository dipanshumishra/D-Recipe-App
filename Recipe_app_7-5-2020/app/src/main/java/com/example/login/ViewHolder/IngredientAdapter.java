package com.example.login.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.login.Model.IngredientModel;
import com.example.login.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class IngredientAdapter extends FirebaseRecyclerAdapter<IngredientModel,IngredientAdapter.myviewholder>
{

    public IngredientAdapter(@NonNull FirebaseRecyclerOptions<IngredientModel> options3) { super(options3); }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull IngredientModel model) {

        holder.name.setText(model.getName());
        Glide.with(holder.img.getContext()).load(model.getImg()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredientlayout,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.ingredientlayout1img);
            name=itemView.findViewById(R.id.ingredientlayout1name);
        }
    }
}

