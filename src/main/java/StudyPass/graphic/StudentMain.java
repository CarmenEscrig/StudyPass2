package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class StudentMain extends JFrame {
    final JLabel titulo = new JLabel("Study Pass");
    final JButton estudiar = new JButton("Empezar a estudiar");
    final JButton tarjeta = new JButton("Ver Tarjetas");
    final JButton progreso = new JButton("Ver Progreso");

    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();


    public StudentMain() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setSize(1960, 1080);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 80));
        tarjeta.setPreferredSize(new Dimension(450,250));
        tarjeta.setFont(new Font("Courier New",Font.ITALIC,40));
        estudiar.setPreferredSize(new Dimension(1265,350));
        estudiar.setFont(new Font("Courier New",Font.ITALIC,40));
        progreso.setPreferredSize(new Dimension(450,250));
        progreso.setFont(new Font("Courier New", Font.ITALIC, 40));
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(titulo);
        panel_2.add(estudiar);
        panel_3.add(tarjeta);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(progreso);
        panel_1.setBackground(Color.black);
        panel_2.setBackground(Color.black);
        panel_3.setBackground(Color.black);

        estudiar.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new SolutionCard();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        });

        tarjeta.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new ShowCards();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        });

        progreso.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Progress();
                }
            });
        });

        setVisible(true);
    }
}
