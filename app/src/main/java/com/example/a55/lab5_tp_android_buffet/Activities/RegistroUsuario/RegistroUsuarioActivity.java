package com.example.a55.lab5_tp_android_buffet.Activities.RegistroUsuario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a55.lab5_tp_android_buffet.R;

public class RegistroUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        //Ocultar ActionBar
        getSupportActionBar().hide();
    }
}
