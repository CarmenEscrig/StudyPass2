package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class ShowAnswerCard extends JFrame{

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Pregunta      ");

    final JTextField txtNombre = new JTextField(50);

    final JLabel lblRespuesta = new JLabel("Your Answer");

    final JTextField txtRespuesta = new JTextField(50);

    final JLabel lblShow = new JLabel("Answer         ");

    final JTextField txtShow = new JTextField(50);


    final JLabel cmbLista = new JLabel("");

    final JLabel lblEtiqueta = new JLabel("Asignatura: ");


    final JButton btnCorrect = new JButton("Correct");
    final JButton btnIncorrect = new JButton("Incorrect");




    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();



    public ShowAnswerCard() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        setSize(700, 850);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        btnCorrect.setPreferredSize(new Dimension(150,40));
        btnIncorrect.setPreferredSize(new Dimension(150,40));
        panel_1.add(Box.createVerticalStrut(30));
        panel_1.add(titulo);
        panel_3.add(lblNombre);
        txtNombre.setPreferredSize(new Dimension(70,70));
        panel_3.add(txtNombre);
        panel_3.add(lblRespuesta);
        txtRespuesta.setPreferredSize(new Dimension(70,70));
        panel_3.add(txtRespuesta);
        panel_2.add(lblEtiqueta);
        panel_2.add(cmbLista);
        panel_3.add(lblShow);
        txtShow.setPreferredSize(new Dimension(70,70));
        panel_3.add(txtShow);
        panel_4.add(btnCorrect);
        panel_4.add(Box.createHorizontalStrut(150));
        panel_4.add(btnIncorrect);




        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ShowAnswerCard();
            }
        });
    }
}
