package com.example.mockup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ScrollingTabContainerView;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner;
    ArrayAdapter<String> arrayAdapter;
    ImageButton imageButtonPlus, imageButtonMinus;
    TextView quantity, price;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonMinus = (ImageButton) findViewById(R.id.imageButton);
        imageButtonPlus = (ImageButton) findViewById(R.id.imageButton2);
        quantity = (TextView) findViewById(R.id.textView16);
        spinner = (Spinner) findViewById(R.id.spinner);
        price = (TextView) findViewById(R.id.textView3);

        imageButtonPlus.setOnClickListener(this);
        imageButtonMinus.setOnClickListener(this);

        Map<String, String> map = new HashMap<>();
        map.put("Piano", "500");
        map.put("Guitar", "400");
        map.put("Komus", "300");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Piano");
        arrayList.add("Guitar");
        arrayList.add("Komus");

        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (Map.Entry<String, String> st : map.entrySet()) {
                    if (st.getKey().equals(arrayList.get(position))) {
                        price.setText(st.getValue());
                    }


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    @Override
    public void onClick(View v) {
        int count = Integer.parseInt(quantity.getText().toString());
        String string;


        switch (v.getId()) {
            case R.id.imageButton:
                count++;
                string = String.valueOf(count);
                quantity.setText(string);
                break;
            case R.id.imageButton2:
                if (quantity.getText().toString().equals("0")) {
                    Toast.makeText(MainActivity.this, "Отрицательное число неприемлемо", Toast.LENGTH_SHORT).show();
                } else {
                    count--;
                    string = String.valueOf(count);
                    quantity.setText(string);
                }
        }
    }
}

