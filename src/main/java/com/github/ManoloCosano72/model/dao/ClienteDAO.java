package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionSQL;
import com.github.ManoloCosano72.model.entity.Cliente;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO{
    private final static String FINDBYDNI = "SELECT dni FROM Cliente WHERE dni =?";
    private final static String DELETE = "DELETE FROM Cliente WHERE dni=?";
    private final static String INSERT = "INSERT INTO Cliente (dni,nombre,correo,telefono,direccion,contrasena,esTrabajador) VALUES (?,?,?,?,?,?,?)";


    public Cliente delete(Cliente entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = ConnectionSQL.getConnection().prepareStatement(DELETE)) {
                pst.setString(1, entity.getDni());
                pst.executeUpdate();
            }
        }
        return entity;
    }

    public Cliente findByDni(String dni) {

    }

    public Cliente save(Cliente entity) {

    }
}
