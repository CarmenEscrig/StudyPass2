package StudyPass.tests;

import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class sd extends JFrame {

    String[] names = {"Nombre", "Apellido"};
    Object[][] hjasfjipjioasdfjp = {
            {"Pepe", "sihfioi"}
    };
    DefaultTableModel tableModel = new DefaultTableModel(hjasfjipjioasdfjp, names);
    JTable table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);

    public sd() {

        setTitle("DATOS");
        setSize(300, 200);

        JLabel lblNombre = new JLabel("Nombre");

        JTextField txtNombre = new JTextField(18);

        JLabel lblEdad = new JLabel("Edad");

        JTextField txtEdad = new JTextField(10);

        Container contentpane = getContentPane();

        JPanel panel = new JPanel();

        //Añadir los controles al panel
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblEdad);
        panel.add(txtEdad);
        panel.add(scrollPane);

        contentpane.add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new sd();
            }
        });
    }
}
