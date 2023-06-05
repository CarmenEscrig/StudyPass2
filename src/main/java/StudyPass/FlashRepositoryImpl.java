package StudyPass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlashRepositoryImpl implements IRepository<FlashCard> {
    private java.sql.Connection con;
    public FlashRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }

    private Set<FlashCard> flashCardsCached = new HashSet<>();
    private FlashCard getFlashCardCached(int i){
        for(FlashCard flashCard : flashCardsCached){
            if (flashCard.getId() == i) return flashCard;
        }
        return null;
    }

    @Override
    public List<FlashCard> findAll() throws SQLException {
        List<FlashCard> flashCards = new ArrayList<>();
        Statement st = this.con.createStatement();
        //Ejecutar la consulta, guardando los datos devueltos en un Resulset
        ResultSet rs = st.executeQuery("SELECT * FROM flashcards");

        while(rs.next()){
            FlashCard f =  bdToEntity(rs);
            //Añadir el User al conjunto de users
            flashCards.add(f);
        }
        return flashCards;
    }

    @Override
    public void save(FlashCard flashCard) throws SQLException {
        if (flashCard.getId() == -1){
            ResultSet rs;
            PreparedStatement st = null;
            String query = "INSERT INTO flashcards (question, answer, subjectid) VALUES (?, ?, ?)";
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, flashCard.getQuestion());
            st.setString(2, flashCard.getAnswer());
            st.setInt(3, flashCard.getSubject().getId());

            st.executeUpdate();

            rs = st.getGeneratedKeys();

            if (rs.next()){

                flashCard.setId(rs.getInt(1));
            }
        }else{
            PreparedStatement st = con.prepareStatement("UPDATE flashcards SET name = ?, lastName = ?, subjectid = ? WHERE id = ?");
            st.setString(1, flashCard.getQuestion());
            st.setString(2, flashCard.getAnswer());
            st.setInt(3, flashCard.getSubject().getId());
            st.setInt(4, flashCard.getId());

            st.executeUpdate();
        }
    }

    @Override
    public void delete(FlashCard flashCard) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM flashcards WHERE id = ?");
        st.setInt(1, flashCard.getId());
        st.executeUpdate();
        st.close();
    }

    @Override
    public FlashCard bdToEntity(ResultSet rs) throws SQLException {
        FlashCard flashCard = getFlashCardCached(rs.getInt("id"));
        if (flashCard == null) {
            flashCard = new FlashCard(rs.getInt("id"), rs.getString("question"), rs.getString("answer"));
            flashCardsCached.add(flashCard);
            flashCard.setSubject(new SubjectRepositoryImpl().findByFlashCard(flashCard));
        }
        return flashCard;
    }

    public ArrayList<FlashCard> findBySubject(Subject subject) throws SQLException {
        ArrayList<FlashCard> flashCards = new ArrayList<>();
        PreparedStatement st = con.prepareStatement("SELECT * FROM flashcards where subjectid = ?");
        ResultSet rs = st.executeQuery();

        while(rs.next()){
            FlashCard s =  bdToEntity(rs);
            flashCards.add(s);
        }
        return flashCards;
    }
}
