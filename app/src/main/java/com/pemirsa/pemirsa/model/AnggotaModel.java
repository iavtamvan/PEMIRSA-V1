package com.pemirsa.pemirsa.model;

import com.google.gson.annotations.SerializedName;

public class AnggotaModel {

    @SerializedName("no_hp_anggota")
    private String noHpAnggota;

    @SerializedName("nim_anggota")
    private String nimAnggota;

    @SerializedName("organisasi_anggota")
    private String organisasiAnggota;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("jabatan_anggota")
    private String jabatanAnggota;

    @SerializedName("url_foto_ktm_anggota")
    private String urlFotoKtmAnggota;

    @SerializedName("token_anggota")
    private Object tokenAnggota;

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

    public String getNoHpAnggota() {
        return noHpAnggota;
    }

    public String getNimAnggota() {
        return nimAnggota;
    }

    public String getOrganisasiAnggota() {
        return organisasiAnggota;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getJabatanAnggota() {
        return jabatanAnggota;
    }

    public String getUrlFotoKtmAnggota() {
        return urlFotoKtmAnggota;
    }

    public Object getTokenAnggota() {
        return tokenAnggota;
    }

    public String getProdiAnggota() {
        return prodiAnggota;
    }

    public String getEmailAnggota() {
        return emailAnggota;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUrlFotoAnggota() {
        return urlFotoAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public String getId() {
        return id;
    }

    public String getStatusAnggota() {
        return statusAnggota;
    }
}