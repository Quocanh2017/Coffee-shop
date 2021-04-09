package com.example.bundletesting.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.model.CoffeeSelected;

import java.util.List;

public class CoffeeSelectedAdapter extends RecyclerView.Adapter<CoffeeSelectedAdapter.CoffeeSelectedViewHolder>{

    private List<CoffeeSelected> listCoffeeSelected;

    public void setData(List<CoffeeSelected> list){
        this.listCoffeeSelected = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoffeeSelectedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cf_select, parent, false);
        return new CoffeeSelectedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeSelectedViewHolder holder, int position) {
        CoffeeSelected coffeeSelected = listCoffeeSelected.get(position);
        if (coffeeSelected == null){
            return;
        }

        holder.imgCoffeeSelected.setImageResource(coffeeSelected.getResourceId());
        holder.tvCoffeeSelected.setText(coffeeSelected.getName());
        holder.tvCoffeePriceSelected.setText(coffeeSelected.getPrice());
    }

    @Override
    public int getItemCount() {
        if(listCoffeeSelected != null){
            return listCoffeeSelected.size();
        }
        return 0;
    }

    public class CoffeeSelectedViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCoffeeSelected;
        private TextView tvCoffeeSelected;
        private TextView tvCoffeePriceSelected;

        public CoffeeSelectedViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCoffeeSelected = itemView.findViewById(R.id.img_cf_selected);
            tvCoffeeSelected = itemView.findViewById(R.id.tv_cf_selected);
            tvCoffeePriceSelected = itemView.findViewById(R.id.tv_cf_price_selected);
        }
    }
}
