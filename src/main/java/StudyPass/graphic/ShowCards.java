package StudyPass.graphic;

import StudyPass.code.FlashCard;
import StudyPass.code.FlashRepositoryImpl;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;

public class ShowCards extends JFrame {

    final JLabel titulo = new JLabel("Study Pass");
    final JLabel lblNombre = new JLabel("Flashcards:");
    final FlashCard[] items = new FlashRepositoryImpl().findAll().toArray(new FlashCard[0]);
    final JList<FlashCard> list = new JList<>(items);
    final JToolBar tool = new JToolBar();


    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();

    public ShowCards() throws SQLException {

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setSize(600, 750);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        lblNombre.setFont(new Font("Courier New", Font.BOLD, 30));
        list.setPreferredSize(new Dimension(500,120 + items.length * 10));

        panel_1.add(Box.createVerticalStrut(50));
        panel_1.add(titulo);
        panel_2.add(lblNombre);
        panel_3.add(tool);
        panel_3.add(new JScrollPane(list));

        setVisible(true);
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
