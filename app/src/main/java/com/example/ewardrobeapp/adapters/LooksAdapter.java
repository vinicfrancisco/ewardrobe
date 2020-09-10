package com.example.ewardrobeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ewardrobeapp.R;
import com.example.ewardrobeapp.models.Look;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LooksAdapter extends BaseAdapter {
    private Context context;
    private List<Look> looks;

    public LooksAdapter(Context context, List<Look> looks) {
        super();
        this.context = context;
        this.looks = looks;
    }

    @Override
    public int getCount() {
        return looks.size();
    }

    @Override
    public Object getItem(int position) {
        return looks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.looks_item, viewGroup, false);
        }

        Look look = this.looks.get(position);

        TextView look_name = (TextView) convertView.findViewById(R.id.look_name);
        look_name.setText(look.getName());

        ImageView look_bottom_image = (ImageView) convertView.findViewById(R.id.look_bottom_image);
        Picasso.get().load(look.getTop().getClothes_url()).resize(200, 200).into(look_bottom_image);

        ImageView look_top_image = (ImageView) convertView.findViewById(R.id.look_top_image);
        Picasso.get().load(look.getBottom().getClothes_url()).resize(200, 200).into(look_top_image);

        return convertView;
    }
}
