package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pemirsa.pemirsa.adapter.ListPengurusVerticalAdapter;
import com.pemirsa.pemirsa.adapter.ListRiwayatDaftarRuanganAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.model.RiwayatDaftarRuanganModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatDaftarRuanganPresenter {
    private ApiServiceServer apiServiceServer;
    private ArrayList<RiwayatDaftarRuanganModel> riwayatDaftarRuanganModels = new ArrayList<>();
    private ListRiwayatDaftarRuanganAdapter listRiwayatDaftarRuanganAdapter;

    public void riwayatDaftarRuangan(final Context context, String id, final RecyclerView rv){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getRiwayatDaftarRuangan(id)
                .enqueue(new Callback<ArrayList<RiwayatDaftarRuanganModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<RiwayatDaftarRuanganModel>> call, Response<ArrayList<RiwayatDaftarRuanganModel>> response) {
                        if (response.isSuccessful()){
                            riwayatDaftarRuanganModels = response.body();
                            listRiwayatDaftarRuanganAdapter = new ListRiwayatDaftarRuanganAdapter(context, riwayatDaftarRuanganModels);
                            rv.setAdapter(listRiwayatDaftarRuanganAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(context));
                            listRiwayatDaftarRuanganAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<RiwayatDaftarRuanganModel>> call, Throwable t) {
                        Toast.makeText(context, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
