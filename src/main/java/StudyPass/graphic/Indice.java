package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class Indice extends JFrame {
    final JLabel lblTitulo = new JLabel("Study Pass");
    final JButton btnIniciarSesion = new JButton("Iniciar Sesion");
    final JButton btnRegistrarse = new JButton("Registrarse");

    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_3 = new JPanel();


    public Indice() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_3);
        setSize(1960, 1080);
        setTitle("StudyPass");
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 80));
        btnIniciarSesion.setPreferredSize(new Dimension(450, 250));
        btnIniciarSesion.setBackground( new Color(187, 225, 251) );
        btnIniciarSesion.setFont(new Font("Courier New", Font.ITALIC, 40));
        btnRegistrarse.setPreferredSize(new Dimension(450, 250));
        btnRegistrarse.setFont(new Font("Courier New", Font.ITALIC, 40));
        btnRegistrarse.setBackground( new Color(187, 225, 251) );
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(lblTitulo);
        panel_3.add(btnIniciarSesion);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(btnRegistrarse);
        panel_1.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));

        btnIniciarSesion.addActionListener((e) -> SwingUtilities.invokeLater(Login::new));

        btnRegistrarse.addActionListener((e) -> SwingUtilities.invokeLater(Register::new));

        setVisible(true);
    }

}
