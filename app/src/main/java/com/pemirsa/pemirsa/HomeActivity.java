package com.pemirsa.pemirsa;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.pemirsa.pemirsa.helper.Config;
import com.pemirsa.pemirsa.helper.firebase.NotificationUtils;
import com.pemirsa.pemirsa.ui.fragment.HomeFragment;
import com.pemirsa.pemirsa.ui.fragment.data.CekRuanganFragment;
import com.pemirsa.pemirsa.ui.fragment.data.ListPengurusFragment;
import com.pemirsa.pemirsa.ui.fragment.data.RiwayatPenggunaanRuanganFragment;
import com.pemirsa.pemirsa.ui.fragment.form.DaftarPenggunaanRuanganFragment;
import com.pemirsa.pemirsa.ui.fragment.form.DaftarPengurusFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentManager fragmentManager;
    FloatingActionButton fab;


    private DrawerLayout drawer;
    private LinearLayout divHeaderLogin;
    private ImageView ivAvatar;
    private TextView tvNamaOrganisasi;
    private TextView tvEmail;
    private TextView tvAppsVersion;
    private LinearLayout divBeranda;
    private ImageView ibBeranda;
    private TextView tvBeranda;
    private LinearLayout divDaftarPengurus;
    private ImageView ivDaftarPengurus;
    private TextView tvDaftarPengurus;
    private LinearLayout divDaftarPenggunaanRuangan;
    private ImageView ivPenggunaanRuangan;
    private TextView tvPenggunaanRuangan;
    private LinearLayout divDataPengurus;
    private ImageView ivDataPengurus;
    private TextView tvDataPengurus;
    private LinearLayout divRiwayatPenggunaanRuangan;
    private ImageView ivRiwayatPenggunaanRuangan;
    private TextView tvRiwayatPenggunaanRuangan;
    private LinearLayout divCekRuanganKosong;
    private ImageView ivCekRuanganKosong;
    private TextView tvCekRuanganKosong;
    private LinearLayout divProfil;
    private ImageView ivProfil;
    private TextView tvProfil;
    private LinearLayout divLogout;
    private ImageView ivLogout;
    private TextView tvLogout;

    private BroadcastReceiver mRegistrationBroadcastReceiver;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initView(navigationView);

        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PRED_NAME, MODE_PRIVATE);
        Glide.with(this).load(sharedPreferences.getString(Config.URL_LOGO_ORGANISASI, "")).apply(new RequestOptions().override(300, 300)).into(ivAvatar);
        tvNamaOrganisasi.setText(sharedPreferences.getString(Config.NAMA_ORGANISASI, ""));
        tvEmail.setText(sharedPreferences.getString(Config.EMAIL, ""));
        tvAppsVersion.setText("Version " + BuildConfig.VERSION_NAME);

        Toast.makeText(this, "" + sharedPreferences.getString(Config.TOKEN_FIREBASE_REG_ID, ""), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + sharedPreferences.getString(Config.TOKEN_FIREBASE_REG_ID, ""), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + sharedPreferences.getString(Config.TOKEN_FIREBASE_REG_ID, ""), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + sharedPreferences.getString(Config.TOKEN_FIREBASE_REG_ID, ""), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + sharedPreferences.getString(Config.TOKEN_FIREBASE_REG_ID, ""), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + sharedPreferences.getString(Config.TOKEN_FIREBASE_REG_ID, ""), Toast.LENGTH_SHORT).show();

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                    displayFirebaseRegId();

                } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                    // new push notification is received

                    String message = intent.getStringExtra("message");

                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();

//                    txtMessage.setText(message);
                }
            }
        };

        divBeranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFragmentFab(new HomeFragment(), "Beranda");
            }
        });

        divDaftarPengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFragmentNoFab(new DaftarPengurusFragment(), "Daftar Pengurus");
            }
        });

        divDaftarPenggunaanRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFragmentNoFab(new DaftarPenggunaanRuanganFragment(), "Daftar Penggunaan Ruangan");
            }
        });

        divDataPengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFragmentNoFab(new ListPengurusFragment(), "Data Pengurus");
            }
        });

        divRiwayatPenggunaanRuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFragmentNoFab(new RiwayatPenggunaanRuanganFragment(), "Riwayat P. Ruangan");
            }
        });

        divCekRuanganKosong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFragmentNoFab(new CekRuanganFragment(), "Cek Ruangan");
            }
        });

        divProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Profilsss", Toast.LENGTH_SHORT).show();
            }
        });

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.containerViewPager, new HomeFragment()).commit();
        getSupportActionBar().setTitle("Beranda");

    }


    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PRED_NAME, 0);
        String regId = pref.getString("regId", null);

        Log.e("", "Firebase reg id: " + regId);

        if (!TextUtils.isEmpty(regId)) {
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+ regId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Firebase Reg Id is not received yet!", Toast.LENGTH_SHORT).show();
        }
        
    }
    @Override
    protected void onResume() {
        super.onResume();

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    @SuppressLint("RestrictedApi")
    private void gotoFragmentFab(Fragment fragment, String tittle) {
        fab.setVisibility(View.VISIBLE);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.containerViewPager, fragment).commit();
        getSupportActionBar().setTitle(tittle);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @SuppressLint("RestrictedApi")
    private void gotoFragmentNoFab(Fragment fragment, String tittle) {
        fab.setVisibility(View.GONE);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.containerViewPager, fragment).commit();
        getSupportActionBar().setTitle(tittle);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("RestrictedApi")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_beranda) {
//            fab.setVisibility(View.VISIBLE);
//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new HomeFragment()).commit();
//            getSupportActionBar().setTitle("Beranda");
//        } else if (id == R.id.nav_daftar_pengurus) {
//            fab.setVisibility(View.GONE);
//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new DaftarPengurusFragment()).commit();
//            getSupportActionBar().setTitle("Daftar Pengurus");
//        } else if (id == R.id.nav_penggunaan_ruangan) {
//            fab.setVisibility(View.GONE);
//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new DaftarPenggunaanRuanganFragment()).commit();
//            getSupportActionBar().setTitle("Daftar Penggunaan Ruangan");
//        } else if (id == R.id.nav_data_pengurus) {
//            fab.setVisibility(View.GONE);
//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new ListPengurusFragment()).commit();
//            getSupportActionBar().setTitle("Data Pengurus");
//        } else if (id == R.id.nav_data_penggunaan_ruangan) {
//            fab.setVisibility(View.GONE);
//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new RiwayatPenggunaanRuanganFragment()).commit();
//            getSupportActionBar().setTitle("Riwayat P.Ruangan");
//        } else if (id == R.id.nav_data_cek_penggunaan_ruangan) {
//            fab.setVisibility(View.GONE);
//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new CekRuanganFragment()).commit();
//            getSupportActionBar().setTitle("Cek ruangan Kosong");
//        } else if (id == R.id.nav_profil) {
//
//        } else if (id == R.id.nav_keluar) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initView(View navigationView) {
        divHeaderLogin = navigationView.findViewById(R.id.divHeaderLogin);
        ivAvatar = navigationView.findViewById(R.id.ivAvatar);
        tvNamaOrganisasi = navigationView.findViewById(R.id.tv_nama_organisasi);
        tvEmail = navigationView.findViewById(R.id.tv_email);
        tvAppsVersion = navigationView.findViewById(R.id.tv_apps_version);
        divBeranda = navigationView.findViewById(R.id.div_Beranda);
        ibBeranda = navigationView.findViewById(R.id.ib_beranda);
        tvBeranda = navigationView.findViewById(R.id.tv_beranda);
        divDaftarPengurus = navigationView.findViewById(R.id.div_Daftar_Pengurus);
        ivDaftarPengurus = navigationView.findViewById(R.id.iv_daftar_pengurus);
        tvDaftarPengurus = navigationView.findViewById(R.id.tv_daftar_pengurus);
        divDaftarPenggunaanRuangan = navigationView.findViewById(R.id.div_Daftar_Penggunaan_Ruangan);
        ivPenggunaanRuangan = navigationView.findViewById(R.id.iv_penggunaan_ruangan);
        tvPenggunaanRuangan = navigationView.findViewById(R.id.tv_penggunaan_ruangan);
        divDataPengurus = navigationView.findViewById(R.id.div_Data_Pengurus);
        ivDataPengurus = navigationView.findViewById(R.id.iv_data_pengurus);
        tvDataPengurus = navigationView.findViewById(R.id.tv_data_pengurus);
        divRiwayatPenggunaanRuangan = navigationView.findViewById(R.id.div_Riwayat_Penggunaan_Ruangan);
        ivRiwayatPenggunaanRuangan = navigationView.findViewById(R.id.iv_riwayat_penggunaan_ruangan);
        tvRiwayatPenggunaanRuangan = navigationView.findViewById(R.id.tv_riwayat_penggunaan_ruangan);
        divCekRuanganKosong = navigationView.findViewById(R.id.div_Cek_Ruangan_Kosong);
        ivCekRuanganKosong = navigationView.findViewById(R.id.iv_Cek_Ruangan_Kosong);
        tvCekRuanganKosong = navigationView.findViewById(R.id.tv_Cek_Ruangan_Kosong);
        divProfil = navigationView.findViewById(R.id.div_Profil);
        ivProfil = navigationView.findViewById(R.id.iv_profil);
        tvProfil = navigationView.findViewById(R.id.tv_Profil);
        divLogout = navigationView.findViewById(R.id.div_Logout);
        ivLogout = navigationView.findViewById(R.id.iv_logout);
        tvLogout = navigationView.findViewById(R.id.tv_logout);
    }
}
