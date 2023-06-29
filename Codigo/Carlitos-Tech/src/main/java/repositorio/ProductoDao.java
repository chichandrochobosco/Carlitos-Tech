package repositorio;
import Core.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repositorio.Jdbc.SqlConnection;

public class ProductoDao implements Dao<Producto>{

    @Override
    public void add(Producto p){
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
          //  query = "SELECT EXISTS(SELECT from producto where id = ?);";
         //   ps = con.prepareStatement(query);
      //      ps.setInt(1, p.getId());
       //     rs = ps.executeQuery();
       //     boolean productoExistente = rs.getBoolean(1);
       //     if(!productoExistente){
                query = "INSERT INTO producto(id, nombre, marca, precio, cant_producto) values(?,?,?,?,?);";
                ps = con.prepareStatement(query);
                ps.setInt(1, p.getId());
                ps.setString(2, p.getNombre());
                ps.setString(3, p.getMarca());
                ps.setFloat(4, p.getPrecio());
                ps.setInt(5, p.getCantidad());
                ps.executeUpdate();
        //    }
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

    @Override
    public void delete(int id) {
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        query = "DELETE FROM PRODUCTO WHERE id = ?;";
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
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

    @Override
    public Producto get(int id){
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int cantidad;
        String nombre, marca;
        float precio;
        
        Producto productoBuscado = null;
        
        try{
            query = "SELECT * from producto WHERE id =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
            nombre = rs.getString("nombre");
            marca = rs.getString("marca");
            precio = rs.getFloat("precio");
            cantidad = rs.getInt("cant_producto");           
            productoBuscado = new Producto(id, nombre, precio, marca, cantidad);
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
        
        return productoBuscado;
    }

    @Override
    public Producto get(String id) throws SQLException {
        return get(Integer.parseInt(id));
    }

    @Override
    public List<Producto> getList() {
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
        return productos;
    }

    @Override
    public void update(Producto p){
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        query = "UPDATE producto SET nombre = ?, marca = ?, precio = ?, cant_producto = ? WHERE id = ?;";
        try{
            ps = con.prepareStatement(query);
            ps.setString(1, p.getNombre());
            ps.setString(2,p.getMarca());
            ps.setFloat(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
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
