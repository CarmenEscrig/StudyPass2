package StudyPass.defcode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepositoryImpl implements IRepository<User> {

    private java.sql.Connection con;

    //Constructor
    public UserRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }

    //Gestionar cache
    private static Set<User> usersCached = new HashSet<>();

    private User getUserCached(int i){
        for(User user : usersCached){
            if (user.getId() == i) return user;
        }
        return null;
    }

    //Transformar el usuario de la base de datos en un objecto
    public User bdToEntity(ResultSet rs) throws SQLException {
        User user = getUserCached(rs.getInt("id"));
        if (user == null) {
            user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("type"));
            usersCached.add(user);
            user.setProgress(new ProgressRepositoryImpl().findByUser(user));
            user.setSubjects(new SubjectRepositoryImpl().findByUser(user));
            usersCached.remove(user);
            usersCached.add(user);
        }
        return user;
    }

    //Guardar el objeto user en la base de datos
    @Override
    public void save(User user) throws SQLException {
        if (user.getId() == -1){
            if (user.getProgress().getId() == -1) {
                ProgressRepositoryImpl progressRepository = new ProgressRepositoryImpl();
                progressRepository.save(user.getProgress());
            }
            ResultSet rs;
            PreparedStatement st = null;
            String query = "INSERT INTO users (username, password, progressid, type) VALUES (?, ?, ?, ?)";
            //Fijáos en Statement.RETURN_GENERATED_KEYS. Permite recuperar el campo ID autogenerado por MySql
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setInt(3, user.getProgress().getId());
            st.setString(4, user.getType());

            st.executeUpdate();

            rs = st.getGeneratedKeys();

            if (rs.next()){
                user.setId(rs.getInt(1));
            }

            //Codigo user-subject

            for (Subject subject : user.getSubjects()) {
                PreparedStatement st2 = con.prepareStatement("INSERT INTO user_subject (userid, subjectid) VALUES (?, ?)");
                st2.setInt(1, user.getId());
                st2.setInt(2, subject.getId());
                st2.executeUpdate();
            }


        }else{
            PreparedStatement st = con.prepareStatement("UPDATE users SET username = ?, password = ?, progressid = ?, type = ? WHERE id = ?");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setInt(3, user.getProgress().getId());
            st.setString(4, user.getType());
            st.setInt(5, user.getId());

            st.executeUpdate();

            //Codigo user-subject

            for (Subject subject : user.getSubjects()) {
                PreparedStatement st2 = con.prepareStatement("INSERT INTO user_subject (userid, subjectid) VALUES (?, ?)");
                st2.setInt(1, user.getId());
                st2.setInt(2, subject.getId());

                st2.executeUpdate();
            }
        }
    }

    //Eliminar de la base de datos
    @Override
    public void delete(User user) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM users WHERE id = ?");
        st.setInt(1, user.getId());
        st.executeUpdate();

        PreparedStatement st2 = con.prepareStatement("DELETE FROM user_subject WHERE userid = ?");
        st2.setInt(1, user.getId());
        st2.executeUpdate();
        st.close();
        st2.close();
    }

    //Metodos para buscar usuarios
    //Buscar todos los usuarios de la base de datos
    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();

        Statement st = this.con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users");

        while(rs.next()){
            User u =  bdToEntity(rs);
            users.add(u);
        }
        return users;
    }

    //Buscar por el id del usuario
    public User findById(int id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE id = ? ");
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        User o = null;
        if (rs.next()){
            o = bdToEntity(rs);
        }
        return o;
    }

    //Buscar los usuarios que tienen x asignatura
    public ArrayList<User> findBySubject(Subject subject) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement st = con.prepareStatement("SELECT * FROM user_subject where subjectid = ?");
        st.setInt(1, subject.getId());
        ResultSet rs = st.executeQuery();

        while(rs.next()){
            User u =  findById(rs.getInt("userid"));
            users.add(u);
        }
        return users;
    }
}
