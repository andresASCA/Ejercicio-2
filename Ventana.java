import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JLabel lblResultado;
    private JLabel lblAperturas;

    private Pila pila=new Pila();
    public Ventana() {
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String codigo = txtCodigo.getText();
                    boolean resultado = pila.balanceada(codigo);

                    if (resultado) {
                        int contParentesis = 0, contLlaves = 0, contCorchetes = 0;
                        for (int i = 0; i < codigo.length(); i++) {
                            char c = codigo.charAt(i);
                            if (c == '(') contParentesis++;
                            else if (c == '{') contLlaves++;
                            else if (c == '[') contCorchetes++;
                        }

                        lblResultado.setText("Código balanceado");
                        lblAperturas.setText("Aperturas: ( )=" + contParentesis +
                                ", { }=" + contLlaves +
                                ", [ ]=" + contCorchetes);
                    } else {
                        lblResultado.setText("Código no balanceado");
                        lblAperturas.setText("");
                    }
                } catch (Exception ex) {
                    lblResultado.setText(ex.getMessage());
                    lblAperturas.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

