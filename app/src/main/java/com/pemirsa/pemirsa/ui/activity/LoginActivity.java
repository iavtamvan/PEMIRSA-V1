package com.pemirsa.pemirsa.ui.activity;

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

public class LoginActivity extends AppCompatActivity {

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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.logins(LoginActivity.this,edtUsername.getText().toString().trim(),
                        edtPassword.getText().toString().trim());

            }
        });
    }

    private void initView() {
        ivLogin = (ImageView) findViewById(R.id.iv_login);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}
