package repositorio;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author losmelli
 * @param <T>
 */
public interface Dao <T> {
    
     public void add(T emp) throws SQLException;
     
    public void delete(int id) throws SQLException;
    
    public T getByInt(int id) throws SQLException;
    
    public T getByStr(String id) throws SQLException;
    
    public List<T> getList() throws SQLException;
    
    public void update(T t) throws SQLException;
    
}
