package com.github.ManoloCosano72.model.test;

import com.github.ManoloCosano72.model.dao.VehiculoDAO;
import com.github.ManoloCosano72.model.entity.Trabajador;
import com.github.ManoloCosano72.model.entity.Vehiculo;

public class TestVehiculoInsert {
    public static void main(String[] args) {
        VehiculoDAO vehiculoDAO = new VehiculoDAO();
        Trabajador t = new Trabajador();
        t.setIdTrabajador(1);
        Vehiculo v = new Vehiculo(1,"Seat",1997,"Toledo",t);
        vehiculoDAO.save(v);
    }


}
