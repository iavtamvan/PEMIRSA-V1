package com.pemirsa.pemirsa.adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.ui.activity.DetailPengurusActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListPengurusVerticalAdapter extends RecyclerView.Adapter<ListPengurusVerticalAdapter.ViewHolder> {
    private Context context;
    private ArrayList<AnggotaModel> anggotaModels;

    public ListPengurusVerticalAdapter(Context context, ArrayList<AnggotaModel> anggotaModels) {
        this.context = context;
        this.anggotaModels = anggotaModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_pengurus_vertical, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(anggotaModels.get(i).getUrlFotoAnggota()).apply(new RequestOptions().override(300,300)).into(viewHolder.ivListPengurusCircle);
        viewHolder.tvListPengurusNama.setText(anggotaModels.get(i).getNamaAnggota());
        viewHolder.tvListPengurusNim.setText(anggotaModels.get(i).getNimAnggota());
        viewHolder.tvListPengurusNohp.setText(anggotaModels.get(i).getNoHpAnggota());
        viewHolder.tvListPengurusCreatedat.setText(anggotaModels.get(i).getCreatedAt());

        viewHolder.cvKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPengurusActivity.class);
                intent.putExtra(Config.BUNDLE_ID_PENGURUS, anggotaModels.get(i).getId());
                intent.putExtra(Config.BUNDLE_ID_USER, anggotaModels.get(i).getIdUser());
                intent.putExtra(Config.BUNDLE_NAMA_ANGGOTA, anggotaModels.get(i).getNamaAnggota());
                intent.putExtra(Config.BUNDLE_NIM_ANGGOTA, anggotaModels.get(i).getNimAnggota());
                intent.putExtra(Config.BUNDLE_ORGANISASI_ANGGOTA, anggotaModels.get(i).getOrganisasiAnggota());
                intent.putExtra(Config.BUNDLE_PRODI_ANGGOTA, anggotaModels.get(i).getProdiAnggota());
                intent.putExtra(Config.BUNDLE_EMAIL_ANGGOTA, anggotaModels.get(i).getEmailAnggota());
                intent.putExtra(Config.BUNDLE_JABATAN_ANGGOTA, anggotaModels.get(i).getJabatanAnggota());
                intent.putExtra(Config.BUNDLE_NO_HP_ANGGOTA, anggotaModels.get(i).getNoHpAnggota());
                intent.putExtra(Config.BUNDLE_URL_FOTO_KTM_ANGGOTA, anggotaModels.get(i).getUrlFotoKtmAnggota());
                intent.putExtra(Config.BUNDLE_URL_FOTO_ANGGOTA, anggotaModels.get(i).getUrlFotoAnggota());
                intent.putExtra(Config.BUNDLE_STATUS_ANGGOTA, anggotaModels.get(i).getStatusAnggota());
                intent.putExtra(Config.BUNDLE_TOKEN_ANGGOTA, anggotaModels.get(i).getTokenAnggota());
                intent.putExtra(Config.CREATED_AT, anggotaModels.get(i).getCreatedAt());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return anggotaModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cvKlik;
        private CircleImageView ivListPengurusCircle;
        private TextView tvListPengurusNama;
        private TextView tvListPengurusNim;
        private TextView tvListPengurusNohp;
        private TextView tvListPengurusCreatedat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvKlik = itemView.findViewById(R.id.cv_klik);
            ivListPengurusCircle = itemView.findViewById(R.id.iv_list_pengurus_circle);
            tvListPengurusNama = itemView.findViewById(R.id.tv_list_pengurus_nama);
            tvListPengurusNim = itemView.findViewById(R.id.tv_list_pengurus_nim);
            tvListPengurusNohp = itemView.findViewById(R.id.tv_list_pengurus_nohp);
            tvListPengurusCreatedat = itemView.findViewById(R.id.tv_list_pengurus_createdat);
        }
    }

    public void removeItem(int position) {
        anggotaModels.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

//    }
}
