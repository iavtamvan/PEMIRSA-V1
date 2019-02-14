package com.pemirsa.pemirsa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.model.ListRuanganModel;

import java.util.ArrayList;

public class ListCekRuanganKosongAdapter extends RecyclerView.Adapter<ListCekRuanganKosongAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ListRuanganModel> listRuanganModels;
    private String statusRuangan;

    public ListCekRuanganKosongAdapter(Context context, ArrayList<ListRuanganModel> listRuanganModels) {
        this.context = context;
        this.listRuanganModels = listRuanganModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_ruangan_kosong, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        Glide.with(context).load(listRuanganModels.get(i).getu()).apply(new RequestOptions().override(300, 300)).into(viewHolder.ivListDaftarRuangan);
        viewHolder.tvListRuanganKosongNama.setText(listRuanganModels.get(i).getNamaRuangan());
        viewHolder.tvListRuanganKosongLokasi.setText(listRuanganModels.get(i).getLokasiRuangan());
        statusRuangan = listRuanganModels.get(i).getStatusRuangan();
        viewHolder.divContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (statusRuangan.contains("Kosong")){
                    Toast.makeText(context, "Ruangan Kosong", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return listRuanganModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout divContainer;
        private TextView tvListRuanganKosongNama;
        private TextView tvListRuanganKosongLokasi;
        private ImageView ivStatusRuangan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            divContainer = itemView.findViewById(R.id.div_container);
            tvListRuanganKosongNama = itemView.findViewById(R.id.tv_list_ruangan_kosong_nama);
            tvListRuanganKosongLokasi = itemView.findViewById(R.id.tv_list_ruangan_kosong_lokasi);
            ivStatusRuangan = itemView.findViewById(R.id.iv_status_ruangan);
        }
    }

    public void removeItem(int position) {
        listRuanganModels.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

//    }
}
