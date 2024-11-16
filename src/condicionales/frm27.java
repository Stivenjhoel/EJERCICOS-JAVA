package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm27 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtMontoVendido;
    private JLabel lblSueldoBruto, lblDescuento, lblSueldoNeto, lblPolos;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm27 frame = new frm27();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm27() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 350);
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

        lblSueldoBruto = new JLabel("Sueldo Bruto: ");
        lblSueldoBruto.setBounds(30, 130, 300, 30);
        getContentPane().add(lblSueldoBruto);

        lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(30, 170, 300, 30);
        getContentPane().add(lblDescuento);

        lblSueldoNeto = new JLabel("Sueldo Neto: ");
        lblSueldoNeto.setBounds(30, 210, 300, 30);
        getContentPane().add(lblSueldoNeto);

        lblPolos = new JLabel("Polos: ");
        lblPolos.setBounds(30, 250, 300, 30);
        getContentPane().add(lblPolos);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        // Obtener el monto total vendido
        double montoVendido = Double.parseDouble(txtMontoVendido.getText());

        // Calcular el sueldo bruto
        double sueldoBase = 600;
        double comision = montoVendido * 0.15;
        double sueldoBruto = sueldoBase + comision;

        // Calcular el descuento
        double descuento = 0.0;
        if (sueldoBruto > 1800) {
            descuento = sueldoBruto * 0.10; // 10% de descuento si el sueldo es mayor a S/. 1800
        } else {
            descuento = sueldoBruto * 0.05; // 5% de descuento si el sueldo es menor o igual a S/. 1800
        }

        // Calcular el sueldo neto
        double sueldoNeto = sueldoBruto - descuento;

        // Determinar la cantidad de polos
        int polos = (montoVendido > 1000) ? 3 : 1;

        // Mostrar los resultados
        lblSueldoBruto.setText("Sueldo Bruto: S/. " + sueldoBruto);
        lblDescuento.setText("Descuento: S/. " + descuento);
        lblSueldoNeto.setText("Sueldo Neto: S/. " + sueldoNeto);
        lblPolos.setText("Polos: " + polos);
    }
}

