package Modelo.dao;

import java.sql.ResultSet;

/**
 *
 * @author alexa
 */
public interface UsuarioDAO {
    
    public ResultSet consultUser();
    public ResultSet consultUserRol();
    public ResultSet consultID_User(String user);
    public ResultSet consultUsuarioIngresado(int ident);
    public ResultSet consultLogin(String log, String pass);
    public ResultSet consultExistencia(String ident, String log );
    public int insertUser(String name, String apel, String log, String pass, int ID);
    public int mod_User(String name, String apel, String log, String pass,int id, int ID);
    public int deleteUser(int ID);
}
