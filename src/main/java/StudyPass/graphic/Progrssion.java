package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class Progrssion extends JFrame {

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Progreso");

    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();
    final Grafica grafica = new Grafica(new int[2]);

    public Progrssion(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setSize(700,600);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        panel_1.add(titulo);
        panel_2.add(lblNombre);
        panel_3.add(grafica);

    setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Progrssion();
            }
        });
    }

}
