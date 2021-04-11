package com.example.bundletesting.view;

import android.widget.Button;

import com.example.bundletesting.controller.TableSelectedAdapter;
import com.example.bundletesting.model.TableSelected;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class TableSelectedView  extends BottomSheetDialogFragment {

    private Button button;
    private List<TableSelected> listTable;
    private TableSelectedAdapter.IClickItemSelectTable tClick;

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
