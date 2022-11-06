package com.android.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class secondpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Request window feature
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_secondpage);
    }
}