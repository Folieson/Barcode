package com.example.barcode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.barcode.R;

public class NavBar extends AppCompatActivity {

    ImageView imgFavorites;
    ImageView imgFriends;
    ImageView imgRecents;

    Button btn_his;
    Button btn_camera;
    Button btn_gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_bar);

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
        });

/*
        imgFavorites = (ImageView) findViewById(R.id.action_favorites);
        imgFriends = (ImageView) findViewById(R.id.action_friends);
        imgRecents = (ImageView) findViewById(R.id.action_recents);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                imgFavorites.setVisibility(View.VISIBLE);
                                imgFriends.setVisibility(View.GONE);
                                imgRecents.setVisibility(View.GONE);
                                break;
                            case R.id.action_friends:
                                imgFavorites.setVisibility(View.GONE);
                                imgFriends.setVisibility(View.VISIBLE);
                                imgRecents.setVisibility(View.GONE);
                                break;
                            case R.id.action_recents:
                                imgFavorites.setVisibility(View.GONE);
                                imgFriends.setVisibility(View.GONE);
                                imgRecents.setVisibility(View.VISIBLE);
                                break;
                        }
                        return false;
                    }
                });*/
    }
}

