/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carlitos.tech;

/**
 *
 * @author lolo
 */
public abstract class Usuario {
    String nombre;
    String apellido;
    String contraseña;

    public Usuario(String nombre, String apellido, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }
    
    public abstract void MostrarDatos();
}
