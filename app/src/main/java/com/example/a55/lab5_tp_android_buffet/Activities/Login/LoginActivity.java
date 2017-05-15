package com.example.a55.lab5_tp_android_buffet.Activities.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView(this, loginModel);
        LoginCtrl loginCtrl = new LoginCtrl(loginView);


    }
}
