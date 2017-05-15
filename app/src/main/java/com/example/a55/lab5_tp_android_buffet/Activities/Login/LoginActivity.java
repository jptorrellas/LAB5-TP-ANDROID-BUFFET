package com.example.a55.lab5_tp_android_buffet.Activities.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.a55.lab5_tp_android_buffet.Activities.Login.Controller.LoginCtrl;
import com.example.a55.lab5_tp_android_buffet.Activities.Login.Model.LoginModel;
import com.example.a55.lab5_tp_android_buffet.Activities.Login.View.LoginView;
import com.example.a55.lab5_tp_android_buffet.POJOS.Usuario;
import com.example.a55.lab5_tp_android_buffet.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Ocultar ActionBar
        getSupportActionBar().hide();

        Usuario.listaUsuarios = new ArrayList<Usuario>();

        Usuario u1 = new Usuario("Juan", "Torrellas", 20555444, "a@a.com", "123");
        Usuario.registrarUsuario(u1);

        // SharedPreferences
        SharedPreferences shar = getSharedPreferences("miConfig", Context.MODE_PRIVATE);

        //Para editar el Shar
        if (!(shar.contains("recordarme")) || !(shar.contains("email")) || !(shar.contains("clave")) ) {

            SharedPreferences.Editor editor = shar.edit();

            editor.putBoolean("recordarme", true);
            editor.putString("email", "");
            editor.putString("clave", "");
            editor.commit();
        }



        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView(this, loginModel);
        LoginCtrl loginCtrl = new LoginCtrl(loginView);


    }
}
