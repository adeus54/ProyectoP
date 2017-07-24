package Modelo.vo.vo;

/**
 *
 * @author alexa
 */
public class UsuarioVO {

    private String us_nombres;
    private String us_apellidos;
    private String us_login;
    private String us_password;
    private int us_id;
    private int ID;

    public UsuarioVO(String us_nombres, String us_apellidos, String us_login, String us_password) {
        this.us_nombres = us_nombres;
        this.us_apellidos = us_apellidos;
        this.us_login = us_login;
        this.us_password = us_password;
    }

    public UsuarioVO(String us_nombres, String us_apellidos, String us_login, String us_password, int ident) {
        this.us_nombres = us_nombres;
        this.us_apellidos = us_apellidos;
        this.us_login = us_login;
        this.us_password = us_password;
        this.ID = ident;
    }

    public UsuarioVO(int id, String us_nombres, String us_apellidos, String us_login, String us_password,int ident) {
        this.us_id = id;
        this.us_nombres = us_nombres;
        this.us_apellidos = us_apellidos;
        this.us_login = us_login;
        this.us_password = us_password;
        this.ID = ident;
    }

    public UsuarioVO(int ident) {
        this.ID = ident;
    }

    public UsuarioVO(int ide, String us_nombres) {
        this.us_id = ide;
        this.us_nombres = us_nombres;

    }
    
    public int getID() {
        return ID;
    }
    
    public int getUs_id() {
        return us_id;
    }

    public String getUs_nombres() {
        return us_nombres;
    }

    public void setUs_nombres(String us_nombres) {
        this.us_nombres = us_nombres;
    }

    public String getUs_apellidos() {
        return us_apellidos;
    }

    public void setUs_apellidos(String us_apellidos) {
        this.us_apellidos = us_apellidos;
    }

    public String getUs_login() {
        return us_login;
    }

    public void setUs_login(String us_login) {
        this.us_login = us_login;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

}
