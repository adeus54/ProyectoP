package Modelo.vo.vo;

/**
 *
 * @author alexa
 */
public class ReservacionVO {
    private int res_id;
    private int us_id;
    private int ideProductos;

    public ReservacionVO(int res_id, int us_id, int ideProductos) {
        this.res_id = res_id;
        this.us_id = us_id;
        this.ideProductos = ideProductos;
    }
    
    public ReservacionVO(int res_id) {
        this.res_id = res_id;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public int getUs_id() {
        return us_id;
    }

    public void setUs_id(int us_id) {
        this.us_id = us_id;
    }

    public int getIdeProductos() {
        return ideProductos;
    }

    public void setIdeProductos(int ideProductos) {
        this.ideProductos = ideProductos;
    }
    
    
}
