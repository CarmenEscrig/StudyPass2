package StudyPass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubjectRepositoryImpl implements IRepository<Subject> {
    private java.sql.Connection con;
    public SubjectRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }
    private Set<Subject> subjectCached = new HashSet<>();

    private Subject getSubjectCached(int i){
        for(Subject subject : subjectCached){
            if (subject.getId() == i) return subject;
        }
        return null;
    }


    @Override
    public List<Subject> findAll() throws SQLException {
        List<Subject> subjects = new ArrayList<>();

        Statement st = this.con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM subjects");

        while(rs.next()){
            Subject s =  bdToEntity(rs);
            subjects.add(s);
        }
        return subjects;
    }

    @Override
    public void save(Subject subject) throws SQLException {
        if (subject.getId() == -1){
            ResultSet rs;
            PreparedStatement st = null;
            String query = "INSERT INTO subjects (name) VALUES (?)";
            //Fijáos en Statement.RETURN_GENERATED_KEYS. Permite recuperar el campo ID autogenerado por MySql
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, subject.getName());

            st.executeUpdate();

            rs = st.getGeneratedKeys();

            if (rs.next()){
                subject.setId(rs.getInt(1));
            }

            //Codigo user-subject

            for (User user : subject.getUsers()) {
                PreparedStatement st2 = con.prepareStatement("INSERT INTO user_subject (userid, subjectid) VALUES (?, ?)");
                st2.setInt(1, user.getId());
                st2.setInt(2, subject.getId());

                st2.executeUpdate();

            }
        }else{
            PreparedStatement st = con.prepareStatement("UPDATE subjects SET username = ? WHERE id = ?");
            st.setString(1, subject.getName());
            st.setInt(2, subject.getId());

            st.executeUpdate();
            //Codigo user-subject

            for (User user : subject.getUsers()) {
                PreparedStatement st2 = con.prepareStatement("INSERT INTO user_subject (userid, subjectid) VALUES (?, ?)");
                st2.setInt(1, user.getId());
                st2.setInt(2, subject.getId());

                st2.executeUpdate();

            }
        }
    }

    @Override
    public void delete(Subject subject) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM subjects WHERE id = ?");
        st.setInt(1, subject.getId());
        st.executeUpdate();
        PreparedStatement st2 = con.prepareStatement("DELETE FROM user_subject WHERE subjectid = ?");
        st2.setInt(1, subject.getId());
        st2.executeUpdate();
        st.close();
        st2.close();
    }

    @Override
    public Subject bdToEntity(ResultSet rs) throws SQLException {
        Subject subject = getSubjectCached(rs.getInt("id"));
        if (subject == null) {
            subject = new Subject(rs.getInt("id"), rs.getString("name"));
            subjectCached.add(subject);
            subject.setFlashCards(new FlashRepositoryImpl().findBySubject(subject));
            subject.setUsers(new UserRepositoryImpl().findBySubject(subject));
        }
        return new Subject(rs.getInt("id"), rs.getString("name"));
    }

    public ArrayList<Subject> findByUser(User user) throws SQLException{
        ArrayList<Subject> subjects = new ArrayList<>();
        PreparedStatement st = con.prepareStatement("SELECT * FROM subjects where id = ?");
        ResultSet rs = st.executeQuery();

        while(rs.next()){
            Subject s =  bdToEntity(rs);
            subjects.add(s);
        }
        return subjects;
    }

    public Subject findByFlashCard(FlashCard flashCard) throws SQLException{
        PreparedStatement st = con.prepareStatement("SELECT * FROM subjects WHERE id = ? ");
        st.setInt(1, flashCard.getId());

        ResultSet rs = st.executeQuery();
        Subject s = null;
        if (rs.next()){
            s = bdToEntity(rs);
        }
        return s;
    }
}
