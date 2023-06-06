package StudyPass.code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProgressRepositoryImpl implements IRepository<Progress> {
    private java.sql.Connection con;
    public ProgressRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }

    @Override
    public List<Progress> findAll() throws SQLException {
        List<Progress> progresses = new ArrayList<>();
        Statement st = this.con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM progress");

        while(rs.next()){
            Progress p =  bdToEntity(rs);
            progresses.add(p);
        }
        return progresses;
    }

    public Progress findByUser(User user) throws SQLException{
        PreparedStatement st = con.prepareStatement("SELECT * FROM progress WHERE id = ? ");
        st.setInt(1, user.getId());

        ResultSet rs = st.executeQuery();
        Progress p = null;
        if (rs.next()){
            p = bdToEntity(rs);
        }
        return p;
    }

    @Override
    public void save(Progress progress) throws SQLException {
        if (progress.getId() == -1){
            ResultSet rs;
            PreparedStatement st = null;
            String query = "INSERT INTO progress (correct, incorrect) VALUES (?, ?)";
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, progress.getCorrect());
            st.setInt(2, progress.getIncorrect());

            st.executeUpdate();
            rs = st.getGeneratedKeys();

            if (rs.next()){
                progress.setId(rs.getInt(1));
            }
        }else{
            PreparedStatement st = con.prepareStatement("UPDATE progress SET correct = ?, incorrect = ? WHERE id = ?");
            st.setInt(1, progress.getCorrect());
            st.setInt(2, progress.getCorrect());
            st.setInt(3, progress.getId());

            st.executeUpdate();
        }
    }

    @Override
    public void delete(Progress progress) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM progress WHERE id = ?");
        st.setInt(1, progress.getId());
        st.executeUpdate();
        st.close();
    }

    @Override
    public Progress bdToEntity(ResultSet rs) throws SQLException {
        return new Progress(rs.getInt("id"), rs.getInt("correct"), rs.getInt("incorrect"));
    }
}