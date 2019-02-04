package com.pemirsa.pemirsa.rest.uploadImage;

import com.pemirsa.pemirsa.rest.ApiServiceServer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LENOVO on 26/10/2017.
 */

public class RetroClient {


//    private static final String ROOT_URL = "http://inssang.can.web.id/images/";
    private static final String ROOT_URL = "http://indiku.id/image/upload_client/";

    public RetroClient(){
    }

    private static Retrofit getRetrofitClient(){
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

    }

    public static ApiServiceServer getService(){
        return getRetrofitClient().create(ApiServiceServer.class);
    }
}
