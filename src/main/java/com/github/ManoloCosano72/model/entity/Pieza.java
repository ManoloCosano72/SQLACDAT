package com.github.ManoloCosano72.model.entity;

import java.util.Objects;

public class Pieza {
    protected int idPieza;
    protected String nombre;
    protected String tipo;
    protected int precio;

    public Pieza(int idPieza, String nombre, String tipo, int precio) {
        this.idPieza = idPieza;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Pieza() {
    }

    public Pieza(int idPieza, String nombre) {
        this.idPieza = idPieza;
        this.nombre = nombre;
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
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
