package com.example.bundletesting.homepage.table;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.homepage.table.Table;
import com.example.bundletesting.homepage.table.TableAdapter;

import java.util.ArrayList;
import java.util.List;

public class TableFragment extends Fragment {

    private RecyclerView recyclerViewTable;
    private TableAdapter tableAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_table, container, false);
        
        recyclerViewTable = (RecyclerView) view.findViewById(R.id.crv_table);
       tableAdapter = new TableAdapter(this.getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerViewTable.setLayoutManager(gridLayoutManager);

        tableAdapter.setData(getListTable());
        recyclerViewTable.setAdapter(tableAdapter);

        return view;

    }

    private List<Table> getListTable(){
        List<Table> list = new ArrayList<>();
        list.add(new Table(R.drawable.tabod, "table 1"));
        list.add(new Table(R.drawable.tabod, "table 2"));
        list.add(new Table(R.drawable.tabod, "table 3"));
        list.add(new Table(R.drawable.tabod, "table 4"));

        list.add(new Table(R.drawable.tabod, "table 5"));
        list.add(new Table(R.drawable.tabod, "table 6"));
        list.add(new Table(R.drawable.tabod, "table 7"));
        list.add(new Table(R.drawable.tabod, "table 8"));

        return list;
    }
}
