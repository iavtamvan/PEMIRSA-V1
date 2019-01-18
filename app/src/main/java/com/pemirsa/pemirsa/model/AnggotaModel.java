package com.pemirsa.pemirsa.model;

import com.google.gson.annotations.SerializedName;

public class AnggotaModel {

    @SerializedName("no_hp_anggota")
    private String noHpAnggota;

    @SerializedName("nim_anggota")
    private String nimAnggota;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("jabatan_anggota")
    private String jabatanAnggota;

    @SerializedName("url_foto_ktm_anggota")
    private String urlFotoKtmAnggota;

    @SerializedName("prodi_anggota")
    private String prodiAnggota;

    @SerializedName("email_anggota")
    private String emailAnggota;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("url_foto_anggota")
    private String urlFotoAnggota;

    @SerializedName("nama_anggota")
    private String namaAnggota;

    @SerializedName("id")
    private String id;

    @SerializedName("status_anggota")
    private String statusAnggota;

    public void setNoHpAnggota(String noHpAnggota) {
        this.noHpAnggota = noHpAnggota;
    }

    public String getNoHpAnggota() {
        return noHpAnggota;
    }

    public void setNimAnggota(String nimAnggota) {
        this.nimAnggota = nimAnggota;
    }

    public String getNimAnggota() {
        return nimAnggota;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setJabatanAnggota(String jabatanAnggota) {
        this.jabatanAnggota = jabatanAnggota;
    }

    public String getJabatanAnggota() {
        return jabatanAnggota;
    }

    public void setUrlFotoKtmAnggota(String urlFotoKtmAnggota) {
        this.urlFotoKtmAnggota = urlFotoKtmAnggota;
    }

    public String getUrlFotoKtmAnggota() {
        return urlFotoKtmAnggota;
    }

    public void setProdiAnggota(String prodiAnggota) {
        this.prodiAnggota = prodiAnggota;
    }

    public String getProdiAnggota() {
        return prodiAnggota;
    }

    public void setEmailAnggota(String emailAnggota) {
        this.emailAnggota = emailAnggota;
    }

    public String getEmailAnggota() {
        return emailAnggota;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUrlFotoAnggota(String urlFotoAnggota) {
        this.urlFotoAnggota = urlFotoAnggota;
    }

    public String getUrlFotoAnggota() {
        return urlFotoAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setStatusAnggota(String statusAnggota) {
        this.statusAnggota = statusAnggota;
    }

    public String getStatusAnggota() {
        return statusAnggota;
    }
}