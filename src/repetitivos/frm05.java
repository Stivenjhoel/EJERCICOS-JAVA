package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm05 {

    // Método para generar la tabla de multiplicar de un número n
    public static String generarTablaMultiplicar(int n) {
        StringBuilder tabla = new StringBuilder();
        for (int i = 1; i <= 12; i++) {
            tabla.append(n).append(" x ").append(i).append(" = ").append(n * i).append("\n");
        }
        return tabla.toString();
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Generar Tabla de Multiplicar");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelNumero = new JLabel("Número n:");
        labelNumero.setBounds(30, 30, 80, 25);
        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 150, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Tabla de Multiplicar:");
        labelResultado.setBounds(30, 70, 150, 25);
        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(120, 70, 150, 150);
        txtResultado.setEditable(false);

        // Botón para realizar la operación
        JButton btnGenerar = new JButton("Generar Tabla");
        btnGenerar.setBounds(120, 230, 150, 30);

        // Acción al presionar el botón
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor del usuario
                try {
                    int numero = Integer.parseInt(txtNumero.getText());

                    // Generar la tabla de multiplicar de n
                    String tabla = generarTablaMultiplicar(numero);

                    // Mostrar el resultado en el área de texto
                    txtResultado.setText(tabla);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido.");
                }
            }
        });

        // Agregar los componentes a la ventana
        frame.add(labelNumero);
        frame.add(txtNumero);
        frame.add(labelResultado);
        frame.add(txtResultado);
        frame.add(btnGenerar);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

