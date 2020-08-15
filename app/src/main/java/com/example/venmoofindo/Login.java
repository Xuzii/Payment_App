package com.example.venmoofindo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.android.volley.RequestQueue;

import java.util.concurrent.atomic.AtomicBoolean;

public class Login extends AppCompatActivity {

    private RequestQueue queue;
    private String username;
    private String password;
    private String url;

    private EditText usernameText;
    private EditText passwordText;

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());


            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }

//        Amplify.Auth.fetchAuthSession(
//                result -> Log.i("AmplifyQuickstart", result.toString()),
//                error -> Log.e("AmplifyQuickstart", error.toString())
//        );
//


        usernameText = (EditText) findViewById(R.id.Enter_email);
        passwordText = (EditText) findViewById(R.id.Enter_password);

        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameText.getText().toString();
                password = passwordText.getText().toString();
                loginRequest(username, password);

            }
        });
//
//        queue = Volley.newRequestQueue(this);

    }

    public void loginRequest(String username, String password){
//        AtomicBoolean signIn = new AtomicBoolean(false);
//        Amplify.Auth.signIn(
//                username,
//                password,
//                result -> signIn.set(result.isSignInComplete()),
//                error -> Log.e("AuthQuickstart", error.toString())
//        );
//
//        if(signIn.get()){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//        } else {
//            // TODO: Tell user invalid login
//        }

    }





}
