package Modelo.l;


import Modelo.dao.DAOFactory;
import Modelo.dao.ReservacionDAO;
import Modelo.vo.vo.ReservacionVO;
import controlador.Coordinador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexa
 */
public class LReservacion {
    
     DAOFactory SQLProFactory = DAOFactory.getDAOFactory(DAOFactory.SQLProduct_DAO);
    // Create a DAO
    ReservacionDAO ReserDAO = SQLProFactory.getReservacion();
    private Coordinador coordinador;
    
    public int Insertar_Reservacion(int user) throws SQLException {
        int usuario = user;
           
        return ReserDAO.insertreservacion(usuario);      
    }
    
    public ArrayList<ReservacionVO> consultarId_AIngresar() throws ClassNotFoundException, SQLException {
        ArrayList<ReservacionVO> lstCata = new ArrayList<>();

        ResultSet rs = ReserDAO.consultexistencia();

        while (rs.next()) {
            int id = rs.getInt("id");
            
            ReservacionVO objAdmin = new ReservacionVO(id);
            lstCata.add(objAdmin);
        }

        return lstCata;
    }

    public void setCoordinador(Coordinador coordinador) {
    this.coordinador = coordinador;
    }
}
