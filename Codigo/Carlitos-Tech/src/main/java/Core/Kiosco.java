package Core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import repositorio.Dao;
import repositorio.ProductoDao;
import repositorio.VentaDao;

public class Kiosco {

    private Inventario inventario;
    private static List<Venta> listaVentas = new ArrayList<>();
    public Kiosco(Inventario inventario, Caja caja) {
        this.inventario = inventario;        
    }

    public static void añadirVenta(List<Producto> listaProductos, float valorTotal) throws SQLException {       
        Venta venta = new Venta(listaProductos,valorTotal);
        listaVentas.add(venta);
        Dao<Venta> dao = new VentaDao();
        dao.add(venta);
    }

  

    public float abrirCaja(Caja caja, float valorInicial) {
        caja.abrirCaja(valorInicial);
        return valorInicial;
    }

    public float cerrarCaja(Caja caja) {
        return caja.cerrarCaja(0); // El metodo cerrarCaja() deberia ya devolver el valor final y no pedir parametros
    }
}
