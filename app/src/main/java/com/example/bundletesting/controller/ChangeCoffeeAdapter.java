package com.example.bundletesting.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.model.ChangeCoffee;
import com.example.bundletesting.model.ChangeTable;

import java.util.List;

public class ChangeCoffeeAdapter extends RecyclerView.Adapter<ChangeCoffeeAdapter.changeCoffeeViewHolder>{

    private List<ChangeCoffee> list;
    private IClickItemCoffee iClickCoffee;

    public ChangeCoffeeAdapter(IClickItemCoffee iClickCoffee) {
        this.iClickCoffee = iClickCoffee;
    }

    public interface IClickItemCoffee{
        public void updateCoffee(ChangeCoffee changeCoffee);

        public void deleteCoffee(ChangeCoffee changeCoffee);
    }

    public ChangeCoffeeAdapter(List<ChangeCoffee> list) {
        this.list = list;
    }

    public void setData(List<ChangeCoffee> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public changeCoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_change_coffee, parent, false);

        return new changeCoffeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull changeCoffeeViewHolder holder, int position) {
        final ChangeCoffee changeCoffee = list.get(position);
        if (changeCoffee == null){
            return;
        }
        holder.imageView.setImageResource(changeCoffee.getSourceId());
        holder.textViewName.setText(changeCoffee.getName());
        holder.textViewDes.setText(changeCoffee.getDescription());
        holder.textViewPrice.setText(changeCoffee.getPrice());
        holder.buttonUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iClickCoffee.updateCoffee(changeCoffee);
            }
        });
        holder.buttonDelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                iClickCoffee.deleteCoffee(changeCoffee);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class changeCoffeeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewDes;
        private TextView textViewPrice;
        private Button buttonUpdate;
        private Button buttonDelete;

        public changeCoffeeViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_change_coffee);
            textViewName = itemView.findViewById(R.id.text_name_coffee);
            textViewDes = itemView.findViewById(R.id.text_des_coffee);
            textViewPrice = itemView.findViewById(R.id.text_price_coffee);
            buttonUpdate = itemView.findViewById(R.id.btn_update_coffee);
            buttonDelete = itemView.findViewById(R.id.btn_delete_coffee);
        }
    }
}
