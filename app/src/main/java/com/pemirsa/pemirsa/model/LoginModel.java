package com.pemirsa.pemirsa.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_organisasi")
    @Expose
    private String namaOrganisasi;
    @SerializedName("jenis_organisasi")
    @Expose
    private String jenis_organisasi;

    public String getJenis_organisasi() {
        return jenis_organisasi;
    }

    public void setJenis_organisasi(String jenis_organisasi) {
        this.jenis_organisasi = jenis_organisasi;
    }

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("deskripsi_organisasi")
    @Expose
    private String deskripsi_organisasi;

    public String getDeskripsi_organisasi() {
        return deskripsi_organisasi;
    }

    public void setDeskripsi_organisasi(String deskripsi_organisasi) {
        this.deskripsi_organisasi = deskripsi_organisasi;
    }

    @SerializedName("nama_ketua")
    @Expose
    private String namaKetua;
    @SerializedName("nama_wakil_ketua")
    @Expose
    private String namaWakilKetua;
    @SerializedName("nama_sekretaris")
    @Expose
    private String namaSekretaris;
    @SerializedName("no_hp_ketua")
    @Expose
    private String noHpKetua;
    @SerializedName("no_hp_sekretaris")
    @Expose
    private String noHpSekretaris;
    @SerializedName("nama_bendahara")
    @Expose
    private String namaBendahara;
    @SerializedName("url_website")
    @Expose
    private String urlWebsite;
    @SerializedName("jumlah_anggota")
    @Expose
    private String jumlahAnggota;
    @SerializedName("url_struk_organisasi")
    @Expose
    private String urlStrukOrganisasi;
    @SerializedName("url_logo_organisasi")
    @Expose
    private String urlLogoOrganisasi;
    @SerializedName("status_organisasi")
    @Expose
    private String statusOrganisasi;
    @SerializedName("status_aplikasi")
    @Expose
    private String statusAplikasi;
    @SerializedName("token_firebase")
    @Expose
    private String tokenFirebase;
    @SerializedName("hardware_id")
    @Expose
    private String hardwareId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaOrganisasi() {
        return namaOrganisasi;
    }

    public void setNamaOrganisasi(String namaOrganisasi) {
        this.namaOrganisasi = namaOrganisasi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaKetua() {
        return namaKetua;
    }

    public void setNamaKetua(String namaKetua) {
        this.namaKetua = namaKetua;
    }

    public String getNamaWakilKetua() {
        return namaWakilKetua;
    }

    public void setNamaWakilKetua(String namaWakilKetua) {
        this.namaWakilKetua = namaWakilKetua;
    }

    public String getNamaSekretaris() {
        return namaSekretaris;
    }

    public void setNamaSekretaris(String namaSekretaris) {
        this.namaSekretaris = namaSekretaris;
    }

    public String getNoHpKetua() {
        return noHpKetua;
    }

    public void setNoHpKetua(String noHpKetua) {
        this.noHpKetua = noHpKetua;
    }

    public String getNoHpSekretaris() {
        return noHpSekretaris;
    }

    public void setNoHpSekretaris(String noHpSekretaris) {
        this.noHpSekretaris = noHpSekretaris;
    }

    public String getNamaBendahara() {
        return namaBendahara;
    }

    public void setNamaBendahara(String namaBendahara) {
        this.namaBendahara = namaBendahara;
    }

    public String getUrlWebsite() {
        return urlWebsite;
    }

    public void setUrlWebsite(String urlWebsite) {
        this.urlWebsite = urlWebsite;
    }

    public String getJumlahAnggota() {
        return jumlahAnggota;
    }

    public void setJumlahAnggota(String jumlahAnggota) {
        this.jumlahAnggota = jumlahAnggota;
    }

    public String getUrlStrukOrganisasi() {
        return urlStrukOrganisasi;
    }

    public void setUrlStrukOrganisasi(String urlStrukOrganisasi) {
        this.urlStrukOrganisasi = urlStrukOrganisasi;
    }

    public String getUrlLogoOrganisasi() {
        return urlLogoOrganisasi;
    }

    public void setUrlLogoOrganisasi(String urlLogoOrganisasi) {
        this.urlLogoOrganisasi = urlLogoOrganisasi;
    }

    public String getStatusOrganisasi() {
        return statusOrganisasi;
    }

    public void setStatusOrganisasi(String statusOrganisasi) {
        this.statusOrganisasi = statusOrganisasi;
    }

    public String getStatusAplikasi() {
        return statusAplikasi;
    }

    public void setStatusAplikasi(String statusAplikasi) {
        this.statusAplikasi = statusAplikasi;
    }

    public String getTokenFirebase() {
        return tokenFirebase;
    }

    public void setTokenFirebase(String tokenFirebase) {
        this.tokenFirebase = tokenFirebase;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
