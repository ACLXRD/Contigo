/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usa.modelo.dto.Institucion;
import java.sql.*;
import org.json.JSONObject;
/**
 *
 * @author santi
 */
public class InstitucionDao implements IDao<Institucion> {

    PreparedStatement pat;
    Statement stmt; 	            
    ResultSet result;
    
    @Override
    public boolean crear(Institucion t) {
        /*
        try {
            String sql = "insert into  institucion (Direccion_idDireccion,nombre) values (?,?)";
            Connection conn = Conexion.tomarConexion();
            pat = conn.prepareStatement(sql);
            //pat.setInt(1, proveedor.getDireccion().getIdDireccion());
            //pat.setString(2, proveedor.getNombre());
            boolean insert = pat.execute();
            pat.close();
            return insert;
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        return false;
    }

    @Override
    public Institucion consultar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Institucion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Institucion> listarTodos() {
        LinkedList<Institucion> instituciones = new LinkedList<Institucion>();
        //pat sirve como el cur() de py 
        try {
            String sql = "select * from institucion";
            Connection conn = Conexion.tomarConexion();
            pat = conn.prepareStatement(sql);
            result = pat.executeQuery();
            while(result.next()){
                Institucion ins = new Institucion();
                ins.setIdMunicipio(result.getInt("MUNICIPIO_id"));
                //int meto_pago = result.getInt("METODO_PAGO_id");//falta en el fornt 
                ins.setNombre(result.getString("nombre"));
                ins.setCorreo(result.getString("correo"));
                ins.setDireccion(result.getString("direccion"));
                ins.setTipoInstitucion(result.getBoolean("tipoInstitucion"));
                //boolean calen = result.getBoolean("calendario"); //falta en front
                ins.setBarrio(result.getString("barrio"));
                ins.setTelefono(result.getString("telefono"));
                ins.setContraseña(result.getString("contraseña"));
                ins.setPagina(result.getString("web"));
                instituciones.add(ins);
            }
            return instituciones;
        } catch (SQLException ex) {
            Logger.getLogger(InstitucionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instituciones;
    }

}
