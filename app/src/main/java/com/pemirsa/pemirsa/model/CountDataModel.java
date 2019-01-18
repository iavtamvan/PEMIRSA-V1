package com.pemirsa.pemirsa.model;

import com.google.gson.annotations.SerializedName;

public class CountDataModel {

    @SerializedName("count_data_table_anggota")
    private String countDataTableAnggota;

    @SerializedName("count_data_table_pemakaian_ruang")
    private String countDataTablePemakaianRuang;

    @SerializedName("count_data_table_ph")
    private String countDataTablePh;

    public void setCountDataTableAnggota(String countDataTableAnggota) {
        this.countDataTableAnggota = countDataTableAnggota;
    }

    public String getCountDataTableAnggota() {
        return countDataTableAnggota;
    }

    public void setCountDataTablePemakaianRuang(String countDataTablePemakaianRuang) {
        this.countDataTablePemakaianRuang = countDataTablePemakaianRuang;
    }

    public String getCountDataTablePemakaianRuang() {
        return countDataTablePemakaianRuang;
    }

    public void setCountDataTablePh(String countDataTablePh) {
        this.countDataTablePh = countDataTablePh;
    }

    public String getCountDataTablePh() {
        return countDataTablePh;
    }
}