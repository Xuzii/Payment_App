package com.example.venmoofindo;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainUI extends AppCompatActivity {

    private Button send_money_button;
    private Button request_money_button;
    private TextView greeting;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.app_bar_main);

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navgiation_drawer_close);
        if(drawer != null) {
            drawer.addDrawerListener(toggle);
            toggle.syncState();
        }



    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void sendMoneyUI() {
        Intent intent = new Intent(this, SendMoney.class);
        startActivity(intent);

    }

    private void requestMoneyUI() {
        Intent intent = new Intent(this, RequestMoney.class);
        startActivity(intent);
    }
//@Override
//public boolean onCreateOptionsMenu(Menu menu) {
//    MenuInflater inflater = getMenuInflater();
//    inflater.inflate(R.menu.main_menu,menu);
//    return true;
//}
}