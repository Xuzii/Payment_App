package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText phoneNumber;

    Button next;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);
        firstName = (EditText) findViewById(R.id.Enter_name);
        lastName = (EditText) findViewById(R.id.Enter_lastName);
        email = (EditText) findViewById(R.id.Enter_email);
        phoneNumber = (EditText) findViewById(R.id.Enter_phone);
        next = (Button) findViewById(R.id.next_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpUserPass.class);
                intent.putExtra("FIRST_NAME", firstName.getText().toString());
                intent.putExtra("LAST_NAME", lastName.getText().toString());
                intent.putExtra("EMAIL", email.getText().toString());
                intent.putExtra("PHONENUMBER", phoneNumber.getText().toString());
                startActivity(intent);
            }
        });

    }
}
