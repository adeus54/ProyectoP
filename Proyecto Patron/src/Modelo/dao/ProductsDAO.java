package Modelo.dao;

import java.io.FileInputStream;
import java.sql.ResultSet;

/**
 *
 * @author alexa
 */
public interface ProductsDAO {
    public ResultSet consultProducts();
    public ResultSet consultProductsUP(String CO);
    public int ActualizarCantProducts(String code, int cant);
    public ResultSet consultProductsPorNam(String nam) ;
    public ResultSet consultExistencia(String code);
    public ResultSet consultProductsSelected(int id) ;
    public int insertProduct(String code, String name, String descrip, double precio,String dispon, int cant,
            String url, FileInputStream image);
    public int ModificarProducts(String code, String name, String descrip, double precio, String dispon, 
            int cant, String url, FileInputStream image);
    public int deleteProduct(String code);
}
