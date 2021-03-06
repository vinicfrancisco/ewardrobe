package com.example.ewardrobeapp.ui.clothes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ewardrobeapp.R;
import com.example.ewardrobeapp.adapters.ClothesAdapter;
import com.example.ewardrobeapp.models.Clothes;
import com.example.ewardrobeapp.new_clothes;
import com.example.ewardrobeapp.retrofit.RetrofitInitializer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClothesFragment extends Fragment {
    private Context me;
    private ClothesViewModel clothesViewModel;
    private ListView clothes_list;
    View rootView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        me = getContext();
        clothesViewModel =
                ViewModelProviders.of(this).get(ClothesViewModel.class);
        rootView = inflater.inflate(R.layout.fragment_clothes, container, false);

        clothes_list = (ListView) rootView.findViewById(R.id.clothes_list);

        getClothes();

        FloatingActionButton fab = rootView.findViewById(R.id.add_clothes_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(), new_clothes.class);
                startActivity(i);
            }
        });

        return rootView;
    }

    private void getClothes() {
        Call<List<Clothes>> call = new RetrofitInitializer().clothes().getClothes();

        call.enqueue(new Callback<List<Clothes>>() {
            @Override
            public void onResponse(Call<List<Clothes>> call, Response<List<Clothes>> response) {
                clothes_list.setAdapter(new ClothesAdapter(me, response.body()));
            }

            @Override
            public void onFailure(Call<List<Clothes>> call, Throwable t) {
                // Display error]
            }
        });
    }
}