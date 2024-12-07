package com.github.ManoloCosano72.model.entity;

import java.util.List;
import java.util.Objects;

public class Trabajador extends Usuario{
    private int idTrabajador;
    private String puesto;
    private List<Vehiculo> vehiculos;

    public Trabajador(String nombre, String correo, String contrasena, boolean esTrabajador) {
        super(nombre, correo, contrasena, esTrabajador);
    }

    public Trabajador(String nombre, String correo, String contrasena, boolean esTrabajador, int idTrabajador, String puesto, List<Vehiculo> vehiculos) {
        super(nombre, correo, contrasena, esTrabajador);
        this.idTrabajador = idTrabajador;
        this.puesto = puesto;
        this.vehiculos = vehiculos;
    }

    public Trabajador() {
    }
    public Trabajador(int idTrabajador){
        this.idTrabajador=idTrabajador;
    }
    public Trabajador(String nombre, String correo, String contrasena,int idTrabajador, String puesto){
        super(nombre,correo,contrasena);
        this.idTrabajador = idTrabajador;
        this.puesto = puesto;
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
                ", vehiculos=" + vehiculos +
                '}';
    }
}
