package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class SendMoney extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);


        AutoCompleteTextView editText = findViewById(R.id.users);
        ArrayAdapter<String> autoComepleteAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,  COUNTRIES);
        editText.setAdapter(autoComepleteAdapter);

        Spinner spinner = (Spinner) findViewById(R.id.banks);
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, COUNTRIES);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

    }
}