package com.pemirsa.pemirsa.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Config {
    public static final String SHARED_PRED_NAME = "pemirsa v1";


    public static final String ERROR_INTERNET = "Periksa Koneksi Anda";
    public static final String MENGIRIM_DATA = "Mengirim data...";
    public static final String DATA_BERHASIL_DISIMPAN = "Data Berhasil di Simpan";
    public static final String DATA_GAGAL_DISIMPAN = "Data Gagal di Simpan";
    public static final String DATA_KOSONG = "Data kosong";

    public static final String ID = "id_user";
    public static final String ID_RUANGAN = "id_ruangan";
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
    public static final String TOKEN_FIREBASE_REG_ID = "token_firebasesssssss";
    public static final String HARDWARE_ID = "hardware_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";
    public static final String IDANGGOTA = "idAnggota";
    public static final String URLFOTOPJ = "urlFotoPj";
    public static final String COUNT_DATA_TABLE_ANGGOTA = "count_data_table_anggota";
    public static final String COUNT_DATA_TABLE_PEMAKAIAN_RUANG = "count_data_table_pemakaian_ruang";
    public static final String PATH_IMAGE = "path_image";
    public static final String PATH_FILE_PROPOSAL = "path_file_proposal";
    public static final String DATE_PICKER_FRAGMENT_DIALOG = "DatePickerFragmentDialog";
    public static final String TIME_PICKER_FRAGMENT_DIALOG = "TimePickerFragmentDialog";


    //bundle
    public static final String BUNDLE_TYPE_DAFTAR_PENGURUS = "bundle_type_daftar_pengurus";
    public static final String BUNDLE_ID_PENGURUS = "id_pengurus";
    public static final String BUNDLE_ID_USER = "id_user";
    public static final String BUNDLE_NAMA_ANGGOTA = "nama_anggota";
    public static final String BUNDLE_NIM_ANGGOTA = "nim_anggota";
    public static final String BUNDLE_ORGANISASI_ANGGOTA = "organisasi_anggota";
    public static final String BUNDLE_PRODI_ANGGOTA = "prodi_anggota";
    public static final String BUNDLE_EMAIL_ANGGOTA = "email_anggota";
    public static final String BUNDLE_JABATAN_ANGGOTA = "jabatan_anggota";
    public static final String BUNDLE_NO_HP_ANGGOTA = "no_hp_anggota";
    public static final String BUNDLE_URL_FOTO_KTM_ANGGOTA = "url_foto_ktm_anggota";
    public static final String BUNDLE_URL_FOTO_ANGGOTA = "url_foto_anggota";
    public static final String BUNDLE_STATUS_ANGGOTA = "status_anggota";
    public static final String BUNDLE_TOKEN_ANGGOTA = "token_anggota";

    public static final String BUNDLE_ID_DAFTAR_RUANGAN = "id_daftar_ruangan";
    public static final String BUNDLE_ID_ANGGOTA = "id_anggota";
    public static final String BUNDLE_NAMA_DAFTAR_RUANGAN = "nama_daftar_ruangan";
    public static final String BUNDLE_NAMA_ACARA = "nama_acara";
    public static final String BUNDLE_DESKRIPSI_ACARA = "deskripsi_acara";
    public static final String BUNDLE_TGL_MULAI_DAFTAR_RUANGAN = "tgl_mulai_daftar_ruangan";
    public static final String BUNDLE_TGL_SELESAI_DAFTAR_RUANGAN = "tgl_selesai_daftar_ruangan";
    public static final String BUNDLE_JAM_MULAI_DAFTAR_RUANGAN = "jam_mulai_daftar_ruangan";
    public static final String BUNDLE_JAM_SELESAI_DAFTAR_RUANGAN = "jam_selesai_daftar_ruangan";
    public static final String BUNDLE_NAMA_ORGANISASI_DAFTAR_RUANGAN = "nama_organisasi_daftar_ruangan";
    public static final String BUNDLE_PJ_DAFTAR_RUANGAN = "pj_daftar_ruangan";
    public static final String BUNDLE_JUMLAH_PESERTA_DAFTAR_RUANGAN = "jumlah_peserta_daftar_ruangan";
    public static final String BUNDLE_URL_FILE_DAFTAR_RUANGAN = "url_file_daftar_ruangan";
    public static final String BUNDLE_URL_FOTO_PJ = "url_foto_pj";
    public static final String BUNDLE_STATUS_DAFTAR_RUANGAN = "status_daftar_ruangan";
    public static final String BUNDLE_RATE_RUANGAN = "rate_ruangan";
    public static final String BUNDLE_TOKEN_DAFTAR_RUANGAN = "token_daftar_ruangan";



    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    public static final String TOPIC_GLOBAL = "global";
    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;


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
