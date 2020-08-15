package com.example.venmoofindo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainUI extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Button send_money_button;
    private Button request_money_button;
    private TextView greeting;
    private DrawerLayout drawer;

    // menu items

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.app_bar_main);
        setNavigationViewListener();

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

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        View hView =  navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        switch (item.getItemId()) {

            case R.id.account_info: {
                intent = new Intent(this, AccountInformation.class);
                startActivity(intent);
                break;
            }
            case R.id.transaction_history: {
                intent = new Intent(this, TransactionHistory.class);
                startActivity(intent);
                break;
            }
        }
        //close navigation drawer
        drawer.closeDrawer(GravityCompat.START);
        return true;
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