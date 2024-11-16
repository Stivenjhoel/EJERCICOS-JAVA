package repetitivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm04 {

    // Método para mostrar los m múltiplos de un número n
    public static String mostrarMultiplos(int n, int m) {
        StringBuilder multiples = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            multiples.append(n * i).append(" ");
        }
        return multiples.toString().trim();
    }

    public static void main(String[] args) {
        // Crear el marco de la ventana
        JFrame frame = new JFrame("Mostrar Múltiplos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel labelNumero = new JLabel("Número n:");
        labelNumero.setBounds(30, 30, 80, 25);
        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(120, 30, 150, 25);

        JLabel labelMultiples = new JLabel("Múltiplos (m):");
        labelMultiples.setBounds(30, 70, 100, 25);
        JTextField txtMultiples = new JTextField();
        txtMultiples.setBounds(120, 70, 150, 25);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Múltiplos:");
        labelResultado.setBounds(30, 110, 80, 25);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(120, 110, 150, 25);
        txtResultado.setEditable(false);

        // Botón para realizar la operación
        JButton btnCalcular = new JButton("Mostrar Múltiplos");
        btnCalcular.setBounds(120, 150, 150, 30);

        // Acción al presionar el botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del usuario
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    int multiples = Integer.parseInt(txtMultiples.getText());

                    // Mostrar los m múltiplos de n
                    String resultado = mostrarMultiplos(numero, multiples);

                    // Mostrar el resultado
                    txtResultado.setText(resultado);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese números válidos.");
                }
            }
        });

        // Agregar los componentes a la ventana
        frame.add(labelNumero);
        frame.add(txtNumero);
        frame.add(labelMultiples);
        frame.add(txtMultiples);
        frame.add(labelResultado);
        frame.add(txtResultado);
        frame.add(btnCalcular);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

