/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import restful.Model.DueniaModel;
import restful.Model.Conexion;

/**
 *
 * @author Mario Andres
 */
public class DueniaService {
    
    public ArrayList<DueniaModel> getDuenia() {
        ArrayList<DueniaModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM duenia";
        
        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                DueniaModel duenia = new DueniaModel();
                duenia.setCodigo_due(rs.getInt("codigo_due"));
                duenia.setNombre_due(rs.getString("nombre_due"));
                duenia.setCedula_due(rs.getString("cedula_due"));
                duenia.setTelefono_due(rs.getString("telefono_due"));
                duenia.setDireccion_due(rs.getString("direccion_due"));
                duenia.setCorreo_due(rs.getString("correo_due"));
                lista.add(duenia);
            }
        } catch (SQLException e) {
        }
        return lista;
    }
        

    public DueniaModel getDuenia(int codigo_due) {
        DueniaModel duenia = new DueniaModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM duenia WHERE codigo_due = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, codigo_due);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                duenia.setCodigo_due(rs.getInt("codigo_due"));
                duenia.setNombre_due(rs.getString("nombre_due"));
                duenia.setCedula_due(rs.getString("cedula_due"));
                duenia.setTelefono_due(rs.getString("telefono_due"));
                duenia.setDireccion_due(rs.getString("direccion_due"));
                duenia.setCorreo_due(rs.getString("correo_due"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return duenia;
    }
    
    
    public DueniaModel addDuenia(DueniaModel duenia) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO duenia(codigo_due,nombre_due,cedula_due,telefono_due,direccion_due,correo_due)";
        Sql = Sql + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, duenia.getCodigo_due());
            pstm.setString(2, duenia.getNombre_due());
            pstm.setString(3, duenia.getCedula_due());
            pstm.setString(4, duenia.getTelefono_due());
            pstm.setString(5, duenia.getDireccion_due());
            pstm.setString(6, duenia.getCorreo_due());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return duenia;
    }


    
    public DueniaModel updateDuenia(DueniaModel duenia) {
        Conexion conn = new Conexion();
        String sql = "UPDATE duenia SET nombre_due=?,cedula_due=?,telefono_due=?,direccion_due=?,correo_due=? WHERE codigo_due= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);            
            pstm.setString(1, duenia.getNombre_due());
            pstm.setString(2, duenia.getCedula_due());
            pstm.setString(3, duenia.getTelefono_due());
            pstm.setString(4, duenia.getDireccion_due());
            pstm.setString(5, duenia.getCorreo_due());
            pstm.setInt(6, duenia.getCodigo_due());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return duenia;
    }

    
    public String delDuenia(int codigo_due) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM duenia WHERE codigo_due= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, codigo_due);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Acción\":\"Se ha borrado el registro\"}";
    }
    
    
    
    
    
    
    
    
    
}
