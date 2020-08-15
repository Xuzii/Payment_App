package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.widget.ImageView;



public class Success extends AppCompatActivity {

    private ImageView mImgCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);

        mImgCheck = (ImageView) findViewById(R.id.imageView);
        ((Animatable) mImgCheck.getDrawable()).start();
    }
}