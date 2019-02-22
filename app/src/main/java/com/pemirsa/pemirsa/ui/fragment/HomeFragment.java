package com.pemirsa.pemirsa.ui.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.adapter.HomeListPengurusHorizontalAdapter;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.presenter.HomePresenter;

import java.util.ArrayList;

import ru.alexbykov.nopaginate.callback.OnLoadMoreListener;
import ru.alexbykov.nopaginate.paginate.NoPaginate;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ImageView ivBeranda;
    private TextView tvNamaOrganisasi;
    private TextView tvJenisOrganisasi;
    private TextView tvNamaKetuaOrganisasi;
    private TextView tvNamaWakilKetuaOrganisasi;
    private Button btnStatusApps;
    private TextView tvJumlahAnggota;
    private TextView tvJumlahPh;
    private TextView tvJumlahPemakaianRuangan;
    private ImageView tvInfo;
    private RecyclerView rvDaftarPengurus;
    private TextView tvDeskripsiOrganisasi;
    private TextView tvBacaSalanjutnya;
    private LinearLayout divReadMore;
    private TextView tvNamaSekretaris;
    private TextView tvNamaBendahara;
    private TextView tvWebsite;
    private TextView tvStatusAplikasi;
    private TextView tvUsername;
    private TextView tvRilisAkun;

    private String id;
    private String nama_organisasi;
    private String jenis_organisasi;
    private String email;
    private String nama_ketua;
    private String nama_wakil_ketua;
    private String nama_sekretaris;
    private String no_hp_ketua;
    private String no_hp_sekretaris;
    private String nama_bendahara;
    private String url_website;
    private String jumlah_anggota;
    private String url_struk_organisasi;
    private String url_logo_organisasi;
    private String status_organisasi;
    private String status_aplikasi;
    private String deskripsi_organisasi;
    private String token_firebase;
    private String hardware_id;
    private String username;
    private String created_at;
    private String updated_at;
    private String count_data_table_anggota;
    private String count_data_table_pemakaian_ruang;

    private HomePresenter homePresenter;
    private HomeListPengurusHorizontalAdapter homeListPengurusHorizontalAdapter;
    private ArrayList<AnggotaModel> anggotaModels;
    private ViewSkeletonScreen skeletonScreen;
    private LinearLayout divContainer;
    private FrameLayout divFrameContainer;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        getSharedPref();

        homePresenter = new HomePresenter();
        anggotaModels = new ArrayList<>();
        homeListPengurusHorizontalAdapter = new HomeListPengurusHorizontalAdapter(getActivity(), anggotaModels);
        homePresenter.getDataAnggota(getActivity(), id, rvDaftarPengurus);
        homePresenter.countData(getActivity(), id, tvJumlahAnggota, tvJumlahPemakaianRuangan);
        rvDaftarPengurus.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvDaftarPengurus.setAdapter(homeListPengurusHorizontalAdapter);

        // TODO PAgination
        NoPaginate noPaginate = NoPaginate.with(rvDaftarPengurus)
                .setOnLoadMoreListener(new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        //http or db request
                        homePresenter.getDataAnggota(getActivity(), id, rvDaftarPengurus);
                    }
                })
                .setLoadingTriggerThreshold(5) //0 by default
                .build();
        noPaginate.showLoading(true);

        //TODO Skeleton
        skeletonScreen = Skeleton.bind(view)
                .load(R.layout.fragment_home)
                .shimmer(true)
                .show();
//        ShimmerLayout shimmerText = (ShimmerLayout) view.findViewById(R.id.shimmer_text);
//        shimmerText.startShimmerAnimation();

        return view;
    }

    private void getSharedPref() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
        id = sharedPreferences.getString(Config.ID, "");
        nama_organisasi = sharedPreferences.getString(Config.NAMA_ORGANISASI, "");
        jenis_organisasi = sharedPreferences.getString(Config.JENIS_ORGANISASI, "");
        email = sharedPreferences.getString(Config.EMAIL, "");
        nama_ketua = sharedPreferences.getString(Config.NAMA_KETUA, "");
        nama_wakil_ketua = sharedPreferences.getString(Config.NAMA_WAKIL_KETUA, "");
        nama_sekretaris = sharedPreferences.getString(Config.NAMA_SEKRETARIS, "");
        no_hp_ketua = sharedPreferences.getString(Config.NO_HP_KETUA, "");
        no_hp_sekretaris = sharedPreferences.getString(Config.NO_HP_SEKRETARIS, "");
        nama_bendahara = sharedPreferences.getString(Config.NAMA_BENDAHARA, "");
        url_website = sharedPreferences.getString(Config.URL_WEBSITE, "");
        jumlah_anggota = sharedPreferences.getString(Config.JUMLAH_ANGGOTA, "");
        url_struk_organisasi = sharedPreferences.getString(Config.URL_STRUK_ORGANISASI, "");
        url_logo_organisasi = sharedPreferences.getString(Config.URL_LOGO_ORGANISASI, "");
        status_organisasi = sharedPreferences.getString(Config.STATUS_ORGANISASI, "");
        status_aplikasi = sharedPreferences.getString(Config.STATUS_APLIKASI, "");
        deskripsi_organisasi = sharedPreferences.getString(Config.DESKRIPSI_ORGANISASI, "");
        token_firebase = sharedPreferences.getString(Config.TOKEN_FIREBASE_REG_ID, "");
        hardware_id = sharedPreferences.getString(Config.HARDWARE_ID, "");
        username = sharedPreferences.getString(Config.USERNAME, "");
        created_at = sharedPreferences.getString(Config.PASSWORD, "");
        updated_at = sharedPreferences.getString(Config.CREATED_AT, "");
        count_data_table_anggota = sharedPreferences.getString(Config.COUNT_DATA_TABLE_ANGGOTA, "");
        count_data_table_pemakaian_ruang = sharedPreferences.getString(Config.COUNT_DATA_TABLE_PEMAKAIAN_RUANG, "");

        Glide.with(getActivity()).load(url_logo_organisasi).into(ivBeranda);
        tvNamaOrganisasi.setText(nama_organisasi);
        tvJenisOrganisasi.setText(jenis_organisasi);
        tvNamaKetuaOrganisasi.setText(nama_ketua);
        tvNamaWakilKetuaOrganisasi.setText(nama_wakil_ketua);
        btnStatusApps.setText(status_organisasi); //enaknya dibikin status organisasi atau aplikasi yah?
//        tvJumlahAnggota.setText(count_data_table_anggota + " Anggota"); // null
        tvJumlahPh.setText(null); // null
//        tvJumlahPemakaianRuangan.setText(count_data_table_pemakaian_ruang + " Booking");
        tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Info Organisasi", Toast.LENGTH_SHORT).show();
            }
        });
        tvDeskripsiOrganisasi.setText(deskripsi_organisasi);
        tvNamaSekretaris.setText(nama_sekretaris + " / " + no_hp_sekretaris);
        tvNamaBendahara.setText(nama_bendahara);
        tvWebsite.setText(url_website);
        tvStatusAplikasi.setText(status_aplikasi);
        tvUsername.setText(username);
        tvRilisAkun.setText(created_at);
        tvBacaSalanjutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBacaSalanjutnya.getText().equals("Baca Selanjutnya")) {
                    tvBacaSalanjutnya.setText("Ciutkan");
                    divReadMore.setVisibility(View.VISIBLE);
                } else {
                    tvBacaSalanjutnya.setText("Baca Selanjutnya");
                    divReadMore.setVisibility(View.GONE);
                }
            }
        });

//        skeletonScreen.hide();

    }


    private void initView(View view) {
        ivBeranda = view.findViewById(R.id.iv_beranda);
        tvNamaOrganisasi = view.findViewById(R.id.tv_nama_organisasi);
        tvJenisOrganisasi = view.findViewById(R.id.tv_jenis_organisasi);
        tvNamaKetuaOrganisasi = view.findViewById(R.id.tv_nama_ketua_organisasi);
        tvNamaWakilKetuaOrganisasi = view.findViewById(R.id.tv_nama_wakil_ketua_organisasi);
        btnStatusApps = view.findViewById(R.id.btn_status_apps);
        tvJumlahAnggota = view.findViewById(R.id.tv_jumlah_anggota);
        tvJumlahPh = view.findViewById(R.id.tv_jumlah_ph);
        tvJumlahPemakaianRuangan = view.findViewById(R.id.tv_jumlah_pemakaian_ruangan);
        tvInfo = view.findViewById(R.id.tv_info);
        rvDaftarPengurus = view.findViewById(R.id.rv_daftar_pengurus);
        tvDeskripsiOrganisasi = view.findViewById(R.id.tv_deskripsi_organisasi);
        tvBacaSalanjutnya = view.findViewById(R.id.tv_baca_salanjutnya);
        divReadMore = view.findViewById(R.id.div_read_more);
        tvNamaSekretaris = view.findViewById(R.id.tv_nama_sekretaris);
        tvNamaBendahara = view.findViewById(R.id.tv_nama_bendahara);
        tvWebsite = view.findViewById(R.id.tv_website);
        tvStatusAplikasi = view.findViewById(R.id.tv_status_aplikasi);
        tvUsername = view.findViewById(R.id.tv_username);
        tvRilisAkun = view.findViewById(R.id.tv_rilis_akun);
        divContainer = view.findViewById(R.id.div_container);
        divFrameContainer = view.findViewById(R.id.div_frame_container);
    }
}
