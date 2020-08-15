package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginUITest extends AppCompatActivity {

    private Button login_button;
    private Button signUp;
    public EditText usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        usernameText = (EditText) findViewById(R.id.Enter_email);

        login_button = (Button)findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterMainUI();
            }
        });

        signUp = (Button) findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign_up();
            }
        });
    }

    private void enterMainUI(){
        Intent intent = new Intent(this, MainUI.class);
        startActivity(intent);
    }

    private void sign_up() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}