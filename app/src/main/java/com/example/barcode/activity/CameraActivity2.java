package com.example.barcode.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.barcode.R;
import com.example.barcode.activity.ui.cameraactivity2.CameraActivity2Fragment;

public class CameraActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity2_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CameraActivity2Fragment.newInstance())
                    .commitNow();
        }
    }
}
