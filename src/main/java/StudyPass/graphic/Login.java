package StudyPass.graphic;

import StudyPass.defcode.User;
import StudyPass.defcode.UserRepositoryImpl;
import StudyPass.Main;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;

public class Login extends JFrame {
    final JLabel lblNombre = new JLabel("Username");

    final JTextField textNombre = new JTextField(15);

    JLabel lblPassword = new JLabel("Password");

    JPasswordField textRespuesta = new JPasswordField(15);

    final JButton btnIniciarSesion = new JButton("Iniciar Sesion");
    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    public Login() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        setSize(300, 125);
        setTitle("StudyPass");
        panel.setBackground(new Color(242,247,255));
        btnIniciarSesion.setBackground( new Color(187, 225, 251) );
        panel_1.add(lblNombre);
        panel_1.add(textNombre);
        panel_1.add(lblPassword);
        panel_1.add(textRespuesta);
        panel_1.add(btnIniciarSesion);

        btnIniciarSesion.addActionListener((e) -> {
            try {
                login();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


        setVisible(true);
    }

    public void login() throws SQLException {
        String user = textNombre.getText();
        String password = Arrays.toString(textRespuesta.getPassword());
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        for (User u : userRepository.findAll()) {
            if (user.equals(u.getUsername()) && password.equals(u.getPassword())) {
                JOptionPane.showMessageDialog(null, "login ok");
                Main.user = u;
                if (u.getType().equals("estudiante")) {
                    SwingUtilities.invokeLater(StudentMain::new);
                } else {
                    SwingUtilities.invokeLater(ProfessorMain::new);
                }
                setVisible(false);
                break;
            }
        }
        if (isVisible()) {
            JOptionPane.showMessageDialog(null, "login failed");
        }
    }

}
