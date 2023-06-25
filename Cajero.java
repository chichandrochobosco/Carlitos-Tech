/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carlitos.tech;

/**
 *
 * @author lolo
 */
public class Cajero extends Usuario {

    public Cajero(String nombre, String apellido, String contraseña) {
        super(nombre, apellido, contraseña);
    }

    public Venta RealizarVenta(Quiosco q) {

        return null;

    }

    @Override
    public void MostrarDatos() {
        System.out.println("Datos" + nombre + apellido);
    }

}
