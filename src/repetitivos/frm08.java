package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm08 {

    // Método para calcular la potencia de un número n elevado a m
    public static double calcularPotencia(double base, int exponente) {
        double resultado = 1;
        for (int i = 1; i <= Math.abs(exponente); i++) {
            resultado *= base;
        }
        
        // Si el exponente es negativo, se calcula la inversa
        if (exponente < 0) {
            resultado = 1 / resultado;
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Calcular Potencia");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelBase = new JLabel("Base (n):");
        labelBase.setBounds(30, 30, 80, 25);
        JTextField txtBase = new JTextField();
        txtBase.setBounds(120, 30, 150, 25);

        JLabel labelExponente = new JLabel("Exponente (m):");
        labelExponente.setBounds(30, 70, 100, 25);
        JTextField txtExponente = new JTextField();
        txtExponente.setBounds(120, 70, 150, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Resultado:");
        labelResultado.setBounds(30, 110, 80, 25);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(120, 110, 150, 25);
        txtResultado.setEditable(false);

        // Botón para realizar la operación
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 150, 150, 30);

        // Acción al presionar el botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del usuario
                try {
                    double base = Double.parseDouble(txtBase.getText());
                    int exponente = Integer.parseInt(txtExponente.getText());

                    // Calcular la potencia
                    double resultado = calcularPotencia(base, exponente);

                    // Mostrar el resultado
                    txtResultado.setText(String.valueOf(resultado));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese valores válidos.");
                }
            }
        });

        // Agregar los componentes a la ventana
        frame.add(labelBase);
        frame.add(txtBase);
        frame.add(labelExponente);
        frame.add(txtExponente);
        frame.add(labelResultado);
        frame.add(txtResultado);
        frame.add(btnCalcular);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

