package com.pemirsa.pemirsa.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.pemirsa.pemirsa.R;
import com.pemirsa.pemirsa.model.LoginModel;
import com.pemirsa.pemirsa.presenter.LoginPresenter;

import java.util.ArrayList;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_CAMERA_AND_LOCATION = 1;
    private ImageView ivLogin;
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;

    private LoginPresenter loginPresenter;
    private ArrayList<LoginModel> loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        loginModel = new ArrayList<>();
        loginPresenter = new LoginPresenter();
        methodRequiresTwoPermission();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.logins(LoginActivity.this,edtUsername.getText().toString().trim(),
                        edtPassword.getText().toString().trim());

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
        ivLogin = (ImageView) findViewById(R.id.iv_login);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}
