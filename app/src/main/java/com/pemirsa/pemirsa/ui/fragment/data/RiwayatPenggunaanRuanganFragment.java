package com.pemirsa.pemirsa.ui.fragment.data;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.presenter.RiwayatDaftarRuanganPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatPenggunaanRuanganFragment extends Fragment {


    private TextView tvNamaOrganisasi;
    private RecyclerView rv;
    private String idUser, namaOrganisasi;

    private RiwayatDaftarRuanganPresenter riwayatDaftarRuanganPresenter;

    public RiwayatPenggunaanRuanganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_riwayat_penggunaan_ruangan, container, false);
        initView(view);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
        idUser = sharedPreferences.getString(Config.ID, "");
        namaOrganisasi = sharedPreferences.getString(Config.NAMA_ORGANISASI, "");
        tvNamaOrganisasi.setText(namaOrganisasi);

        riwayatDaftarRuanganPresenter = new RiwayatDaftarRuanganPresenter();
        riwayatDaftarRuanganPresenter.riwayatDaftarRuangan(getActivity(), idUser , rv);

        return view;
    }

    private void initView(View view) {
        tvNamaOrganisasi = view.findViewById(R.id.tv_nama_organisasi);
        rv = view.findViewById(R.id.rv);
    }
}
