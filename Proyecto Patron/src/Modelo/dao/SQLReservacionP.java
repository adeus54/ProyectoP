
package Modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexa
 */
public class SQLReservacionP implements ReservacionDAO {

    @Override
    public int insertreservacion(int use) {
        int retorno = 0;
        try {
            String strSQL = "INSERT INTO myinvtdb.reservaciones (us_id) " + "VALUES (?)";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setInt(1, use);
            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }
    
    @Override
    public ResultSet consultexistencia() {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(
                    "SELECT MAX(idreservaciones) AS id FROM myinvtdb.reservaciones ");
          
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    
}
