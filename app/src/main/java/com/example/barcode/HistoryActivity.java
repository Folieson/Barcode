package com.example.barcode;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barcode.Data.Product;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends Activity {
    RecyclerView rvTeams;
    List<Product> products = new ArrayList<>();
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resycler_view);

        rvTeams = (RecyclerView) findViewById(R.id.rv);

        setProductsData();

        adapter = new RVAdapter(products);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rvTeams.setLayoutManager(manager);
        rvTeams.setAdapter(adapter);


    }

    private void setProductsData() {
        products.add(new Product("E1234", "name","brand"));
        products.add(new Product("E5678", "another name","another brand"));
        products.add(new Product("E2345", "name3","brand3"));
    }
}
