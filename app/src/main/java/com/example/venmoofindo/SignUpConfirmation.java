package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;

import java.util.concurrent.atomic.AtomicBoolean;

public class SignUpConfirmation extends AppCompatActivity {

    EditText usernameConfirmationText;
    EditText codeText;
    Button createAccount;

    String username;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirmation);

        usernameConfirmationText = (EditText) findViewById(R.id.Enter_username);
        codeText = (EditText) findViewById(R.id.Enter_code);



        createAccount = (Button) findViewById(R.id.create_account_button);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = usernameConfirmationText.getText().toString();
                code = codeText.getText().toString();
                confirmation();
            }
        });

    }

    public void confirmation(){
        AtomicBoolean confirmation = new AtomicBoolean(false);
        Amplify.Auth.confirmSignUp(
                username,
                code,
                result -> confirmation.set(result.isSignUpComplete()),
                error -> Log.e("AuthQuickstart", error.toString())
        );
        if (confirmation.get()) {
            Intent intent = new Intent(getApplicationContext(), MainUI.class);
            startActivity(intent);
        } else {
            //TODO: NOT CORRECT
        }
    }
}