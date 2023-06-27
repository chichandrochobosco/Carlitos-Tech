package Core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private final LocalDateTime fechaHora;
    private final float precio;
    private final List<Producto> productos;

    public Venta(float precio, List<Producto>productos) {
        this.precio = precio;
        this.productos = productos;
        fechaHora = LocalDateTime.now();
    }

    public Venta() { //temporal para que no de errores en el dao venta
        precio = 100f;
        fechaHora = LocalDateTime.now();
        productos = new ArrayList<Producto>();
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
