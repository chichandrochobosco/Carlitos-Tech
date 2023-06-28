package Core;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private final LocalDateTime fechaHora;
    private final float precio;
    private final List<Producto> productos;

    
    
    public Venta(List<Producto>productos) {
        this.productos = productos;
        fechaHora = LocalDateTime.now();
        precio = calculoPrecio(); // implementar
    }

    public Venta(float precio, LocalDateTime fechaHora, List<Producto>productos) {
        this.precio = precio;
        this.fechaHora = fechaHora;
        this.productos = productos;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public float getPrecio() {
        return precio;
    }
    
    public List<Producto> getProductos(){
        return productos;
    }
    
}
