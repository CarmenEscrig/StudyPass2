package StudyPass;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame{

    final JLabel titulo = new JLabel("Study Pass");

    final JLabel lblTitulo = new JLabel("Registrarse"); //

    final JLabel lblNombre = new JLabel("Username");

    final JTextField txtNombre = new JTextField(50);

    JLabel lblRespuesta = new JLabel("Password");

    JTextField txtRespuesta = new JTextField(50);

    String[] opciones = { "Estudiante", "Profesor" };

    final JComboBox<String> cmbLista = new JComboBox<String>(opciones);

    final JLabel lblEtiqueta = new JLabel("Tipo: ");


    final JLabel lblAsignatura = new JLabel("Seleccione sus asignaturas: ");

    final JButton btnAsignatura_1 = new JButton("Matematicas");
    final JButton btnAsignatura_2 = new JButton("Fisica y Quimica");

    final JButton btnAsignatura_3 = new JButton("Castellano");

    final JButton btnAsignatura_4 = new JButton("Ingles");

    final JButton btnAsignatura_5 = new JButton("Programacion");

    final JButton btnAsignatura_6 = new JButton("Historia");




    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();
    final JPanel panel_5 = new JPanel();
    final JPanel panel_6 = new JPanel();




    public Register() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        panel.add(panel_5);
        panel.add(panel_6);

        setSize(700, 600);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 40));
        lblAsignatura.setPreferredSize(new Dimension(250,50));
        btnAsignatura_2.setPreferredSize(new Dimension(250,50));
        panel_1.add(Box.createVerticalStrut(30));
        panel_1.add(titulo);
        panel_5.add(lblAsignatura);
        panel_2.add(lblNombre);
        txtNombre.setPreferredSize(new Dimension(70,70));
        panel_2.add(txtNombre);
        panel_2.add(lblRespuesta);
        txtRespuesta.setPreferredSize(new Dimension(70,70));
        panel_2.add(txtRespuesta);
        panel_3.add(Box.createVerticalStrut(80));
        panel_3.add(lblEtiqueta);
        panel_3.add(cmbLista);
        panel_4.add(lblAsignatura);
        panel_4.add(Box.createHorizontalStrut(100));
        panel_4.add(btnAsignatura_2);
        panel_6.add(lblAsignatura);




        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Register();
            }
        });
    }
}
