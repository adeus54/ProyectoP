package Modelo.dao;

import Modelo.conexion.Conexion;


/**
 *
 * @author alexa
 */
public class SQLUsersDAOFactory extends DAOFactory{
    
    public static Conexion conect (){
        Conexion con = new Conexion();
        return con;
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new SQLUsuarioDAO();
    }

    @Override
    public RolUsuarioDAO getUsuarioRolDAO() {
        return new SQLRolUsuarioDAO();
    }
  
    @Override
    public ProductsDAO getProductDAO() {
        return new SQLProductsDAO();
    }

    @Override
    public ReservacionDAO getReservacion() {
        return new SQLReservacionP();
    }
    
    @Override
    public PreciosDAO getPreciosDAO() {
    return new SQLPrecios_P();
    }
}
