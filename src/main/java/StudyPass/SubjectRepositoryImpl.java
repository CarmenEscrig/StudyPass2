package StudyPass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectRepositoryImpl implements IRepository<Subject> {
    @Override
    public List<Subject> findAll() throws SQLException {
        return null;
    }

    @Override
    public Subject findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void save(Subject entity) throws SQLException {

    }

    @Override
    public void delete(Subject entity) throws SQLException {

    }

    @Override
    public Subject bdToEntity(ResultSet rs) throws SQLException {
        return null;
    }
}
