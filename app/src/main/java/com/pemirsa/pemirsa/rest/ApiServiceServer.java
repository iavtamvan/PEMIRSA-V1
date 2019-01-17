package com.pemirsa.pemirsa.rest;

import com.pemirsa.pemirsa.model.LoginModel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ApiServiceServer {
    @GET("login/{username}/{password}")
    Call<ArrayList<LoginModel>> getLogin(@Path("username") String username,
                                         @Path("password") String password);
//    @GET("userv1/{id}")
//    Call<ArrayList<LoginModel>> getLogin(@Path("username") String username,
//                                         @Path("password") String password);
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


//    @Multipart
//    @POST("upload.php")
//    Call<Result> postIMmage(@Part MultipartBody.Part image);


}
