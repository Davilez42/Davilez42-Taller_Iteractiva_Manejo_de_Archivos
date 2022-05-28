import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.FlowLayout;

public class App extends JFrame implements ActionListener {
    JTextField cajaTexto1, cajaTexto2, texto_variado;
    JLabel etiqueta1, etiqueta2, etiqueta3;
    JPanel panel1;
    JButton boton1;
    Container contenedor;

    public App() {
        super("Prueba");
        contenedor = getContentPane();
        panel1 = new JPanel();

        panel1.setLayout(new FlowLayout());
        contenedor.add(panel1);

        etiqueta1 = new JLabel("Ruta");
        panel1.add(etiqueta1);

        cajaTexto1 = new JTextField(25);
        panel1.add(cajaTexto1);

        etiqueta2 = new JLabel("Texto");
        panel1.add(etiqueta2);

        cajaTexto2 = new JTextField(25);
        panel1.add(cajaTexto2);

        boton1 = new JButton("Ingresar Texto");
        boton1.addActionListener(this);
        panel1.add(boton1);  
        etiqueta3 = new JLabel("                  texto variado                   ");
       
        panel1.add(etiqueta3);

        texto_variado = new JTextField(20);
        texto_variado.setEditable(false);
        panel1.add(texto_variado);

        setLocationRelativeTo(null);
        setResizable(false);
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        App ap = new App();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Archivos arc = new Archivos();
        if (e.getSource() == boton1) {
            arc.escribir_Archivo(cajaTexto1.getText(), cajaTexto2.getText());
            StringTokenizer texto = new StringTokenizer(cajaTexto2.getText(), " ");
            String texto_final = "";
            int tam = texto.countTokens();
            for (int i = 0; i < tam; i++) {
                texto_final += variar_Texto(texto.nextToken()) + " ";
            }
            texto_variado.setText(texto_final);
        }
    }

    public String variar_Texto(String texto) {
        String texto_original = texto;
        String texto_mayus = texto.toUpperCase();
        String texto_minus = texto.toLowerCase();
        String texto_f = "";
        for (int i = 0; i < texto.length(); i++) {
            if (texto_original.charAt(i) == texto_mayus.charAt(i)) {
                texto_f += texto_minus.charAt(i);
            } else {
                texto_f += texto_mayus.charAt(i);
            }
        }

        return texto_f;
    }

}
