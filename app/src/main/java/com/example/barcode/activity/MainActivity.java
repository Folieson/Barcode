package com.example.barcode.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.barcode.R;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class MainActivity extends AppCompatActivity {

    public MainActivity (ImageView img, Bitmap bit, TextView txt) {
        TextView txtView = txt;
        //Проработка кода
        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(getApplicationContext())
                .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                .build();
        if (!barcodeDetector.isOperational()) {
            txtView.setText("Не работает детектор");
            return;
        }
        //Создаем кадр для передачи изображения
        Frame frame = new Frame.Builder().setBitmap(bit).build();
        SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);
        if (barcodes.size() == 0) {
            txtView.setText("Код не найден");
            return;
        }
        //Так как у нас всего один код
        Barcode thisCode = barcodes.valueAt(0);
        txtView.setText(thisCode.rawValue);
        img.setImageBitmap(bit);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtView = findViewById(R.id.txtContent);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView myimageView = findViewById(R.id.imgview);
                //перевод в растровое изображение
                Bitmap myBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.qr);
                myimageView.setImageBitmap(myBitmap);
                //Проработка кода
                BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(getApplicationContext())
                    .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                    .build();

                if (!barcodeDetector.isOperational()) {
                    txtView.setText("Не работает детектор");
                }

                //Создаем кадр для передачи изображения
                Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
                SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);
                //Так как у нас всего один код
                Barcode thisCode = barcodes.valueAt(0);
                txtView.setText(thisCode.rawValue);
            }
        });
    }
}
