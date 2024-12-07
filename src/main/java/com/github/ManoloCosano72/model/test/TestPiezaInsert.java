package com.github.ManoloCosano72.model.test;

import com.github.ManoloCosano72.model.dao.PiezaDAO;
import com.github.ManoloCosano72.model.entity.Cliente;
import com.github.ManoloCosano72.model.entity.Pieza;
import com.github.ManoloCosano72.model.entity.Vehiculo;

public class TestPiezaInsert {
    public static void main(String[] args) {
        PiezaDAO piezaDAO = new PiezaDAO();
        Vehiculo v = new Vehiculo(1);
        Cliente c = new Cliente();
        c.setDni("1111S");
        Pieza p = new Pieza(1,v,"Llanta","Furgoneta",3,c);
        piezaDAO.save(p);
    }
}
