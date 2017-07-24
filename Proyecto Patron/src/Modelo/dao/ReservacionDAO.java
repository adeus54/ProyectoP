package Modelo.dao;

import java.sql.ResultSet;

/**
 *
 * @author alexa
 */
public interface ReservacionDAO {
     public int insertreservacion(int use);
     public ResultSet consultexistencia() ;
     
}
