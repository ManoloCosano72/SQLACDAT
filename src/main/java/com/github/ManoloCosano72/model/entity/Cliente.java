package com.github.ManoloCosano72.model.entity;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class Cliente extends Usuario{
    protected String dni;
    protected String telefono;
    protected String direccion;
    protected List<Pieza> piezas;

    public Cliente(String nombre, String correo, String contrasena, boolean esTrabajador) {
        super(nombre, correo, contrasena, esTrabajador);
    }

    public Cliente(String nombre, String correo, String contrasena, boolean esTrabajador, String dni) {
        super(nombre, correo, contrasena, esTrabajador);
        this.dni = dni;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cliente cliente = (Cliente) object;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }


}
