package Core;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.Dao;

public class LoginService {
    private Dao<Usuario> dao;

    public LoginService(Dao dao) {
        this.dao = dao;
    }
    
    public Usuario validarUsuario(String nombre,String contraseña){
        Usuario user = null; 
        try {
            user =  dao.get(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(user != null) {       
            if(user.getNombre().equals(nombre) && user.getContraseña().equals(contraseña)){
                return user;
            }
        }
        return null;
    }
}

