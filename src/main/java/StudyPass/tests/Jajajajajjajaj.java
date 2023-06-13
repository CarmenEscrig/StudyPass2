package StudyPass.tests;

import StudyPass.code.Subject;
import StudyPass.code.SubjectRepositoryImpl;
import StudyPass.code.User;
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

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Indice();
            }
        });
    }
}
