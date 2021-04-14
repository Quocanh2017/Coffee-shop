package com.example.bundletesting.view.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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
import com.example.bundletesting.controller.ChangeTableAdapter;
import com.example.bundletesting.controller.TableAdapter;
import com.example.bundletesting.model.ChangeTable;
import com.example.bundletesting.model.Table;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.UpdateTable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChangeTableFragment extends Fragment {

    private static final int REQUEST_CODE = 10;
    private EditText editTextName;
    private Button button;
    private RecyclerView recyclerView;

    private ChangeTableAdapter changeTableAdapter;
    private List<ChangeTable> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_table, container, false);

        editTextName = view.findViewById(R.id.edit_table);
        button = view.findViewById(R.id.button_add_table);
        recyclerView = view.findViewById(R.id.rcv_change_table);

        changeTableAdapter = new ChangeTableAdapter(new ChangeTableAdapter.IClickItemTable() {
            @Override
            public void updateTable(ChangeTable changeTable) {
                clickUpdateTable(changeTable);
            }
        });
        list = new ArrayList<>();
        changeTableAdapter.setData(list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(changeTableAdapter);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addTable();
            }
        });

        loadData();

        return view;
    }

    private void clickUpdateTable(ChangeTable changeTable){
        Intent intent = new Intent(this.getContext(), UpdateTable.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("change_table",changeTable);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            loadData();
        }
    }

    private void addTable() {
        String sTableName = editTextName.getText().toString().trim();
        if(TextUtils.isEmpty(sTableName)){
            return;
        }
        ChangeTable changeTable = new ChangeTable(R.drawable.tabod, sTableName);

        if(isTableExist(changeTable)){
            Toast.makeText(this.getContext(),"Add table not successfully", Toast.LENGTH_SHORT).show();
            return;
        }

        CoffeeDatabase.getInstance(this.getContext()).changeTableDAO().insertChangeTable(changeTable);
        Toast.makeText(this.getContext(),"Add table successfully", Toast.LENGTH_SHORT).show();

        editTextName.setText("");

        loadData();

    }

    private void loadData(){
        //get list table change from room db
        list = CoffeeDatabase.getInstance(this.getContext()).changeTableDAO().getListChangeTable();
        changeTableAdapter.setData(list);
    }

    public boolean isTableExist(ChangeTable changeTable){
        List<ChangeTable> listTable = CoffeeDatabase.getInstance(this.getContext()).changeTableDAO().checkTable(changeTable.getName());
        return listTable != null && !listTable.isEmpty();
    }

}
