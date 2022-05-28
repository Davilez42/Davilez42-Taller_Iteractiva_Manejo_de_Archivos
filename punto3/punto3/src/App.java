import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;

public class App extends JFrame implements ActionListener {
    JTextField ruta1, ruta2, rutaFinal;
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

        etiqueta1 = new JLabel("Ruta1");
        panel1.add(etiqueta1);

        ruta1 = new JTextField(25);
        ruta1.setText("C:\\Users\\joses\\OneDrive\\Escritorio\\A.txt");
        panel1.add(ruta1);

        etiqueta2 = new JLabel("Ruta2");
        panel1.add(etiqueta2);

        ruta2 = new JTextField(25);
        ruta2.setText("C:\\Users\\joses\\OneDrive\\Escritorio\\B.txt");
        panel1.add(ruta2);

        etiqueta3 = new JLabel("Ruta Final");
        panel1.add(etiqueta3);

        rutaFinal = new JTextField(25);
        rutaFinal.setText("C:\\Users\\joses\\OneDrive\\Escritorio\\Mision-Tic-2022-Ciclo-1--Ejercicio_Talleres");
        panel1.add(rutaFinal);

      

        boton1 = new JButton("Clonar");
        boton1.addActionListener(this);
        panel1.add(boton1);  
       


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
          arc.escribir_Archivo(ruta1.getText(), ruta2.getText(), rutaFinal.getText());
        }
    }


}
