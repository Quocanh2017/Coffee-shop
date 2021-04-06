package com.example.bundletesting.homepage.coffee;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>{

    private Context context;
    private List<Coffee> listCoffee;

    public CoffeeAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Coffee> list){
        this.listCoffee = list;
        //bin and load data to Coffee Adapter
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee, parent, false);
        return new CoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        Coffee coffee = listCoffee.get(position);
        if(coffee == null){
            return;
        }
        holder.imageView.setImageResource(coffee.getResourceId());
        holder.textViewName.setText(coffee.getName());
        holder.textViewDescription.setText(coffee.getDescription());
        holder.textViewPrice.setText(coffee.getPrice());
    }

    @Override
    public int getItemCount() {
        if(listCoffee != null){
            return listCoffee.size();
        }
        return 0;
    }

    public class CoffeeViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewDescription;
        private TextView textViewPrice;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_coffee);
            textViewName = itemView.findViewById(R.id.tv_coffeeName);
            textViewDescription = itemView.findViewById(R.id.tv_des_coffee);
            textViewPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
