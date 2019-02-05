package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.widget.Toast;

import com.pemirsa.pemirsa.adapter.HomeAdapter;
import com.pemirsa.pemirsa.model.ErrorMsgModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPengurusPresenter {
    private ApiServiceServer apiServiceServer;
    private ArrayList<ErrorMsgModel> errorMsgModels = new ArrayList<>();

    public void kirimDataPengurus(final Context context, String id_user, String nama_anggota, String nim_anggota, String organisasi_anggota, String prodi_anggota, String email_anggota, String jabatan_anggota, String no_hp_anggota, String url_foto_ktm_anggota, String url_foto_anggota, String status_anggota, String token_anggota) {
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.postDataPengurus(id_user, nama_anggota, nim_anggota, organisasi_anggota, prodi_anggota, email_anggota, jabatan_anggota, no_hp_anggota, url_foto_ktm_anggota, url_foto_anggota, status_anggota, token_anggota)
                .enqueue(new Callback<ArrayList<ErrorMsgModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ErrorMsgModel>> call, Response<ArrayList<ErrorMsgModel>> response) {
                errorMsgModels = response.body();
                if (response.isSuccessful()){
                    for (int i = 0; i < errorMsgModels.size(); i++) {
                        Toast.makeText(context, "" + errorMsgModels.get(i).getError(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ErrorMsgModel>> call, Throwable t) {
                Toast.makeText(context, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
