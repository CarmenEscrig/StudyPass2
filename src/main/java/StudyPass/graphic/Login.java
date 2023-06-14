package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class Login extends JFrame {
    final JLabel lblNombre = new JLabel("Username");

    final JTextField textNombre = new JTextField(15);

    JLabel lblPassword = new JLabel("Password");

    JPasswordField textRespuesta = new JPasswordField(15);

    final JButton btnRegister = new JButton("Iniciar Sesion");
    final Container panel = getContentPane();

    final JPanel panel_1 = new JPanel();

    public Login() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        setSize(300, 125);
        setTitle("StudyPass");
        panel_1.add(lblNombre);
        panel_1.add(textNombre);
        panel_1.add(lblPassword);
        panel_1.add(textRespuesta);
        panel_1.add(btnRegister);
        setVisible(true);
    }


}
