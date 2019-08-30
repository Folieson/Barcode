package com.example.barcode.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class ReadCode {

    public ReadCode (ImageView img, Bitmap bit, TextView txt, Context cnt) {
        TextView txtView = txt;
        //Проработка кода
        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(cnt)
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



}
