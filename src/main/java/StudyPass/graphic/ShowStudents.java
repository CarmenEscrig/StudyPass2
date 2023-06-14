package StudyPass.graphic;

import StudyPass.defcode.Subject;
import StudyPass.defcode.User;
import StudyPass.defcode.UserRepositoryImpl;
import StudyPass.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ShowStudents extends JFrame {

    final JLabel lblTitulo = new JLabel("Study Pass");
    final JLabel lblNombre = new JLabel("Estudiantes:");
    String[] names = {"ID" , "Username" , "Correctas", "Incorrectas"};

    DefaultTableModel tableModel = new DefaultTableModel(names, 0);

    JTable table = new JTable(tableModel);
    final JToolBar tool = new JToolBar();


    final Container panel = getContentPane();
    final JPanel panel_1 = new JPanel();
    final JPanel panel_2 = new JPanel();
    final JPanel panel_3 = new JPanel();

    public ShowStudents() throws SQLException {

        completeTable();

        table.setPreferredScrollableViewportSize(new Dimension(550, 100));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setSize(600, 750);
        panel.add(panel_1);
        panel.add(panel_2);
        panel.add(panel_3);
        setTitle("StudyPass");
        lblTitulo.setFont(new Font("Courier New", Font.BOLD, 40));
        lblNombre.setFont(new Font("Courier New", Font.BOLD, 30));

        panel_1.add(Box.createVerticalStrut(50));
        panel_1.add(lblTitulo);
        panel_2.add(lblNombre);
        panel_3.add(tool);
        panel_3.add(new JScrollPane(table));
        panel_1.setBackground(new Color(242,247,255));
        panel_2.setBackground(new Color(242,247,255));
        panel_3.setBackground(new Color(242,247,255));

        setVisible(true);
    }

    public void completeTable() throws SQLException {

        boolean add = true;

        for (Subject s : Main.user.getSubjects()) {
            for (User u : new UserRepositoryImpl().findBySubject(s)) {
                if (u.getType().equals("estudiante")) {
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 0).equals(u.getId())) {
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        Object[] newRow = {u.getId(), u.getUsername(), u.getProgress().getCorrect(), u.getProgress().getIncorrect()};
                        tableModel.addRow(newRow);
                    }
                }
            }
        }
    }

}
