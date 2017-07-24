package Modelo.vo.vo;

/**
 *
 * @author alexa
 */
public class PreciosVO {
   private double precioU;
   private int rsv_cantidad;
   private double saldo;
   private int idreservacion;
   private int idproducto;

    public PreciosVO(double precioU, int rsv_cantidad, double saldo, int idreservacion, int idproducto) {
        this.precioU = precioU;
        this.rsv_cantidad = rsv_cantidad;
        this.saldo = saldo;
        this.idreservacion = idreservacion;
        this.idproducto = idproducto;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

    public int getRsv_cantidad() {
        return rsv_cantidad;
    }

    public void setRsv_cantidad(int rsv_cantidad) {
        this.rsv_cantidad = rsv_cantidad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(int idreservacion) {
        this.idreservacion = idreservacion;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
     
}

