package StudyPass.graphic;

import StudyPass.defcode.User;
import StudyPass.defcode.UserRepositoryImpl;
import StudyPass.Main;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;

public class Register extends JFrame{

    final JLabel lblTitulo = new JLabel("Study Pass");

    final JLabel lblNombre = new JLabel("Username");

    final JTextField textNombre = new JTextField(50);

    JLabel lblPassword = new JLabel("Password");

    JPasswordField textRespuesta = new JPasswordField(50);

    String[] opciones = { "Estudiante", "Profesor" };

    final JComboBox<String> cmbLista = new JComboBox<>(opciones);

    final JLabel lblEtiqueta = new JLabel("Tipo: ");


    final JLabel lblAsignatura = new JLabel("Seleccione sus asignaturas: ");

    final JToggleButton btnAsignatura_1 = new JToggleButton(Main.subjects.get(0).getName());
    final JToggleButton btnAsignatura_2 = new JToggleButton(Main.subjects.get(1).getName());

    final JToggleButton btnAsignatura_3 = new JToggleButton(Main.subjects.get(2).getName());

    final JToggleButton btnAsignatura_4 = new JToggleButton(Main.subjects.get(3).getName());

    final JToggleButton btnAsignatura_5 = new JToggleButton(Main.subjects.get(4).getName());

    final JToggleButton btnAsignatura_6 = new JToggleButton(Main.subjects.get(5).getName());
    final JButton btnRegister = new JButton("Register");




    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    final JPanel panel_2 = new JPanel();

    final JPanel panel_3 = new JPanel();

    final JPanel panel_4 = new JPanel();
    final JPanel panel_5 = new JPanel();
    final JPanel panel_6 = new JPanel();
    final JPanel panel_7 = new JPanel();
    final JPanel panel_8 = new JPanel();



    public Register() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        panel.add(panel_4);
        panel.add(panel_5);
        panel.add(panel_6);
        panel.add(panel_7);
        panel.add(panel_8);


        setSize(700, 1030);
        setTitle("StudyPass");
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 40));
        lblAsignatura.setPreferredSize(new Dimension(210,50));
        btnAsignatura_1.setPreferredSize(new Dimension(150,50));
        btnAsignatura_1.setBackground( new Color(187, 225, 251) );
        btnAsignatura_2.setPreferredSize(new Dimension(150,50));
        btnAsignatura_2.setBackground( new Color(187, 225, 251) );
        btnAsignatura_3.setPreferredSize(new Dimension(150,50));
        btnAsignatura_3.setBackground( new Color(187, 225, 251) );
        btnAsignatura_4.setPreferredSize(new Dimension(150,50));
        btnAsignatura_4.setBackground( new Color(187, 225, 251) );
        btnAsignatura_5.setPreferredSize(new Dimension(150,50));
        btnAsignatura_5.setBackground( new Color(187, 225, 251) );
        btnAsignatura_6.setPreferredSize(new Dimension(150,50));
        btnAsignatura_6.setBackground( new Color(187, 225, 251) );
        btnRegister.setPreferredSize(new Dimension(150,70));
        btnRegister.setBackground( new Color(187, 225, 251) );
        panel_1.add(Box.createVerticalStrut(30));
        panel_1.add(lblTitulo);
        panel_2.add(lblAsignatura);
        panel_3.add(lblNombre);
        textNombre.setPreferredSize(new Dimension(70,70));
        panel_3.add(textNombre);
        panel_3.add(lblPassword);
        textRespuesta.setPreferredSize(new Dimension(70,70));
        panel_3.add(textRespuesta);
        panel_4.add(lblEtiqueta);
        panel_4.add(cmbLista);
        panel_5.add(lblAsignatura);
        panel_6.add(btnAsignatura_1);
        panel_6.add(btnAsignatura_2);
        panel_6.add(btnAsignatura_3);
        panel_7.add(btnAsignatura_4);
        panel_7.add(btnAsignatura_5);
        panel_7.add(btnAsignatura_6);
        panel_8.add(btnRegister);

        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));
        panel_4.setBackground(new Color(242,247,255));
        panel_5.setBackground(new Color(242,247,255));
        panel_6.setBackground(new Color(242,247,255));
        panel_7.setBackground(new Color(242,247,255));
        panel_8.setBackground(new Color(242,247,255));

        btnRegister.addActionListener((e) -> {
            registUser();
            setVisible(false);
        });

        setVisible(true);

    }

    public void registUser() {
        String username = textNombre.getText();
        String password = Arrays.toString(textRespuesta.getPassword());
        String type = cmbLista.getSelectedItem().toString().toLowerCase();
        User user = new User(username, password, type);

        if (btnAsignatura_1.isSelected()) {
            user.addSubject(Main.subjects.get(0));
            btnAsignatura_1.setSelected(false);
        }
        if (btnAsignatura_2.isSelected()) {
            user.addSubject(Main.subjects.get(1));
            btnAsignatura_2.setSelected(false);
        }
        if (btnAsignatura_3.isSelected()) {
            user.addSubject(Main.subjects.get(2));
            btnAsignatura_3.setSelected(false);
        }
        if (btnAsignatura_4.isSelected()) {
            user.addSubject(Main.subjects.get(3));
            btnAsignatura_4.setSelected(false);
        }
        if (btnAsignatura_5.isSelected()) {
            user.addSubject(Main.subjects.get(4));
            btnAsignatura_5.setSelected(false);
        }
        if (btnAsignatura_6.isSelected()) {
            user.addSubject(Main.subjects.get(5));
            btnAsignatura_6.setSelected(false);
        }

        try {
            UserRepositoryImpl userRepository = new UserRepositoryImpl();
            userRepository.save(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
