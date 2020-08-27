package com.example.ewardrobeapp.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Comece agora a adicionar suas melhores peças no eWardrobe!");
}

    public LiveData<String> getText() {
        return mText;
    }
}