package com.pemirsa.pemirsa.ui.fragment.form;


import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.model.ErrorMsgModel;
import com.pemirsa.pemirsa.model.Result;
import com.pemirsa.pemirsa.presenter.DaftarPengurusPresenter;
import com.pemirsa.pemirsa.presenter.ListDaftarPengurusPresenter;
import com.pemirsa.pemirsa.rest.ApiServiceServer;
import com.pemirsa.pemirsa.rest.uploadImage.RetroClient;
import com.pemirsa.pemirsa.ui.activity.ListDaftarPengurusActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static android.support.v4.provider.FontsContractCompat.FontRequestCallback.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarPengurusFragment extends Fragment {
    private DaftarPengurusPresenter daftarPengurusPresenter;
    private ArrayList<ErrorMsgModel> errorMsgModels;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private String id_user, urlFotoKtm, UrlFotoAnggota, prodi, jabatan, statusPengurus;
    private ListDaftarPengurusPresenter listDaftarPengurusPresenter;
    private TextInputEditText edtNamaPengurus;
    private TextInputEditText edtNimPengurus;
    private LinearLayout divProdi;
    private Spinner spnProdiPengurus;
    private TextInputEditText edtEmailPengurus;
    private LinearLayout divJabatan;
    private Spinner spnJabatanPengurus;
    private TextInputEditText edtNohpPengurus;
    private ImageView ivKtmPengurus;
    private Button btnKtmAmbilFoto;
    private ImageView ivFotoPengurus;
    private Button btnPilihFotoPengurus;
    private LinearLayout divStatusPengurus;
    private Spinner spnStatusPengurus;
    private Button btnKirimDataPengurus;


    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private int PICK_IMAGE_REQUEST = 1000;
    private String fname, imagePath, imagePathServer;


    public DaftarPengurusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_pengurus, container, false);
        initView(view);

        sharedPreferences = getActivity().getSharedPreferences(Config.SHARED_PRED_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        id_user = sharedPreferences.getString(Config.ID, "");
        Toast.makeText(getActivity(), "" + id_user, Toast.LENGTH_SHORT).show();

        errorMsgModels = new ArrayList<>();
        daftarPengurusPresenter = new DaftarPengurusPresenter();
        listDaftarPengurusPresenter = new ListDaftarPengurusPresenter();

        listDaftarPengurusPresenter.getDataListPengurus(getActivity(), "prodi", spnProdiPengurus);
        listDaftarPengurusPresenter.getDataListPengurus(getActivity(), "jabatan", spnJabatanPengurus);
        listDaftarPengurusPresenter.getDataListPengurus(getActivity(), "status", spnStatusPengurus);

        spnProdiPengurus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prodi = spnProdiPengurus.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnJabatanPengurus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jabatan = spnJabatanPengurus.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnStatusPengurus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statusPengurus = spnStatusPengurus.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnKirimDataPengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        btnKtmAmbilFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (getActivity().checkSelfPermission(Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA},
                                MY_CAMERA_PERMISSION_CODE);
                    } else {
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST);
                    }
                }
            }
        });

        btnPilihFotoPengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
// Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });


        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new
                        Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(getActivity(), "camera permission denied", Toast.LENGTH_LONG).show();
            }

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            final Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ivKtmPengurus.setImageBitmap(bitmap);
            // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
            Uri tempUri = getImageUri(getActivity(), bitmap);

            // CALL THIS METHOD TO GET THE ACTUAL PATH
            File finalFile = new File(getRealPathFromURI(tempUri));

            imagePath = finalFile.getPath();
//            savingImage(bitmap);
        }
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//            Uri uri = data.getData();
//
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
//                // Log.d(TAG, String.valueOf(bitmap));
//
////                ImageView imageView = (ImageView) findViewById(R.id.imageView);
//                ivFotoPengurus.setImageBitmap(bitmap);
//
//                String[] projection = { MediaStore.Images.Media.DATA };
//
//                Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
//                cursor.moveToFirst();
//
//                Log.d("Reulsts :> ", DatabaseUtils.dumpCursorToString(cursor));
//
//                int columnIndex = cursor.getColumnIndex(projection[0]);
//                String picturePath = cursor.getString(columnIndex); // returns null
////                File file = new File(picturePath);
////                Toast.makeText(this, "Path >>"+ file.getPath(), Toast.LENGTH_SHORT).show();
////                Toast.makeText(this, "Na,e >>"+ file.getName(), Toast.LENGTH_SHORT).show();
//                cursor.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }
// Pilih foto Not Working
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//            Uri uri = data.getData();
//
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(Objects.requireNonNull(getActivity()).getContentResolver(), uri);
//                // Log.d(TAG, String.valueOf(bitmap));
//
////                ImageView imageView = (ImageView) findViewById(R.id.imageView);
//                ivFotoPengurus.setImageBitmap(bitmap);
//
//                String[] projection = { MediaStore.Images.Media.DATA };
//
//                Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
//                cursor.moveToFirst();
//
//                Log.d("Reulsts :> ", DatabaseUtils.dumpCursorToString(cursor));
//
//                int columnIndex = cursor.getColumnIndex(projection[0]);
//                String picturePath = cursor.getString(columnIndex); // returns null
////                File file = new File(picturePath);
////                Toast.makeText(this, "Path >>"+ file.getPath(), Toast.LENGTH_SHORT).show();
////                Toast.makeText(this, "Na,e >>"+ file.getName(), Toast.LENGTH_SHORT).show();
//                cursor.close();
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                Toast.makeText(getActivity(), "Catch > " + e.getMessage() , Toast.LENGTH_SHORT).show();
//            }
//        }
//        else {
//            Toast.makeText(getActivity(), "Load Image null" , Toast.LENGTH_SHORT).show();
//        }
//    }

    // upload mulai Image
    private void uploadImage() {

        final ProgressDialog p = ProgressDialog.show(getActivity(), "Loading", Config.MENGIRIM_DATA, false, false);


        ApiServiceServer s = RetroClient.getService();

        final File f = new File(imagePath);

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
                        editor.putString(Config.PATH_IMAGE, "http://indiku.id/image/upload_client/" + f.getName());
                        urlFotoKtm = "http://indiku.id/image/upload_client/" + f.getName();
                        editor.apply();
                        daftarPengurusPresenter.kirimDataPengurus(getActivity(), id_user, edtNamaPengurus.getText().toString().trim(), edtNimPengurus.getText().toString().trim(),
                                prodi.trim(), edtEmailPengurus.getText().toString().trim(), jabatan.trim(),
                                edtNohpPengurus.getText().toString().trim(), urlFotoKtm, UrlFotoAnggota, statusPengurus.trim());
                        Log.d(TAG, "onResponseImage: " + urlFotoKtm);
                        edtNamaPengurus.setText("");
                        edtNimPengurus.setText("");
                        edtEmailPengurus.setText("");
                        edtNohpPengurus.setText("");

                    } else {
                        Toast.makeText(getActivity(), "Gagal else", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Gagal not fuull", Toast.LENGTH_SHORT).show();
                }

                imagePath = "";
//                imageVi.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                p.dismiss();


            }
        });
    }


    // upload selesai Image
    private void initView(View view) {
        edtNamaPengurus = view.findViewById(R.id.edt_nama_pengurus);
        edtNimPengurus = view.findViewById(R.id.edt_nim_pengurus);
        divProdi = view.findViewById(R.id.div_prodi);
        spnProdiPengurus = view.findViewById(R.id.spn_prodi_pengurus);
        edtEmailPengurus = view.findViewById(R.id.edt_email_pengurus);
        divJabatan = view.findViewById(R.id.div_jabatan);
        spnJabatanPengurus = view.findViewById(R.id.spn_jabatan_pengurus);
        edtNohpPengurus = view.findViewById(R.id.edt_nohp_pengurus);
        ivKtmPengurus = view.findViewById(R.id.iv_ktm_pengurus);
        btnKtmAmbilFoto = view.findViewById(R.id.btn_ktm_ambil_foto);
        ivFotoPengurus = view.findViewById(R.id.iv_foto_pengurus);
        btnPilihFotoPengurus = view.findViewById(R.id.btn_pilih_foto_pengurus);
        divStatusPengurus = view.findViewById(R.id.div_status_pengurus);
        spnStatusPengurus = view.findViewById(R.id.spn_status_pengurus);
        btnKirimDataPengurus = view.findViewById(R.id.btn_kirim_data_pengurus);
    }
}
