/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carlitos.tech;

/**
 *
 * @author lolo
 */
public class Administrador extends Usuario {

    public Administrador(String nombre, String apellido, String contraseña) {
        super(nombre, apellido, contraseña);
    }

    public Producto IngresarProducto(Inventario inventario) {

        return null;

    }

    public Producto EliminarProducto(Inventario inventario) {

        return null;
    }

    public Producto Inventario(Inventario inventario) {

        return null;
    }

    @Override
    public void MostrarDatos() {
        System.out.println("Datos" + nombre + apellido);
    }
}
