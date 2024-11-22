package com.github.ManoloCosano72.model.entity;

import java.util.Objects;

public class Vehiculo {
    private int codigoVehiculo;
    private String marca;
    private int antiguedad;
    private String modelo;

    public Vehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public Vehiculo() {
    }

    public Vehiculo(int codigoVehiculo, String marca, int antiguedad, String modelo) {
        this.codigoVehiculo = codigoVehiculo;
        this.marca = marca;
        this.antiguedad = antiguedad;
        this.modelo = modelo;
    }

    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) object;
        return codigoVehiculo == vehiculo.codigoVehiculo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoVehiculo);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "codigoVehiculo=" + codigoVehiculo +
                ", marca='" + marca + '\'' +
                ", antiguedad=" + antiguedad +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
