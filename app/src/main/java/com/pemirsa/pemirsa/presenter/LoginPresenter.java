package com.pemirsa.pemirsa.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.pemirsa.pemirsa.HomeActivity;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.CountDataModel;
import com.pemirsa.pemirsa.model.LoginModel;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.ClientServer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private ApiServiceServer apiServiceServer;
    private ClientServer clientServer;
    private ArrayList<LoginModel> loginModel = new ArrayList<>();
    private ArrayList<CountDataModel> countDatumModels = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editorl;

    public void logins(final Context context, final String usename, String password){
        apiServiceServer = ClientServer.getInstanceRetrofit();
        apiServiceServer.getLogin(usename, password).enqueue(new Callback<ArrayList<LoginModel>>() {
            @Override
            public void onResponse(Call<ArrayList<LoginModel>> call, Response<ArrayList<LoginModel>> response) {
                if (response.isSuccessful()){
                    loginModel = response.body();
                    for (int i = 0; i < loginModel.size(); i++) {
                        final String id = loginModel.get(i).getId();
                        final String nama_organisasi = loginModel.get(i).getNamaOrganisasi();
                        final String jenis_organisasi = loginModel.get(i).getJenis_organisasi();
                        final String email = loginModel.get(i).getEmail();
                        final String nama_ketua = loginModel.get(i).getNamaKetua();
                        final String nama_wakil_ketua = loginModel.get(i).getNamaWakilKetua();
                        final String nama_sekretaris = loginModel.get(i).getNamaSekretaris();
                        final String no_hp_ketua = loginModel.get(i).getNoHpKetua();
                        final String no_hp_sekretaris = loginModel.get(i).getNoHpSekretaris();
                        final String nama_bendahara = loginModel.get(i).getNamaBendahara();
                        final String url_website = loginModel.get(i).getUrlWebsite();
                        final String jumlah_anggota = loginModel.get(i).getJumlahAnggota();
                        final String url_struk_organisasi = loginModel.get(i).getUrlStrukOrganisasi();
                        final String url_logo_organisasi = loginModel.get(i).getUrlLogoOrganisasi();
                        final String status_organisasi = loginModel.get(i).getStatusOrganisasi();
                        final String status_aplikasi = loginModel.get(i).getStatusAplikasi();
                        final String deskripsi_organisasi = loginModel.get(i).getDeskripsi_organisasi();
                        final String token_firebase = loginModel.get(i).getTokenFirebase();
                        final String hardware_id = loginModel.get(i).getHardwareId();
                        final String username = loginModel.get(i).getUsername();
                        final String created_at = loginModel.get(i).getUpdatedAt();
                        final String updated_at = loginModel.get(i).getUpdatedAt();

                        ApiServiceServer apiServiceServerData = ClientServer.getInstanceRetrofit();
                        apiServiceServerData.getDataCount(id).enqueue(new Callback<ArrayList<CountDataModel>>() {
                            @Override
                            public void onResponse(Call<ArrayList<CountDataModel>> call, Response<ArrayList<CountDataModel>> response) {
                                if (response.isSuccessful()){
                                    countDatumModels = response.body();
                                    for (int j = 0; j < countDatumModels.size(); j++) {
                                        final String count_data_table_anggota = countDatumModels.get(j).getCountDataTableAnggota();
                                        final String count_data_table_pemakaian_ruang = countDatumModels.get(j).getCountDataTablePemakaianRuang();


                                        sharedPreferences = context.getSharedPreferences(Config.SHARED_PRED_NAME,Context.MODE_PRIVATE);
                                        editorl =sharedPreferences.edit();

                                        editorl.putString(Config.ID,id);
                                        editorl.putString(Config.NAMA_ORGANISASI,nama_organisasi);
                                        editorl.putString(Config.JENIS_ORGANISASI,jenis_organisasi);
                                        editorl.putString(Config.EMAIL,email);
                                        editorl.putString(Config.NAMA_KETUA,nama_ketua);
                                        editorl.putString(Config.NAMA_WAKIL_KETUA,nama_wakil_ketua);
                                        editorl.putString(Config.NAMA_SEKRETARIS,nama_sekretaris);
                                        editorl.putString(Config.NO_HP_KETUA,no_hp_ketua);
                                        editorl.putString(Config.NO_HP_SEKRETARIS,no_hp_sekretaris);
                                        editorl.putString(Config.NAMA_BENDAHARA,nama_bendahara);
                                        editorl.putString(Config.URL_WEBSITE,url_website);
                                        editorl.putString(Config.JUMLAH_ANGGOTA,jumlah_anggota);
                                        editorl.putString(Config.URL_STRUK_ORGANISASI,url_struk_organisasi);
                                        editorl.putString(Config.URL_LOGO_ORGANISASI,url_logo_organisasi);
                                        editorl.putString(Config.STATUS_ORGANISASI,status_organisasi);
                                        editorl.putString(Config.STATUS_APLIKASI,status_aplikasi);
                                        editorl.putString(Config.DESKRIPSI_ORGANISASI,deskripsi_organisasi);
                                        editorl.putString(Config.TOKEN_FIREBASE,token_firebase);
                                        editorl.putString(Config.HARDWARE_ID,hardware_id);
                                        editorl.putString(Config.USERNAME,username);
                                        editorl.putString(Config.PASSWORD,created_at);
                                        editorl.putString(Config.CREATED_AT,updated_at);
                                        editorl.putString(Config.COUNT_DATA_TABLE_ANGGOTA,count_data_table_anggota);
                                        editorl.putString(Config.COUNT_DATA_TABLE_PEMAKAIAN_RUANG,count_data_table_pemakaian_ruang);

                                        editorl.apply();

                                        Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                        context.startActivity(new Intent(context, HomeActivity.class));
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
            }

            @Override
            public void onFailure(Call<ArrayList<LoginModel>> call, Throwable t) {
                Toast.makeText(context, Config.ERROR_INTERNET, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
