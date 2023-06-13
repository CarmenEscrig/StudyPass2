package StudyPass.graphic;

import StudyPass.code.FlashCard;
import StudyPass.code.FlashRepositoryImpl;
import StudyPass.code.Subject;
import StudyPass.tests.Jajajajajjajaj;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowCards extends JFrame {

    final JLabel titulo = new JLabel("Study Pass");
    final JLabel lblNombre = new JLabel("Flashcards:");
    FlashCard[] items;
    final JList<FlashCard> list;
    final JToolBar tool = new JToolBar();


    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();

    public ShowCards() throws SQLException {

        ArrayList<FlashCard> flashCards = new ArrayList<>();
        for (Subject s : Jajajajajjajaj.user.getSubjects()) {
            flashCards.addAll(new FlashRepositoryImpl().findBySubject(s));
        }

        items = flashCards.toArray(new FlashCard[0]);

        list = new JList<>(items);


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
        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));

        setVisible(true);
    }

}
