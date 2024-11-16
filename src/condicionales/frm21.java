package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm21 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;
    private JLabel lblResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm21 frame = new frm21();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm21() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNumero = new JLabel("Número asignado:");
        lblNumero.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(160, 30, 100, 30);
        getContentPane().add(txtNumero);

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.setBounds(80, 80, 180, 30);
        getContentPane().add(btnVerificar);

        lblResultado = new JLabel("");
        lblResultado.setBounds(30, 130, 300, 50);
        getContentPane().add(lblResultado);

        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnVerificar_actionPerformed();
            }
        });
    }

    protected void btnVerificar_actionPerformed() {
        int numeroAsignado = Integer.parseInt(txtNumero.getText());
        String resultado = "";

        if (numeroAsignado < 1000 || numeroAsignado > 9999) {
            resultado = "El número debe tener 4 cifras.";
        } else {
            // Extraer los datos del número asignado
            int estadoCivil = numeroAsignado / 1000;       // Primer dígito (estado civil)
            int edad = (numeroAsignado % 1000) / 10;       // Dos siguientes cifras (edad)
            int sexo = numeroAsignado % 10;                // Última cifra (sexo)

            // Determinar el estado civil
            switch (estadoCivil) {
                case 1:
                    resultado += "Estado civil: Soltero(a)\n";
                    break;
                case 2:
                    resultado += "Estado civil: Casado(a)\n";
                    break;
                case 3:
                    resultado += "Estado civil: Divorciado(a)\n";
                    break;
                case 4:
                    resultado += "Estado civil: Viudo(a)\n";
                    break;
                default:
                    resultado += "Estado civil: Desconocido\n";
                    break;
            }

            resultado += "Edad: " + edad + " años\n";

            if (sexo == 1) {
                resultado += "Sexo: Masculino\n";
            } else if (sexo == 2) {
                resultado += "Sexo: Femenino\n";
            } else {
                resultado += "Sexo: Desconocido\n";
            }
        }

        lblResultado.setText("<html>" + resultado.replace("\n", "<br>") + "</html>");
    }
}

