package com.example.barcode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.barcode.Data.Product;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    public List<Product> productList;

    public RVAdapter(List<Product> productList) {
        this.productList = productList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, brand, id;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvName);
            brand = (TextView) itemView.findViewById(R.id.tvBrand);
            id = (TextView) itemView.findViewById(R.id.tvId);

        }
    }

    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row,parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {
        holder.name.setText(productList.get(position).getName());
        holder.brand.setText(productList.get(position).getBrand());
        holder.id.setText(productList.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}