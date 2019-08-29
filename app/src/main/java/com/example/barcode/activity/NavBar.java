package com.example.barcode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.barcode.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavBar extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Button btn_his;
    Button btn_camera;
    Button btn_gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_bar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Intent intent;
                        switch (item.getItemId()) {
                            case R.id.action_history:
                                intent = new Intent(NavBar.this, HistoryActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.action_camera:
                                intent = new Intent(NavBar.this, CameraActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.action_gallery:
                                intent = new Intent(NavBar.this, GalleryActivity.class);
                                startActivity(intent);
                                return true;
                        }
                        return false;
                    }
                });
/*
        btn_his = findViewById(R.id.btn_history);
        btn_his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavBar.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        btn_camera = findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavBar.this, NavBar.class);
                startActivity(intent);
            }
        });

        btn_gallery = findViewById(R.id.btn_gallery);
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavBar.this, GalleryActivity.class);
                startActivity(intent);
            }
        });*/



    }
}

