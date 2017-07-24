package controlador;

import Modelo.l.LCantidadProd;
import Modelo.l.LInventarioProduct;
import Modelo.l.LROLUsuario;
import Modelo.l.LReservacion;
import Modelo.l.LUsuarios;
import Vista.GUI_Inventario;
import Vista.GUI_Login;
import Vista.GUI_Registro;
import Vista.GUI_RevisarReservaciones;
import Vista.ReservacionProductos;

/**
 *
 * @author alexa
 */
public class Coordinador {

    private GUI_Login loginP;
    private GUI_Inventario inventario;
    private GUI_Registro registro;
    private LUsuarios logi1;
    private LROLUsuario logi2;
    private LReservacion logi4;
    private LInventarioProduct logi3;
    private ReservacionProductos reserva;
    private GUI_RevisarReservaciones revision;
    private LCantidadProd logi5;

    void setLogin(GUI_Login loginP) {
    this.loginP = loginP;
    }

    void setGUI_inventario(GUI_Inventario inventario) {
    this.inventario =  inventario;
    }

    void setGUI_registro(GUI_Registro registro) {
    this.registro = registro;  
    }

    void setBlUsuarios(LUsuarios logi1) {
    this.logi1 = logi1;
    }

    void setBLRolUsuario(LROLUsuario logi2) {
    this.logi2 = logi2;           
    }

    void setBLReservacion(LReservacion logi4) {
    this.logi4 = logi4;
    }

    void setBLInventarioProduct(LInventarioProduct logi3) {
    this.logi3 = logi3;
    }

    void setGUI_ReservacionProductos(ReservacionProductos reserva) {
    this.reserva = reserva;
    }

    void setGUI_ReservacionProductos(GUI_RevisarReservaciones revision) {
    this.revision=revision;
    }

    void setBLCantidadProducto(LCantidadProd logi5) {
    this.logi5 = logi5;
    }
    
}
