package com.example.bundletesting.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.model.Coffee;
import com.example.bundletesting.model.CoffeeSelected;
import com.example.bundletesting.view.ListCoffeeWAdd;

import java.util.List;

public class CoffeeSelectedAdapter extends RecyclerView.Adapter<CoffeeSelectedAdapter.CoffeeSelectedViewHolder>{

    private List<Coffee> listCoffeeSelected;
    private Context context;

    public interface IClickItemCoffeeSelected{
        void removeCoffeeSelected(Coffee coffeeSelected);
    }

    private IClickItemCoffeeSelected iClickItem;

    public CoffeeSelectedAdapter(IClickItemCoffeeSelected iClickItem) {
        this.iClickItem = iClickItem;
    }

    public CoffeeSelectedAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Coffee> list){
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
        Coffee coffeeSelected = listCoffeeSelected.get(position);
        if (coffeeSelected == null){
            return;
        }

        holder.imgCoffeeSelected.setImageResource(coffeeSelected.getResourceId());
        holder.tvCoffeeSelected.setText(coffeeSelected.getName());
        holder.tvCoffeePriceSelected.setText(coffeeSelected.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iClickItem.removeCoffeeSelected(coffeeSelected);
            }
        });
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
