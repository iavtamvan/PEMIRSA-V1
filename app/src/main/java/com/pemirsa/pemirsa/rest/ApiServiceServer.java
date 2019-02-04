package com.pemirsa.pemirsa.rest;

import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.model.CountDataModel;
import com.pemirsa.pemirsa.model.ErrorMsgModel;
import com.pemirsa.pemirsa.model.ListDaftarPengurusModel;
import com.pemirsa.pemirsa.model.LoginModel;
import com.pemirsa.pemirsa.model.Result;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface ApiServiceServer {
    @GET("login/{username}/{password}")
    Call<ArrayList<LoginModel>> getLogin(@Path("username") String username,
                                         @Path("password") String password);
    @GET("anggota/count/{id}")
    Call<ArrayList<CountDataModel>> getDataCount(@Path("id") String id);
    @GET("anggota/{id}")
    Call<ArrayList<AnggotaModel>> getDataAnggota(@Path("id") String id);
    @GET("listdaftarpengurus/{type}")
    Call<ArrayList<ListDaftarPengurusModel>> getDataListDaftarPengurus(@Path("type") String id);

    @FormUrlEncoded
    @POST("anggota")
    Call<ArrayList<ErrorMsgModel>> postDataPengurus(@Field("id_user") String id_user,
                                                    @Field("nama_anggota") String nama_anggota,
                                                    @Field("nim_anggota") String nim_anggota,
                                                    @Field("prodi_anggota") String prodi_anggota,
                                                    @Field("email_anggota") String email_anggota,
                                                    @Field("jabatan_anggota") String jabatan_anggota,
                                                    @Field("no_hp_anggota") String no_hp_anggota,
                                                    @Field("url_foto_ktm_anggota") String url_foto_ktm_anggota,
                                                    @Field("url_foto_anggota") String url_foto_anggota,
                                                    @Field("status_anggota") String status_anggota);

    @GET("getLatLong.php")
    Call<ResponseBody> getTps();
    @FormUrlEncoded
    @POST("daftarAsuransi.php")
    Call<ResponseBody> postPendaftaranAgenUser(@Field("id_user") String id,
                                               @Field("nomer_verif") String noVeriv,
                                               @Field("nama") String nama,
                                               @Field("tempat_lahir") String tempatlahir,
                                               @Field("tanggal_lahir") String tgllahir,
                                               @Field("jenis_kelamin") String jk,
                                               @Field("alamat") String alamat,
                                               @Field("agama") String agama,
                                               @Field("no_telp") String nohp,
                                               @Field("pekerjaan") String pekerjaan,
                                               @Field("kewarganegaraan") String kewarganegaraan,
                                               @Field("status_kawin") String statuskawin,
                                               @Field("id_jns_asuransi") String idjnsasuransi);


    @Multipart
    @POST("upload.php")
    Call<Result> postIMmage(@Part MultipartBody.Part image);


}
