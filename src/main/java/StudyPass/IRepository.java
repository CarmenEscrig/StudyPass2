package StudyPass;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
    public List<T> findAll() throws SQLException;

    public void save(T entity) throws SQLException, IOException;

    public void delete(T entity) throws SQLException ;

    public T bdToEntity(ResultSet rs) throws SQLException ;


}
