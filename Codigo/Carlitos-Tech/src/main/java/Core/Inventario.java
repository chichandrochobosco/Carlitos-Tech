
package Core;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Licha
 */
public class Inventario {
    private ArrayList<Producto> listaProducto = new ArrayList<>();

    public Inventario() {
        listaProducto = new ArrayList<>();
    }
    
    public void agregarProducto(){
        Scanner in = new Scanner(System.in);
        String nombre, marca;
        int  id, seguir, cantidad;
        float precio;
        
        do{
           System.out.println("Ingrese el id: ");
           id = in.nextInt();
           in.nextLine();
           System.out.println("Ingrese el nombre: ");
           nombre = in.nextLine(); 
           System.out.println("Ingrese el precio: ");
           precio = in.nextFloat();
           in.nextLine();
           System.out.println("Ingrese la marca: ");
           marca = in.nextLine();
           System.out.println("Ingrese la cantidad: ");
           cantidad = in.nextInt();
           in.nextLine();
           
           Producto producto = new Producto(id, nombre, precio, marca, cantidad);
           listaProducto.add(producto);
            
           System.out.println("Desea seguir ingresando prodcutos: 1-Si otro num-No ");
           seguir = in.nextInt();
           in.nextLine();
        }while(seguir==1);
            
    }
    public void eliminarProducto(){
        Scanner in = new Scanner(System.in);
        int id;
        for(Producto producto : listaProducto){
            producto.mostrarDatos();
        }
        System.out.println("Ingrese el ID  del producto a eliminar: ");
        id = in.nextInt();
        in.nextLine();
        //listaProducto.remove(Producto.getId(id));
        Producto productoAEliminar = null;
        for (Producto producto : listaProducto) {
            if (producto.getId() == id) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            listaProducto.remove(productoAEliminar);
        }
    }
    public void modificarStock(){
        Scanner in = new Scanner(System.in);
        int id;
        int cantidad;
        for(Producto producto : listaProducto){
            producto.mostrarDatos();
        }
        System.out.println("Ingrese el ID  del producto a modificar su stock: ");
        id = in.nextInt();
        in.nextLine();
        System.out.println("ingrese cantidad");
        cantidad = in.nextInt();
        in.nextLine();
        for (Producto producto : listaProducto) {
            if (producto.getId() == id) {
                producto.setCantidad(cantidad);
                break;
            }
        }

    }
    public Producto obtenerProducto(int id){
        return null;
    }
    public int consultarStock(int id){
        return 0;
    }
    
}
