package com.example.barcode.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barcode.R;
import com.example.barcode.adapter.RVAdapter;
import com.example.barcode.data.ProductsList;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView rvTeams;
    ProductsList products = new ProductsList();
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resycler_view);

        rvTeams = findViewById(R.id.rv);

        adapter = new RVAdapter(this, products);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        rvTeams.setLayoutManager(manager);
        rvTeams.setAdapter(adapter);
    }
}
