package com.pemirsa.pemirsa.model;

import com.google.gson.annotations.SerializedName;

public class ListRuanganModel {

    @SerializedName("jenis_ruangan")
    private String jenisRuangan;

    @SerializedName("fasilitas_ruangan")
    private String fasilitasRuangan;

    @SerializedName("url_foto1_ruangan")
    private String urlFoto1Ruangan;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("lokasi_ruangan")
    private String lokasiRuangan;

    @SerializedName("url_foto2_ruangan")
    private String urlFoto2Ruangan;

    @SerializedName("status_ruangan")
    private String statusRuangan;

    @SerializedName("kapasitas_ruangan")
    private String kapasitasRuangan;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("url_image_tumbnail")
    private String urlImageTumbnail;

    @SerializedName("url_foto3_ruangan")
    private String urlFoto3Ruangan;

    @SerializedName("id")
    private String id;

    @SerializedName("nama_ruangan")
    private String namaRuangan;

    @SerializedName("url_foto4_ruangan")
    private String urlFoto4Ruangan;

    public void setJenisRuangan(String jenisRuangan) {
        this.jenisRuangan = jenisRuangan;
    }

    public String getJenisRuangan() {
        return jenisRuangan;
    }

    public void setFasilitasRuangan(String fasilitasRuangan) {
        this.fasilitasRuangan = fasilitasRuangan;
    }

    public String getFasilitasRuangan() {
        return fasilitasRuangan;
    }

    public void setUrlFoto1Ruangan(String urlFoto1Ruangan) {
        this.urlFoto1Ruangan = urlFoto1Ruangan;
    }

    public String getUrlFoto1Ruangan() {
        return urlFoto1Ruangan;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setLokasiRuangan(String lokasiRuangan) {
        this.lokasiRuangan = lokasiRuangan;
    }

    public String getLokasiRuangan() {
        return lokasiRuangan;
    }

    public void setUrlFoto2Ruangan(String urlFoto2Ruangan) {
        this.urlFoto2Ruangan = urlFoto2Ruangan;
    }

    public String getUrlFoto2Ruangan() {
        return urlFoto2Ruangan;
    }

    public void setStatusRuangan(String statusRuangan) {
        this.statusRuangan = statusRuangan;
    }

    public String getStatusRuangan() {
        return statusRuangan;
    }

    public void setKapasitasRuangan(String kapasitasRuangan) {
        this.kapasitasRuangan = kapasitasRuangan;
    }

    public String getKapasitasRuangan() {
        return kapasitasRuangan;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUrlImageTumbnail(String urlImageTumbnail) {
        this.urlImageTumbnail = urlImageTumbnail;
    }

    public String getUrlImageTumbnail() {
        return urlImageTumbnail;
    }

    public void setUrlFoto3Ruangan(String urlFoto3Ruangan) {
        this.urlFoto3Ruangan = urlFoto3Ruangan;
    }

    public String getUrlFoto3Ruangan() {
        return urlFoto3Ruangan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setUrlFoto4Ruangan(String urlFoto4Ruangan) {
        this.urlFoto4Ruangan = urlFoto4Ruangan;
    }

    public String getUrlFoto4Ruangan() {
        return urlFoto4Ruangan;
    }

    @Override
    public String toString() {
        return
                "ListRuanganModel{" +
                        "jenis_ruangan = '" + jenisRuangan + '\'' +
                        ",fasilitas_ruangan = '" + fasilitasRuangan + '\'' +
                        ",url_foto1_ruangan = '" + urlFoto1Ruangan + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",lokasi_ruangan = '" + lokasiRuangan + '\'' +
                        ",url_foto2_ruangan = '" + urlFoto2Ruangan + '\'' +
                        ",status_ruangan = '" + statusRuangan + '\'' +
                        ",kapasitas_ruangan = '" + kapasitasRuangan + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",url_image_tumbnail = '" + urlImageTumbnail + '\'' +
                        ",url_foto3_ruangan = '" + urlFoto3Ruangan + '\'' +
                        ",id = '" + id + '\'' +
                        ",nama_ruangan = '" + namaRuangan + '\'' +
                        ",url_foto4_ruangan = '" + urlFoto4Ruangan + '\'' +
                        "}";
    }
}