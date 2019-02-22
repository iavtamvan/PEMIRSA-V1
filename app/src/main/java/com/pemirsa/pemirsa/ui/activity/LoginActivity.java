package com.pemirsa.pemirsa.ui.activity;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.pemirsa.pemirsa.BuildConfig;
import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.helper.firebase.MyFirebaseInstanceIDService;
import com.pemirsa.pemirsa.model.LoginModel;
import com.pemirsa.pemirsa.presenter.LoginPresenter;

import java.util.ArrayList;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_CAMERA_AND_LOCATION = 1;


    private LoginPresenter loginPresenter;
    private ArrayList<LoginModel> loginModel;
    private Toolbar toolbar;
    private TextView tvAppVersion;
    private TextView edtUsername;
    private TextView edtPassword;
    private TextView tvRegistrasi;
    private ProgressBar pbLogin;
    private LinearLayout divLogin;
    private MyFirebaseInstanceIDService myFirebaseInstanceIDService;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginModel = new ArrayList<>();
        loginPresenter = new LoginPresenter();
        methodRequiresTwoPermission();
        initView();
        tvAppVersion.setText("Version " + BuildConfig.VERSION_NAME);
        divLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.logins(LoginActivity.this, edtUsername.getText().toString().trim(),
                        edtPassword.getText().toString().trim());

                FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Task Gagal", Toast.LENGTH_SHORT).show();
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PRED_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(Config.TOKEN_FIREBASE_REG_ID, "dsfsdfsd");
                        editor.apply();
                        // Log and toast
//                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d("token_verif", token);
                    }
                });

            }
        });

    }

    @AfterPermissionGranted(RC_CAMERA_AND_LOCATION)
    private void methodRequiresTwoPermission() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.app_name),
                    RC_CAMERA_AND_LOCATION, perms);
        }
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        tvAppVersion = findViewById(R.id.tvAppVersion);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        tvRegistrasi = findViewById(R.id.tvRegistrasi);
        pbLogin = findViewById(R.id.pbLogin);
        divLogin = findViewById(R.id.div_Login);
    }
}
