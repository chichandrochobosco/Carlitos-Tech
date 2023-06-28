
package Core;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.Dao;
import repositorio.ProductoDao;

public class Inventario {
    private ArrayList<Producto> listaProducto = new ArrayList<>();

    public Inventario() {
        listaProducto = new ArrayList<>();
    }
    
    public Inventario(ArrayList<Producto>productos) {
        listaProducto = productos;
    }
    
    public void agregarProducto(Producto producto){
        try {
            Dao<Producto> dao;
            dao = new ProductoDao();
            dao.add(producto);
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }
    
}
