package com.pemirsa.pemirsa.ui.fragment.data;


import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.adapter.ListPengurusVerticalAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.helper.RecyclerItemTouchHelper;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.presenter.ListDataPengurusPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPengurusFragment extends Fragment implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {


    private TextView tvNamaOrganisasi;
    private RecyclerView rv;
    private ListDataPengurusPresenter listDataPengurusPresenter;
    private ListPengurusVerticalAdapter listPengurusVerticalAdapter;
    private ArrayList<AnggotaModel> anggotaModels = new ArrayList<>();

    private String namaOrganisasi;

    public ListPengurusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_pengurus, container, false);
        initView(view);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
        namaOrganisasi = sharedPreferences.getString(Config.NAMA_ORGANISASI, "");
        tvNamaOrganisasi.setText(namaOrganisasi);

        listDataPengurusPresenter = new ListDataPengurusPresenter();
        listPengurusVerticalAdapter = new ListPengurusVerticalAdapter(getActivity(), anggotaModels);
        listDataPengurusPresenter.anggota(getActivity(), namaOrganisasi, "Aktif", rv);
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rv);


        return view;
    }

    private void initView(View view) {
        tvNamaOrganisasi = view.findViewById(R.id.tv_nama_organisasi);
        rv = view.findViewById(R.id.rv);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof ListPengurusVerticalAdapter.ViewHolder) {
            // get the removed item name to display it in snack bar
            Toast.makeText(getActivity(), "Swipe succes", Toast.LENGTH_SHORT).show();

//            // backup of removed item for undo purpose
//            final ClipData.Item deletedItem = anggotaModels.get(viewHolder.getAdapterPosition());
//            final int deletedIndex = viewHolder.getAdapterPosition();
//
//            // remove the item from recycler view
//            listPengurusVerticalAdapter.removeItem(viewHolder.getAdapterPosition());

        }
    }
}
