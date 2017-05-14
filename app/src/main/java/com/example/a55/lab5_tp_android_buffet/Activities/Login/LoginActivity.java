package com.example.a55.lab5_tp_android_buffet.Activities.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a55.lab5_tp_android_buffet.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ocultar ActionBar
        getSupportActionBar().hide();
    }
}
