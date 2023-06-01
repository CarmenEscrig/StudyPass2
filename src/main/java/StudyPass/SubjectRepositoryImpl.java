package StudyPass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectRepositoryImpl implements IRepository<Subject> {
    private java.sql.Connection con;
    public SubjectRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }

    @Override
    public List<Subject> findAll() throws SQLException {
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

    public Subject findByFlashCard(FlashCard flashCard) throws SQLException{
        PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE id = ? ");
        st.setInt(1, flashCard.getId());

        ResultSet rs = st.executeQuery();
        Subject s = null;
        if (rs.next()){
            s = bdToEntity(rs);
        }
        return s;
    }
}
