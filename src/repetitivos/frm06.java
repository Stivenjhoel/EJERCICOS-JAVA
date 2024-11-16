package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm06 {

    // Método para generar la tabla de multiplicar de un número n entre los rangos x y y
    public static String generarTablaMultiplicar(int n, int x, int y) {
        StringBuilder tabla = new StringBuilder();
        for (int i = x; i <= y; i++) {
            tabla.append(n).append(" x ").append(i).append(" = ").append(n * i).append("\n");
        }
        return tabla.toString();
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Generar Tabla de Multiplicar");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelNumero = new JLabel("Número n:");
        labelNumero.setBounds(30, 30, 80, 25);
        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 150, 25);

        JLabel labelRango = new JLabel("Rango (x - y):");
        labelRango.setBounds(30, 70, 100, 25);
        JTextField txtRangoX = new JTextField();
        txtRangoX.setBounds(120, 70, 60, 25);
        JTextField txtRangoY = new JTextField();
        txtRangoY.setBounds(190, 70, 60, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Tabla de Multiplicar:");
        labelResultado.setBounds(30, 110, 150, 25);
        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(120, 110, 150, 150);
        txtResultado.setEditable(false);

        // Botón para realizar la operación
        JButton btnGenerar = new JButton("Generar Tabla");
        btnGenerar.setBounds(120, 270, 150, 30);

        // Acción al presionar el botón
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del usuario
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    int rangoX = Integer.parseInt(txtRangoX.getText());
                    int rangoY = Integer.parseInt(txtRangoY.getText());

                    // Verificar que el rango sea válido
                    if (rangoX > rangoY) {
                        JOptionPane.showMessageDialog(frame, "El valor de x debe ser menor o igual a y.");
                        return;
                    }

                    // Generar la tabla de multiplicar de n en el rango x - y
                    String tabla = generarTablaMultiplicar(numero, rangoX, rangoY);

                    // Mostrar el resultado en el área de texto
                    txtResultado.setText(tabla);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.");
                }
            }
        });

        // Agregar los componentes a la ventana
        frame.add(labelNumero);
        frame.add(txtNumero);
        frame.add(labelRango);
        frame.add(txtRangoX);
        frame.add(txtRangoY);
        frame.add(labelResultado);
        frame.add(txtResultado);
        frame.add(btnGenerar);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

