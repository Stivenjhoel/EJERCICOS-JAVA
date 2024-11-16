package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm07 {

    // Método para calcular el factorial de un número
    public static long calcularFactorial(int numero) {
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Calcular Factorial");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelNumero = new JLabel("Número:");
        labelNumero.setBounds(30, 30, 80, 25);
        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 150, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Factorial:");
        labelResultado.setBounds(30, 70, 80, 25);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(120, 70, 150, 25);
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

                    // Verificar que el número sea positivo
                    if (numero < 0) {
                        JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número positivo.");
                        return;
                    }

                    // Calcular el factorial
                    long resultado = calcularFactorial(numero);

                    // Mostrar el resultado
                    txtResultado.setText(String.valueOf(resultado));

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

