package StudyPass.graphic;

import StudyPass.defcode.FlashCard;
import StudyPass.defcode.FlashRepositoryImpl;
import StudyPass.defcode.Subject;
import StudyPass.Main;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class SolutionCard extends JFrame{
    private int cont = 4;
    FlashRepositoryImpl flashRepository = new FlashRepositoryImpl();

    FlashCard flashCard;

    final JLabel lblTitulo = new JLabel("Study Pass");

    final JLabel jLabQuestion = new JLabel("Pregunta: ");

    final JLabel jLabQuestionText = new JLabel();

    final JLabel jLabYourAnswer = new JLabel("Your Answer: ");

    final JTextField textRespuesta = new JTextField(50);

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
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 40));

        btnShowAnswer.setPreferredSize(new Dimension(150,40));
        btnShowAnswer.setBackground( new Color(187, 225, 251) );
        btnCorrect.setPreferredSize(new Dimension(150,40));
        btnCorrect.setBackground( new Color(187, 225, 251) );
        btnIncorrect.setPreferredSize(new Dimension(150,40));
        btnIncorrect.setBackground( new Color(187, 225, 251) );


        panel_1.add(Box.createVerticalStrut(30));
        panel_1.add(lblTitulo);
        panel_1.setBackground(new Color(242,247,255));

        panel_2.add(lblEtiqueta);
        panel_2.add(cmbLista);
        panel_2.setBackground(new Color(242,247,255));

        panel_3.add(jLabQuestion);
        panel_3.add(jLabQuestionText);
        panel_3.setBackground(new Color(242,247,255));

        panel_4.add(jLabYourAnswer);
        textRespuesta.setPreferredSize(new Dimension(70,70));
        panel_4.add(textRespuesta);
        panel_4.setBackground(new Color(242,247,255));

        panel_5.add(jLabAnswer);
        panel_5.add(jLabAnswerText);
        panel_5.setBackground(new Color(242,247,255));
        jLabAnswer.setVisible(false);
        jLabAnswerText.setVisible(false);

        panel_6.add(btnCorrect);
        panel_6.add(btnShowAnswer);
        panel_6.add(btnIncorrect);
        btnCorrect.setVisible(false);
        btnIncorrect.setVisible(false);
        panel_6.setBackground(new Color(242,247,255));


        btnShowAnswer.addActionListener((e) -> {
            btnShowAnswer.setVisible(false);
            jLabAnswer.setVisible(true);
            jLabAnswerText.setVisible(true);
            btnCorrect.setVisible(true);
            btnIncorrect.setVisible(true);
        });

        btnCorrect.addActionListener((e) -> {
            Main.user.getProgress().increaseCorrect();
            if (cont == 0) {
                setVisible(false);
            } else {
                cont --;
                btnCorrect.setVisible(false);
                btnIncorrect.setVisible(false);
                btnShowAnswer.setVisible(true);
                jLabAnswer.setVisible(false);
                jLabAnswerText.setVisible(false);
                try {
                    changeFlash();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                btnShowAnswer.setVisible(true);
            }
        });

        btnIncorrect.addActionListener((e) -> {
            Main.user.getProgress().increaseIncorrect();
            if (cont == 0) {
                setVisible(false);
            } else {
                cont --;
                btnCorrect.setVisible(false);
                btnIncorrect.setVisible(false);
                btnShowAnswer.setVisible(true);
                jLabAnswer.setVisible(false);
                jLabAnswerText.setVisible(false);
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
            for(Subject s : Main.user.getSubjects()) {
                if (flashCard.getSubject().getId() == s.getId()) {
                    esAsignatura = true;
                    break;
                }
            }
        } while (!esAsignatura);

        jLabQuestionText.setText(flashCard.getQuestion());

        cmbLista.setText(flashCard.getSubject().getName());

        jLabAnswerText.setText(flashCard.getAnswer());

    }



}
