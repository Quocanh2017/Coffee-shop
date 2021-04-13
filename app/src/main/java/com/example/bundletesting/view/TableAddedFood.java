package com.example.bundletesting.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.CoffeeSelectedAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class TableAddedFood extends BottomSheetDialogFragment {
    private RecyclerView recyclerViewCoffeeSelected;
    private CoffeeSelectedAdapter coffeeSelectedAdapter;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);;
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_table, null);
        bottomSheetDialog.setContentView(view);

        recyclerViewCoffeeSelected = (RecyclerView) view.findViewById(R.id.crv_order);
        coffeeSelectedAdapter = new CoffeeSelectedAdapter(this.getContext());

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCoffeeSelected.setLayoutManager(linearLinearLayoutManager);

        recyclerViewCoffeeSelected.setAdapter(coffeeSelectedAdapter);

        return bottomSheetDialog;
    }
}
