package StudyPass.tests;

import StudyPass.defcode.DatabaseConnection;
import StudyPass.defcode.FlashCard;
import StudyPass.defcode.Subject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class MainPrueba {
    static Connection con = DatabaseConnection.getInstance().getConnection();
    public static void main(String[] args) throws SQLException, IOException {
        Subject subject = new Subject(2,"matematicas");
        FlashCard flashCard = new FlashCard(1, "¿Cuanto es 2 + 2?", "4", subject);
        flashCard.transformToFile();
    }
}
