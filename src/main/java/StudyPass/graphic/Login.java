package StudyPass.graphic;

import StudyPass.code.User;
import StudyPass.code.UserRepositoryImpl;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Login extends JFrame{
    final JLabel titulo = new JLabel("Study Pass");
    final JButton iniciar_sesion = new JButton("Iniciar Sesion");
    final JButton registrarse = new JButton("Registrarse");

    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_3 = new JPanel();


    public Login() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_3);
        setSize(1960, 1080);
        setTitle("StudyPass");
        titulo.setFont(new Font("Courier New", Font.BOLD, 80));
        iniciar_sesion.setPreferredSize(new Dimension(450,250));
        iniciar_sesion.setFont(new Font("Courier New",Font.ITALIC,40));
        registrarse.setPreferredSize(new Dimension(450,250));
        registrarse.setFont(new Font("Courier New", Font.ITALIC, 40));
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(titulo);
        panel_3.add(iniciar_sesion);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(registrarse);
        panel_1.setBackground(Color.black);
        panel_3.setBackground(Color.black);

        iniciar_sesion.addActionListener((e) -> {
            try {
                login();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        });

        registrarse.addActionListener((e) -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Register();
                }
            });
        });

        setVisible(true);
    }

    public void login() throws SQLException {
        String user = JOptionPane.showInputDialog(null, "user");
        String password = JOptionPane.showInputDialog(null, "password");
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        for (User u : userRepository.findAll()) {
            if (user.equals(u.getUsername()) && password.equals(u.getPassword())) {
                JOptionPane.showMessageDialog(null, "login ok");
            } else {
                JOptionPane.showMessageDialog(null, "login failed");
            }
        }

    }



    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Login();
            }
        });
    }*/
}
