import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    JTextArea cajaTexto;
    JPanel panel1;
    JButton boton1;
    Container contenedor;

    public App() {
        super("Prueba");
        contenedor = getContentPane();
        panel1 = new JPanel();
        panel1.setBackground(Color.gray);
        contenedor.add(panel1);
        boton1 = new JButton("Mostrar Texto");
        boton1.addActionListener(this);
        panel1.add(boton1);

        cajaTexto = new JTextArea(15, 20);
        cajaTexto.setEditable(false);
        
        panel1.add(cajaTexto);

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
        Archivos arc =  new Archivos();
        if(e.getSource()==boton1){
           cajaTexto.setText(arc.leerArchivo()); 
        }
    }
}
