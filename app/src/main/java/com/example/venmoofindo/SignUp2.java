package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class SignUp2 extends AppCompatActivity {

    private Button createAccount;
    EditText usernameText;
    EditText passwordText;

    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_userpass_page);

        usernameText = (EditText) findViewById(R.id.Enter_username);
        passwordText = (EditText) findViewById(R.id.Enter_password);

        Intent newIntent = getIntent();
        username = usernameText.getText().toString();
        password = passwordText.getText().toString();
        firstName = newIntent.getStringExtra("FIRST_NAME");
        lastName = newIntent.getStringExtra("LAST_NAME");
        email = newIntent.getStringExtra("EMAIL");
        phoneNumber = newIntent.getStringExtra("PHONENUMBER");


        createAccount = (Button) findViewById(R.id.create_account_button);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
                enterMainUI();
            }
        });
    }

    private void signUp(){
        Amplify.Auth.signUp(
                username,
                password,
                AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email).build(),
                result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
                error -> Log.e("AuthQuickStart", "Sign up failed", error)
        );
    }

    private void enterMainUI(){
        Intent intent = new Intent(this, MainUI.class);
        startActivity(intent);
    }
}