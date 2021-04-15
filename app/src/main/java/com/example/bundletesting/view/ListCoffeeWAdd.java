package com.example.bundletesting.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bundletesting.R;
import com.example.bundletesting.controller.CoffeeSelectedAdapter;
import com.example.bundletesting.controller.TableSelectedAdapter;
import com.example.bundletesting.model.ChangeCoffee;
import com.example.bundletesting.model.Coffee;
import com.example.bundletesting.model.CoffeeSelected;
import com.example.bundletesting.model.HoldCoffee;
import com.example.bundletesting.model.TableSelected;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.fragment.TableFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListCoffeeWAdd extends AppCompatActivity {

    private Coffee coffee;
    private Button button;

    private TextView textView;
    private TextView textView_time;

    private RecyclerView recyclerViewCoffeeSelected;
    private CoffeeSelectedAdapter coffeeSelectedAdapter;

    private String nameTable;

    List<Coffee> selectedList = new ArrayList<>();
    List<Coffee> list;

    private static final int MY_REQUES_CODE = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_coffee_w_add);

        recyclerViewCoffeeSelected = (RecyclerView) findViewById(R.id.rcv_coffee_selected);
        coffeeSelectedAdapter = new CoffeeSelectedAdapter(this);

        LinearLayoutManager linearLinearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewCoffeeSelected.setLayoutManager(linearLinearLayoutManager);

        list = (ArrayList<Coffee>) getIntent().getExtras().getSerializable("Coffee");

        coffeeSelectedAdapter.setData(list);
        recyclerViewCoffeeSelected.setAdapter(coffeeSelectedAdapter);


        button = findViewById(R.id.btn_add_to_table);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickOpenBottomSheetSelectTable();
            }

        });

        textView = findViewById(R.id.tv_total_price_od);
        textView_time = findViewById(R.id.tv_time_oder_od);
        Date currentTime = Calendar.getInstance().getTime();
        textView_time.setText(String.valueOf(currentTime));
        String[] x;
        double y=0;
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                x = list.get(i).getPrice().split(" ");
                y = y + Double.parseDouble(x[0]);
                Arrays.fill(x, null);
            }
        }
        textView.setText(String.valueOf(y) + " VND");

        Log.d("size", "onCreate: " + list.size());

//        Toast.makeText(getApplicationContext(), coffee.toString(), Toast.LENGTH_SHORT);

    }

    public void clickOpenBottomSheetSelectTable() {
        TableSelectedView tableSelectedView = new TableSelectedView(new TableSelectedAdapter.IClickItemSelectTable() {
            @Override
            public void SelectedTableItem(TableSelected tableSelected) {
                nameTable = tableSelected.getNumberTable();
//                for (Coffee coffee: list) {
//                    HoldCoffee holdCoffee = new HoldCoffee(coffee.getId(), nameTable);
//                    CoffeeDatabase.getInstance(ListCoffeeWAdd.this).holdCoffeeDAO().insertHoldCoffee(holdCoffee);
//                }

                Log.i("click",tableSelected.getNumberTable().toString());

//                selectedList = (ArrayList<Coffee>) list;

                if (list != null) {
                    for(int i=0; i<list.size(); i++){
                        int x = list.get(i).getResourceId();
                        String y = list.get(i).getName();
                        String z = list.get(i).getPrice();
                        HoldCoffee holdCoffee = new HoldCoffee(nameTable,x ,y,z);
                        CoffeeDatabase.getInstance(ListCoffeeWAdd.this).holdCoffeeDAO().insertHoldCoffee(holdCoffee);
                    }
//                    DataLocalTransfer.setCategory((Coffee) selectedList);
//                    Toast.makeText(ListCoffeeWAdd.this,DataLocalTransfer.getCategory().getName(), Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent(ListCoffeeWAdd.this, TableAddedFood.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putParcelableArrayList("add_to_table", (ArrayList<? extends Parcelable>) selectedList);

//                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.layout_hh, new TableAddedFood());
//                    fragmentTransaction.commit();

//                    Intent intent = new Intent(ListCoffeeWAdd.this, TableAddedFood.class);

//                    Bundle bundle = new Bundle();
//                    bundle.putParcelableArrayList("add_to_table", (ArrayList<? extends Parcelable>) selectedList);
//                    Fragment fr = new TableAddedFood();
//                    fr.setArguments(bundle);

//                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.crv_order, fr);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();

                    Toast.makeText(ListCoffeeWAdd.this, nameTable + " was add successfully", Toast.LENGTH_SHORT).show();

//                    intent.putExtras(bundle);

//                    startActivity(intent);

//                    startActivityForResult(intent, MY_REQUES_CODE);

//                    TableAddedFood frag = new TableAddedFood();
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("add_to_table", (Serializable) selectedList);
//                    frag.setArguments(bundle);
                }
                else {
                    Toast.makeText(ListCoffeeWAdd.this, "Add to table not successfully", Toast.LENGTH_SHORT).show();
                }

//                Intent intent = new Intent(ListCoffeeWAdd.this,TableFragment.class);
//                startActivity(intent);

            }
        });
        //cho nay
//        tableSelectedView.a = new ArrayList<>();
        tableSelectedView.show(getSupportFragmentManager(), tableSelectedView.getTag());
    }

    public List<Coffee> getSelectedList() {
        return selectedList;
    }

    public List<CoffeeSelected> getListCoffeeSelected(){
        List<CoffeeSelected> listhh = new ArrayList<>();


        return listhh;
    }


}