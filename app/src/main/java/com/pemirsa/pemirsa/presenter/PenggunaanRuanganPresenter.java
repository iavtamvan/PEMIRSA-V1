package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.adapter.ListCekRuanganKosongAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.model.ErrorMsgModel;
import com.pemirsa.pemirsa.model.ListRuanganModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class PenggunaanRuanganPresenter {
    private ApiServiceServer apiServiceServer;
    private ArrayList<ErrorMsgModel> errorMsgModels = new ArrayList<>();
    private ArrayList<ListRuanganModel> listRuanganModels = new ArrayList<>();
    private ArrayList<AnggotaModel> anggotaModels = new ArrayList<>();

    private List<String> dataRuangan = new ArrayList<>();
    private List<String> dataAnggota = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapterRuangan;
    private ArrayAdapter<String> arrayAdapterAnggota;
    private ListCekRuanganKosongAdapter listCekRuanganKosongAdapter;
    private String idAnggota;
    private String urlFotoPj;
    private String namAnggota;


    public void sendDataPenggunaanRuangan(final Context context, String id_user, String id_anggota, String nama_daftar_ruangan, String nama_acara, String deskripsi_acara, String tgl_mulai_daftar_ruangan, String tgl_selesai_daftar_ruangan, String jam_mulai_daftar_ruangan, String jam_selesai_daftar_ruangan, String nama_organisasi_daftar_ruangan, String pj_daftar_ruangan, String jumlah_peserta_daftar_ruangan, String url_file_daftar_ruangan, String url_foto_pj, String status_daftar_ruangan, String token_daftar_ruangan, String id_ruangan){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.postDataPenggunaanRuangan(id_user, id_anggota, nama_daftar_ruangan, nama_acara, deskripsi_acara, tgl_mulai_daftar_ruangan, tgl_selesai_daftar_ruangan, jam_mulai_daftar_ruangan, jam_selesai_daftar_ruangan,nama_organisasi_daftar_ruangan, pj_daftar_ruangan, jumlah_peserta_daftar_ruangan, url_file_daftar_ruangan, url_foto_pj, status_daftar_ruangan, token_daftar_ruangan, id_ruangan)
                .enqueue(new Callback<ArrayList<ErrorMsgModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ErrorMsgModel>> call, Response<ArrayList<ErrorMsgModel>> response) {
                        errorMsgModels = response.body();
                        if (response.isSuccessful()){
                            Toast.makeText(context, "" + Config.DATA_BERHASIL_DISIMPAN, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, ""+ response.message() , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ErrorMsgModel>> call, Throwable t) {
                        Toast.makeText(context, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }
    
    public void spinnerListRuangan(final Context context, final Spinner spinner){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getDataListRuangan("kosong")
                .enqueue(new Callback<ArrayList<ListRuanganModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ListRuanganModel>> call, Response<ArrayList<ListRuanganModel>> response) {
                        if (response.isSuccessful()){
                            listRuanganModels = response.body();
                            for (int i = 0; i < listRuanganModels.size(); i++) {
                                dataRuangan.add(listRuanganModels.get(i).getNamaRuangan());
                                String idRuangan = listRuanganModels.get(i).getId();
                                arrayAdapterRuangan = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, dataRuangan);
                                spinner.setAdapter(arrayAdapterRuangan);
                                spinner.clearFocus();
//                                SharedPreferences sharedPreferences = context.getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putString(Config.ID_RUANGAN, idRuangan);
//
//                                editor.apply();


                            }
                        } else {
                            Toast.makeText(context, "" + Config.DATA_KOSONG, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ListRuanganModel>> call, Throwable t) {
                        Toast.makeText(context, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void spinnerListAnggota(final Context context, final Spinner spinner, String prodi){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getDataAnggotaAllOrganisasidanStatusAnggota(prodi, "Aktif")
                .enqueue(new Callback<ArrayList<AnggotaModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<AnggotaModel>> call, Response<ArrayList<AnggotaModel>> response) {
                        anggotaModels = response.body();
                        if (response.isSuccessful()){
                            for (int i = 0; i < anggotaModels.size(); i++) {
                                dataAnggota.add(anggotaModels.get(i).getNamaAnggota());
                                arrayAdapterAnggota = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, dataAnggota);
                                spinner.setAdapter(arrayAdapterAnggota);
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        namAnggota = spinner.getSelectedItem().toString().trim();
                                        for (AnggotaModel s : anggotaModels) {
                                            if (s.getNamaAnggota() != null && s.getNamaAnggota().contains(namAnggota)) {
                                                idAnggota = s.getId();
                                                urlFotoPj = s.getUrlFotoAnggota();
                                                Log.d(TAG, "idAnggotta : " + idAnggota);
                                                SharedPreferences sharedPreferences = context.getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
                                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                                editor.putString(Config.IDANGGOTA, idAnggota);
                                                editor.putString(Config.URLFOTOPJ, urlFotoPj);
                                                editor.apply();

                                            }
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                        Toast.makeText(context, "Galat", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } else {
                            Toast.makeText(context, "" + Config.DATA_KOSONG, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<AnggotaModel>> call, Throwable t) {
                        Toast.makeText(context, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void cekListRuangan(final Context context, final RecyclerView rv){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getDataListRuangan("kosong")
                .enqueue(new Callback<ArrayList<ListRuanganModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ListRuanganModel>> call, Response<ArrayList<ListRuanganModel>> response) {
                        if (response.isSuccessful()){
                            listRuanganModels = response.body();
                            // bikin adapter, xml, view
                            listCekRuanganKosongAdapter = new ListCekRuanganKosongAdapter(context, listRuanganModels);
                            rv.setAdapter(listCekRuanganKosongAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(context));
                            listCekRuanganKosongAdapter.notifyDataSetChanged();

                        } else {
                            Toast.makeText(context, "" + Config.DATA_KOSONG, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ListRuanganModel>> call, Throwable t) {
                        Toast.makeText(context, "" + Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
