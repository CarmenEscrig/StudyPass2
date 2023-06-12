package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ProfessorMain extends JFrame {
    final JLabel titulo = new JLabel("Study Pass");
    final JButton addCard = new JButton("Añadir tarjetas");
    final JButton showCards = new JButton("Ver Tarjetas");
    final JButton showStudents = new JButton("Ver Alumnos");

    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();


    public ProfessorMain() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setSize(1960, 1080);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 80));
        showCards.setPreferredSize(new Dimension(450,250));
        showCards.setFont(new Font("Courier New",Font.ITALIC,40));
        addCard.setPreferredSize(new Dimension(1265,350));
        addCard.setFont(new Font("Courier New",Font.ITALIC,40));
        showStudents.setPreferredSize(new Dimension(450,250));
        showStudents.setFont(new Font("Courier New", Font.ITALIC, 40));
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(titulo);
        panel_2.add(addCard);
        panel_3.add(showCards);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(showStudents);
        panel_1.setBackground(Color.black);
        panel_2.setBackground(Color.black);
        panel_3.setBackground(Color.black);

        addCard.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new AddCard();
                }
            });
        });

        showCards.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new ShowStudents();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        });

        showStudents.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Progress();
                }
            });
        });


        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ProfessorMain();
            }
        });
    }
}
