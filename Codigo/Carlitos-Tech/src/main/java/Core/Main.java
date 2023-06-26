package Core;

import repositorio.Dao;
import repositorio.UserDao;
import vistas.Login;
import vistas.VistaAdmin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author losmelli
 */
public class Main {
    public static void main(String[] args) {
        Dao dao = new UserDao();
        LoginService service = new LoginService(dao);
        Login login = new vistas.Login(service);
        login.setVisible(true);
        
    }
}
