package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    final JLabel titulo = new JLabel("Study Pass");
    final JButton tarjeta = new JButton("Iniciar Sesion");
    final JButton progreso = new JButton("Registrarse");

    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_3 = new JPanel();


    public Login() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_3);
        setSize(1960, 1080);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 80));
        tarjeta.setPreferredSize(new Dimension(450,250));
        tarjeta.setFont(new Font("Courier New",Font.ITALIC,40));
        progreso.setPreferredSize(new Dimension(450,250));
        progreso.setFont(new Font("Courier New", Font.ITALIC, 40));
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(titulo);
        panel_3.add(tarjeta);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(progreso);
        panel_1.setBackground(Color.black);
        panel_3.setBackground(Color.black);


        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Login();
            }
        });
    }
}
