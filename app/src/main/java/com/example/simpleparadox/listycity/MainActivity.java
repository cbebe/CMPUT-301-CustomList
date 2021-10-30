package com.example.simpleparadox.listycity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String CITY_EXTRA = "com.example.simpleparadox.listycity.CITY_EXTRA";

    // Declare the variables so that you will be able to reference it later.
    ListView cityList;
    EditText newName;
    LinearLayout nameField;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.field_nameEntry);
        newName = findViewById(R.id.editText_name);

        cityList = findViewById(R.id.city_list);
        dataList = new ArrayList<>();
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);


        cityList.setAdapter(cityAdapter);
        cityList.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, ShowActivity.class);
            intent.putExtra(CITY_EXTRA, dataList.get(i));
            startActivity(intent);
        });


        final Button addButton = findViewById(R.id.button_add);
        addButton.setOnClickListener(v -> nameField.setVisibility(View.VISIBLE));

        final Button confirmButton = findViewById(R.id.button_confirm);
        confirmButton.setOnClickListener(v -> {
            String cityName = newName.getText().toString();
            cityAdapter.add(cityName);
            newName.getText().clear();
            nameField.setVisibility(View.INVISIBLE);
        });

        final Button deleteButton = findViewById(R.id.button_clear);
        deleteButton.setOnClickListener(v -> cityAdapter.clear());
    }
}
