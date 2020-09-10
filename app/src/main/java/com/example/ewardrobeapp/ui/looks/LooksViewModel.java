package com.example.ewardrobeapp.ui.looks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LooksViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LooksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Clothes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}