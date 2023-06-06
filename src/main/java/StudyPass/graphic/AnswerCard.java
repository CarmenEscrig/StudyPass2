package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class AnswerCard extends JFrame{

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Pregunta  ");

    final JTextField txtNombre = new JTextField(50);

    JLabel lblRespuesta = new JLabel("Respuesta");

    JTextField txtRespuesta = new JTextField(50);


    final JLabel cmbLista = new JLabel("");

    final JLabel lblEtiqueta = new JLabel("Asignatura: ");


    final JButton btnShowAnswer = new JButton("Show answer");




    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();



    public AnswerCard() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        setSize(700, 600);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        btnShowAnswer.setPreferredSize(new Dimension(150,40));
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
        panel_4.add(btnShowAnswer);




        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AnswerCard();
            }
        });
    }
}
