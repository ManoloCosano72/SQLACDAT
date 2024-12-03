package com.github.ManoloCosano72.model.entity;

import java.util.List;
import java.util.Objects;

public class Cliente extends Usuario {
    private String dni;
    private String telefono;
    private String direccion;
    private List<Pieza> piezas;

    public Cliente(String nombre, String correo, String contrasena, boolean esTrabajador) {
        super(nombre, correo, contrasena, esTrabajador);
    }

    public Cliente(String nombre, String correo, String contrasena, boolean esTrabajador, String dni) {
        super(nombre, correo, contrasena, esTrabajador);
        this.dni = dni;
    }

    public Cliente() {
    }
    public Cliente(String dni, String nombre,String correo,String telefono,String direccion,String contrasena){
        this.dni= dni;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Pieza> piezas) {
        this.piezas = piezas;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", piezas=" + piezas +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", esTrabajador=" + esTrabajador +
                '}';
    }
}
