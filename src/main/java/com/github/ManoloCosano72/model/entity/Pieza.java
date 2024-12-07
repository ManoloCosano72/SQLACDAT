package com.github.ManoloCosano72.model.entity;

import java.util.Objects;

public class Pieza {
    private int idPieza;
    private Vehiculo vehiculo;
    private String nombre;
    private String tipo;
    private int precio;
    private Cliente cliente;

    public Pieza(int idPieza, Vehiculo vehiculo, String nombre, String tipo, int precio, Cliente cliente) {
        this.idPieza = idPieza;
        this.vehiculo = vehiculo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cliente = cliente;
    }

    public Pieza() {
    }

    public Pieza(int idPieza, String nombre) {
        this.idPieza = idPieza;
        this.nombre = nombre;
    }
    public Pieza(int idPieza,String nombre,String tipo, int precio){
        this.idPieza = idPieza;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public String getNombre() {
        return nombre;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Pieza pieza = (Pieza) object;
        return idPieza == pieza.idPieza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPieza);
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "idPieza=" + idPieza +
                ", vehiculo=" + vehiculo +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", cliente=" + cliente +
                '}';
    }
}
