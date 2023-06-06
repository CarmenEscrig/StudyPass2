package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class Progrssion extends JFrame {

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Progreso:");

    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    int[] gjyu = {1,1};
    final Grafica grafica = new Grafica(gjyu);

    public Progrssion(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setSize(700,600);
        panel.add(panel_1);
        panel.add(panel_2);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        panel_1.add(titulo);
        panel_2.add(lblNombre);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(grafica);
        panel.add(Box.createVerticalStrut(80));


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
