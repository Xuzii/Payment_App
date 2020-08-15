package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.ArrayList;

public class SendMoney extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "Andorra", "Angola"
    };

    private ArrayList<String> users;
    AutoCompleteTextView autoCompleteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);


        users = new ArrayList<>();
        autoCompleteText = findViewById(R.id.users);


        // initialize users
        ListOfUsers listOfUsers = new ListOfUsers(this);
        users = listOfUsers.getUsers("Xuzii");

        ArrayAdapter<String> autoComepleteAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,  users);
        autoCompleteText.setAdapter(autoComepleteAdapter);


        // initialize banks
        Spinner spinner = (Spinner) findViewById(R.id.banks);
        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, users);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

    }


}