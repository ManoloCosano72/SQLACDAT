package com.github.ManoloCosano72.model.test;

import com.github.ManoloCosano72.model.dao.TrabajadorDAO;
import com.github.ManoloCosano72.model.entity.Trabajador;

public class TestTrabajadorInsert {
    public static void main(String[] args) {
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        Trabajador t = new Trabajador("Agustin","a@a.com","22222",1,"Chapista");
        trabajadorDAO.save(t);
    }

}
