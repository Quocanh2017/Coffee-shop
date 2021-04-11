package com.example.bundletesting.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.model.TableSelected;

import java.util.List;

public class TableSelectedAdapter extends RecyclerView.Adapter<TableSelectedAdapter.TableSelectedViewHolder>{

    private Context context;
    private List<TableSelected> list;
    private IClickItemSelectTable iClickItemSelectTable;

    public TableSelectedAdapter(List<TableSelected> list,IClickItemSelectTable iClickItemSelectTable) {
        this.iClickItemSelectTable = iClickItemSelectTable;
        this.list = list;
    }

    public TableSelectedAdapter(Context context) {
        this.context = context;
    }

    public interface IClickItemSelectTable{
        void SelectedTableItem(TableSelected tableSelected);
    }

    @NonNull
    @Override
    public TableSelectedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table_selected, parent, false);
        return new TableSelectedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableSelectedViewHolder holder, int position) {
        TableSelected tableSelected = list.get(position);
        if (tableSelected == null){
            return;
        }
        holder.textView.setText(tableSelected.getNumberTable());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItemSelectTable.SelectedTableItem(tableSelected);
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

    public class TableSelectedViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public TableSelectedViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_selected_table);
        }
    }
}
