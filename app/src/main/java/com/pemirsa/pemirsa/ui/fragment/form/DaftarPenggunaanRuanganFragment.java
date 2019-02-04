package com.pemirsa.pemirsa.ui.fragment.form;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fastaccess.datetimepicker.DatePickerFragmentDialog;
import com.fastaccess.datetimepicker.DateTimeBuilder;
import com.fastaccess.datetimepicker.callback.DatePickerCallback;
import com.fastaccess.datetimepicker.callback.TimePickerCallback;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.presenter.DaftarPenggunaanRuanganPresenter;

import java.util.ArrayList;
import java.util.Calendar;

import static com.pemirsa.pemirsa.helper.Config.getDateAndTime;
import static com.pemirsa.pemirsa.helper.Config.getTimeOnly;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarPenggunaanRuanganFragment extends Fragment implements DatePickerCallback, TimePickerCallback {


    private TextInputEditText edtNamaAcara;
    private TextInputEditText edtNamaDeskripsiAcara;
    private LinearLayout divTanggalMulaiDaftarRuangan;
    private TextView tvTanggalMulaiDaftarRuangan;
    private LinearLayout divTanggalSelesaiDaftarRuangan;
    private TextView tvTanggalSelesaiDaftarRuangan;
    private LinearLayout divJamMulaiDaftarRuangan;
    private TextView tvJamMulaiDaftarRuangan;
    private LinearLayout divJamSelesaiDaftarRuangan;
    private TextView tvJamSelesaiDaftarRuangan;
    private LinearLayout divNamaOrganisasi;
    private TextView tvNamaOrganisasi;
    private LinearLayout divProdi;
    private Spinner spnNamaRuangan;
    private LinearLayout divPjRuangan;
    private Spinner spnPenanggungJawabRuangan;
    private TextInputEditText edtJumlahPeserta;
    private TextView tvNameFile;
    private Button btnPilihFileProposal;
    private TextView tvTokenPenggunaanRuangan;
    private Button btnKirimPenggunaanRuangan;

    private DaftarPenggunaanRuanganPresenter daftarPenggunaanRuanganPresenter;
    private ArrayList<AnggotaModel> anggotaModels = new ArrayList<>();
    private String prodi, idAnggota, idUser, urlFotoPj;

    public DaftarPenggunaanRuanganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daftar_penggunaan_ruangan, container, false);
        initView(view);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
        prodi = sharedPreferences.getString(Config.NAMA_ORGANISASI, "");
        idUser = sharedPreferences.getString(Config.ID, "");
        daftarPenggunaanRuanganPresenter = new DaftarPenggunaanRuanganPresenter();
        daftarPenggunaanRuanganPresenter.spinnerListAnggota(getActivity(), spnPenanggungJawabRuangan, prodi);
        daftarPenggunaanRuanganPresenter.spinnerListRuangan(getActivity(),spnNamaRuangan);

        spnPenanggungJawabRuangan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (AnggotaModel s : anggotaModels){
                    Toast.makeText(getActivity(), "" + s, Toast.LENGTH_SHORT).show();
                    if (s.getNamaAnggota() != null && s.getNamaAnggota().contains(spnPenanggungJawabRuangan.getSelectedItem().toString().trim())){
                        idAnggota = s.getId();
                        urlFotoPj = s.getUrlFotoAnggota();
                        Toast.makeText(getActivity(), "" + idAnggota, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "Galat", Toast.LENGTH_SHORT).show();
            }
        });

        btnKirimPenggunaanRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                daftarPenggunaanRuanganPresenter.sendDataPenggunaanRuangan(getActivity(), idUser, idAnggota,spnNamaRuangan.getSelectedItem().toString().trim(),
//                        edtNamaAcara.getText().toString().trim(), edtNamaDeskripsiAcara.getText().toString().trim(), tvTanggalMulaiDaftarRuangan.getText().toString().trim(),
//                        tvTanggalSelesaiDaftarRuangan.getText().toString().trim(), tvJamMulaiDaftarRuangan.getText().toString().trim(), tvJamSelesaiDaftarRuangan.getText().toString().trim(),
//                        tvNamaOrganisasi.getText().toString().trim(),spnPenanggungJawabRuangan.getSelectedItem().toString().trim(), edtJumlahPeserta.getText().toString().trim(),
//                        "urllll", urlFotoPj, "Booking", tvTokenPenggunaanRuangan.getText().toString().trim());
                daftarPenggunaanRuanganPresenter.sendDataPenggunaanRuangan(getActivity(), "8","18","aaa","aa","aa","aa","aa","aa","aa",
                        "aa","aa","aa","aa","aaa","aaa","aaaa");
            }
        });

        divTanggalMulaiDaftarRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long date;
                Calendar minDate = Calendar.getInstance();
                minDate.set(2015, minDate.get(Calendar.MONTH), minDate.get(Calendar.DAY_OF_MONTH));
                Calendar maxDate = Calendar.getInstance();
                maxDate.set(2016, minDate.get(Calendar.MONTH) + 1, minDate.get(Calendar.DAY_OF_MONTH));

                DatePickerFragmentDialog.newInstance(
                        DateTimeBuilder.newInstance()
                                .withTime(true)
                                .with24Hours(true)
                                .withMinDate(minDate.getTimeInMillis())
                                .withCurrentHour(12)
                                .withCurrentMinute(30))
                        .show(getActivity().getSupportFragmentManager(), "DatePickerFragmentDialog");

            }
        });


        return view;
    }

    private void initView(View view) {
        edtNamaAcara = view.findViewById(R.id.edt_nama_acara);
        edtNamaDeskripsiAcara = view.findViewById(R.id.edt_nama_deskripsi_acara);
        divTanggalMulaiDaftarRuangan = view.findViewById(R.id.div_tanggal_mulai_daftar_ruangan);
        tvTanggalMulaiDaftarRuangan = view.findViewById(R.id.tv_tanggal_mulai_daftar_ruangan);
        divTanggalSelesaiDaftarRuangan = view.findViewById(R.id.div_tanggal_selesai_daftar_ruangan);
        tvTanggalSelesaiDaftarRuangan = view.findViewById(R.id.tv_tanggal_selesai_daftar_ruangan);
        divJamMulaiDaftarRuangan = view.findViewById(R.id.div_jam_mulai_daftar_ruangan);
        tvJamMulaiDaftarRuangan = view.findViewById(R.id.tv_jam_mulai_daftar_ruangan);
        divJamSelesaiDaftarRuangan = view.findViewById(R.id.div_jam_selesai_daftar_ruangan);
        tvJamSelesaiDaftarRuangan = view.findViewById(R.id.tv_jam_selesai_daftar_ruangan);
        divNamaOrganisasi = view.findViewById(R.id.div_nama_organisasi);
        tvNamaOrganisasi = view.findViewById(R.id.tv_nama_organisasi);
        divProdi = view.findViewById(R.id.div_prodi);
        spnNamaRuangan = view.findViewById(R.id.spn_nama_ruangan);
        divPjRuangan = view.findViewById(R.id.div_pj_ruangan);
        spnPenanggungJawabRuangan = view.findViewById(R.id.spn_penanggung_jawab_ruangan);
        edtJumlahPeserta = view.findViewById(R.id.edt_jumlah_peserta);
        tvNameFile = view.findViewById(R.id.tv_name_file);
        btnPilihFileProposal = view.findViewById(R.id.btn_pilih_file_proposal);
        tvTokenPenggunaanRuangan = view.findViewById(R.id.tv_token_penggunaan_ruangan);
        btnKirimPenggunaanRuangan = view.findViewById(R.id.btn_kirim_penggunaan_ruangan);
    }

    @Override
    public void onDateSet(long date) {
//        tvTanggalMulaiDaftarRuangan.setText(Config.getDateOnly(date));
    }

    @Override
    public void onTimeSet(long time, long date) {
        tvTanggalMulaiDaftarRuangan.setText(getDateAndTime(date));

    }
}
