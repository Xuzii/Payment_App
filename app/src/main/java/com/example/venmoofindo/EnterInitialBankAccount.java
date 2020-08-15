package com.example.venmoofindo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;

public class EnterInitialBankAccount extends AppCompatActivity {

    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bank_information);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        nextPhase();


    }
    public void nextPhase() {
        if (mSeekBar != null) {
            mSeekBar.setProgress(mSeekBar.getProgress() + 1);
        }
    }


}