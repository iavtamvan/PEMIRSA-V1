package com.pemirsa.pemirsa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;

public class DetailPengurusActivity extends AppCompatActivity {

    private String id_pengurus;
    private String id_user;
    private String nama_anggota;
    private String nim_anggota;
    private String organisasi_anggota;
    private String prodi_anggota;
    private String email_anggota;
    private String jabatan_anggota;
    private String no_hp_anggota;
    private String url_foto_ktm_anggota;
    private String url_foto_anggota;
    private String status_anggota;
    private String token_anggota;
    private String created_at;
    private LinearLayout divContainer;
    private ImageView ivDetailPengurus;
    private TextView tvDetailPengurusNama;
    private TextView tvDetailPengurusJabatan;
    private TextView tvDetailPengurusProdi;
    private TextView tvDetailPengurusNamaOrganisasi;
    private Button btnStatusPengurus;
    private ImageView ivDetailPengurusKtm;
    private LinearLayout divCollapsInfoPengurus;
    private ImageView ivDetailPengurusCollaps;
    private TextView tvDetailPengurusEmail;
    private TextView tvDetailPengurusTelepon;
    private TextView tvDetailPengurusPersetujuan;
    private LinearLayout divContainerDetailPengurus;
    private TextView tvDetailPengurusToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengurus);
        initView();

        id_pengurus = getIntent().getStringExtra(Config.BUNDLE_ID_PENGURUS);
        id_user = getIntent().getStringExtra(Config.BUNDLE_ID_USER);
        nama_anggota = getIntent().getStringExtra(Config.BUNDLE_NAMA_ANGGOTA);
        nim_anggota = getIntent().getStringExtra(Config.BUNDLE_NIM_ANGGOTA);
        organisasi_anggota = getIntent().getStringExtra(Config.BUNDLE_ORGANISASI_ANGGOTA);
        prodi_anggota = getIntent().getStringExtra(Config.BUNDLE_PRODI_ANGGOTA);
        email_anggota = getIntent().getStringExtra(Config.BUNDLE_EMAIL_ANGGOTA);
        jabatan_anggota = getIntent().getStringExtra(Config.BUNDLE_JABATAN_ANGGOTA);
        no_hp_anggota = getIntent().getStringExtra(Config.BUNDLE_NO_HP_ANGGOTA);
        url_foto_ktm_anggota = getIntent().getStringExtra(Config.BUNDLE_URL_FOTO_KTM_ANGGOTA);
        url_foto_anggota = getIntent().getStringExtra(Config.BUNDLE_URL_FOTO_ANGGOTA);
        status_anggota = getIntent().getStringExtra(Config.BUNDLE_STATUS_ANGGOTA);
        token_anggota = getIntent().getStringExtra(Config.BUNDLE_TOKEN_ANGGOTA);
        created_at = getIntent().getStringExtra(Config.CREATED_AT);

        Glide.with(this).load(url_foto_anggota).apply(new RequestOptions().override(300, 300)).into(ivDetailPengurus);
        Glide.with(this).load(url_foto_ktm_anggota).apply(new RequestOptions().override(300, 300)).into(ivDetailPengurusKtm);
        tvDetailPengurusNama.setText(nama_anggota);
        tvDetailPengurusJabatan.setText(jabatan_anggota);
        tvDetailPengurusProdi.setText(prodi_anggota);
        tvDetailPengurusNamaOrganisasi.setText(organisasi_anggota);
        btnStatusPengurus.setText(status_anggota);
        tvDetailPengurusEmail.setText(email_anggota);
        tvDetailPengurusTelepon.setText(no_hp_anggota);

        final String collaps = "ciut";
        divCollapsInfoPengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divContainerDetailPengurus.setVisibility(View.VISIBLE);
            }
        });


    }

    private void initView() {
        divContainer = findViewById(R.id.div_container);
        ivDetailPengurus = findViewById(R.id.iv_detail_pengurus);
        tvDetailPengurusNama = findViewById(R.id.tv_detail_pengurus_nama);
        tvDetailPengurusJabatan = findViewById(R.id.tv_detail_pengurus_jabatan);
        tvDetailPengurusProdi = findViewById(R.id.tv_detail_pengurus_prodi);
        tvDetailPengurusNamaOrganisasi = findViewById(R.id.tv_detail_pengurus_nama_organisasi);
        btnStatusPengurus = findViewById(R.id.btn_status_pengurus);
        ivDetailPengurusKtm = findViewById(R.id.iv_detail_pengurus_ktm);
        divCollapsInfoPengurus = findViewById(R.id.div_collaps_info_pengurus);
        ivDetailPengurusCollaps = findViewById(R.id.iv_detail_pengurus_collaps);
        tvDetailPengurusEmail = findViewById(R.id.tv_detail_pengurus_email);
        tvDetailPengurusTelepon = findViewById(R.id.tv_detail_pengurus_telepon);
        tvDetailPengurusPersetujuan = findViewById(R.id.tv_detail_pengurus_persetujuan);
        divContainerDetailPengurus = findViewById(R.id.div_container_detail_pengurus);
        tvDetailPengurusToken = findViewById(R.id.tv_detail_pengurus_token);
    }
}
