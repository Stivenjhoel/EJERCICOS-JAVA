package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm29 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHorasTrabajadas, txtPagoPorHora;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm29 frame = new frm29();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm29() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblHorasTrabajadas = new JLabel("Horas trabajadas:");
        lblHorasTrabajadas.setBounds(30, 30, 120, 30);
        getContentPane().add(lblHorasTrabajadas);

        txtHorasTrabajadas = new JTextField();
        txtHorasTrabajadas.setBounds(160, 30, 80, 30);
        getContentPane().add(txtHorasTrabajadas);

        JLabel lblPagoPorHora = new JLabel("Pago por hora (S/.):");
        lblPagoPorHora.setBounds(30, 80, 120, 30);
        getContentPane().add(lblPagoPorHora);

        txtPagoPorHora = new JTextField();
        txtPagoPorHora.setBounds(160, 80, 80, 30);
        getContentPane().add(txtPagoPorHora);

        JButton btnCalcular = new JButton("Calcular Sueldo");
        btnCalcular.setBounds(80, 130, 180, 30);
        getContentPane().add(btnCalcular);

        lblResultado = new JLabel("");
        lblResultado.setBounds(30, 180, 300, 60);
        getContentPane().add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        try {
            int horasTrabajadas = Integer.parseInt(txtHorasTrabajadas.getText());
            double pagoPorHora = Double.parseDouble(txtPagoPorHora.getText());

            // Validación de horas trabajadas y pago por hora
            if (horasTrabajadas < 0 || pagoPorHora <= 0) {
                lblResultado.setText("Error: Ingrese valores válidos.");
                return;
            }

            double sueldoBruto = 0;
            double horasExtras = 0;

            // Cálculo del sueldo bruto
            if (horasTrabajadas <= 48) {
                sueldoBruto = horasTrabajadas * pagoPorHora;
            } else {
                horasExtras = horasTrabajadas - 48;
                sueldoBruto = (48 * pagoPorHora) + (horasExtras * pagoPorHora * 1.2); // 20% de recargo por horas extras
            }

            // Cálculo del descuento
            double descuento = 0;
            if (sueldoBruto > 1500) {
                descuento = sueldoBruto * 0.11; // 11% de descuento
            }

            double sueldoNeto = sueldoBruto - descuento;

            // Mostrar los resultados
            lblResultado.setText(String.format("Horas trabajadas: %d\nPago por hora: S/. %.2f\nSueldo Bruto: S/. %.2f\nDescuento: S/. %.2f\nSueldo Neto: S/. %.2f",
                    horasTrabajadas, pagoPorHora, sueldoBruto, descuento, sueldoNeto));
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Por favor ingrese números válidos.");
        }
    }
}

