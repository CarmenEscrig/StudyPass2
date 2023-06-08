package StudyPass.tests;

import StudyPass.code.Subject;
import StudyPass.code.SubjectRepositoryImpl;
import StudyPass.graphic.Indice;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Jajajajajjajaj {

    public static ArrayList<Subject> subjects;

    static {
        try {
            subjects = (ArrayList<Subject>) new SubjectRepositoryImpl().findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Indice();
            }
        });
    }
}
