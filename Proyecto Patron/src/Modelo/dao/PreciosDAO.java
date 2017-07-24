package Modelo.dao;

import java.sql.ResultSet;

/**
 *
 * @author alexa
 */
public interface PreciosDAO {
     public int Insertar_Precios(double pr, int can, double Tpre,int rs, int idpr);
     public ResultSet consultProductsSelected(int id);
}
