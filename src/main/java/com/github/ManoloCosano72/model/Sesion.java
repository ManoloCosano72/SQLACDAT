package com.github.ManoloCosano72.model;

import com.github.ManoloCosano72.model.entity.Cliente;

public class Sesion {
    private static Sesion _instance;
    private static Cliente clienteIniciado;

    private Sesion() {

    }

    public void iniciarSesion(Cliente cliente) {
        clienteIniciado = cliente;
    }

    public static Sesion getInstancia() {
        if (_instance == null) {
            _instance = new Sesion();
            _instance.iniciarSesion(clienteIniciado);
        }
        return _instance;
    }

    public Cliente getClienteIniciado() {
        return clienteIniciado;
    }

    public static void CerrarSesion() {
        clienteIniciado = null;
    }
}
