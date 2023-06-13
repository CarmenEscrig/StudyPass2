package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class StudentMain extends JFrame {
    final JLabel lblTitulo = new JLabel("Study Pass");
    final JButton btnEstudiar = new JButton("Empezar a estudiar");
    final JButton btnTarjeta = new JButton("Ver Tarjetas");
    final JButton btnProgreso = new JButton("Ver Progreso");

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
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 80));
        btnTarjeta.setPreferredSize(new Dimension(450,250));
        btnTarjeta.setFont(new Font("Courier New",Font.ITALIC,40));
        btnTarjeta.setBackground( new Color(187, 225, 251) );
        btnEstudiar.setPreferredSize(new Dimension(1265,350));
        btnEstudiar.setFont(new Font("Courier New",Font.ITALIC,40));
        btnEstudiar.setBackground( new Color(187, 225, 251) );
        btnProgreso.setPreferredSize(new Dimension(450,250));
        btnProgreso.setFont(new Font("Courier New", Font.ITALIC, 40));
        btnProgreso.setBackground( new Color(187, 225, 251) );
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(lblTitulo);
        panel_2.add(btnEstudiar);
        panel_3.add(btnTarjeta);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(btnProgreso);
        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));

        btnEstudiar.addActionListener((e) -> {
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

        btnTarjeta.addActionListener((e) -> {
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

        btnProgreso.addActionListener((e) -> {
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
