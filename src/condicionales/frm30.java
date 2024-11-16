package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm30 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCuota, txtDiaPago;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm30 frame = new frm30();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm30() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCuota = new JLabel("Cuota mensual (S/.):");
        lblCuota.setBounds(30, 30, 150, 30);
        getContentPane().add(lblCuota);

        txtCuota = new JTextField();
        txtCuota.setBounds(180, 30, 80, 30);
        getContentPane().add(txtCuota);

        JLabel lblDiaPago = new JLabel("Día de pago:");
        lblDiaPago.setBounds(30, 80, 150, 30);
        getContentPane().add(lblDiaPago);

        txtDiaPago = new JTextField();
        txtDiaPago.setBounds(180, 80, 80, 30);
        getContentPane().add(txtDiaPago);

        JButton btnCalcular = new JButton("Calcular Pago");
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
            double cuota = Double.parseDouble(txtCuota.getText());
            int diaPago = Integer.parseInt(txtDiaPago.getText());

            // Validación de entrada
            if (cuota <= 0 || diaPago < 1 || diaPago > 31) {
                lblResultado.setText("Error: Ingrese datos válidos.");
                return;
            }

            double montoPagar = cuota;
            double descuento = 0;
            double recargo = 0;

            // Primeros 10 días - Descuento
            if (diaPago >= 1 && diaPago <= 10) {
                descuento = Math.max(5, cuota * 0.02);
                montoPagar = cuota - descuento;
            }
            // Días 11-20 - No descuento ni recargo
            else if (diaPago >= 11 && diaPago <= 20) {
                montoPagar = cuota; // Sin descuento ni recargo
            }
            // Últimos días del mes - Recargo
            else if (diaPago >= 21 && diaPago <= 31) {
                recargo = Math.max(10, cuota * 0.03);
                montoPagar = cuota + recargo;
            }

            // Mostrar resultado
            if (descuento > 0) {
                lblResultado.setText(String.format("Descuento aplicado: S/. %.2f\nMonto a pagar: S/. %.2f", descuento, montoPagar));
            } else if (recargo > 0) {
                lblResultado.setText(String.format("Recargo aplicado: S/. %.2f\nMonto a pagar: S/. %.2f", recargo, montoPagar));
            } else {
                lblResultado.setText(String.format("Monto a pagar: S/. %.2f", montoPagar));
            }

        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Por favor ingrese números válidos.");
        }
    }
}

