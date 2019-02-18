package com.pemirsa.pemirsa.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.RiwayatDaftarRuanganModel;
import com.pemirsa.pemirsa.ui.activity.DetailPenggunaanRuanganActivity;
import com.pemirsa.pemirsa.ui.activity.DetailPengurusActivity;

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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(riwayatDaftarRuanganModels.get(i).getUrlFotoPj()).apply(new RequestOptions().override(300, 300)).into(viewHolder.ivListDaftarRuangan);
        viewHolder.tvListDaftarRuanganNama.setText(riwayatDaftarRuanganModels.get(i).getNamaDaftarRuangan());
        viewHolder.tvListDaftarRuanganStatus.setText(riwayatDaftarRuanganModels.get(i).getStatusDaftarRuangan());
        viewHolder.tvListDaftarRuanganPemesanan.setText(riwayatDaftarRuanganModels.get(i).getCreatedAt());

        viewHolder.divContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPenggunaanRuanganActivity.class);
                intent.putExtra(Config.BUNDLE_ID_USER, riwayatDaftarRuanganModels.get(i).getIdUser());
                intent.putExtra(Config.BUNDLE_ID_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getId());
                intent.putExtra(Config.BUNDLE_ID_ANGGOTA, riwayatDaftarRuanganModels.get(i).getIdAnggota());
                intent.putExtra(Config.BUNDLE_NAMA_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getNamaDaftarRuangan());
                intent.putExtra(Config.BUNDLE_NAMA_ACARA, riwayatDaftarRuanganModels.get(i).getNamaAcara());
                intent.putExtra(Config.BUNDLE_DESKRIPSI_ACARA, riwayatDaftarRuanganModels.get(i).getDeskripsiAcara());
                intent.putExtra(Config.BUNDLE_TGL_MULAI_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getTglMulaiDaftarRuangan());
                intent.putExtra(Config.BUNDLE_TGL_SELESAI_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getTglSelesaiDaftarRuangan());
                intent.putExtra(Config.BUNDLE_JAM_MULAI_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getJamMulaiDaftarRuangan());
                intent.putExtra(Config.BUNDLE_JAM_SELESAI_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getJamSelesaiDaftarRuangan());
                intent.putExtra(Config.BUNDLE_NAMA_ORGANISASI_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getNamaOrganisasiDaftarRuangan());
                intent.putExtra(Config.BUNDLE_PJ_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getPjDaftarRuangan());
                intent.putExtra(Config.BUNDLE_JUMLAH_PESERTA_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getJumlahPesertaDaftarRuangan());
                intent.putExtra(Config.BUNDLE_URL_FILE_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getUrlFileDaftarRuangan());
                intent.putExtra(Config.BUNDLE_URL_FOTO_PJ, riwayatDaftarRuanganModels.get(i).getUrlFotoPj());
                intent.putExtra(Config.BUNDLE_STATUS_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getStatusDaftarRuangan());
                intent.putExtra(Config.BUNDLE_RATE_RUANGAN, riwayatDaftarRuanganModels.get(i).getRateRuangan());
                intent.putExtra(Config.BUNDLE_TOKEN_DAFTAR_RUANGAN, riwayatDaftarRuanganModels.get(i).getTokenDaftarRuangan());
                context.startActivity(intent);
            }
        });


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
        private LinearLayout divContainer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            divContainer = itemView.findViewById(R.id.div_container_riwayat);
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
