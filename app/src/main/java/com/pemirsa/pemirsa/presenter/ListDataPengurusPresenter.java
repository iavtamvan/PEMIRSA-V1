package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pemirsa.pemirsa.adapter.ListPengurusVerticalAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListDataPengurusPresenter {
    private ApiServiceServer apiServiceServer;
    private ArrayList<AnggotaModel> anggotaModels = new ArrayList<>();
    private ListPengurusVerticalAdapter listPengurusVerticalAdapter;

    public void anggota(final Context context, String prodi, String status, final RecyclerView rv) {
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getDataAnggotaAllOrganisasidanStatusAnggota(prodi, status)
                .enqueue(new Callback<ArrayList<AnggotaModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<AnggotaModel>> call, Response<ArrayList<AnggotaModel>> response) {
                        if (response.isSuccessful()) {
                            anggotaModels = response.body();
                            listPengurusVerticalAdapter = new ListPengurusVerticalAdapter(context, anggotaModels);
                            rv.setAdapter(listPengurusVerticalAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(context));
                            listPengurusVerticalAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<AnggotaModel>> call, Throwable t) {
                        Toast.makeText(context, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
