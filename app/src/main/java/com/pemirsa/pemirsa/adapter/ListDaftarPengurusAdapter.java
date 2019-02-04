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
import com.pemirsa.pemirsa.model.ListDaftarPengurusModel;

import java.util.ArrayList;

public class ListDaftarPengurusAdapter extends RecyclerView.Adapter<ListDaftarPengurusAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListDaftarPengurusModel> listDaftarPengurusModels;

    public ListDaftarPengurusAdapter(Context context, ArrayList<ListDaftarPengurusModel> listDaftarPengurusModels) {
        this.context = context;
        this.listDaftarPengurusModels = listDaftarPengurusModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_daftar_pengurus, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(listDaftarPengurusModels.get(i).getUrl_image()).apply(new RequestOptions().override(600, 200)).into(viewHolder.ivListDaftarPengurus);
        viewHolder.tvListDaftarPengurusType.setText(listDaftarPengurusModels.get(i).getNamaDaftar());
    }

    @Override
    public int getItemCount() {
        return listDaftarPengurusModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivListDaftarPengurus;
        private TextView tvListDaftarPengurusType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivListDaftarPengurus = itemView.findViewById(R.id.iv_list_daftar_pengurus);
            tvListDaftarPengurusType = itemView.findViewById(R.id.tv_list_daftar_pengurus_type);
        }
    }
}
