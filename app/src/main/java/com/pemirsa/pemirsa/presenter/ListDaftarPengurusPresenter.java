package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.adapter.ListDaftarPengurusAdapter;
import com.pemirsa.pemirsa.model.ErrorMsgModel;
import com.pemirsa.pemirsa.model.ListDaftarPengurusModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListDaftarPengurusPresenter {
    private ApiServiceServer apiServiceServer;
    private ArrayList<ListDaftarPengurusModel> listDaftarPengurusModels = new ArrayList<>();
    private ListDaftarPengurusAdapter listDaftarPengurusAdapter;

    private List<String> dataProduk;
    private ArrayAdapter<String> arrayAdapter;


    public void getDataListPengurus(final Context context, String type, final Spinner spinner){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getDataListDaftarPengurus(type).enqueue(new Callback<ArrayList<ListDaftarPengurusModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ListDaftarPengurusModel>> call, Response<ArrayList<ListDaftarPengurusModel>> response) {
                dataProduk = new ArrayList<>();
                listDaftarPengurusModels = response.body();
                if (response.isSuccessful()){
                    for (int i = 0; i < listDaftarPengurusModels.size(); i++) {
                        dataProduk.add(listDaftarPengurusModels.get(i).getNamaDaftar());
                        arrayAdapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, dataProduk);
                        spinner.setAdapter(arrayAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ListDaftarPengurusModel>> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
