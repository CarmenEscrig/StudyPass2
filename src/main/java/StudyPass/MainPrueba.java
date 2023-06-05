package StudyPass;

import java.sql.Connection;
import java.sql.SQLException;

public class MainPrueba {
    static Connection con = DatabaseConnection.getInstance().getConnection();
    public static void main(String[] args) throws SQLException {
        User user = new User("Pepe", "Taller2014", "student");
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        userRepository.save(user);
        for (User user1 : userRepository.findAll()) {
            System.out.println(user1.getUsername());
        }
        userRepository.delete(user);
    }
}
