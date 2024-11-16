package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm26 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoCompra;
    private JLabel lblPropioDinero, lblPrestamo, lblIntereses, lblTotalPago;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm26 frame = new frm26();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm26() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoCompra = new JLabel("Monto Total de Compra:");
        lblMontoCompra.setBounds(30, 30, 150, 30);
        getContentPane().add(lblMontoCompra);

        txtMontoCompra = new JTextField();
        txtMontoCompra.setBounds(180, 30, 100, 30);
        getContentPane().add(txtMontoCompra);

        JButton btnCalcular = new JButton("Calcular Pago");
        btnCalcular.setBounds(80, 80, 180, 30);
        getContentPane().add(btnCalcular);

        lblPropioDinero = new JLabel("Dinero Propio: ");
        lblPropioDinero.setBounds(30, 130, 300, 30);
        getContentPane().add(lblPropioDinero);

        lblPrestamo = new JLabel("Prestamo: ");
        lblPrestamo.setBounds(30, 170, 300, 30);
        getContentPane().add(lblPrestamo);

        lblIntereses = new JLabel("Intereses: ");
        lblIntereses.setBounds(30, 210, 300, 30);
        getContentPane().add(lblIntereses);

        lblTotalPago = new JLabel("Total a Pagar: ");
        lblTotalPago.setBounds(30, 250, 300, 30);
        getContentPane().add(lblTotalPago);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        // Obtener el monto total de la compra
        double montoCompra = Double.parseDouble(txtMontoCompra.getText());

        // Inicializar las variables
        double prestamo = 0.0;
        double intereses = 0.0;
        double propioDinero = 0.0;

        // Calcular préstamo y propio dinero según el monto de la compra
        if (montoCompra > 5000) {
            prestamo = montoCompra * 0.30;  // 30% si excede los $5000
        } else {
            prestamo = montoCompra * 0.20;  // 20% si no excede los $5000
        }

        // Calcular los intereses (10% del préstamo)
        intereses = prestamo * 0.10;

        // Calcular el dinero propio que cubrirá la empresa
        propioDinero = montoCompra - prestamo;

        // Calcular el total a pagar (préstamo + intereses + propio dinero)
        double totalPago = montoCompra + intereses;

        // Mostrar los resultados
        lblPropioDinero.setText("Dinero Propio: S/. " + propioDinero);
        lblPrestamo.setText("Préstamo: S/. " + prestamo);
        lblIntereses.setText("Intereses: S/. " + intereses);
        lblTotalPago.setText("Total a Pagar: S/. " + totalPago);
    }
}

