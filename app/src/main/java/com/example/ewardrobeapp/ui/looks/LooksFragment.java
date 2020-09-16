package com.example.ewardrobeapp.ui.looks;

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
import com.example.ewardrobeapp.adapters.LooksAdapter;
import com.example.ewardrobeapp.models.Look;
import com.example.ewardrobeapp.new_look;
import com.example.ewardrobeapp.retrofit.RetrofitInitializer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LooksFragment extends Fragment {
    private Context me;
    private LooksViewModel looksViewModel;
    private ListView looks_list;
    View rootView;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        me = getContext();
        looksViewModel =
                ViewModelProviders.of(this).get(LooksViewModel.class);

        rootView = inflater.inflate(R.layout.fragment_looks, container, false);

        looks_list = (ListView) rootView.findViewById(R.id.looks_list);

        getLooks();

        FloatingActionButton fab = rootView.findViewById(R.id.add_look_button);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(), new_look.class);
                startActivity(i);
            }
        });

        return rootView;
    }

    public void getLooks() {
        Call<List<Look>> call = new RetrofitInitializer().looks().getLooks();

        call.enqueue(new Callback<List<Look>>() {
            @Override
            public void onResponse(Call<List<Look>> call, Response<List<Look>> response) {
                looks_list.setAdapter(new LooksAdapter(me, response.body()));
            }

            @Override
            public void onFailure(Call<List<Look>> call, Throwable t) {
                // Display error
            }
        });
    }
}