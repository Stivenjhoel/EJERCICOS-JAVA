package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm01 {

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("División por Restas Sucesivas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelDividendo = new JLabel("Dividendo:");
        labelDividendo.setBounds(30, 30, 80, 25);
        JTextField txtDividendo = new JTextField();
        txtDividendo.setBounds(120, 30, 150, 25);

        JLabel labelDivisor = new JLabel("Divisor:");
        labelDivisor.setBounds(30, 70, 80, 25);
        JTextField txtDivisor = new JTextField();
        txtDivisor.setBounds(120, 70, 150, 25);

        // Etiquetas para mostrar los resultados
        JLabel labelCociente = new JLabel("Cociente:");
        labelCociente.setBounds(30, 110, 80, 25);
        JTextField txtCociente = new JTextField();
        txtCociente.setBounds(120, 110, 150, 25);
        txtCociente.setEditable(false);

        JLabel labelResto = new JLabel("Resto:");
        labelResto.setBounds(30, 150, 80, 25);
        JTextField txtResto = new JTextField();
        txtResto.setBounds(120, 150, 150, 25);
        txtResto.setEditable(false);

        // Botón para realizar la operación
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 190, 150, 30);

        // Acción al presionar el botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del usuario
                try {
                    int dividendo = Integer.parseInt(txtDividendo.getText());
                    int divisor = Integer.parseInt(txtDivisor.getText());

                    // Validar si el divisor es cero
                    if (divisor == 0) {
                        JOptionPane.showMessageDialog(frame, "El divisor no puede ser cero.");
                        return;
                    }

                    // Calcular el cociente y el resto usando restas sucesivas
                    int cociente = 0;
                    while (dividendo >= divisor) {
                        dividendo -= divisor;
                        cociente++;
                    }
                    int resto = dividendo;

                    // Mostrar el resultado
                    txtCociente.setText(String.valueOf(cociente));
                    txtResto.setText(String.valueOf(resto));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.");
                }
            }
        });

        // Agregar los componentes a la ventana
        frame.add(labelDividendo);
        frame.add(txtDividendo);
        frame.add(labelDivisor);
        frame.add(txtDivisor);
        frame.add(labelCociente);
        frame.add(txtCociente);
        frame.add(labelResto);
        frame.add(txtResto);
        frame.add(btnCalcular);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
