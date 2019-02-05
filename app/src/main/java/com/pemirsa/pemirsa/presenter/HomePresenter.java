package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.pemirsa.pemirsa.adapter.HomeAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.model.CountDataModel;
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
    private ArrayList<CountDataModel> countDatumModels = new ArrayList<>();
    private HomeAdapter homeAdapter;

    public void getDataAnggota(final Context context, String id, final RecyclerView rvHome){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getDataAnggotaId(id).enqueue(new Callback<ArrayList<AnggotaModel>>() {
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

    public void countData(final Context context, String id, final TextView jumlahAnggota, final TextView jumlahPakaiRuangan){
        ApiServiceServer apiServiceServerData = ClientServer.getInstanceRetrofit();
        apiServiceServerData.getDataCount(id).enqueue(new Callback<ArrayList<CountDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CountDataModel>> call, Response<ArrayList<CountDataModel>> response) {
                if (response.isSuccessful()){
                    countDatumModels = response.body();
                    for (int j = 0; j < countDatumModels.size(); j++) {
                        final String count_data_table_anggota = countDatumModels.get(j).getCountDataTableAnggota();
                        final String count_data_table_pemakaian_ruang = countDatumModels.get(j).getCountDataTablePemakaianRuang();
                        jumlahAnggota.setText(count_data_table_anggota + " Anggota");
                        jumlahPakaiRuangan.setText(count_data_table_pemakaian_ruang + "x Booking");
//                        SharedPreferences sharedPreferences = context.getSharedPreferences(Config.SHARED_PRED_NAME,Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor =sharedPreferences.edit();
//
//                        editor.putString(Config.COUNT_DATA_TABLE_ANGGOTA,count_data_table_anggota);
//                        editor.putString(Config.COUNT_DATA_TABLE_PEMAKAIAN_RUANG,count_data_table_pemakaian_ruang);
//
//                        editor.apply();

                    }
                }
                else {
                    Toast.makeText(context, "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CountDataModel>> call, Throwable t) {
                Toast.makeText(context, Config.ERROR_INTERNET + "Count " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
