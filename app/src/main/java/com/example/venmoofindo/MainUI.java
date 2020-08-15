package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainUI extends AppCompatActivity {

    private Button send_money_button;
    private Button request_money_button;
    private TextView greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greeting = (TextView)findViewById(R.id.greeting);

        send_money_button = (Button)findViewById(R.id.SendMoney);
        send_money_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoneyUI();
            }
        });
        request_money_button = (Button)findViewById(R.id.RequestMoney);
        request_money_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestMoneyUI();
            }
        });
    }

    private void sendMoneyUI() {
        Intent intent = new Intent(this, SendMoney.class);
        startActivity(intent);

    }

    private void requestMoneyUI() {
        Intent intent = new Intent(this, RequestMoney.class);
        startActivity(intent);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu,menu);
//        return true;
//    }
}