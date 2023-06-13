package StudyPass.defcode;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class FlashRepositoryImpl implements IRepository<FlashCard> {
    private java.sql.Connection con;

    //Constructor
    public FlashRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }

    //Gestionar Cache
    private static Set<FlashCard> flashCardsCached = new HashSet<>();
    private FlashCard getFlashCardCached(int i){
        for(FlashCard flashCard : flashCardsCached){
            if (flashCard.getId() == i) return flashCard;
        }
        return null;
    }

    //Lista para gestionar las flashcards que se mostraran al estudiar
    private static List<Integer> numbers = new ArrayList<>();
    private static Random random = new Random();


    //Transformar la flashcard de la base de datos en un objecto
    @Override
    public FlashCard bdToEntity(ResultSet rs) throws SQLException {
        FlashCard flashCard = getFlashCardCached(rs.getInt("id"));
        if (flashCard == null) {
            flashCard = new FlashCard(rs.getInt("id"), rs.getString("question"), rs.getString("answer"));
            flashCardsCached.add(flashCard);
            flashCard.setSubject(new SubjectRepositoryImpl().findByFlashCard(flashCard));
            flashCardsCached.remove(flashCard);
            flashCardsCached.add(flashCard);
        }
        return flashCard;
    }


    //Guardar el objeto flashcard en la base de datos
    @Override
    public void save(FlashCard flashCard) throws SQLException, IOException {
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

            flashCard.transformToFile();

        }else{
            PreparedStatement st = con.prepareStatement("UPDATE flashcards SET name = ?, lastName = ?, subjectid = ? WHERE id = ?");
            st.setString(1, flashCard.getQuestion());
            st.setString(2, flashCard.getAnswer());
            st.setInt(3, flashCard.getSubject().getId());
            st.setInt(4, flashCard.getId());

            st.executeUpdate();
        }
    }

    //Eliminar de la base de datos
    @Override
    public void delete(FlashCard flashCard) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM flashcards WHERE id = ?");
        st.setInt(1, flashCard.getId());
        st.executeUpdate();
        st.close();
    }


    //Metodos para buscar flashcards
    //Buscar todas las flashcards de la base de datos
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

    //Buscar las flashcards de x asignatura
    public ArrayList<FlashCard> findBySubject(Subject subject) throws SQLException {
        ArrayList<FlashCard> flashCards = new ArrayList<>();
        PreparedStatement st = con.prepareStatement("SELECT * FROM flashcards where subjectid = ?");
        st.setInt(1, subject.getId());
        ResultSet rs = st.executeQuery();

        while(rs.next()){
            FlashCard s =  bdToEntity(rs);
            flashCards.add(s);
        }
        return flashCards;
    }

    //Gestionar las flashcards que aparecen al estudiar

    //Se resetea la lista de flashcards
    public void resetNumbers() throws SQLException {
        numbers.clear();
        int max = findAll().size();
        for (int i = 0; i < max; i++) {
            numbers.add(i);
        }
    }

    //Se randomiza la flashcard a mostrar
    public FlashCard randomCard() throws SQLException {


        int num = random.nextInt(findAll().size());

        return findAll().get(num);

    }
}
