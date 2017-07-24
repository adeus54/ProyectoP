package Modelo.l;

import Modelo.dao.DAOFactory;
import Modelo.dao.RolUsuarioDAO;
import Modelo.vo.vo.RolVO;
import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexa
 */
public class LROLUsuario {

    // create the required DAO Factory
    DAOFactory SQLFactory = DAOFactory.getDAOFactory(DAOFactory.SQLUserDAO);
    // Create a DAO
    RolUsuarioDAO RolUsDAO = SQLFactory.getUsuarioRolDAO();
    private Coordinador coordinador;

    public int insertrRoleUser(int user, int rol) throws SQLException {
        int usuario = user;
        int role = rol;

        return RolUsDAO.insertRolUser(usuario, role);
    }

    public int deleteRoleUser(int user, int rol) throws SQLException {
        int usuario = user;
        int role = rol;

        return RolUsDAO.deleteRolUser(usuario, role);
    }
    
    public ArrayList<RolVO> consultarId_AIngresar() throws ClassNotFoundException, SQLException {
        ArrayList<RolVO> lstCata = new ArrayList<>();

        ResultSet rs = RolUsDAO.consult_RolaAdjuntar("CLIENTE");

        while (rs.next()) {
            int id = rs.getInt("rol_id");
            
            RolVO objAdmin = new RolVO(id);
            lstCata.add(objAdmin);
        }

        return lstCata;
    }

    public void setCoordinador(Coordinador coordinador) {
    this.coordinador = coordinador;
    }
}
