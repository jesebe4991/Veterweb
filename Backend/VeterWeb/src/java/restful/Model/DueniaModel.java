/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Mario Andres
 */
@XmlRootElement
public class DueniaModel {
    private int codigo_due;
    private String nombre_due;
    private String cedula_due;
    private String telefono_due;
    private String direccion_due;
    private String correo_due;

    public DueniaModel() {
    }

    public DueniaModel(int codigo_due, String nombre_due, String cedula_due, String telefono_due, String direccion_due, String correo_due) {
        this.codigo_due = codigo_due;
        this.nombre_due = nombre_due;
        this.cedula_due = cedula_due;
        this.telefono_due = telefono_due;
        this.direccion_due = direccion_due;
        this.correo_due = correo_due;  
    }

    public int getCodigo_due() {
        return codigo_due;
    }

    public void setCodigo_due(int codigo_due) {
        this.codigo_due = codigo_due;
    }

    public String getNombre_due() {
        return nombre_due;
    }

    public void setNombre_due(String nombre_due) {
        this.nombre_due = nombre_due;
    }

    public String getCedula_due() {
        return cedula_due;
    }

    public void setCedula_due(String cedula_due) {
        this.cedula_due = cedula_due;
    }

    public String getTelefono_due() {
        return telefono_due;
    }

    public void setTelefono_due(String telefono_due) {
        this.telefono_due = telefono_due;
    }

    public String getDireccion_due() {
        return direccion_due;
    }

    public void setDireccion_due(String direccion_due) {
        this.direccion_due = direccion_due;
    }

    public String getCorreo_due() {
        return correo_due;
    }

    public void setCorreo_due(String correo_due) {
        this.correo_due = correo_due;
    }

 
    
}
