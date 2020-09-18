package com.example.ewardrobeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ewardrobeapp.R;
import com.example.ewardrobeapp.models.Clothes;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ClothesRecycleAdapter extends RecyclerView.Adapter<ClothesRecycleAdapter.MyViewHolder> {
    private List<Clothes> data;

    public ClothesRecycleAdapter(List<Clothes> data) {
        this.data = data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView clothes_name;
        public ImageView clothes_image;

        public MyViewHolder(View view) {
            super(view);
            clothes_name = (TextView) view.findViewById(R.id.clothes_name);
            clothes_image = (ImageView) view.findViewById(R.id.clothes_image);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.look_clothes_item, parent, false);


        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Clothes clothes = this.data.get(position);

        holder.clothes_name.setText(clothes.getName());
        Picasso.get().load(clothes.getClothes_url()).resize(200, 200).into(holder.clothes_image);
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }


}
