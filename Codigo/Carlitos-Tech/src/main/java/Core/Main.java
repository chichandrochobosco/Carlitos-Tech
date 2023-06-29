package Core;

import repositorio.Dao;
import repositorio.UsuarioDao;
import vistas.Login;
import vistas.VistaAdmin;

public class Main {
    public static void main(String[] args) {
        Dao dao = new UsuarioDao();
        LoginService service = new LoginService(dao);
        Login login = new vistas.Login(service);
        login.setVisible(true);
        
    }
}
