package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm28 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtHora, txtMinuto;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm28 frame = new frm28();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm28() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblHora = new JLabel("Hora (0-23):");
        lblHora.setBounds(30, 30, 100, 30);
        getContentPane().add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(130, 30, 50, 30);
        getContentPane().add(txtHora);

        JLabel lblMinuto = new JLabel("Minuto (0-59):");
        lblMinuto.setBounds(30, 80, 100, 30);
        getContentPane().add(lblMinuto);

        txtMinuto = new JTextField();
        txtMinuto.setBounds(130, 80, 50, 30);
        getContentPane().add(txtMinuto);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(80, 130, 180, 30);
        getContentPane().add(btnConvertir);

        lblResultado = new JLabel("");
        lblResultado.setBounds(30, 170, 300, 30);
        getContentPane().add(lblResultado);

        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnConvertir_actionPerformed();
            }
        });
    }

    protected void btnConvertir_actionPerformed() {
        try {
            int hora = Integer.parseInt(txtHora.getText());
            int minuto = Integer.parseInt(txtMinuto.getText());
            
            // Validación de hora y minuto
            if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59) {
                lblResultado.setText("Error: Hora o minuto inválido.");
                return;
            }
            
            // Convertir la hora al formato de 12 horas
            String periodo = "AM";
            if (hora >= 12) {
                periodo = "PM";
                if (hora > 12) {
                    hora -= 12; // Convertir a formato de 12 horas
                }
            }
            if (hora == 0) {
                hora = 12; // Si la hora es 0, representarla como 12 (mediodía o medianoche)
            }

            lblResultado.setText(String.format("Hora: %02d:%02d %s", hora, minuto, periodo));
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Por favor ingrese un número válido.");
        }
    }
}

