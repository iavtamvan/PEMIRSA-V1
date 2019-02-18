package com.pemirsa.pemirsa.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;

public class DetailPenggunaanRuanganActivity extends AppCompatActivity {

    private ImageView ivDetailPenggunaanRuangan;
    private TextView tvDetailPenggunaanRuanganNama;
    private TextView tvDetailPenggunaanRuanganNamaOrganisasi;
    private Button btnDetailPenggunaanRuanganStatus;
    private TextView tvDetailPenggunaanRuanganTargetPeserta;
    private TextView tvDetailPenggunaanRuanganPj;
    private TextView tvDetailPenggunaanRuanganNamaAcara;
    private TextView tvDetailPenggunaanRuanganHariTanggalMulai;
    private TextView tvDetailPenggunaanRuanganHariTanggalSelesai;
    private ImageView ivDetailPenggunaanRuanganFotopj;
    private TextView tvDetailPenggunaanRuanganDeskripsiAcara;
    private TextView tvDetailPenggunaanRuanganFilePermohonan;
    private TextView tvDetailPenggunaanRuanganToken;

    private String id_user;
    private String id_daftar_ruangan;
    private String id_anggota;
    private String nama_daftar_ruangan;
    private String nama_acara;
    private String deskripsi_acara;
    private String tgl_mulai_daftar_ruangan;
    private String tgl_selesai_daftar_ruangan;
    private String jam_mulai_daftar_ruangan;
    private String jam_selesai_daftar_ruangan;
    private String nama_organisasi_daftar_ruangan;
    private String pj_daftar_ruangan;
    private String jumlah_peserta_daftar_ruangan;
    private String url_file_daftar_ruangan;
    private String url_foto_pj;
    private String status_daftar_ruangan;
    private String rate_ruangan;
    private String token_daftar_ruangan;
    private String url_foto_organisasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penggunaan_ruangan);
        initView();
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PRED_NAME, MODE_PRIVATE);
        url_foto_organisasi = sharedPreferences.getString(Config.URL_LOGO_ORGANISASI, "");


        id_user = getIntent().getStringExtra(Config.BUNDLE_ID_USER);
        id_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_ID_DAFTAR_RUANGAN);
        id_anggota = getIntent().getStringExtra(Config.BUNDLE_ID_ANGGOTA);
        nama_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_NAMA_DAFTAR_RUANGAN);
        nama_acara = getIntent().getStringExtra(Config.BUNDLE_NAMA_ACARA);
        deskripsi_acara = getIntent().getStringExtra(Config.BUNDLE_DESKRIPSI_ACARA);
        tgl_mulai_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_TGL_MULAI_DAFTAR_RUANGAN);
        tgl_selesai_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_TGL_SELESAI_DAFTAR_RUANGAN);
        jam_mulai_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_JAM_MULAI_DAFTAR_RUANGAN);
        jam_selesai_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_JAM_SELESAI_DAFTAR_RUANGAN);
        nama_organisasi_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_NAMA_ORGANISASI_DAFTAR_RUANGAN);
        pj_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_PJ_DAFTAR_RUANGAN);
        jumlah_peserta_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_JUMLAH_PESERTA_DAFTAR_RUANGAN);
        url_file_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_URL_FILE_DAFTAR_RUANGAN);
        url_foto_pj = getIntent().getStringExtra(Config.BUNDLE_URL_FOTO_PJ);
        status_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_STATUS_DAFTAR_RUANGAN);
        rate_ruangan = getIntent().getStringExtra(Config.BUNDLE_RATE_RUANGAN);
        token_daftar_ruangan = getIntent().getStringExtra(Config.BUNDLE_TOKEN_DAFTAR_RUANGAN);

        Glide.with(this).load(url_foto_organisasi).apply(new RequestOptions().override(300, 300)).into(ivDetailPenggunaanRuangan);
        Glide.with(this).load(url_foto_pj).apply(new RequestOptions().override(300, 300)).into(ivDetailPenggunaanRuanganFotopj);

        tvDetailPenggunaanRuanganNama.setText(nama_daftar_ruangan);
        tvDetailPenggunaanRuanganNamaOrganisasi.setText(nama_organisasi_daftar_ruangan);
        btnDetailPenggunaanRuanganStatus.setText(status_daftar_ruangan);
        tvDetailPenggunaanRuanganTargetPeserta.setText("Target Peserta\n" + jumlah_peserta_daftar_ruangan);
        tvDetailPenggunaanRuanganPj.setText(pj_daftar_ruangan);
        tvDetailPenggunaanRuanganNamaAcara.setText(nama_acara);
        tvDetailPenggunaanRuanganHariTanggalMulai.setText(tgl_mulai_daftar_ruangan + " " + jam_mulai_daftar_ruangan);
        tvDetailPenggunaanRuanganHariTanggalSelesai.setText(tgl_selesai_daftar_ruangan + " " + jam_selesai_daftar_ruangan);
        tvDetailPenggunaanRuanganDeskripsiAcara.setText(deskripsi_acara);
        tvDetailPenggunaanRuanganFilePermohonan.setText(url_file_daftar_ruangan);
        tvDetailPenggunaanRuanganToken.setText(token_daftar_ruangan);

    }

    private void initView() {
        ivDetailPenggunaanRuangan = findViewById(R.id.iv_detail_penggunaan_ruangan);
        tvDetailPenggunaanRuanganNama = findViewById(R.id.tv_detail_penggunaan_ruangan_nama);
        tvDetailPenggunaanRuanganNamaOrganisasi = findViewById(R.id.tv_detail_penggunaan_ruangan_nama_organisasi);
        btnDetailPenggunaanRuanganStatus = findViewById(R.id.btn_detail_penggunaan_ruangan_status);
        tvDetailPenggunaanRuanganTargetPeserta = findViewById(R.id.tv_detail_penggunaan_ruangan_target_peserta);
        tvDetailPenggunaanRuanganPj = findViewById(R.id.tv_detail_penggunaan_ruangan_pj);
        tvDetailPenggunaanRuanganNamaAcara = findViewById(R.id.tv_detail_penggunaan_ruangan_nama_acara);
        tvDetailPenggunaanRuanganHariTanggalMulai = findViewById(R.id.tv_detail_penggunaan_ruangan_hari_tanggal_mulai);
        tvDetailPenggunaanRuanganHariTanggalSelesai = findViewById(R.id.tv_detail_penggunaan_ruangan_hari_tanggal_selesai);
        ivDetailPenggunaanRuanganFotopj = findViewById(R.id.iv_detail_penggunaan_ruangan_fotopj);
        tvDetailPenggunaanRuanganDeskripsiAcara = findViewById(R.id.tv_detail_penggunaan_ruangan_deskripsi_acara);
        tvDetailPenggunaanRuanganFilePermohonan = findViewById(R.id.tv_detail_penggunaan_ruangan_file_permohonan);
        tvDetailPenggunaanRuanganToken = findViewById(R.id.tv_detail_penggunaan_ruangan_token);
    }
}
