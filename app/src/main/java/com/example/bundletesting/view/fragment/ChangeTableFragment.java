package com.example.bundletesting.view.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.TableAdapter;
import com.example.bundletesting.model.Table;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChangeTableFragment extends Fragment {

    private FloatingActionButton btnFloatingAdd;
    private Button button;
    private EditText editTable;
    private RecyclerView rcvTable;
    private TableAdapter tableAdapter;
    private List<Table> listTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_table, container, false);
//        btnFloatingAdd = view.findViewById(R.id.btn_floating_insert_tb);
//        btnFloatingAdd.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                openAddDialog(Gravity.CENTER);
//            }
//        });
//
//        editTable = view.findViewById(R.id.add_tb_name);
//        button = view.findViewById(R.id.btn_add_table);
//        rcvTable = view.findViewById(R.id.rcv_change_table);
//
//        tableAdapter = new TableAdapter(this.getContext());
//        listTable = new ArrayList<>();
//        tableAdapter.setData(listTable);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
//        rcvTable.setLayoutManager(linearLayoutManager);
//        rcvTable.setAdapter(tableAdapter);
//
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                addTable();
//            }
//        });

        return view;
    }

    private void addTable() {
        String tableName = editTable.getText().toString().trim();
        if(TextUtils.isEmpty(tableName)){
            return;
        }
        Table table = new Table(R.drawable.tabod, tableName);
        CoffeeDatabase.getInstance(this.getContext()).tableDAO().insertTable(table);
        Toast.makeText(this.getContext(),"add table is successfully",Toast.LENGTH_SHORT).show();

        editTable.setText("");
    }

    private void openAddDialog(int gravity){
        //open dialog
        final Dialog dialog = new Dialog(this.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_add_table);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);


        dialog.show();
    }
}
