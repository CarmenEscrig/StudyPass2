package StudyPass;

import java.sql.Connection;
import java.sql.SQLException;

public class MainPrueba {
    static Connection con = DatabaseConnection.getInstance().getConnection();
    public static void main(String[] args) throws SQLException {
        /*User user = new User("Pepe", "Taller2014", "student");
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.save(user);
        for (User user1 : userRepository.findAll()) {
            System.out.println(user1.getUsername());
        }
        userRepository.delete(user);
*/
        Subject subject = new Subject("Matematicas");
        SubjectRepositoryImpl subjectRepository = new SubjectRepositoryImpl();
        subjectRepository.save(subject);
        subjectRepository.findAll();

        FlashCard flashCard = new FlashCard("algo","si",subject);
        FlashRepositoryImpl flashRepository = new FlashRepositoryImpl();
        flashRepository.save(flashCard);
        flashRepository.findAll();

        Progress progress = new Progress(12,15);
        ProgressRepositoryImpl progressRepository = new ProgressRepositoryImpl();
        progressRepository.save(progress);
        progressRepository.findAll();


    }
}
