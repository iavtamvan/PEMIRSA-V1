package com.pemirsa.pemirsa.model;

import com.google.gson.annotations.SerializedName;

public class ListDaftarPengurusModel {

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("type_daftar")
    private String typeDaftar;

    @SerializedName("nama_daftar")
    private String namaDaftar;

    @SerializedName("url_image")
    private String url_image;

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTypeDaftar(String typeDaftar) {
        this.typeDaftar = typeDaftar;
    }

    public String getTypeDaftar() {
        return typeDaftar;
    }

    public void setNamaDaftar(String namaDaftar) {
        this.namaDaftar = namaDaftar;
    }

    public String getNamaDaftar() {
        return namaDaftar;
    }
}