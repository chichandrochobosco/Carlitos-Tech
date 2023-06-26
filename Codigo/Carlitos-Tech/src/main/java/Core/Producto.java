
package Core;

/**
 *
 * @author Licha
 */
public class Producto {
    private String id;
    private String nombre;
    private float precio;
    private String marca;
    private int cantidad;

    public Producto(String id, String nombre, float precio, String marca, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public void mostrarDatos() {
        System.out.println("Producto: "+"id: " + id + ", nombre: " + nombre + ", precio: " + precio +", marca: "+marca);
    }
    
    
    
}
