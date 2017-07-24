package Modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexa
 */
public class SQLUsuarioDAO implements UsuarioDAO {


    @Override
    public ResultSet consultUser() {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT * FROM mydb.usuario");
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
     @Override
    public ResultSet consultID_User(String user) {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT us_id FROM mydb.usuario where us_login =?");
            pst.setString(1, user);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    @Override
    public ResultSet consultUsuarioIngresado(int us_ID) {
        ResultSet rs = null;
        try {
            String strSQL = "SELECT us_id FROM mydb.usuario WHERE identificacion = ?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setInt(1, us_ID);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    @Override
    public ResultSet consultUserRol() {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT* FROM mydb.usuario us, mydb.rol_usuario ru Where 1 = 1 AND us.us_id = ru.us_id ");
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    @Override
    public ResultSet consultLogin(String log, String pass) {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT us_login,us_password, rol_nombre FROM mydb.usuario us, mydb.rol r, mydb.rol_usuario ru Where us.us_login = ? AND us.us_password = ? AND us.us_id = ru.us_id AND r.rol_id = ru.rol_id");
            pst.setString(1, log);
            pst.setString(2, pass);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    @Override
    public ResultSet consultExistencia(String ident, String log) {
        ResultSet rs = null;
        try {
            String strSQL = "SELECT COUNT(*) total FROM mydb.usuario WHERE identificacion = ? AND us_login = ?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setString(1, ident);
            pst.setString(2, log);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
      
    @Override
    public int insertUser(String name, String apel, String log, String pass, int ID) {
        int retorno = 0;
        try {
            String strSQL = "INSERT INTO mydb.usuario (us_nombre, us_apellido, us_login,us_password,identificacion) " + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setString(1, name);
            pst.setString(2, apel);
            pst.setString(3, log);
            pst.setString(4, pass);
            pst.setInt(5, ID);
            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    @Override
    public int mod_User(String name, String apel, String log, String pass,int id, int ID) {
        int retorno = 0;
        try {
            String strSQL = "UPDATE mydb.usuario SET us_nombre=?,us_apellido=?,us_login=?,us_password=?,identificacion = ? WHERE us_id = ?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setString(1, name);
            pst.setString(2, apel);
            pst.setString(3, log);
            pst.setString(4, pass);
            pst.setInt(5, ID);
            pst.setInt(6, id);
            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    @Override
    public int deleteUser(int ID) {
        int retorno = 0;
        try {
            String strSQL = "DELETE FROM mydb.usuario WHERE identificacion = ?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setInt(1, ID);
            
            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

}
