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
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class Principal {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        //Se instancian las clases unicas
        GUI_Login loginP = new GUI_Login();
        GUI_Inventario inventario = new GUI_Inventario();
        GUI_Registro registro = new GUI_Registro();
        GUI_RevisarReservaciones revision = new GUI_RevisarReservaciones();
        Coordinador coordinador = new Coordinador();
        LUsuarios logi1 = new LUsuarios();
        LROLUsuario logi2 = new LROLUsuario();
        LInventarioProduct logi3 = new LInventarioProduct();
        LReservacion logi4 = new LReservacion();
        LCantidadProd logi5 = new LCantidadProd();
        try {
            ReservacionProductos reserva = new ReservacionProductos();
            reserva.setCoordinador(coordinador);
            coordinador.setGUI_ReservacionProductos(reserva);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Se establecen la relaciones entre las clases con el coordinador
        loginP.setCoordinador(coordinador);
        inventario.setCoordinador(coordinador);
        registro.setCoordinador(coordinador);
        logi1.setCoordinador(coordinador);
        logi2.setCoordinador(coordinador);
        logi3.setCoordinador(coordinador);
        logi4.setCoordinador(coordinador);
        logi5.setCoordinador(coordinador);
        revision.setCoordinador(coordinador);
        
        //Se relaciona al coordinador con las clases
        coordinador.setLogin(loginP);
        coordinador.setGUI_inventario(inventario);
        coordinador.setGUI_registro(registro);       
        coordinador.setBlUsuarios(logi1);
        coordinador.setBLRolUsuario(logi2);
        coordinador.setBLCantidadProducto(logi5);
        coordinador.setBLInventarioProduct(logi3);
        coordinador.setBLReservacion(logi4);
        coordinador.setGUI_ReservacionProductos(revision);
        
        
        loginP.setVisible(true);

    }
}
