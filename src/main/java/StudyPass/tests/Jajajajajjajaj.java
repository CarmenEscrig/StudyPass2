package StudyPass.tests;

import StudyPass.defcode.Subject;
import StudyPass.defcode.SubjectRepositoryImpl;
import StudyPass.defcode.User;
import StudyPass.graphic.Indice;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Jajajajajjajaj {

    public static User user;
    public static ArrayList<Subject> subjects;

    static {
        try {
            subjects = (ArrayList<Subject>) new SubjectRepositoryImpl().findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        SubjectRepositoryImpl.subjectCached.clear();

        SwingUtilities.invokeLater(Indice::new);
    }
}
