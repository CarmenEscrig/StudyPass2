package StudyPass;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Principal extends JFrame {
    final JLabel titulo = new JLabel("Study Pass");
    final JButton estudiar = new JButton("Empezar a estudiar");
    final JButton tarjeta = new JButton("Ver Tarjeta");
    final JButton progreso = new JButton("Ver Progreso");

    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();


    public Principal() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setSize(350, 250);
        setTitle("StudyPass");
        tarjeta.setPreferredSize(new Dimension(500,250));
        estudiar.setPreferredSize(new Dimension(450,350));
        progreso.setPreferredSize(new Dimension(450,250));
        panel_1.add(titulo);
        panel_2.add(estudiar);
        panel_3.add(tarjeta);
        panel_3.add(progreso);

        panel_3.setBackground(Color.blue);


        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Principal();
            }
        });
    }
}
