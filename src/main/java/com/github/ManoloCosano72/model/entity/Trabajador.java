package com.github.ManoloCosano72.model.entity;

import java.util.List;
import java.util.Objects;

public class Trabajador {
    protected int idTrabajador;
    protected String puesto;
    protected String nombre;

    private List<Vehiculo> vehiculos;

    public Trabajador(int idTrabajador, String puesto, String nombre) {
        this.idTrabajador = idTrabajador;
        this.puesto = puesto;
        this.nombre = nombre;
        this.vehiculos = null;
    }

    public Trabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Trabajador() {
        this(-1, "", "");
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Trabajador that = (Trabajador) object;
        return idTrabajador == that.idTrabajador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrabajador);
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "idTrabajador=" + idTrabajador +
                ", puesto='" + puesto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
