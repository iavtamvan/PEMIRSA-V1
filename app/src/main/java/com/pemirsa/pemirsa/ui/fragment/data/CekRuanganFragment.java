package com.pemirsa.pemirsa.ui.fragment.data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pemirsa.pemirsa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CekRuanganFragment extends Fragment {


    public CekRuanganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cek_ruangan, container, false);

        return view;
    }

}
