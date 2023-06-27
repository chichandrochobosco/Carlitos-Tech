package repositorio;

import Core.Producto;
import java.sql.SQLException;
import java.util.List;
import Core.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.Jdbc.SqlConnection;

public class VentaDao implements Dao<Venta>{

    @Override
    public void add(Venta venta) {
        java.sql.Timestamp sqlTimestamp = java.sql.Timestamp.valueOf(venta.getFechaHora());
        Connection con = SqlConnection.getConnection();
        String query;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            query = "INSERT INTO Venta (fecha_hora, valor) VALUES (?, ?)";
            ps = con.prepareStatement(query);
            ps.setTimestamp(1, sqlTimestamp);
            ps.setFloat(2, venta.getPrecio());
            ps.executeUpdate();
            
            query = "SELECT LAST_INSERT_ID();";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            int idVenta = rs.getInt("id");
                        
            query = "INSERT INTO venta_producto (id_venta, id_producto, cantidad) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            for(Producto p: venta.getProductos()){
                ps.setInt(1, idVenta);
                ps.setInt(2, p.getId());
                ps.setInt(3, p.getCantidad());
                ps.addBatch();
            }
            ps.executeBatch();
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try {
                if(rs != null && ps != null){
                    rs.close();
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Venta getByInt(int id) {
        return new Venta();
    }

    @Override
    public List getList() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Venta venta) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta getByStr(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
