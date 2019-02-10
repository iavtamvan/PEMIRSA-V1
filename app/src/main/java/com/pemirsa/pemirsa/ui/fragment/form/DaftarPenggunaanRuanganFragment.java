package com.pemirsa.pemirsa.ui.fragment.form;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.obsez.android.lib.filechooser.ChooserDialog;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.AnggotaModel;
import com.pemirsa.pemirsa.model.Result;
import com.pemirsa.pemirsa.presenter.PenggunaanRuanganPresenter;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.uploadImage.RetroClient;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarPenggunaanRuanganFragment extends Fragment {


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

    private PenggunaanRuanganPresenter penggunaanRuanganPresenter;
    private ArrayList<AnggotaModel> anggotaModels = new ArrayList<>();
    private String prodi, idAnggota, idUser, urlFotoPj;

    private int mYear, mMonth, mDay, mHour, mMinute;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String urlFileProposal;
    private String path;
    private String displayName;

    public DaftarPenggunaanRuanganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daftar_penggunaan_ruangan, container, false);
        initView(view);

        sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
//        SharedPreferences.Editor editor = sharedPreferences.edit();
        prodi = sharedPreferences.getString(Config.NAMA_ORGANISASI, "");
        idUser = sharedPreferences.getString(Config.ID, "");
        idAnggota = sharedPreferences.getString(Config.IDANGGOTA, "");
        urlFotoPj = sharedPreferences.getString(Config.URLFOTOPJ, "");
        Log.d(TAG, "idUser: " + idUser);
//        Toast.makeText(getActivity(), "anggota ? " + idAnggota, Toast.LENGTH_SHORT).show();

        if (idAnggota==null && urlFotoPj==null){
            Toast.makeText(getActivity(), "" + Config.DATA_KOSONG,  Toast.LENGTH_SHORT).show();
        }

        tvTokenPenggunaanRuangan.setText("PEMIRSA-" +UUID.randomUUID().toString());
        tvNamaOrganisasi.setText(prodi);

        penggunaanRuanganPresenter = new PenggunaanRuanganPresenter();
        penggunaanRuanganPresenter.spinnerListAnggota(getActivity(), spnPenanggungJawabRuangan, prodi);
        penggunaanRuanganPresenter.spinnerListRuangan(getActivity(), spnNamaRuangan);

        btnKirimPenggunaanRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        divTanggalMulaiDaftarRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                tvTanggalMulaiDaftarRuangan.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        divTanggalSelesaiDaftarRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                tvTanggalSelesaiDaftarRuangan.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        divJamMulaiDaftarRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                tvJamMulaiDaftarRuangan.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        divJamSelesaiDaftarRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                tvJamSelesaiDaftarRuangan.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        btnPilihFileProposal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("*/*");
//                startActivityForResult(intent, 7);

                new ChooserDialog().with(getActivity())
                        .withStartFile(path)
                        .withChosenListener(new ChooserDialog.Result() {
                            @Override
                            public void onChoosePath(String path, File pathFile) {
                                urlFileProposal = path;
                                tvNameFile.setText(path);
                            }
                        })
                        .build()
                        .show();
            }
        });


        return view;
    }
    //Upload File
    private void uploadImage() {

        final ProgressDialog p = ProgressDialog.show(getActivity(), "Loading ", Config.MENGIRIM_DATA, false, false);


        ApiServiceServer s = RetroClient.getService();

        final File f = new File(urlFileProposal);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), f);

        MultipartBody.Part part = MultipartBody.Part.createFormData("uploaded_file", f.toString(), requestFile);
        Call<Result> resultCAll = s.postIMmage(part);
        resultCAll.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                p.dismiss();
                if (response.isSuccessful()) {
                    if (response.body().getResult().equals("success")) {
                        Toast.makeText(getActivity(), "Sukses", Toast.LENGTH_SHORT).show();
                        editor.putString(Config.PATH_FILE_PROPOSAL, "http://indiku.id/image/upload_client/" + f.getName());
                        urlFileProposal = "http://indiku.id/image/upload_client/" + f.getName();
                        editor.apply();

                        penggunaanRuanganPresenter.sendDataPenggunaanRuangan(getActivity(), idUser,idAnggota,spnNamaRuangan.getSelectedItem().toString().trim()
                                ,edtNamaAcara.getText().toString().trim(),edtNamaAcara.getText().toString().trim(),tvTanggalMulaiDaftarRuangan.getText().toString().trim(),
                                tvTanggalSelesaiDaftarRuangan.getText().toString().trim(),tvJamMulaiDaftarRuangan.getText().toString().trim(),
                                tvJamSelesaiDaftarRuangan.getText().toString().trim(), tvNamaOrganisasi.getText().toString().trim(),
                                spnPenanggungJawabRuangan.getSelectedItem().toString().trim(),edtJumlahPeserta.getText().toString().trim(),
                                urlFileProposal,urlFotoPj,"Booking",tvTokenPenggunaanRuangan.getText().toString().trim());

                    } else {
                        Toast.makeText(getActivity(), "Gagal else", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Gagal not fuull", Toast.LENGTH_SHORT).show();
                }

//                imageVi.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                p.dismiss();


            }
        });
    }
    //Upload Selesai File

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
}
