package StudyPass.graphic;

import javax.swing.*;
import java.awt.*;

public class Grafica extends JPanel {


    private int[] valores;

    public Grafica(int[] valores) {
        this.valores = valores;


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int total = 0;
        for (int valor : valores) {
            total += valor;
        }

        int anguloInicio = 0;

        for (int i = 0; i < valores.length; i++) {
            int angulo = (int) Math.round((valores[i] * 360.0) / total);

            g.setColor(obtenerColor(i));
            g.fillArc(50, 50, 200, 200, anguloInicio, angulo);

            anguloInicio += angulo;
        }
    }

    private Color obtenerColor(int indice) {
        Color[] colores = {Color.RED, Color.green};
        int index = indice % colores.length;
        return colores[index];
    }

    public static void main(String[] args) {
        final int[][] valore = new int[1][1];
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Grafica(valore[0] = new int[]{1, 1});
            }
        });


        JFrame ventana = new JFrame("StudyPass");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);

        Grafica grafica = new Grafica(valore[0]);
        ventana.add(grafica);

        ventana.setVisible(true);

    }
}
