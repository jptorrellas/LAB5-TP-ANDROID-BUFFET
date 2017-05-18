package com.example.a55.lab5_tp_android_buffet.Activities.MiPedido.Controller;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import com.example.a55.lab5_tp_android_buffet.Activities.Menu.Listeners.MenuListener;
import com.example.a55.lab5_tp_android_buffet.Activities.Menu.View.MenuView;
import com.example.a55.lab5_tp_android_buffet.Activities.MiPedido.Interfaces.IMiPedido;
import com.example.a55.lab5_tp_android_buffet.Activities.MiPedido.Listeners.MiPedidoListener;
import com.example.a55.lab5_tp_android_buffet.Activities.MiPedido.View.MiPedidoView;
import com.example.a55.lab5_tp_android_buffet.POJOS.Pedido;
import com.example.a55.lab5_tp_android_buffet.R;

/**
 * Created by A55 on 18/05/2017.
 */

public class MiPedidoCtrl implements IMiPedido {
    /**
     * Atributos
     */

    public MiPedidoView miPedidoView;
    public MiPedidoListener miPedidoListener;

    SharedPreferences shar;

    /**
     * Constructor
     */
    public MiPedidoCtrl(MiPedidoView miPedidoView) {

        this.miPedidoView = miPedidoView;
        this.miPedidoListener = new MiPedidoListener(this);

        this.miPedidoView.btnConfirmarPedido.setOnClickListener(miPedidoListener);

        // Levanta SharedPreferences
        this.shar = PreferenceManager.getDefaultSharedPreferences(this.miPedidoView.miPedidoActivity);

    }

    @Override
    public void operar(View v) {

        switch (v.getId()) {

            case R.id.btnConfirmarPedido:

                this.confirmarPedido();
                break;

            default:
                Toast.makeText(this.miPedidoView.miPedidoActivity, "SWITCH DEFAULT", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void confirmarPedido() {

        Toast.makeText(this.miPedidoView.miPedidoActivity, "PEDIDO REALIZADO!!!", Toast.LENGTH_SHORT).show();

        Pedido.limpiarMiPedido();
        this.miPedidoView.miPedidoActivity.finish();
    }
}
