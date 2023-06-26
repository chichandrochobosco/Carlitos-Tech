/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author lolo
 */
public  class Usuario {
    String nombre;
    String apellido;
    String contraseña;
    Rol rol;

    public Usuario(String nombre, String apellido, String contraseña,Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Rol getRol() {
        return rol;
    }
    
  
}
