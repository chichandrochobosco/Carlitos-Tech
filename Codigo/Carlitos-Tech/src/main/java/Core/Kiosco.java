package Core;

import java.util.ArrayList;
import java.util.List;

public class Kiosco {
    private Inventario inventario;
    private static List<Venta>listaVentas;

    public Kiosco(Inventario inventario, Caja caja) {
        this.inventario = inventario;
        listaVentas = new ArrayList<>();
    }
    
    public static void realizarVenta(List<Producto>listaProductos){
        listaVentas.add(new Venta(listaProductos));
    }
    
    public float abrirCaja(Caja caja, float valorInicial){
        caja.abrirCaja(valorInicial);
        return valorInicial;
    }
    
    public float cerrarCaja(Caja caja){
        return caja.cerrarCaja(0); // El metodo cerrarCaja() deberia ya devolver el valor final y no pedir parametros
    }
}
