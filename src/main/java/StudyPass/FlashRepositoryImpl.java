package StudyPass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FlashRepositoryImpl implements IRepository<FlashCard> {
    private java.sql.Connection con;
    public FlashRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }


    @Override
    public List<FlashCard> findAll() throws SQLException {
        return null;
    }

    @Override
    public FlashCard findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void save(FlashCard entity) throws SQLException {

    }

    @Override
    public void delete(FlashCard entity) throws SQLException {

    }

    @Override
    public FlashCard bdToEntity(ResultSet rs) throws SQLException {
        return new FlashCard(rs.getInt("id"), rs.getString("question"), rs.getString("answer"), new SubjectRepositoryImpl().findById(rs.getInt("subject")));
    }
}
