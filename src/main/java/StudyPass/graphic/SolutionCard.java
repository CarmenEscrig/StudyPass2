package StudyPass.graphic;

import StudyPass.code.FlashCard;
import StudyPass.code.FlashRepositoryImpl;
import StudyPass.code.Subject;
import StudyPass.tests.Jajajajajjajaj;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class SolutionCard extends JFrame{
    private int cont = 10;
    FlashRepositoryImpl flashRepository = new FlashRepositoryImpl();

    FlashCard flashCard;

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel jLabQuestion = new JLabel("Pregunta: ");

    final JLabel jLabQuestionText = new JLabel();

    final JLabel jLabYourAnswer = new JLabel("Your Answer: ");

    final JTextField txtRespuesta = new JTextField(50);

    final JLabel jLabAnswer = new JLabel("Answer: ");

    final JLabel jLabAnswerText = new JLabel();


    final JLabel cmbLista = new JLabel("");

    final JLabel lblEtiqueta = new JLabel("Asignatura: ");


    final JButton btnShowAnswer = new JButton("Show answer");


    final JButton btnCorrect = new JButton("Correct");
    final JButton btnIncorrect = new JButton("Incorrect");




    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();
    final JPanel panel_5 = new JPanel();

    final JPanel panel_6 = new JPanel();




    public SolutionCard() throws SQLException {

        flashRepository.resetNumbers();
        changeFlash();


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        panel.add(panel_5);
        panel.add(panel_6);

        setSize(700, 850);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));

        btnShowAnswer.setPreferredSize(new Dimension(150,40));
        btnShowAnswer.setBackground( new Color(187, 225, 251) );
        btnCorrect.setPreferredSize(new Dimension(150,40));
        btnCorrect.setBackground( new Color(187, 225, 251) );
        btnIncorrect.setPreferredSize(new Dimension(150,40));
        btnIncorrect.setBackground( new Color(187, 225, 251) );


        panel_1.add(Box.createVerticalStrut(30));
        panel_1.add(titulo);

        panel_2.add(lblEtiqueta);
        panel_2.add(cmbLista);

        panel_3.add(jLabQuestion);
        panel_3.add(jLabQuestionText);

        panel_4.add(jLabYourAnswer);
        txtRespuesta.setPreferredSize(new Dimension(70,70));
        panel_4.add(txtRespuesta);


        panel_6.add(btnShowAnswer);

        btnShowAnswer.addActionListener((e) -> {
            btnShowAnswer.setVisible(false);
            panel_5.add(jLabAnswer);
            panel_5.add(jLabAnswerText);
            panel_6.add(btnCorrect);
            panel_6.add(Box.createHorizontalStrut(150));
            panel_6.add(btnIncorrect);
        });

        btnCorrect.addActionListener((e) -> {
            if (cont == 0) {
                setVisible(false);
            } else {
                cont --;
                Jajajajajjajaj.user.getProgress().increaseCorrect();
                btnCorrect.setVisible(false);
                btnIncorrect.setVisible(false);
                panel_5.remove(jLabAnswer);
                panel_5.remove(jLabAnswerText);
                panel_6.remove(btnCorrect);
                panel_6.remove(btnIncorrect);
                try {
                    changeFlash();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                btnShowAnswer.setVisible(true);
            }
        });

        btnIncorrect.addActionListener((e) -> {
            if (cont == 0) {
                setVisible(false);
            } else {
                cont --;
                Jajajajajjajaj.user.getProgress().increaseIncorrect();
                btnCorrect.setVisible(false);
                btnIncorrect.setVisible(false);
                panel_5.remove(jLabAnswer);
                panel_5.remove(jLabAnswerText);
                panel_6.remove(btnCorrect);
                panel_6.remove(btnIncorrect);
                try {
                    changeFlash();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                btnShowAnswer.setVisible(true);
            }
        });


        setVisible(true);
    }

    public void changeFlash() throws SQLException {
        boolean esAsignatura = false;

        do {
            flashCard = flashRepository.randomCard();
            for(Subject s : Jajajajajjajaj.user.getSubjects()) {
                if (flashCard.getSubject() == s) {
                    esAsignatura = true;
                    break;
                }
            }
        } while (esAsignatura == false);

        jLabQuestionText.setText(flashCard.getQuestion());

        cmbLista.setText(flashCard.getSubject().getName());

        jLabAnswerText.setText(flashCard.getAnswer());

    }



}
