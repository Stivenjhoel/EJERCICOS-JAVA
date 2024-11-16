package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm25 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtSueldoBruto, txtNumeroHijos;
    private JLabel lblBonificacion, lblSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm25 frame = new frm25();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm25() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(30, 30, 150, 30);
        getContentPane().add(lblSueldoBruto);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(180, 30, 100, 30);
        getContentPane().add(txtSueldoBruto);

        JLabel lblNumeroHijos = new JLabel("Número de Hijos:");
        lblNumeroHijos.setBounds(30, 80, 150, 30);
        getContentPane().add(lblNumeroHijos);

        txtNumeroHijos = new JTextField();
        txtNumeroHijos.setBounds(180, 80, 100, 30);
        getContentPane().add(txtNumeroHijos);

        JButton btnCalcular = new JButton("Calcular Bonificación");
        btnCalcular.setBounds(80, 130, 180, 30);
        getContentPane().add(btnCalcular);

        lblBonificacion = new JLabel("Bonificación: ");
        lblBonificacion.setBounds(30, 180, 300, 30);
        getContentPane().add(lblBonificacion);

        lblSueldoNeto = new JLabel("Sueldo Neto: ");
        lblSueldoNeto.setBounds(30, 220, 300, 30);
        getContentPane().add(lblSueldoNeto);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        // Obtener el sueldo bruto y el número de hijos
        double sueldoBruto = Double.parseDouble(txtSueldoBruto.getText());
        int numeroHijos = Integer.parseInt(txtNumeroHijos.getText());

        // Inicializar la bonificación
        double bonificacion = 0.0;

        // Calcular la bonificación
        if (numeroHijos > 1) {
            bonificacion = (sueldoBruto * 0.125) + (numeroHijos * 40); // 12.5% del sueldo + S/. 40 por cada hijo
        } else {
            bonificacion = sueldoBruto * 0.10; // 10% del sueldo
        }

        // Calcular el sueldo neto
        double sueldoNeto = sueldoBruto + bonificacion;

        // Mostrar los resultados
        lblBonificacion.setText("Bonificación: S/. " + bonificacion);
        lblSueldoNeto.setText("Sueldo Neto: S/. " + sueldoNeto);
    }
}

