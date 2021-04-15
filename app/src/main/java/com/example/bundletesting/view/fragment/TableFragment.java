package com.example.bundletesting.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.TableAdapter;
import com.example.bundletesting.model.ChangeTable;
import com.example.bundletesting.model.Table;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.TableAddedFood;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sa90.materialarcmenu.ArcMenu;

import java.util.ArrayList;
import java.util.List;

public class TableFragment extends Fragment {

    private RecyclerView recyclerViewTable;
    private TableAdapter tableAdapter;

    private FragmentActivity myContext;

    private Button buttonOK;
    private Button buttonCanel;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_table, container, false);

        recyclerViewTable = (RecyclerView) view.findViewById(R.id.crv_table);

        tableAdapter = new TableAdapter(new TableAdapter.IClickItemTable(){
            @Override
            public void showBottomSheetView(Table table) {
                clickOpenBottomSheetDialog();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerViewTable.setLayoutManager(gridLayoutManager);

        tableAdapter.setData(getListTable());
        recyclerViewTable.setAdapter(tableAdapter);


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    //show bottom sheet
    private void clickOpenBottomSheetDialog(){

        TableAddedFood tableAddedFood = new TableAddedFood();
        tableAddedFood.show(getParentFragmentManager(), tableAddedFood.getTag());

//        buttonOK = view.findViewById(R.id.btn_payment_ok);
//        buttonCanel = view.findViewById(R.id.btn_payment_canel);
//
//        buttonCanel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                tableAddedFood.dismiss();
//            }
//        });
//        buttonOK.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(TableFragment.this.getContext(),"Payment succesfully successfully", Toast.LENGTH_SHORT).show();
//            }
//        });
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
        ///
        List<ChangeTable> cList = CoffeeDatabase.getInstance(TableFragment.this.getContext()).changeTableDAO().getListChangeTable();
        if (cList.size() > 0) {
            for (int i = 0; i < cList.size(); i++) {
                list.add(new Table(cList.get(i).getSourceID(), cList.get(i).getName()));
            }
        }

        return list;
    }
}
