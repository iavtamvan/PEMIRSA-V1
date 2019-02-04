package com.pemirsa.pemirsa.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class Config {
    public static final String SHARED_PRED_NAME = "pemirsa v1";


    public static final String ERROR_INTERNET = "Periksa Koneksi Anda";
    public static final String MENGIRIM_DATA = "Mengirim data...";
    public static final String DATA_BERHASIL_DISIMPAN = "Data Berhasil di Simpan";
    public static final String DATA_GAGAL_DISIMPAN = "Data Gagal di Simpan";
    public static final String DATA_KOSONG =  "Data kosong";

    public static final String ID = "id_user";
    public static final String NAMA_ORGANISASI = "nama_organisasi";
    public static final String JENIS_ORGANISASI = "jenis_organisasi";
    public static final String EMAIL = "email";
    public static final String NAMA_KETUA = "nama_ketua";
    public static final String NAMA_WAKIL_KETUA = "nama_wakil_ketua";
    public static final String NAMA_SEKRETARIS = "nama_sekretaris";
    public static final String NO_HP_KETUA = "no_hp_ketua";
    public static final String NO_HP_SEKRETARIS = "no_hp_sekretaris";
    public static final String NAMA_BENDAHARA = "nama_bendahara";
    public static final String URL_WEBSITE = "url_website";
    public static final String JUMLAH_ANGGOTA = "jumlah_anggota";
    public static final String URL_STRUK_ORGANISASI = "url_struk_organisasi";
    public static final String URL_LOGO_ORGANISASI = "url_logo_organisasi";
    public static final String STATUS_ORGANISASI = "status_organisasi";
    public static final String STATUS_APLIKASI = "status_aplikasi";
    public static final String DESKRIPSI_ORGANISASI = "deskripsi_organisasi";
    public static final String TOKEN_FIREBASE = "token_firebase";
    public static final String HARDWARE_ID = "hardware_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";

    public static final String COUNT_DATA_TABLE_ANGGOTA = "count_data_table_anggota";
    public static final String COUNT_DATA_TABLE_PEMAKAIAN_RUANG = "count_data_table_pemakaian_ruang";


    public static final String BUNDLE_TYPE_DAFTAR_PENGURUS = "bundle_type_daftar_pengurus";

    public static final String PATH_IMAGE = "path_image";


    public static final String DATE_PICKER_FRAGMENT_DIALOG = "DatePickerFragmentDialog";
    public static final String TIME_PICKER_FRAGMENT_DIALOG = "TimePickerFragmentDialog";

    public static String getDateOnly(long time) {
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(time);
    }

    public static String getDateAndTime(long time) {
        SimpleDateFormat sample = new SimpleDateFormat("dd MMM yyyy, hh:mma", Locale.getDefault());
        return sample.format(new Date(time));
    }

    public static String getTimeOnly(long time) {
        SimpleDateFormat sample = new SimpleDateFormat("hh:mma", Locale.getDefault());
        return sample.format(time);
    }
}
