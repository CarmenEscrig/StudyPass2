package StudyPass.graphic;

import StudyPass.defcode.FlashCard;
import StudyPass.defcode.FlashRepositoryImpl;
import StudyPass.tests.Jajajajajjajaj;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class AddCard extends JFrame{

    final JLabel lblTitulo = new JLabel("Study Pass");

    final JLabel lblPregunta = new JLabel("Pregunta  ");

    final JTextField textNombre = new JTextField(50);

    JLabel lblRespuesta = new JLabel("Respuesta");

    JTextField textRespuesta = new JTextField(50);

    String[] opciones = new String[Jajajajajjajaj.subjects.size()];

    final JComboBox<String> cmbLista;

    final JLabel lblEtiqueta = new JLabel("Asignatura: ");


    final JButton btnAdd = new JButton("Add");

    final JButton btnExit = new JButton("Exit");



    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();



    public AddCard() {

        for (int i = 0; i < opciones.length; i++) {
            opciones[i] = Jajajajajjajaj.subjects.get(i).getName();
        }

        cmbLista = new JComboBox<>(opciones);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        setSize(700, 600);
        setTitle("StudyPass");
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 40));
        btnAdd.setPreferredSize(new Dimension(250,50));
        btnAdd.setBackground( new Color(187, 225, 251) );
        btnExit.setPreferredSize(new Dimension(250,50));
        btnExit.setBackground( new Color(187, 225, 251) );
        panel_1.add(Box.createVerticalStrut(30));
        panel_1.add(lblTitulo);
        panel_2.add(lblPregunta);
        textNombre.setPreferredSize(new Dimension(70,70));
        panel_2.add(textNombre);
        panel_2.add(lblRespuesta);
        textRespuesta.setPreferredSize(new Dimension(70,70));
        panel_2.add(textRespuesta);
        panel_3.add(Box.createVerticalStrut(80));
        panel_3.add(lblEtiqueta);
        panel_3.add(cmbLista);
        panel_4.add(btnAdd);
        panel_4.add(Box.createHorizontalStrut(100));
        panel_4.add(btnExit);
        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));
        panel_4.setBackground(new Color(242,247,255));


        btnAdd.addActionListener((e) -> {
            FlashRepositoryImpl flashRepository = new FlashRepositoryImpl();
            FlashCard flashCard = new FlashCard(textNombre.getText(), textRespuesta.getText());
            for (int i = 0; i < Jajajajajjajaj.subjects.size(); i++) {
                if (Jajajajajjajaj.subjects.get(i).getName().equals(cmbLista.getSelectedItem())) {
                    flashCard.setSubject(Jajajajajjajaj.subjects.get(i));
                    break;
                }
            }
            try {
                flashRepository.save(flashCard);
                JOptionPane.showMessageDialog(null, "Flashcard añadida con exito");
            } catch (SQLException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }

            textNombre.setText("");
            textRespuesta.setText("");

        });

        btnExit.addActionListener((e) -> setVisible(false));


        setVisible(true);
    }

}
