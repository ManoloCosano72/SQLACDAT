package com.github.ManoloCosano72.model.dao;

import com.github.ManoloCosano72.model.connection.ConnectionMariaDB;
import com.github.ManoloCosano72.model.entity.Vehiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculoDAO {
    private final static String DELETE = "DELETE FROM vehiculo WHERE CodigoVehiculo =?";
    private final static String FINDBYVEHICULO = "SELECT CodigoVehiculo,Marca,Antiguedad,Modelo FROM vehiculo WHERE CodigoVehiculo=?";
    private final static String FINDALLPIECES = "SELECT ";
    private final static String UPDATE = "UPDATE vehiculo SET Marca=?, Antiguedad=?,Modelo=?";
    private final static String INSERT = "INSERT INTO vehiculo (CodigoVehiculo,Marca,Antiguedad,Modelo) VALUES (?,?,?,?)";
    private final static String FINDBYMODELO = "";
    private final static String FINDPIECESBYMODELO = "";

    public Vehiculo save(Vehiculo entity) {
        if (entity != null) {
            int CodigoVehiculo = entity.getCodigoVehiculo();
            if (CodigoVehiculo != 0) {
                Vehiculo isInDataBase = findByCodVehiculo(CodigoVehiculo);
                if (isInDataBase != null) {
                    try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(INSERT)) {
                        pst.setInt(1, entity.getCodigoVehiculo());
                        pst.setString(2, entity.getMarca());
                        pst.setInt(3, entity.getAntiguedad());
                        pst.setString(4, entity.getModelo());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return entity;
    }

    public Vehiculo delete(Vehiculo entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(DELETE)) {
                pst.setInt(1, entity.getCodigoVehiculo());
                pst.executeUpdate();
            }
        }
        return entity;
    }
    public Vehiculo update(Vehiculo entity) {
        Vehiculo result = entity;
        try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(UPDATE)) {
            pst.setString(1, entity.getMarca());
            pst.setInt(2, entity.getAntiguedad());
            pst.setString(3, entity.getModelo());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Vehiculo findByCodVehiculo(int codVehiculo){
        Vehiculo result = new Vehiculo();
        if (codVehiculo != 0) {
            try (PreparedStatement pst = ConnectionMariaDB.getConnection().prepareStatement(FINDBYVEHICULO)) {
                pst.setInt(1, codVehiculo);
                ResultSet res = pst.executeQuery();
                if (res.next()) {
                    result.setCodigoVehiculo(res.getInt("CodigoVehiculo"));
                }
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static VehiculoDAO build(){
        return new VehiculoDAO();
    }
}
