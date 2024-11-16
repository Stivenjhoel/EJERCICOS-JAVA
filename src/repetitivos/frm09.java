package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm09 {

    // Método para generar el rectángulo de asteriscos
    public static String generarRectangulo(int n) {
        StringBuilder rectangulo = new StringBuilder();
        
        // Crear el rectángulo de asteriscos
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * n; j++) {
                rectangulo.append("*");
            }
            rectangulo.append("\n");
        }
        return rectangulo.toString();
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Generar Rectángulo de Asteriscos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelNumero = new JLabel("Altura (n):");
        labelNumero.setBounds(30, 30, 80, 25);
        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 150, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Rectángulo:");
        labelResultado.setBounds(30, 70, 80, 25);
        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(120, 70, 150, 150);
        txtResultado.setEditable(false);

        // Botón para realizar la operación
        JButton btnGenerar = new JButton("Generar Rectángulo");
        btnGenerar.setBounds(120, 230, 150, 30);

        // Acción al presionar el botón
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del usuario
                try {
                    int n = Integer.parseInt(txtNumero.getText());

                    // Verificar que n sea mayor o igual a 4
                    if (n < 4) {
                        JOptionPane.showMessageDialog(frame, "Por favor, ingrese un valor de n mayor o igual a 4.");
                        return;
                    }

                    // Generar el rectángulo de asteriscos
                    String rectangulo = generarRectangulo(n);

                    // Mostrar el resultado en el área de texto
                    txtResultado.setText(rectangulo);

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

