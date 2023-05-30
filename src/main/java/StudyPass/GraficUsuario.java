package StudyPass;

import javax.swing.JOptionPane;

public class GraficUsuario {
    public static void main(String[] args) {
        String user = JOptionPane.showInputDialog(null, "user");
        String password = JOptionPane.showInputDialog(null, "password");
        if (user.equals("juan") && password.equals("juan")) {
            JOptionPane.showMessageDialog(null, "login ok");
        }else if(user.equals("pablo") && password.equals("pablo")) {
            JOptionPane.showMessageDialog(null, "login ok");
        }else {
            JOptionPane.showMessageDialog(null, "login failed");
        }
    }
}

