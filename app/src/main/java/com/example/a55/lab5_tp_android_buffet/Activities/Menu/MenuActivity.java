package com.example.a55.lab5_tp_android_buffet.Activities.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.a55.lab5_tp_android_buffet.Activities.Menu.Controller.MenuCtrl;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.Model.MenuModel;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.RecyclerView.AdapterMenu;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.View.MenuView;
import com.example.a55.lab5_tp_android_buffet.POJOS.Pedido;
import com.example.a55.lab5_tp_android_buffet.POJOS.Producto;
import com.example.a55.lab5_tp_android_buffet.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Cambia titulo a  ActionBar
        getSupportActionBar().setTitle("MENU");

        //MVC
        MenuModel menuModel = new MenuModel();
        MenuView menuView = new MenuView(this, menuModel);
        MenuCtrl menuCtrl = new MenuCtrl(menuView);

        Log.d("PEDIDO", "" + Pedido.cantidadItemsPedido.toString() + Pedido.precioTotalPedido.toString());

    }
}
