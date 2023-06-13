package StudyPass.graphic;

import StudyPass.code.User;
import StudyPass.code.UserRepositoryImpl;
import StudyPass.tests.Jajajajajjajaj;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Indice extends JFrame {
    final JLabel lblTitulo = new JLabel("Study Pass");
    final JButton btnIniciarSesion = new JButton("Iniciar Sesion");
    final JButton btnRegistrarse = new JButton("Registrarse");

    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_3 = new JPanel();


    public Indice() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panel_1);
        panel.add(panel_3);
        setSize(1960, 1080);
        setTitle("StudyPass");
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 80));
        btnIniciarSesion.setPreferredSize(new Dimension(450, 250));
        btnIniciarSesion.setBackground( new Color(187, 225, 251) );
        btnIniciarSesion.setFont(new Font("Courier New", Font.ITALIC, 40));
        btnRegistrarse.setPreferredSize(new Dimension(450, 250));
        btnRegistrarse.setFont(new Font("Courier New", Font.ITALIC, 40));
        btnRegistrarse.setBackground( new Color(187, 225, 251) );
        panel_1.add(Box.createVerticalStrut(150));
        panel_1.add(lblTitulo);
        panel_3.add(btnIniciarSesion);
        panel_3.add(Box.createHorizontalStrut(350));
        panel_3.add(btnRegistrarse);
        panel_1.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));

        btnIniciarSesion.addActionListener((e) -> {
            try {
                login();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        });

        btnRegistrarse.addActionListener((e) -> {
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
                Jajajajajjajaj.user = u;
                if (u.getType().equals("estudiante")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new StudentMain();
                        }
                    });
                } else {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new ProfessorMain();
                        }
                    });
                }
                setVisible(false);
                break;
            }
            JOptionPane.showMessageDialog(null, "login failed");


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
}
