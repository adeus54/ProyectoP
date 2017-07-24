package Modelo.l;

import Modelo.dao.DAOFactory;
import Modelo.dao.ProductsDAO;
import Modelo.vo.vo.ProductosVO;
import controlador.Coordinador;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexa
 */
public class LInventarioProduct {

    // create the required DAO Factory
    DAOFactory SQLProFactory = DAOFactory.getDAOFactory(DAOFactory.SQLProduct_DAO);
    // Create a DAO
    ProductsDAO ProductDAO = SQLProFactory.getProductDAO();
    private Coordinador coordinador;

    public ArrayList<ProductosVO> ConsultarProducts() throws ClassNotFoundException, SQLException, IOException {
        ArrayList<ProductosVO> lstCata = new ArrayList<>();

        ResultSet rs = ProductDAO.consultProducts();

        while (rs.next()) {

            String code = rs.getString("p_Codigo");
            String nomb = rs.getString("p_nombre");
            String descrip = rs.getString("p_descripcion");
            double precio = rs.getDouble("p_precio");
            String dispon = rs.getString("p_disponibilidad");
            int cantidad = rs.getInt("p_cantidad");
            String url = rs.getString("p_urlImagen");
            InputStream foto = rs.getBinaryStream("p_img");

            ProductosVO objAdmin = new ProductosVO(code, nomb, descrip, precio, dispon, cantidad, url, foto);
            lstCata.add(objAdmin);
        }

        return lstCata;
    }

    public ArrayList<ProductosVO> ConsultarProductsReservados(int id) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<ProductosVO> lstCata = new ArrayList<>();

        ResultSet rs = ProductDAO.consultProductsSelected(id);

        while (rs.next()) {

            String code = rs.getString("p_Codigo");
            String nomb = rs.getString("p_nombre");

            double precio = rs.getDouble("p_precio");
            InputStream foto = rs.getBinaryStream("p_img");

            ProductosVO objAdmin = new ProductosVO(code, nomb, precio, foto);
            lstCata.add(objAdmin);
        }

        return lstCata;
    }

    public ArrayList<ProductosVO> ConsultProductsPorNm(String nm) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<ProductosVO> lstCata = new ArrayList<>();

        ResultSet rs = ProductDAO.consultProductsPorNam(nm);

        while (rs.next()) {
            int id = rs.getInt("idProductos");
            String code = rs.getString("p_Codigo");
            String nomb = rs.getString("p_nombre");
            String descrip = rs.getString("p_descripcion");
            double precio = rs.getDouble("p_precio");
            String dispon = rs.getString("p_disponibilidad");
            int cantidad = rs.getInt("p_cantidad");

            InputStream foto = rs.getBinaryStream("p_img");

            ProductosVO objAdmin = new ProductosVO(id, code, nomb, descrip, precio, dispon, cantidad, foto);
            lstCata.add(objAdmin);
        }

        return lstCata;
    }

    public int insertProductsObjeto(ProductosVO objAdmin) throws SQLException, ClassNotFoundException {
        String code = objAdmin.getP_Codigo();
        String nombre = objAdmin.getP_nombre();
        String descrip = objAdmin.getP_descripcion();
        double precio = objAdmin.getP_precio();
        String dispo = objAdmin.getP_disponibilidad();
        String url_img = objAdmin.getP_urlImagen();
        int cantidad = objAdmin.getCantidad();
        FileInputStream foto = objAdmin.getP_image();

        int a;
        ResultSet rs = ProductDAO.consultExistencia(code);
        int Ide = 0;
        while (rs.next()) {
            Ide = rs.getInt("total");
        }
        //Validacion
        if (Ide > 0) {
            a = 100;
        } else {
            return ProductDAO.insertProduct(code, nombre, descrip, precio, dispo, cantidad, url_img, foto);
        }
        return a;
    }

    public int ModificarProducts(ProductosVO objAdmin) throws SQLException, ClassNotFoundException {
        String code = objAdmin.getP_Codigo();
        String nombre = objAdmin.getP_nombre();
        String descrip = objAdmin.getP_descripcion();
        double precio = objAdmin.getP_precio();
        String dispo = objAdmin.getP_disponibilidad();
        String url_img = objAdmin.getP_urlImagen();
        int cantidad = objAdmin.getCantidad();
        FileInputStream foto = objAdmin.getP_image();

        return ProductDAO.ModificarProducts(code, nombre, descrip, precio, dispo, cantidad, url_img, foto);
    }

    public int ActualizarProductos(ProductosVO objAdmin) throws SQLException, ClassNotFoundException, IOException {
        String code = objAdmin.getP_Codigo();
        int cantidad = objAdmin.getCantidad();
        int Original = consultarProductUp(code);
        int Nuevo = Original - cantidad;
        System.out.println(code);
        System.out.println(cantidad);
        System.out.println(Original);
        System.out.println(Nuevo);
        return ProductDAO.ActualizarCantProducts(code, Nuevo);
    }

    public int consultarProductUp(String CO) throws SQLException {
        ResultSet rs = ProductDAO.consultProducts();
        int cant = 0;
        while (rs.next()) {
            cant = rs.getInt("p_cantidad");                     
        }
        return cant;
    }

    public int DeleteProducto(ProductosVO objAdmin) throws SQLException {
        String codigo = objAdmin.getP_Codigo();

        return ProductDAO.deleteProduct(codigo);

    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}
