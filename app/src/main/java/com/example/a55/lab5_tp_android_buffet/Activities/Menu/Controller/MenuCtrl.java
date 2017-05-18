package com.example.a55.lab5_tp_android_buffet.Activities.Menu.Controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.a55.lab5_tp_android_buffet.Activities.Login.LoginActivity;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.Interfaces.IMenu;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.Listeners.MenuListener;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.MenuActivity;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.View.MenuView;

import com.example.a55.lab5_tp_android_buffet.R;

/**
 * Created by A55 on 18/05/2017.
 */

public class MenuCtrl implements IMenu{

    /**
     * Atributos
     */

    public MenuView menuView;
    public MenuListener menuListener;

    SharedPreferences shar;

    /**
     * Constructor
     */
    public MenuCtrl(MenuView menuView) {

        this.menuView = menuView;
        this.menuListener = new MenuListener(this);

        this.menuView.btnVerPedido.setOnClickListener(menuListener);
        //this.menuView.btnDesloguearse.setOnClickListener(menuListener);

        // Levanta SharedPreferences
        this.shar = PreferenceManager.getDefaultSharedPreferences(this.menuView.menuActivity);

    }

    @Override
    public void operar(View v) {

        switch (v.getId()) {

            case R.id.btnVerPedido:

                this.verPedido();
                break;

            /*case R.id.btnDesloguearse:
                this.desloguear();
                break;*/

            default:
                Toast.makeText(this.menuView.menuActivity, "SWITCH DEFAULT", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void verPedido() {

        Toast.makeText(this.menuView.menuActivity, "UE A VER PEDIDO", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent (this.menuView.menuActivity, PedidoActivity.class);
        //this.menuView.menuActivity.startActivity(intent);

    }

}
