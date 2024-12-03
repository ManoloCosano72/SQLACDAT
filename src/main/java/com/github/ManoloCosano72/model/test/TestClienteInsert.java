package com.github.ManoloCosano72.model.test;

import com.github.ManoloCosano72.model.dao.ClienteDAO;
import com.github.ManoloCosano72.model.entity.Cliente;

public class TestClienteInsert {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente c = new Cliente("1111S","JJ","j@j.com","33333333","Juan","1111");
        clienteDAO.save(c);
    }
}
