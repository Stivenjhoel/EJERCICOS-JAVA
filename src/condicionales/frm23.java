package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class frm23 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNotaMatematicas, txtNotaFisica;
    private JLabel lblPropina, lblObsequio;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm23 frame = new frm23();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm23() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNotaMatematicas = new JLabel("Nota Matemáticas:");
        lblNotaMatematicas.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNotaMatematicas);

        txtNotaMatematicas = new JTextField();
        txtNotaMatematicas.setBounds(180, 30, 100, 30);
        getContentPane().add(txtNotaMatematicas);

        JLabel lblNotaFisica = new JLabel("Nota Física:");
        lblNotaFisica.setBounds(30, 80, 150, 30);
        getContentPane().add(lblNotaFisica);

        txtNotaFisica = new JTextField();
        txtNotaFisica.setBounds(180, 80, 100, 30);
        getContentPane().add(txtNotaFisica);

        JButton btnCalcular = new JButton("Calcular Propina");
        btnCalcular.setBounds(80, 130, 180, 30);
        getContentPane().add(btnCalcular);

        lblPropina = new JLabel("Propina: ");
        lblPropina.setBounds(30, 180, 300, 30);
        getContentPane().add(lblPropina);

        lblObsequio = new JLabel("Obsequio: ");
        lblObsequio.setBounds(30, 220, 300, 30);
        getContentPane().add(lblObsequio);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        // Obtener las notas ingresadas
        double notaMatematicas = Double.parseDouble(txtNotaMatematicas.getText());
        double notaFisica = Double.parseDouble(txtNotaFisica.getText());

        // Inicializar las variables para la propina y el obsequio
        double propinaMatematicas = 0.0;
        double propinaFisica = 0.0;
        String obsequio = "No se obsequiará reloj.";

        // Calcular la propina por Matemáticas
        if (notaMatematicas > 17) {
            propinaMatematicas = 3.0;
        } else {
            propinaMatematicas = notaMatematicas * 1.0;
        }

        // Calcular la propina por Física
        if (notaFisica > 15) {
            propinaFisica = 2.0;
        } else {
            propinaFisica = 0.5 * notaFisica;
        }

        // Calcular el promedio de las notas
        double promedio = (notaMatematicas + notaFisica) / 2;

        // Si el promedio es mayor a 16, obsequiar un reloj
        if (promedio > 16) {
            obsequio = "¡Se obsequiará un reloj!";
        }

        // Calcular la propina total
        double propinaTotal = propinaMatematicas + propinaFisica;

        // Mostrar los resultados
        lblPropina.setText("Propina: S/. " + propinaTotal);
        lblObsequio.setText(obsequio);
    }
}

