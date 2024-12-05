package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Pieza;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PiezaDAO {
    private final static String DELETE = "DELETE FROM pieza WHERE IdPieza=?";
    private final static String INSERT = "INSERT INTO pieza (IdPieza,Nombre,Tipo,Precio) VALUES (?,?,?,?)";
    private final static String UPDATE = "UPDATE pieza SET Nombre=?, Tipo=?, Precio=? WHERE IdPieza=?";
    //JOIN buscar el vehiculo al que pertenece la pieza --private final static String FINDFROMVEHICLE ="";
    private final static String FINDBYID = "SELECT IdPieza FROM pieza WHERE IdPieza=?";



    public Pieza delete(Pieza entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setInt(1, entity.getIdPieza());
                pst.executeUpdate();
            }
        }
        return entity;
    }
    public Pieza findById(int idPieza) {
        Pieza result = new Pieza();
        if (idPieza != 0) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYID)) {
                pst.setInt(1, idPieza);
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
    public Pieza save(Pieza entity) {
        if (entity != null) {
            int IdPieza = entity.getIdPieza();
            if (IdPieza != 0) {
                Pieza isInDataBase = findById(IdPieza);
                if (isInDataBase != null) {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                        pst.setInt(1, entity.getIdPieza());
                        pst.setString(2, entity.getNombre());
                        pst.setString(3, entity.getTipo());
                        pst.setInt(4, entity.getPrecio());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return entity;
    }
    public Pieza update(Pieza entity) {
        Pieza result = entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
            pst.setString(1, entity.getNombre());
            pst.setString(2, entity.getTipo());
            pst.setInt(3, entity.getPrecio());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static PiezaDAO build() {
        return new PiezaDAO();
    }

}
