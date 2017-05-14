package com.example.a55.lab5_tp_android_buffet.POJOS;

import java.util.List;

/**
 * Created by A55 on 14/05/2017.
 */

public class Usuario {

    /*
    * Atributos
    */
    public String nombre;
    public String apellido;
    public Integer dni;
    public String email;
    public String clave;

    public static List<Usuario> listaUsuarios;

    /*
    * Constructor
    */
    public Usuario(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public Usuario(String nombre, String apellido, Integer dni, String email, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.clave = clave;
    }

    /*
    * Funciones
    */
    public static boolean validarUsuario(Usuario usuario) {

        for ( Usuario u : Usuario.listaUsuarios) {
            if (usuario.email.equals(u.email) && usuario.clave.equals(u.clave)) {
                return true;
            }
        }
        return false;
    }

    public static boolean registrarUsuario(Usuario usuario) {

        if (Usuario.validarUsuario(usuario)) {
            return false;
        }
        else {
            Usuario.listaUsuarios.add(usuario);
            return true;
        }
    }

}
