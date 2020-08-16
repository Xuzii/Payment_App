package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;



public class Success extends AppCompatActivity {

    private ImageView mImgCheck;
    boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);

        mImgCheck = (ImageView) findViewById(R.id.imageView);
        Animatable animated = ((Animatable) mImgCheck.getDrawable());
        animated.start();
    }
}