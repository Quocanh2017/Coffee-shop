package com.example.bundletesting.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.TableSelectedAdapter;
import com.example.bundletesting.model.TableSelected;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class TableSelectedView  extends BottomSheetDialogFragment {

    private Button button;
    private TableSelectedAdapter.IClickItemSelectTable iClick;
    public List<Integer> a = new ArrayList<>();

    public TableSelectedView(TableSelectedAdapter.IClickItemSelectTable iClick) {
        this.iClick = iClick;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_add_to_table, null);
        bottomSheetDialog.setContentView(view);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_selected_table);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        TableSelectedAdapter tableSelectedAdapter = new TableSelectedAdapter(getListTableSelected(), new TableSelectedAdapter.IClickItemSelectTable() {
            @Override
            public void SelectedTableItem(TableSelected tableSelected) {
                iClick.SelectedTableItem(tableSelected);
//                tableSelectedAdapter.getItemId(tableSelected);
            }
        });
        recyclerView.setAdapter(tableSelectedAdapter);

        return bottomSheetDialog;
    }

    public List<TableSelected> getListTableSelected(){
        List<TableSelected> list = new ArrayList<>();

        list.add(new TableSelected("table 1"));
        list.add(new TableSelected("table 2"));
        list.add(new TableSelected("table 3"));
        list.add(new TableSelected("table 4"));
        list.add(new TableSelected("table 5"));
        list.add(new TableSelected("table 6"));
        list.add(new TableSelected("table 7"));
        list.add(new TableSelected("table 8"));
        return list;
    }
}
