package com.example.bundletesting.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bundletesting.view.Constants;
import com.example.bundletesting.R;
import com.example.bundletesting.view.SharePrefers;
import com.example.bundletesting.model.User;
import com.example.bundletesting.model.database.CoffeeDatabase;
import com.example.bundletesting.view.ChangeProfile;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private Button button;
    private TextView edit1;
    private TextView edit2;
    private TextView edit3;
    private User user;
    List<User> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        edit1 = view.findViewById(R.id.tv_user_name);
        edit2 = view.findViewById(R.id.tv_user_account);
        edit3 = view.findViewById(R.id.tv_user_address);

        button = view.findViewById(R.id.btn_edit_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ChangeProfile.class);
                startActivity(intent);
            }
        });

        SharedPreferences preferences = SharePrefers.getInstance(getActivity());
        list = getListUser(preferences.getString(Constants.USER_NAME, ""), preferences.getString(Constants.PASSWORD, ""));
        if (list != null && !list.isEmpty()) {
            edit1.setText(list.get(0).getUserName());
            edit2.setText(list.get(0).getAccount());
            edit3.setText(list.get(0).getAddress());
        }

        return view;
    }

    private List<User> getListUser(String account, String password) {
        list = CoffeeDatabase.getInstance(this.getContext()).userDao().getListUser(account, password);
//        Toast.makeText(getApplicationContext(), list.get(0).getUserName(), Toast.LENGTH_SHORT).show();

        return list;
    }
}
