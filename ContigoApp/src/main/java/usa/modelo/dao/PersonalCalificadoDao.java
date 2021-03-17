/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usa.modelo.dto.PersonalCalificado;
import usa.utils.Utils;

/**
 * Clase de acceso a datos del personal calificado
 * @author Valeria Bermúdez y Santiago Pérez
 * @version 1.0.0
 * @since 2021-03-16
 */
public class PersonalCalificadoDao implements IPersonalCalificadoDao {

    @Override
    public boolean crear(PersonalCalificado personal) {
        try {
            String sql = "call insertarPersonalCalificado(?,?,?,?,?,?,?,?,?)";
            Connection conn = Conexion.tomarConexion();
            CallableStatement call = conn.prepareCall(sql);
            call.setString("_documento", personal.getDocumento());
            call.setInt("_TIPO_DOCUMENTO_ID", personal.getTipoDocumento());
            call.setString("_primerNombre", personal.getPrimerNombre());
            call.setString("_segundoNombre", personal.getSegundoNombre());
            call.setString("_primerApellido", personal.getPrimerApellido());
            call.setString("_segundoApellido", personal.getSegundoApellido());
            call.setString("_token", Utils.generateNewToken());
            call.setString("_fechaNacimiento", personal.getFechaDeNacimiento());
            call.setString("_genero",personal.getGenero());
            call.setString("correo", personal.getCorreo());
            call.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonalCalificadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public PersonalCalificado consultar(String id) {
        return new PersonalCalificado();
    }

    @Override
    public boolean actualizar(PersonalCalificado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<PersonalCalificado> listarTodos() {
        LinkedList<PersonalCalificado> personales = new LinkedList();;
        Connection conn = Conexion.tomarConexion();
        String sql = "select p.*,pc.* from Persona as p inner join Personal as pc on pc.PERSONA_documento=p.documento;";
        try {
            PreparedStatement pat = conn.prepareStatement(sql);
            ResultSet rs = pat.executeQuery();
             
            while (rs.next()) {
                PersonalCalificado personalCalificado = new PersonalCalificado();
                personalCalificado.setDocumento(rs.getString("documento"));
                personalCalificado.setPrimerNombre(rs.getString("primerNombre"));
                personalCalificado.setSegundoNombre(rs.getString("segundoNombre"));
                personalCalificado.setPrimerApellido(rs.getString("primerApellido"));
                personalCalificado.setSegundoApellido(rs.getString("segundoApellido"));
                personalCalificado.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toString());
                personalCalificado.setGenero(rs.getString("genero"));
                personalCalificado.setCorreo(rs.getString("correo"));
                personalCalificado.setToken(rs.getString("token"));
                personales.add(personalCalificado);
            }
            rs.close();
            pat.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonalCalificadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personales;
    }

    @Override
    public PersonalCalificado consultarPorToken(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
