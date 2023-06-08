package StudyPass.graphic;

import StudyPass.code.FlashCard;
import StudyPass.code.FlashRepositoryImpl;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class AnswerCard extends JFrame{

    FlashRepositoryImpl flashRepository = new FlashRepositoryImpl();

    FlashCard flashCard;

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Pregunta:  ");

    final JLabel txtNombre = new JLabel();

    JLabel lblRespuesta = new JLabel("Respuesta: ");

    JTextField txtRespuesta = new JTextField(50);


    final JLabel cmbLista = new JLabel();

    final JLabel lblEtiqueta = new JLabel("Asignatura: ");


    final JButton btnShowAnswer = new JButton("Show answer");


    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();

    final JPanel panel_5 = new JPanel();



    public AnswerCard() throws SQLException {

        flashRepository.resetNumbers();
        flashCard = flashRepository.randomCard();

        txtNombre.setText(flashCard.getQuestion());


        cmbLista.setText(flashCard.getSubject().getName());

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_5);
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
        panel_5.add(lblRespuesta);
        txtRespuesta.setPreferredSize(new Dimension(70,70));
        panel_5.add(txtRespuesta);
        panel_2.add(lblEtiqueta);
        panel_2.add(cmbLista);
        panel_4.add(btnShowAnswer);

        btnShowAnswer.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new SolutionCard();
                }
            });
        });




        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new AnswerCard();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
