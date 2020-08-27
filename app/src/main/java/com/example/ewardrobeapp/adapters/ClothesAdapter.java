package com.example.ewardrobeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ewardrobeapp.R;
import com.example.ewardrobeapp.models.Clothes;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ClothesAdapter extends BaseAdapter {
    private Context context;
    private List<Clothes> clothes;

    public ClothesAdapter(Context context, List<Clothes> clothes) {
        super();
        this.context = context;
        this.clothes = clothes;
    }

    @Override
    public int getCount() {
        return clothes.size();
    }

    @Override
    public Object getItem(int position) {
        return clothes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.clothes_item, viewGroup, false);
        }

        Clothes clothes = this.clothes.get(position);

        TextView clothes_name = (TextView) convertView.findViewById(R.id.clothes_name);
        clothes_name.setText(clothes.getName());

        ImageView clothes_image = (ImageView) convertView.findViewById(R.id.clothes_image);
        Picasso.get().load(clothes.getClothes_url()).resize(200, 200).into(clothes_image);

        return convertView;
    }
}
