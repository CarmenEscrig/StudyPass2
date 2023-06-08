package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class ShowCard extends JFrame {

    final JLabel titulo = new JLabel("Study Pass");
    final JLabel lblNombre = new JLabel("Flashcards:");
    final String[] items = {};
    final JList<String> list = new JList<>(items);
    final JToolBar tool = new JToolBar();


    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();

    public ShowCard() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setSize(600, 750);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        lblNombre.setFont(new Font("Courier New", Font.BOLD, 30));
        list.setPreferredSize(new Dimension(500,600));

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
                new ShowCard();
            }
        });
    }
}
