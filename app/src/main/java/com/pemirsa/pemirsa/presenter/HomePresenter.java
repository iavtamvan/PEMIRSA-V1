package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.pemirsa.pemirsa.model.LoginModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;

public class HomePresenter {
    private ApiServiceServer apiServiceServer;
    private ClientServer clientServer;
    private ArrayList<LoginModel> loginModel = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editorl;

    public void getAllData(Context context){

    }
}
