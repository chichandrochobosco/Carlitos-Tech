/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author losmelli
 */
public interface Dao <T> {
    
     public void add(T emp)
        throws SQLException;
     
    public void delete(int id)
        throws SQLException;
    
    public T get(String t)
        throws SQLException;
    
    public List<T> getList()
        throws SQLException;
    
    public void update(T t)
        throws SQLException;
    
}
