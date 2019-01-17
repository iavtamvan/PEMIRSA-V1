package com.pemirsa.pemirsa.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pemirsa.pemirsa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private ImageView ivBeranda;
    private TextView tvNamaOrganisasi;
    private TextView tvJenisOrganisasi;
    private TextView tvNamaKetuaOrganisasi;
    private TextView tvNamaWakilKetuaOrganisasi;
    private Button btnStatusApps;
    private TextView tvJumlahAnggota;
    private TextView tvJumlahPh;
    private TextView tvJumlahPemakaianRuangan;
    private ImageView tvInfo;
    private RecyclerView rvDaftarPengurus;
    private TextView tvDeskripsiOrganisasi;
    private TextView tvBacaSalanjutnya;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);


        return view;
    }

    private void initView(View view) {
        ivBeranda = view.findViewById(R.id.iv_beranda);
        tvNamaOrganisasi = view.findViewById(R.id.tv_nama_organisasi);
        tvJenisOrganisasi = view.findViewById(R.id.tv_jenis_organisasi);
        tvNamaKetuaOrganisasi = view.findViewById(R.id.tv_nama_ketua_organisasi);
        tvNamaWakilKetuaOrganisasi = view.findViewById(R.id.tv_nama_wakil_ketua_organisasi);
        btnStatusApps = view.findViewById(R.id.btn_status_apps);
        tvJumlahAnggota = view.findViewById(R.id.tv_jumlah_anggota);
        tvJumlahPh = view.findViewById(R.id.tv_jumlah_ph);
        tvJumlahPemakaianRuangan = view.findViewById(R.id.tv_jumlah_pemakaian_ruangan);
        tvInfo = view.findViewById(R.id.tv_info);
        rvDaftarPengurus = view.findViewById(R.id.rv_daftar_pengurus);
        tvDeskripsiOrganisasi = view.findViewById(R.id.tv_deskripsi_organisasi);
        tvBacaSalanjutnya = view.findViewById(R.id.tv_baca_salanjutnya);
    }
}
