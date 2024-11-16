package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm03 {

    // Método para contar los divisores de un número
    public static int contarDivisores(int numero) {
        int contador = 0;
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Cantidad de Divisores");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelNumero = new JLabel("Número:");
        labelNumero.setBounds(30, 30, 80, 25);
        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 150, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Cantidad de Divisores:");
        labelResultado.setBounds(30, 70, 150, 25);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(180, 70, 150, 25);
        txtResultado.setEditable(false);

        // Botón para realizar la operación
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 110, 150, 30);

        // Acción al presionar el botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del usuario
                try {
                    int numero = Integer.parseInt(txtNumero.getText());

                    // Calcular la cantidad de divisores
                    int cantidadDivisores = contarDivisores(numero);

                    // Mostrar el resultado
                    txtResultado.setText(String.valueOf(cantidadDivisores));

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
        frame.add(btnCalcular);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

