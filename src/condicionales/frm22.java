package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm22 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtUnidadesA, txtUnidadesB;
    private JLabel lblImporteBruto, lblDescuento, lblTotalPagar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm22 frame = new frm22();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm22() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblUnidadesA = new JLabel("Unidades Producto A:");
        lblUnidadesA.setBounds(30, 30, 150, 30);
        getContentPane().add(lblUnidadesA);

        txtUnidadesA = new JTextField();
        txtUnidadesA.setBounds(180, 30, 100, 30);
        getContentPane().add(txtUnidadesA);

        JLabel lblUnidadesB = new JLabel("Unidades Producto B:");
        lblUnidadesB.setBounds(30, 80, 150, 30);
        getContentPane().add(lblUnidadesB);

        txtUnidadesB = new JTextField();
        txtUnidadesB.setBounds(180, 80, 100, 30);
        getContentPane().add(txtUnidadesB);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(80, 130, 180, 30);
        getContentPane().add(btnCalcular);

        lblImporteBruto = new JLabel("Importe bruto: ");
        lblImporteBruto.setBounds(30, 180, 300, 30);
        getContentPane().add(lblImporteBruto);

        lblDescuento = new JLabel("Descuento: ");
        lblDescuento.setBounds(30, 220, 300, 30);
        getContentPane().add(lblDescuento);

        lblTotalPagar = new JLabel("Total a pagar: ");
        lblTotalPagar.setBounds(30, 260, 300, 30);
        getContentPane().add(lblTotalPagar);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        // Obtener la cantidad de unidades ingresadas
        int unidadesA = Integer.parseInt(txtUnidadesA.getText());
        int unidadesB = Integer.parseInt(txtUnidadesB.getText());

        // Precios y descuentos
        double precioA = 25.0;
        double precioB = 30.0;
        double descuentoA = 0.0;
        double descuentoB = 0.0;

        // Calcular el importe bruto
        double importeBrutoA = unidadesA * precioA;
        double importeBrutoB = unidadesB * precioB;

        // Calcular el descuento para el Producto A
        if (unidadesA > 50) {
            descuentoA = importeBrutoA * 0.15; // 15% de descuento
        }

        // Calcular el descuento para el Producto B
        if (unidadesB > 60) {
            descuentoB = importeBrutoB * 0.10; // 10% de descuento
        }

        // Calcular los totales
        double totalA = importeBrutoA - descuentoA;
        double totalB = importeBrutoB - descuentoB;
        double totalPagar = totalA + totalB;

        // Mostrar los resultados
        lblImporteBruto.setText("Importe bruto: S/. " + (importeBrutoA + importeBrutoB));
        lblDescuento.setText("Descuento: S/. " + (descuentoA + descuentoB));
        lblTotalPagar.setText("Total a pagar: S/. " + totalPagar);
    }
}

