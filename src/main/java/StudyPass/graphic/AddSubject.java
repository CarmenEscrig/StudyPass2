package StudyPass.graphic;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class AddSubject {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JComboBox<String> comboBox = new JComboBox<String>();
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
    JTextField txtAdd = new JTextField(15);
    JButton btnAdd = new JButton("Add");
    JButton btnRemove = new JButton("Remove");
    String selectedValue;

    public AddSubject() {
        comboBox.setModel(model);
        comboBox.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selectedValue = model.getSelectedItem().toString();
                System.out.println(selectedValue);
            }
        });

        btnRemove.addActionListener((e) -> {
            model.removeElement(selectedValue);
        });

        btnAdd.addActionListener((e) -> {
            model.addElement(txtAdd.getText());
            frame.pack();
        });

        panel.add(txtAdd);
        panel.add(btnAdd);
        panel.add(comboBox);
        panel.add(btnRemove);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddSubject();
        });
    }
}
