package Modelo.dao;

/**
 *
 * @author alexa
 */
public abstract class DAOFactory {

    // List of DAO types supported by the factory
    public static final int SQLUserDAO = 1;
    public static final int SQLProduct_DAO = 2;

    public abstract UsuarioDAO getUsuarioDAO();

    public abstract RolUsuarioDAO getUsuarioRolDAO();

    public abstract ProductsDAO getProductDAO();
    
    public abstract ReservacionDAO getReservacion();
    
    public abstract PreciosDAO getPreciosDAO();

    public static DAOFactory getDAOFactory(int factory) {

        switch (factory) {
            case SQLUserDAO:
                return new SQLUsersDAOFactory();
            case SQLProduct_DAO:
                return new SQLProductsDAOFactory();
            default:
                return null;
        }
    }

}
