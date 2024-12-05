package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Cliente;
import com.github.ManoloCosano72.model.entity.Pieza;
import com.github.ManoloCosano72.model.entity.Trabajador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {
    private final static String INSERT = "INSERT INTO trabajo (Id,Puesto,Tipo,Precio) VALUES (?,?,?,?)";
    private final static String FINDBYID = "SELECT Id FROM trabajador WHERE Id=?";
    private final static String FINDALLCLIENTS = "SELECT Dni,Nombre,Telefono,Direccion FROM cliente WHERE Dni=?";
    private final static String FINDALLVEHICLES = "";
    private final static String FINDALLPIECES = "SELECT IdPieza,CodigoVehiculo,Nombre,Tipo,Precio FROM pieza WHERE DniCliente=?";
    private final static String DELETE = "DELETE FROM cliente WHERE Dni=?";
    //JOIN buscar los vehiculos de su lista y todas las piezas que contenga x vehiculo
    //Añadir piezas a la lista de piezas del vehiculo

    public Trabajador findById(int id) {
        Trabajador result = new Trabajador();
        if (id != 0) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYID)) {
                pst.setInt(1, id);
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    result.setIdTrabajador(res.getInt("Id"));
                    result.setNombre(res.getString("Nombre"));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Trabajador save(Trabajador entity) {
        if (entity != null) {
            int Id = entity.getIdTrabajador();
            if (Id != 0) {
                Trabajador isInDataBase = findById(Id);
                if (isInDataBase != null) {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                        pst.setInt(1, entity.getIdTrabajador());
                        pst.setString(2,entity.getPuesto());
                        pst.setString(3, entity.getNombre());
                        pst.setString(4, entity.getCorreo());
                        pst.setString(5, entity.getContrasena());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return entity;
    }

    public List<Pieza> findAllPieces() {
        List<Pieza> piezas = new ArrayList<>();
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(-------)) {
            ResultSet res = pst.executeQuery();
            while (res.next()){
                Pieza p = new Pieza();
                p.setIdPieza(res.getInt("IdPieza"));
                /** codigo vehiculo me falta el findByCodVehiculo en el DAO
                 p.setvehiculo(VehiculoDAO.build().findByCodVehiculo(res.getString("CodigoVehiculo")));
                 **/
                p.setNombre(res.getString("Nombre"));
                p.setTipo(res.getString("Tipo"));
                p.setPrecio(res.getInt("Precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return piezas;
    }
    public Pieza findByPiece(String idPieza) {
        Pieza result = new Pieza();
        if (idPieza != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(-------)) {
                pst.setString(1, idPieza);
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    result.setIdPieza(res.getInt("IdPieza"));
                    result.setNombre(res.getString("Nombre"));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public Cliente findAllClientes(String dni) {
        Cliente result = new Cliente();
        if (dni != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALLCLIENTS)) {
                pst.setString(1, dni);
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    result.setDni(res.getString("Dni"));
                    result.setNombre(res.getString("Nombre"));
                    result.setCorreo(res.getString("Correo"));
                    result.setTelefono(res.getString("Telefono"));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public Cliente delete(Cliente entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setString(1, entity.getDni());
                pst.executeUpdate();
            }
        }
        return entity;
    }


    public static TrabajadorDAO build(){
        return new TrabajadorDAO();
    }
}
