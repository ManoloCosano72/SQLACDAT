package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Cliente;
import com.github.ManoloCosano72.model.entity.Pieza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final static String FINDBYPIECE = "SELECT IdPieza FROM pieza WHERE IdPieza=?";
    private final static String FINDBYDNI = "SELECT Dni FROM cliente WHERE Dni =?";

    private final static String INSERT = "INSERT INTO cliente (Dni,Nombre,Correo,Telefono,Direccion,Contrasena) VALUES (?,?,?,?,?,?)";

    //JOIN buscar el vehiculo x y que muestre ese vehiculo y las piezas de ese vehiculo --private final static String FINDBYVEHICLE = "SELECT CodigoVehiculo ";
    private final static String FINDALLPIECES = "SELECT IdPieza,CodigoVehiculo,Nombre,Tipo,Precio FROM pieza WHERE DniCliente=?";

    //JOIN buscar la pieza x por su id para que el usuario sepa el tipo de vehiculo de donde es la pieza y el nombre de esta --private final static String FINDTHEPIECE = "SELECT IdPieza,CodigoVeehiculo,Nombre,Tipo FROM pieza WHERE IdPieza=?";



    public Cliente findByDni(String dni) {
        Cliente result = new Cliente();
        if (dni != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYDNI)) {
                pst.setString(1, dni);
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    result.setDni(res.getString("Dni"));
                    result.setNombre(res.getString("Nombre"));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Cliente save(Cliente entity) {
        if (entity != null) {
            String Dni = entity.getDni();
            if (Dni != null) {
                Cliente isInDataBase = findByDni(Dni);
                if (isInDataBase != null) {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                        pst.setString(1, entity.getDni());
                        pst.setString(2, entity.getNombre());
                        pst.setString(3, entity.getCorreo());
                        pst.setString(4, entity.getTelefono());
                        pst.setString(5, entity.getDireccion());
                        pst.setString(6, entity.getContrasena());
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
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDALLPIECES)) {
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
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYPIECE)) {
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
    public static ClienteDAO build(){
        return new ClienteDAO();
    }
}
