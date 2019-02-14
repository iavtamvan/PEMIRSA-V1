package com.pemirsa.pemirsa.ui.fragment.data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.presenter.PenggunaanRuanganPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CekRuanganFragment extends Fragment {
    private PenggunaanRuanganPresenter penggunaanRuanganPresenter;
    private RecyclerView rv;


    public CekRuanganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cek_ruangan, container, false);
        initView(view);

        penggunaanRuanganPresenter = new PenggunaanRuanganPresenter();
        penggunaanRuanganPresenter.cekListRuangan(getActivity(), rv);

        return view;
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rv);
    }
}
