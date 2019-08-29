package com.example.barcode.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.barcode.R;
import com.example.barcode.data.ProductsList;

public class ReportActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports_form);
        getIncomingIntent();
    }
    private void getIncomingIntent(){
        if(getIntent().hasExtra("position")){
            int position = getIntent().getIntExtra("position",0);
            setText(position);
        }
    }
    private void setText(int position) {
        ProductsList products = new ProductsList();

        TextView name = findViewById(R.id.tvName);
        name.setText(products.get(position).getName());

        TextView brand = findViewById(R.id.tvBrand);
        brand.setText(products.get(position).getBrand());

        TextView id = findViewById(R.id.tvId);
        id.setText(products.get(position).getId());

        TextView category = findViewById(R.id.tvCategory);
        category.setText(products.get(position).getCategory());

        TextView country = findViewById(R.id.tvCountry);
        country.setText(products.get(position).getCountry());
    }
}
