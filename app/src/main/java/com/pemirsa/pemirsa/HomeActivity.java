package com.pemirsa.pemirsa;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pemirsa.pemirsa.ui.fragment.data.ListPengurusFragment;
import com.pemirsa.pemirsa.ui.fragment.data.RiwayatPenggunaanRuanganFragment;
import com.pemirsa.pemirsa.ui.fragment.form.DaftarPenggunaanRuanganFragment;
import com.pemirsa.pemirsa.ui.fragment.form.DaftarPengurusFragment;
import com.pemirsa.pemirsa.ui.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private FragmentManager fragmentManager;
    FloatingActionButton fab;

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.containerViewPager, new HomeFragment()).commit();
        getSupportActionBar().setTitle("Beranda");
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

        if (id == R.id.nav_beranda) {
            fab.setVisibility(View.VISIBLE);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new HomeFragment()).commit();
            getSupportActionBar().setTitle("Beranda");
        }
        else if (id == R.id.nav_daftar_pengurus) {
            fab.setVisibility(View.GONE);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new DaftarPengurusFragment()).commit();
            getSupportActionBar().setTitle("Daftar Pengurus");
        }  else if (id == R.id.nav_penggunaan_ruangan) {
            fab.setVisibility(View.GONE);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new DaftarPenggunaanRuanganFragment()).commit();
            getSupportActionBar().setTitle("Daftar Penggunaan Ruangan");
        } else if (id == R.id.nav_data_pengurus) {
            fab.setVisibility(View.GONE);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new ListPengurusFragment()).commit();
            getSupportActionBar().setTitle("Data Pengurus");
        } else if (id == R.id.nav_data_penggunaan_ruangan) {
            fab.setVisibility(View.GONE);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.containerViewPager, new RiwayatPenggunaanRuanganFragment()).commit();
            getSupportActionBar().setTitle("Riwayat P.Ruangan");
        } else if (id == R.id.nav_data_cek_penggunaan_ruangan) {

        } else if (id == R.id.nav_profil) {

        } else if (id == R.id.nav_keluar) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
