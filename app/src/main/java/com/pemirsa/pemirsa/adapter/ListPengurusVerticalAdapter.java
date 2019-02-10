package com.pemirsa.pemirsa.adapter;

import android.content.ClipData;
import android.content.Context;
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
import com.pemirsa.pemirsa.model.AnggotaModel;

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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(anggotaModels.get(i).getUrlFotoAnggota()).apply(new RequestOptions().override(300,300)).into(viewHolder.ivListPengurusCircle);
        viewHolder.tvListPengurusNama.setText(anggotaModels.get(i).getNamaAnggota());
        viewHolder.tvListPengurusNim.setText(anggotaModels.get(i).getNimAnggota());
        viewHolder.tvListPengurusNohp.setText(anggotaModels.get(i).getNoHpAnggota());
        viewHolder.tvListPengurusCreatedat.setText(anggotaModels.get(i).getCreatedAt());
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
