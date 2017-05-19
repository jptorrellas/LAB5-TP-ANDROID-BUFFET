package com.example.a55.lab5_tp_android_buffet.Activities.Menu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a55.lab5_tp_android_buffet.Activities.Login.LoginActivity;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.Controller.MenuCtrl;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.Model.MenuModel;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.RecyclerView.AdapterMenu;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.View.MenuView;
import com.example.a55.lab5_tp_android_buffet.POJOS.Pedido;
import com.example.a55.lab5_tp_android_buffet.POJOS.Producto;
import com.example.a55.lab5_tp_android_buffet.R;

public class MenuActivity extends AppCompatActivity {

    Menu miMenu;
    SharedPreferences shar;

    MenuModel menuModel;
    MenuView menuView;
    MenuCtrl menuCtrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Cambia titulo a  ActionBar
        getSupportActionBar().setTitle("MENU");

        // Levanta SharedPreferences
        this.shar = PreferenceManager.getDefaultSharedPreferences(this);

        //MVC
        MenuModel menuModel = new MenuModel();
        MenuView menuView = new MenuView(this, menuModel);
        MenuCtrl menuCtrl = new MenuCtrl(menuView);

    }

   /* @Override
    protected void onStart() {
        super.onStart(+);
        //this.menuCtrl.actualizarDatos();
        Toast.makeText(this.menuView.menuActivity, "ON RESTART", Toast.LENGTH_SHORT).show();

    }*/

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
