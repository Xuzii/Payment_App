package com.example.venmoofindo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class SignUpUserPass extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;

    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;

    Button signUp;


    public class SignUp extends AppCompatActivity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sign_up_userpass_page);
            usernameText = (EditText) findViewById(R.id.Enter_username);
            passwordText= (EditText) findViewById(R.id.Enter_password);

            signUp = (Button) findViewById(R.id.create_account_button);

            Intent newIntent = getIntent();
            username = usernameText.getText().toString();
            password = passwordText.getText().toString();
            firstName = newIntent.getStringExtra("FIRST_NAME");
            lastName = newIntent.getStringExtra("LAST_NAME");
            email = newIntent.getStringExtra("EMAIL");
            phoneNumber = newIntent.getStringExtra("PHONENUMBER");


            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    signUp(username, password, email);
                }
            });




        }

        private void signUp(String username, String password, String email){
            Amplify.Auth.signUp(
                    username,
                    password,
                    AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email).build(),
                    result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
                    error -> Log.e("AuthQuickStart", "Sign up failed", error)
            );
        }

//        private void signUp(){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            Intent newIntent = getIntent();
//            username = usernameText.getText().toString();
//            password = passwordText.getText().toString();
//            firstName = newIntent.getStringExtra("FIRST_NAME");
//            lastName = newIntent.getStringExtra("LAST_NAME");
//            email = newIntent.getStringExtra("EMAIL");
//            phoneNumber = newIntent.getStringExtra("PHONENUMBER");
//
//
//            startActivity(intent);
//        }
    }
}
