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
import com.example.bundletesting.model.ChangeTable;

import java.util.List;

public class ChangeTableAdapter extends RecyclerView.Adapter<ChangeTableAdapter.ChangeTableViewHolder>{

    private List<ChangeTable> list;
    private IClickItemTable iClickItemTable;

    public interface IClickItemTable{
        public void updateTable(ChangeTable changeTable);
    }

    public ChangeTableAdapter(IClickItemTable iClickItemTable) {
        this.iClickItemTable = iClickItemTable;
    }

    public void setData(List<ChangeTable> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChangeTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_change_table, parent, false);
        return new ChangeTableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChangeTableViewHolder holder, int position) {
        final ChangeTable changeTable = list.get(position);
        if (changeTable == null){
            return;
        }
        holder.image.setImageResource(changeTable.getSourceID());
        holder.tvName.setText(changeTable.getName());
        holder.btnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iClickItemTable.updateTable(changeTable);
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

    public class ChangeTableViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView tvName;
        private Button btnButton;

        public ChangeTableViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_change_table);
            tvName = itemView.findViewById(R.id.text_change_table);
            btnButton = itemView.findViewById(R.id.btn_update_table);
        }
    }
}
