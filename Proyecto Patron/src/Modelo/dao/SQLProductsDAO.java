package Modelo.dao;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexa
 */
public class SQLProductsDAO implements ProductsDAO {

    @Override
    public ResultSet consultProducts() {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT * FROM myinvtdb.productos");
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    @Override
    public ResultSet consultProductsUP(String CO) {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT p_cantidad FROM myinvtdb.productos WHERE p_Codigo=?");
            pst.setString(1, CO);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    @Override
    public ResultSet consultProductsSelected(int id) {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT * FROM myinvtdb.reservaciones r, myinvtdb.precios s , myinvtdb.productos p \n"
                    + "WHERE 1=1 \n"
                    + "AND s.idproducto = p.idProductos\n"
                    + "AND s.idreservacion = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    @Override
    public ResultSet consultProductsPorNam(String nam) {
        ResultSet rs = null;
        try {
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement("SELECT * FROM myinvtdb.productos WHERE p_nombre = ?");
            pst.setString(1, nam);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    @Override
    public ResultSet consultExistencia(String code) {
        ResultSet rs = null;
        try {
            String strSQL = "SELECT COUNT(*) total FROM myinvtdb.productos WHERE p_Codigo = ?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setString(1, code);
            rs = pst.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    @Override
    public int insertProduct(String code, String name, String descrip, double precio, String dispon, int cant, String url, FileInputStream image) {
        int retorno = 0;
        try {
            String strSQL = "INSERT INTO myinvtdb.productos (p_Codigo, p_nombre, p_descripcion,p_precio,p_disponibilidad, p_cantidad, p_urlImagen, p_img) " + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setString(1, code);
            pst.setString(2, name);
            pst.setString(3, descrip);
            pst.setDouble(4, precio);
            pst.setString(5, dispon);
            pst.setInt(6, cant);
            pst.setString(7, url);
            pst.setBinaryStream(8, image);
            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    @Override
    public int ModificarProducts(String code, String name, String descrip, double precio, String dispon, int cant, String url, FileInputStream image) {
        int retorno = 0;
        try {
            String strSQL = "UPDATE myinvtdb.productos SET p_nombre =?, p_descripcion=?,p_precio=?,p_disponibilidad=?, p_cantidad=?, p_urlImagen=?, p_img=? WHERE p_Codigo =?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setString(1, name);
            pst.setString(2, descrip);
            pst.setDouble(3, precio);
            pst.setString(4, dispon);
            pst.setInt(5, cant);
            pst.setString(6, url);
            pst.setBinaryStream(7, image);
            pst.setString(8, code);
            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    @Override
    public int ActualizarCantProducts(String code, int cant) {
        int retorno = 0;
        try {
            String strSQL = "UPDATE myinvtdb.productos SET  p_cantidad = ? WHERE p_Codigo = ?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setInt(1, cant);
            pst.setString(2, code);
            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    @Override
    public int deleteProduct(String code) {
        int retorno = 0;
        try {
            String strSQL = "DELETE FROM myinvtdb.productos WHERE p_Codigo = ?";
            PreparedStatement pst = SQLUsersDAOFactory.conect().abrirConexion().prepareStatement(strSQL);
            pst.setString(1, code);

            retorno = pst.executeUpdate();
            pst.close();
            SQLUsersDAOFactory.conect().cerrarConexion();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return retorno;
    }

}
