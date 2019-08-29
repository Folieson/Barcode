package com.example.barcode.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barcode.R;
import com.example.barcode.activity.ReportActivity;
import com.example.barcode.data.Product;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<Product> productList;
    private Context mContext;

    public RVAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        this.mContext = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, brand, id;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            brand = itemView.findViewById(R.id.tvBrand);
            id = itemView.findViewById(R.id.tvId);

        }
    }

    @NonNull
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, final int position) {
        holder.name.setText(productList.get(position).getName());
        holder.brand.setText(productList.get(position).getBrand());
        holder.id.setText(productList.get(position).getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReportActivity.class);
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}