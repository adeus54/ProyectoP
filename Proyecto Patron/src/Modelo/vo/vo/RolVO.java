package Modelo.vo.vo;

/**
 *
 * @author alexa
 */
public class RolVO {

    private String nombre;
    private String descripcion;
    private int ide;

    public RolVO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public RolVO(String nombre) {
        this.nombre = nombre;
    }

    public RolVO(int ide, String nombre, String descripcion) {
        this.ide = ide;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public RolVO(int id) {
        this.ide = id;
    }

    public int getIde() {
        return ide;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
