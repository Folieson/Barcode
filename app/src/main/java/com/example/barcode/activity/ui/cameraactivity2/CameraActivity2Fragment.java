package com.example.barcode.activity.ui.cameraactivity2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.barcode.R;
import com.example.barcode.activity.ReadCode;

import static android.app.Activity.RESULT_OK;

public class CameraActivity2Fragment extends Fragment {

    private CameraActivity2ViewModel mViewModel;
    private static final int REQUEST_TAKE_PHOTO = 1;
    public String mCurrentPhotoPath;
    public ImageView imageView;

    public static CameraActivity2Fragment newInstance() {
        return new CameraActivity2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.camera_activity2_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CameraActivity2ViewModel.class);
        // TODO: Use the ViewModel
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCurrentPhotoPath);
        startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            imageView = getView().findViewById(R.id.imgCam);
            new ReadCode(imageView, (Bitmap) data.getExtras().get("data"), (TextView) getView().findViewById(R.id.message), getContext());
        }
    }




}
