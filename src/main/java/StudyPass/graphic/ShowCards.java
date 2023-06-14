package StudyPass.graphic;

import StudyPass.defcode.FlashCard;
import StudyPass.defcode.FlashRepositoryImpl;
import StudyPass.defcode.Subject;
import StudyPass.tests.Jajajajajjajaj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ShowCards extends JFrame {

    final JLabel lblTitulo = new JLabel("Study Pass");
    final JLabel lblFlashCards = new JLabel("Flashcards:");

    String[] names = {"ID" , "Pregunta" , "Respuesta", "Asignatura"};

    DefaultTableModel tableModel = new DefaultTableModel(names, 0);

    JTable table = new JTable(tableModel);

    final JToolBar tool = new JToolBar();


    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();

    public ShowCards() throws SQLException {

        completeTable();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setSize(600, 750);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setTitle("StudyPass");
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 40));
        lblFlashCards.setFont(new Font("Courier New", Font.BOLD, 30));

        table.setPreferredScrollableViewportSize(new Dimension(550, 100));

        panel_1.add(Box.createVerticalStrut(50));
        panel_1.add(lblTitulo);
        panel_2.add(lblFlashCards);
        panel_3.add(tool);
        panel_3.add(new JScrollPane(table));
        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));


        setVisible(true);
    }

    public void completeTable() throws SQLException {


        for (Subject s : Jajajajajjajaj.user.getSubjects()) {
            for (FlashCard f : new FlashRepositoryImpl().findBySubject(s)){
                Object[] newRow = {f.getId(), f.getQuestion(), f.getAnswer(), f.getSubject().getName()};
                tableModel.addRow(newRow);
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ShowCards();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
