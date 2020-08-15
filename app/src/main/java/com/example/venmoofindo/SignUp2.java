package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp2 extends AppCompatActivity {

    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_userpass_page);

        createAccount = (Button) findViewById(R.id.create_account_button);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterMainUI();
            }
        });
    }

    private void enterMainUI(){
        Intent intent = new Intent(this, MainUI.class);
        startActivity(intent);
    }
}