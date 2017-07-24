package Modelo.dao;

import java.sql.ResultSet;

/**
 *
 * @author alexa
 */
public interface RolUsuarioDAO {
    public int insertRolUser(int use, int rol);
    public int deleteRolUser(int use, int rol);
    public ResultSet consultItem_Rol(int id);
    public ResultSet consult_RolaAdjuntar(String rolname);
}
