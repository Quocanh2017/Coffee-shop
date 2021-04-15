package com.example.bundletesting.view.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.CoffeeAdapter;
import com.example.bundletesting.model.ChangeCoffee;
import com.example.bundletesting.model.ChangeTable;
import com.example.bundletesting.model.Coffee;
import com.example.bundletesting.model.CoffeeSelected;
import com.example.bundletesting.model.Table;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.HomePage;
import com.example.bundletesting.view.ListCoffeeWAdd;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sa90.materialarcmenu.ArcMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

public class CoffeeFragment extends Fragment {

    private RecyclerView recyclerViewCoffee;
    private CoffeeAdapter coffeeAdapter;

//    private FloatingActionButton btnFloatingAdd;
//    private FloatingActionButton btnFloatingEdit;
//    private FloatingActionButton btnFloatingDelete;

    private EditText addCoffeeName;
    private EditText addCoffeeDescription;
    private EditText addCoffeePrice;
    private ImageView addImage;
    private Button btnAddCoffee;

    List<Coffee> list = new ArrayList<>();

    List<Coffee> listAdd = new ArrayList<>();

    List<Coffee> selectedList = new ArrayList<>();

//    private ArcMenu arcMenu;
    MaterialToolbar toolbar;

    private static final int MY_REQUES_CODE = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);

        addCoffeeName = view.findViewById(R.id.add_cf_name);
        addCoffeeDescription = view.findViewById(R.id.add_cf_des);
        addCoffeePrice = view.findViewById(R.id.add_cf_price);
        btnAddCoffee = view.findViewById(R.id.btn_add_cf);
        addImage = view.findViewById(R.id.cf_img_add);

        recyclerViewCoffee = (RecyclerView) view.findViewById(R.id.rcv_coffee);
//        arcMenu = view.findViewById(R.id.arc_menu_cf);

        coffeeAdapter = new CoffeeAdapter(new CoffeeAdapter.IClickItemCoffee(){
            @Override
            public void addCoffee(Coffee coffee) {
                Toast.makeText(getApplicationContext(), coffee.toString(), Toast.LENGTH_SHORT);
                addCoffeeToTable(coffee);
            }
        });


        toolbar = view.findViewById(R.id.fragment_coffee_tool_bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // up button
                Log.i("Test", "Back");
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // menu item
                //cai fragment nao ma no bi tran len thi ong them margin_top: ?attr/appbarsize Nhe
                Intent intent = new Intent(getActivity(), ListCoffeeWAdd.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("Coffee", (Serializable) selectedList);
                intent.putExtras(bundle);

                startActivityForResult(intent, MY_REQUES_CODE);

                return true;
            }
        });

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerViewCoffee.setLayoutManager(linearLinearLayoutManager);

        coffeeAdapter.setData(getListCoffee());
        recyclerViewCoffee.setAdapter(coffeeAdapter);


        return view;
    }


//    //dialog add to recyclerview
//    private void openAddDialog(int gravity){
//        //open dialog
//        final Dialog dialog = new Dialog(this.getContext());
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.layout_dialog_add_coffee);
//
//        Window window = dialog.getWindow();
//        if(window == null){
//            return;
//        }
//
//        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        WindowManager.LayoutParams windowAttribute = window.getAttributes();
//        windowAttribute.gravity = gravity;
//        window.setAttributes(windowAttribute);
//
//        dialog.show();
//    }

    private void addCoffeeToTable(Coffee coffee){
        selectedList.add(coffee);
    }

    private List<Coffee> getListCoffee(){

        list.add(new Coffee(R.drawable.bac_xiu, "Bạc xỉu", "Bạc xỉu ngon", "35000 VND"));
        list.add(new Coffee(R.drawable.cafedenda, "Đen đá", "Đen đá gần ngon", "25000 VND"));
        list.add(new Coffee(R.drawable.capuchino, "Capuchino", "Capuchino hơi ngon", "30000 VND"));
        list.add(new Coffee(R.drawable.cf, "Cà phê truyền thống", "cà phê thượng hạng", "25000 VND"));
        list.add(new Coffee(R.drawable.bac_xiu, "Bạc xỉu", "Bạc xỉu ngon", "35000 VND"));
        list.add(new Coffee(R.drawable.cafedenda, "Đen đá", "Đen đá gần ngon", "25000 VND"));
        list.add(new Coffee(R.drawable.capuchino, "Capuchino", "Capuchino hơi ngon", "30000 VND"));
        list.add(new Coffee(R.drawable.cf, "Cà phê truyền thống", "cà phê thượng hạng", "25000 VND"));

        List<ChangeCoffee> cList = CoffeeDatabase.getInstance(CoffeeFragment.this.getContext()).changeCoffeeDAO().getListChangeCoffee();
        if (cList.size() > 0) {
            for (int i = 0; i < cList.size(); i++) {
                list.add(new Coffee(cList.get(i).getSourceId(), cList.get(i).getName(), cList.get(i).getDescription(), cList.get(i).getPrice()));
            }
        }

        return list;
    }

}
