package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ProfessorMain extends JFrame {
    final JLabel lblTitulo = new JLabel("Study Pass");
    final JButton btnAddCard = new JButton("Añadir tarjetas");
    final JButton btnShowCards = new JButton("Ver Tarjetas");
    final JButton btnShowStudents = new JButton("Ver Alumnos");

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
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 80));
        btnShowCards.setPreferredSize(new Dimension(450,250));
        btnShowCards.setFont(new Font("Courier New",Font.ITALIC,40));
        btnShowCards.setBackground( new Color(187, 225, 251) );
        btnAddCard.setPreferredSize(new Dimension(1265,350));
        btnAddCard.setFont(new Font("Courier New",Font.ITALIC,40));
        btnAddCard.setBackground( new Color(187, 225, 251) );
        btnShowStudents.setPreferredSize(new Dimension(450,250));
        btnShowStudents.setFont(new Font("Courier New", Font.ITALIC, 40));
        btnShowStudents.setBackground( new Color(187, 225, 251) );
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(lblTitulo);
        panel_2.add(btnAddCard);
        panel_3.add(btnShowCards);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(btnShowStudents);
        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));

        btnAddCard.addActionListener((e) -> SwingUtilities.invokeLater(AddCard::new));

        btnShowCards.addActionListener((e) -> SwingUtilities.invokeLater(() -> {
            try {
                new ShowCards();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }));

        btnShowStudents.addActionListener((e) -> SwingUtilities.invokeLater(() -> {
            try {
                new ShowStudents();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }));


        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProfessorMain::new);
    }
}
