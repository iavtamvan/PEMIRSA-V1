package com.pemirsa.pemirsa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.model.AnggotaModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<AnggotaModel> anggotaModels;

    public HomeAdapter(Context context, ArrayList<AnggotaModel> anggotaModels) {
        this.context = context;
        this.anggotaModels = anggotaModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_anggota_horizontal, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(anggotaModels.get(i).getUrlFotoAnggota()).apply(new RequestOptions().override(600,200)).into(viewHolder.ivListAnggota);
        viewHolder.tvListAnggotaNama.setText(anggotaModels.get(i).getNamaAnggota());
    }

    @Override
    public int getItemCount() {
        return anggotaModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivListAnggota;
        private TextView tvListAnggotaNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivListAnggota = itemView.findViewById(R.id.iv_list_anggota);
            tvListAnggotaNama = itemView.findViewById(R.id.tv_list_anggota_nama);
        }
    }
}
