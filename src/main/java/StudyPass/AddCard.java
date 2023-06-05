package StudyPass;

import javax.swing.*;
import java.awt.*;

public class AddCard extends JFrame{

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Pregunta  ");

    final JTextField txtNombre = new JTextField(50);

    JLabel lblRespuesta = new JLabel("Respuesta");

    JTextField txtRespuesta = new JTextField(50);

    String[] opciones = { "Matematicas", "Fisica y Quimica", "Castellano", "Ingles", "Programacion", "Historia" };

    final JComboBox<String> cmbLista = new JComboBox<String>(opciones);

    final JLabel lblEtiqueta = new JLabel("Asignatura: ");


    final JButton btnAdd = new JButton("Add");

    final JButton btnExit = new JButton("Exit");



    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();



    public AddCard() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        setSize(700, 600);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        btnAdd.setPreferredSize(new Dimension(250,50));
        btnExit.setPreferredSize(new Dimension(250,50));
        panel_1.add(Box.createVerticalStrut(30));
        panel_1.add(titulo);
        panel_2.add(lblNombre);
        txtNombre.setPreferredSize(new Dimension(70,70));
        panel_2.add(txtNombre);
        panel_2.add(lblRespuesta);
        txtRespuesta.setPreferredSize(new Dimension(70,70));
        panel_2.add(txtRespuesta);
        panel_3.add(Box.createVerticalStrut(80));
        panel_3.add(lblEtiqueta);
        panel_3.add(cmbLista);
        panel_4.add(btnAdd);
        panel_4.add(Box.createHorizontalStrut(100));
        panel_4.add(btnExit);




        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AddCard();
            }
        });
    }
}
