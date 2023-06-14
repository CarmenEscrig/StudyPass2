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
        int radio = Math.min(getHeight(), getWidth()) / 2; // Calcula el radio para que quepa en el panel
        int xCentro = getWidth() / 2; // Obtiene la coordenada x del centro del panel
        int yCentro = getHeight() / 2; // Obtiene la coordenada y del centro del panel

        for (int i = 0; i < valores.length; i++) {
            int angulo = (int) Math.round((valores[i] * 360.0) / total);

            g.setColor(obtenerColor(i));
            g.fillArc(xCentro - radio, yCentro - radio, 2 * radio, 2 * radio, anguloInicio, angulo);

            anguloInicio += angulo;
        }
    }

    private Color obtenerColor(int indice) {
        Color[] colores = {Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW, Color.MAGENTA};
        int index = indice % colores.length;
        return colores[index];
    }

    public static void main(String[] args) {
        int[] valores = {30, 50};

        JFrame ventana = new JFrame("Gráfica Circular");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 300);

        Grafica grafica = new Grafica(valores);
        ventana.add(grafica);

        ventana.setVisible(true);
    }
}
