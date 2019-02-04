package com.pemirsa.pemirsa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.adapter.ListDaftarPengurusAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.ListDaftarPengurusModel;
import com.pemirsa.pemirsa.presenter.DaftarPengurusPresenter;
import com.pemirsa.pemirsa.presenter.ListDaftarPengurusPresenter;

import java.util.ArrayList;

public class ListDaftarPengurusActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<ListDaftarPengurusModel> listDaftarPengurusModels;
    private ListDaftarPengurusAdapter listDaftarPengurusAdapter;

    private ListDaftarPengurusPresenter listDaftarPengurusPresenter;

    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_daftar_pengurus);
        initView();

        Intent intent = getIntent();
        type = intent.getStringExtra(Config.BUNDLE_TYPE_DAFTAR_PENGURUS);

        listDaftarPengurusPresenter = new ListDaftarPengurusPresenter();
        listDaftarPengurusModels = new ArrayList<>();
        listDaftarPengurusAdapter = new ListDaftarPengurusAdapter(ListDaftarPengurusActivity.this, listDaftarPengurusModels);
//        listDaftarPengurusPresenter.getDataListPengurus(getApplicationContext(), type, rv);


//        rv.setLayoutManager(new LinearLayoutManager(ListDaftarPengurusActivity.this));
//        rv.setAdapter(listDaftarPengurusAdapter);
//        listDaftarPengurusAdapter.notifyDataSetChanged();


    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }
}
