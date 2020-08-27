package com.example.ewardrobeapp.ui.clothes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClothesViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ClothesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Clothes fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }

}
