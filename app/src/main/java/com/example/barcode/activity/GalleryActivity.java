package com.example.barcode.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.barcode.R;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class GalleryActivity extends NavBar {

    ImageView imageView;

    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        imageView = (ImageView)findViewById(R.id.imgGall);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }

    //Обрабатываем результат выбора в галерее:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);

                        TextView txtView = findViewById(R.id.txtGall);
                        //Проработка кода
                        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(getApplicationContext())
                                .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                                .build();
                        if (!barcodeDetector.isOperational()) {
                            txtView.setText("Не работает детектор");
                            return;
                        }
                        //Создаем кадр для передачи изображения
                        Frame frame = new Frame.Builder().setBitmap(selectedImage).build();
                        SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);
                        if (barcodes.size() == 0) {
                            txtView.setText("Код не найден");
                            return;
                        }
                        //Так как у нас всего один код
                        Barcode thisCode = barcodes.valueAt(0);
                        txtView.setText(thisCode.rawValue);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

}
