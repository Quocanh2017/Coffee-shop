package com.example.bundletesting.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.model.Table;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.tableViewHolder>{

    private Context context;
    private List<Table> listTable;

    private IClickItemTable iClickItemTable;

    View view;


    public interface IClickItemTable {
        void showBottomSheetView(Table table);
    }

    public TableAdapter(IClickItemTable iClickItemTable) {
        this.iClickItemTable = iClickItemTable;
    }

    public TableAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Table> list){
        this.listTable = list;
        //load and set data
        notifyDataSetChanged();
    }

    //override function
    @NonNull
    @Override
    public tableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //call to create function and return view
        //create view get ui xml of item_table to put into tableViewHolder
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table, parent, false);
        return new tableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tableViewHolder holder, int position) {
        //set data for tableViewHolder
        Table table = listTable.get(position);
        if (table == null){
            return;
        }

        holder.imgView.setImageResource(table.getResourceImage());
        holder.textViewTable.setText(table.getNumberTable());
        
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iClickItemTable.showBottomSheetView(table);
                holder.itemView.setBackgroundColor(Color.parseColor("#FFF000"));
            }
        });

//        holder.itemView.
    }

//    public void setBackground(){
//        view.setBackgroundColor(Color.parseColor("#00bfff"));
//    }

    @Override
    public int getItemCount() {
        //check size of list table
        if(listTable != null){
            return listTable.size();
        }
        return 0;
    }

    public class tableViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgView;
        private TextView textViewTable;
//        private RelativeLayout rl;

        public tableViewHolder(@NonNull View itemView) {
            super(itemView);

            //get id img and id textview
            imgView = itemView.findViewById(R.id.img_table);
            textViewTable = itemView.findViewById(R.id.textView_table);
//            rl = itemView.findViewById(R.id.background);
        }
    }
}
