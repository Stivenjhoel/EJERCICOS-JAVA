package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm02 {

    // Método para multiplicar dos números sin usar el operador *
    public static int multiplicarPorSumasSucesivas(int a, int b) {
        int resultado = 0;
        
        // Si b es negativo, invertimos los roles para hacer la suma positiva
        int positivoB = b < 0 ? -b : b;
        
        for (int i = 0; i < positivoB; i++) {
            resultado += a;
        }
        
        // Si b era negativo, el resultado final debe ser negativo
        if (b < 0) {
            resultado = -resultado;
        }

        return resultado;
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Multiplicación por Sumas Sucesivas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelNum1 = new JLabel("Número 1:");
        labelNum1.setBounds(30, 30, 80, 25);
        JTextField txtNum1 = new JTextField();
        txtNum1.setBounds(120, 30, 150, 25);

        JLabel labelNum2 = new JLabel("Número 2:");
        labelNum2.setBounds(30, 70, 80, 25);
        JTextField txtNum2 = new JTextField();
        txtNum2.setBounds(120, 70, 150, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Resultado:");
        labelResultado.setBounds(30, 110, 80, 25);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(120, 110, 150, 25);
        txtResultado.setEditable(false);

        // Botón para realizar la operación
        JButton btnCalcular = new JButton("Multiplicar");
        btnCalcular.setBounds(120, 150, 150, 30);

        // Acción al presionar el botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del usuario
                try {
                    int num1 = Integer.parseInt(txtNum1.getText());
                    int num2 = Integer.parseInt(txtNum2.getText());

                    // Realizar la multiplicación
                    int resultado = multiplicarPorSumasSucesivas(num1, num2);

                    // Mostrar el resultado
                    txtResultado.setText(String.valueOf(resultado));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.");
                }
            }
        });

        // Agregar los componentes a la ventana
        frame.add(labelNum1);
        frame.add(txtNum1);
        frame.add(labelNum2);
        frame.add(txtNum2);
        frame.add(labelResultado);
        frame.add(txtResultado);
        frame.add(btnCalcular);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

