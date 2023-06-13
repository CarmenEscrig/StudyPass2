package StudyPass.graphic;

import StudyPass.tests.Jajajajajjajaj;

import javax.swing.*;
import java.awt.*;

public class Progress extends JFrame {

    StudyPass.code.Progress progress = Jajajajajjajaj.user.getProgress();

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Progreso:");

    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();
    final JPanel panel_4 = new JPanel();
    final JLabel correctas = new JLabel("Correctas: ");
    final JLabel incorrectas = new JLabel("Incorrectas: ");
    int[] total = {progress.getCorrect(),progress.getIncorrect()};

    final Grafica grafica = new Grafica(total);

    public Progress(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setSize(500,750);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        lblNombre.setFont(new Font("Courier New", Font.BOLD, 30));
        correctas.setFont(new Font("Courier New", Font.ITALIC, 20));
        incorrectas.setFont(new Font("Courier New", Font.ITALIC, 20));
        panel_1.add(Box.createVerticalStrut(50));
        panel_1.add(titulo);
        panel_2.add(lblNombre);
        panel_3.add(correctas);
        panel_4.add(incorrectas);
        panel.add(grafica);
        panel.add(Box.createVerticalStrut(80));
        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));
        panel_4.setBackground(new Color(242,247,255));


        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Progress();
            }
        });
    }

}
