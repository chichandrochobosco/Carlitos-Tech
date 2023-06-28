package repositorio;

import Core.Inventario;
import Core.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repositorio.Jdbc.SqlConnection;

public class InventarioDao implements Dao<Inventario>{

    @Override
    public void add(Inventario inventario) {
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        for(Producto p: inventario.getListaProducto()){
            try{
                query = "SELECT EXISTS(SELECT from producto where id = ?);";
                ps = con.prepareStatement(query);
                ps.setInt(1, p.getId());
                rs = ps.executeQuery();
                boolean productoExistente = rs.getBoolean(1);
                if(!productoExistente){
                    query = "INSERT INTO producto(id, nombre, marca, precio, cant_producto) values(?,?,?,?,?);";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, p.getId());
                    ps.setString(2, p.getNombre());
                    ps.setString(3, p.getMarca());
                    ps.setFloat(4, p.getPrecio());
                    ps.setInt(5, p.getCantidad());
                    ps.executeUpdate();
                }else{
                    query = "SELECT cant_producto from producto where id = ?);";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, p.getId());
                    rs = ps.executeQuery();
                    if(rs.getInt("cant_producto")!=p.getCantidad()){
                        query = "UPDATE producto SET cant_producto = ? WHERE id = ?;";
                        ps = con.prepareStatement(query);
                        ps.setInt(1, p.getCantidad());
                        ps.setInt(2, p.getId());
                    }
                }
            }catch(SQLException e){
                System.out.println(e);
            }finally{
                try{
                    if(rs!=null && ps!=null){
                        rs.close();
                        ps.close();
                    }
                }catch(SQLException e){System.out.println(e);}
            }
        }
    }
    
    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Inventario get(){
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Producto> productos = new ArrayList<>();
        int id, cantidad;
        String nombre, marca;
        float precio;
        
        try{
            query = "SELECT * from producto";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                marca = rs.getString("marca");
                precio = rs.getFloat("precio");
                cantidad = rs.getInt("cant_producto");
                productos.add(new Producto(id, nombre, precio, marca, cantidad));
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                if(rs!=null && ps!=null){
                    rs.close();
                    ps.close();
                }
            }catch(SQLException e){System.out.println(e);}
        }
        if(productos.isEmpty()){
            return null;
        }
        return new Inventario(productos);
    }
    
    @Override
    public Inventario get(int id){
        return new Inventario();
    }

    @Override
    public Inventario get(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getList() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Inventario t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
