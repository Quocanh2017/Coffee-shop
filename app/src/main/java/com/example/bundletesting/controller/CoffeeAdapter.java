package com.example.bundletesting.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.bundletesting.R;
import com.example.bundletesting.model.Coffee;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private Context context;
    private List<Coffee> listCoffee;

    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public CoffeeAdapter(List<Coffee> listCoffee) {
        this.listCoffee = listCoffee;
    }

    public interface IClickItemCoffee {
        void addCoffee(Coffee coffee);
    }

    private CoffeeAdapter.IClickItemCoffee iClickItemCoffee;

    public CoffeeAdapter(IClickItemCoffee iClickItemCoffee) {
        this.iClickItemCoffee = iClickItemCoffee;
    }

    public CoffeeAdapter(Context context) {
        this.context = context;
//        this.itemListener = itemListener;
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

        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(coffee.getResourceId()));
        holder.swipEditText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        holder.swipDeleteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listCoffee.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });

        holder.imageView.setImageResource(coffee.getResourceId());
        holder.textViewName.setText(coffee.getName());
        holder.textViewDescription.setText(coffee.getDescription());
        holder.textViewPrice.setText(coffee.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iClickItemCoffee.addCoffee(coffee);
            }
        });
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

        private SwipeRevealLayout swipeRevealLayout;
        private TextView swipEditText;
        private TextView swipDeleteText;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);

            swipeRevealLayout = itemView.findViewById(R.id.SwipeRevealLayout);
            swipEditText = itemView.findViewById(R.id.swip_edit);
            swipDeleteText = itemView.findViewById(R.id.swip_delete);

            imageView = itemView.findViewById(R.id.img_coffee);
            textViewName = itemView.findViewById(R.id.tv_coffeeName);
            textViewDescription = itemView.findViewById(R.id.tv_des_coffee);
            textViewPrice = itemView.findViewById(R.id.tv_price);

            }
    }
}
