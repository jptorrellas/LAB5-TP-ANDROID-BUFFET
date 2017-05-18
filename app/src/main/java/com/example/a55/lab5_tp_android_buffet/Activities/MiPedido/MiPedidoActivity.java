package com.example.a55.lab5_tp_android_buffet.Activities.MiPedido;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.a55.lab5_tp_android_buffet.Activities.MiPedido.Controller.MiPedidoCtrl;
import com.example.a55.lab5_tp_android_buffet.Activities.MiPedido.Model.MiPedidoModel;
import com.example.a55.lab5_tp_android_buffet.Activities.MiPedido.View.MiPedidoView;
import com.example.a55.lab5_tp_android_buffet.POJOS.Pedido;
import com.example.a55.lab5_tp_android_buffet.R;

public class MiPedidoActivity extends AppCompatActivity {

    Menu miMenu;
    SharedPreferences shar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_pedido);

        //Cambia titulo a  ActionBar
        getSupportActionBar().setTitle("MI PEDIDO");

        // Levanta SharedPreferences
        this.shar = PreferenceManager.getDefaultSharedPreferences(this);

        //MVC
        MiPedidoModel miPedidoModel = new MiPedidoModel();
        MiPedidoView miPedidoView = new MiPedidoView(this, miPedidoModel);
        MiPedidoCtrl miPedidoCtrl = new MiPedidoCtrl(miPedidoView);
    }


    //Para poner el menu que creamos por xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menusuperior, menu);
        this.miMenu = menu;

        return true;
    }

    //Para capturar la accion del boton del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.btnMenuDesloguearse) {
            this.desloguear();
        }
        return super.onOptionsItemSelected(item);
    }

    public void desloguear() {
        this.borrarSharedPreferences();

        Pedido.limpiarMiPedido();
        this.finish();
    }

    public void borrarSharedPreferences() {
        SharedPreferences.Editor editor = this.shar.edit();

        editor.putBoolean("recordarme", false);
        editor.putString("email", "");
        editor.putString("clave", "");

        editor.commit();
    }
}
