package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pemirsa.pemirsa.adapter.HomeAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.model.LoginModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private ApiServiceServer apiServiceServer;
    private ClientServer clientServer;
    private ArrayList<AnggotaModel> anggotaModels = new ArrayList<>();
    private HomeAdapter homeAdapter;

    public void getDataAnggota(final Context context, String id, final RecyclerView rvHome){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getDataAnggota(id).enqueue(new Callback<ArrayList<AnggotaModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AnggotaModel>> call, Response<ArrayList<AnggotaModel>> response) {
                if (response.isSuccessful()){
                    anggotaModels = response.body();
                    homeAdapter = new HomeAdapter(context, anggotaModels);
                    rvHome.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                    rvHome.setAdapter(homeAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AnggotaModel>> call, Throwable t) {
                Toast.makeText(context, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
