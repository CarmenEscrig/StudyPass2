package StudyPass;

import java.sql.Connection;
import java.sql.SQLException;

public class MainPrueba {
    static Connection con = DatabaseConnection.getInstance().getConnection();
    public static void main(String[] args) throws SQLException {
        Subject subject = new Subject("matematicas");
        Subject subject1 = new Subject("fisica");
        SubjectRepositoryImpl subjectRepository = new SubjectRepositoryImpl();
        subjectRepository.save(subject);
        subjectRepository.save(subject1);
        User user = new User("Pepe", "Taller2014", "student");
        user.addSubject(subject1);
        user.addSubject(subject);
        subject1.addUser(user);
        subject.addUser(user);
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.save(user);
    }
}
