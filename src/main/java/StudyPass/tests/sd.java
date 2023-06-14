package org.example;

import java.awt.Color;
import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Indice extends JFrame {

    String[] names = {"Nombre", "Apellido"};
    Object[][] hjasfjipjioasdfjp = {
            {"Pepe", "sihfioi"}
    };
    DefaultTableModel tableModel = new DefaultTableModel(hjasfjipjioasdfjp, names);
    JTable table = new JTable(tableModel);

    public Indice() {

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
        panel.add(table);

        contentpane.add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Indice();
            }
        });
    }
}
