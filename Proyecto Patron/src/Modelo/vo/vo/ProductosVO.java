package Modelo.vo.vo;

import java.io.FileInputStream;
import java.io.InputStream;


/**
 *
 * @author alexa
 */
public class ProductosVO {
    private String p_Codigo;
    private String p_nombre;
    private String p_descripcion;
    private String p_disponibilidad;
    private String p_urlImagen;
    private int cantidad;
    private int p_id;
    private double p_precio;
    private FileInputStream p_image;
    private InputStream p_imge;

    public ProductosVO(String p_Codigo, String p_nombre, String p_descripcion, double p_precio,String p_disponibilidad, int cantidad,
            String p_urlImagen, FileInputStream p_image) {
        this.p_Codigo = p_Codigo;
        this.p_nombre = p_nombre;
        this.p_descripcion = p_descripcion;
        this.p_disponibilidad = p_disponibilidad;
        this.p_urlImagen = p_urlImagen;
        this.cantidad = cantidad;
        this.p_precio = p_precio;
        this.p_image = p_image;
    }
    
    public ProductosVO(String p_Codigo, String p_nombre, String p_descripcion, double p_precio,String p_disponibilidad, int cantidad,
            String p_urlImagen, InputStream p_image) {
        
        this.p_Codigo = p_Codigo;
        this.p_nombre = p_nombre;
        this.p_descripcion = p_descripcion;
        this.p_disponibilidad = p_disponibilidad;
        this.p_urlImagen = p_urlImagen;
        this.cantidad = cantidad;
        this.p_precio = p_precio;
        this.p_imge = p_image;
    }
    
    public ProductosVO(int id,String p_Codigo, String p_nombre, String p_descripcion, double p_precio,String p_disponibilidad, int cantidad, InputStream p_image) {
        this.p_id=id;
        this.p_Codigo = p_Codigo;
        this.p_nombre = p_nombre;
        this.p_descripcion = p_descripcion;
        this.p_disponibilidad = p_disponibilidad;
        this.cantidad = cantidad;
        this.p_precio = p_precio;
        this.p_imge = p_image;
    }
    
    public ProductosVO(String p_Codigo, String p_nombre, double p_precio, InputStream p_image) { 
        this.p_Codigo = p_Codigo;
        this.p_nombre = p_nombre;
        this.p_precio = p_precio;
        this.p_imge = p_image;
    }

    public ProductosVO(String p_Codigo) {
        this.p_Codigo = p_Codigo;
    }
    
    public ProductosVO(int ide) {
        this.p_id = ide;
    }

    public ProductosVO(String cod, int cantidad) {
        this.p_Codigo = cod;
        this.cantidad = cantidad;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public InputStream getP_imge() {
        return p_imge;   
    }

    public void setP_imge(InputStream p_imge) {
        this.p_imge = p_imge;
    }
    
    
    public String getP_Codigo() {
        return p_Codigo;
    }

    public void setP_Codigo(String p_Codigo) {
        this.p_Codigo = p_Codigo;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public String getP_descripcion() {
        return p_descripcion;
    }

    public void setP_descripcion(String p_descripcion) {
        this.p_descripcion = p_descripcion;
    }

    public String getP_disponibilidad() {
        return p_disponibilidad;
    }

    public void setP_disponibilidad(String p_disponibilidad) {
        this.p_disponibilidad = p_disponibilidad;
    }

    public String getP_urlImagen() {
        return p_urlImagen;
    }

    public void setP_urlImagen(String p_urlImagen) {
        this.p_urlImagen = p_urlImagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getP_precio() {
        return p_precio;
    }

    public void setP_precio(float p_precio) {
        this.p_precio = p_precio;
    }

    public FileInputStream getP_image() {
        return p_image;
    }

    public void setP_image(FileInputStream p_image) {
        this.p_image = p_image;
    }

    
}
