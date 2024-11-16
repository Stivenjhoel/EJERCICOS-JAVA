package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm24 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoVendido;
    private JLabel lblSueldo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm24 frame = new frm24();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm24() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMontoVendido = new JLabel("Monto Total Vendido:");
        lblMontoVendido.setBounds(30, 30, 150, 30);
        getContentPane().add(lblMontoVendido);

        txtMontoVendido = new JTextField();
        txtMontoVendido.setBounds(180, 30, 100, 30);
        getContentPane().add(txtMontoVendido);

        JButton btnCalcular = new JButton("Calcular Sueldo");
        btnCalcular.setBounds(80, 80, 180, 30);
        getContentPane().add(btnCalcular);

        lblSueldo = new JLabel("Sueldo: ");
        lblSueldo.setBounds(30, 130, 300, 30);
        getContentPane().add(lblSueldo);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        // Obtener el monto total vendido
        double montoVendido = Double.parseDouble(txtMontoVendido.getText());

        // Calcular sueldo base (10% del monto vendido)
        double sueldoBase = montoVendido * 0.10;

        // Inicializar la bonificación
        double bonificacion = 0.0;

        // Si el monto vendido es mayor a S/. 5000, calcular bonificación
        if (montoVendido > 5000) {
            double exceso = montoVendido - 5000;
            bonificacion = (exceso / 500) * 25; // S/. 25 por cada S/. 500 de exceso
        }

        // Calcular el sueldo total
        double sueldoTotal = sueldoBase + bonificacion;

        // Mostrar el resultado
        lblSueldo.setText("Sueldo Total: S/. " + sueldoTotal);
    }
}

