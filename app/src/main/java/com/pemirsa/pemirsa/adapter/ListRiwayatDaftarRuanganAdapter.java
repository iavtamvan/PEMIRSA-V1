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
import com.pemirsa.pemirsa.model.RiwayatDaftarRuanganModel;

import java.util.ArrayList;

public class ListRiwayatDaftarRuanganAdapter extends RecyclerView.Adapter<ListRiwayatDaftarRuanganAdapter.ViewHolder> {
    private Context context;
    private ArrayList<RiwayatDaftarRuanganModel> riwayatDaftarRuanganModels;


    public ListRiwayatDaftarRuanganAdapter(Context context, ArrayList<RiwayatDaftarRuanganModel> riwayatDaftarRuanganModels) {
        this.context = context;
        this.riwayatDaftarRuanganModels = riwayatDaftarRuanganModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_riwayat_daftar_ruang, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(riwayatDaftarRuanganModels.get(i).getUrlFotoPj()).apply(new RequestOptions().override(300, 300)).into(viewHolder.ivListDaftarRuangan);
        viewHolder.tvListDaftarRuanganNama.setText(riwayatDaftarRuanganModels.get(i).getNamaDaftarRuangan());
        viewHolder.tvListDaftarRuanganStatus.setText(riwayatDaftarRuanganModels.get(i).getStatusDaftarRuangan());
        viewHolder.tvListDaftarRuanganPemesanan.setText(riwayatDaftarRuanganModels.get(i).getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return riwayatDaftarRuanganModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivListDaftarRuangan;
        private TextView tvListDaftarRuanganNama;
        private TextView tvListDaftarRuanganStatus;
        private TextView tvListDaftarRuanganPemesanan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivListDaftarRuangan = itemView.findViewById(R.id.iv_list_daftar_ruangan);
            tvListDaftarRuanganNama = itemView.findViewById(R.id.tv_list_daftar_ruangan_nama);
            tvListDaftarRuanganStatus = itemView.findViewById(R.id.tv_list_daftar_ruangan_status);
            tvListDaftarRuanganPemesanan = itemView.findViewById(R.id.tv_list_daftar_ruangan_pemesanan);
        }
    }

    public void removeItem(int position) {
        riwayatDaftarRuanganModels.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

//    }
}
