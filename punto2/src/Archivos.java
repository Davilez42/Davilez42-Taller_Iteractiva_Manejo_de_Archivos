import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class Archivos {
    public void escribir_Archivo(String ruta,String mensaje){

        try {
            RandomAccessFile escribir_archivo =  new RandomAccessFile(ruta, "rw");
            RandomAccessFile leer_archivo =  new RandomAccessFile(ruta, "r");
            escribir_archivo.seek(escribir_archivo.length());       
          if(leer_archivo.readLine()==null){
            escribir_archivo.writeBytes(mensaje);
          }
          else{
              escribir_archivo.writeBytes("\n");
              escribir_archivo.writeBytes(mensaje);
          }
        } catch (FileNotFoundException e) {
           JOptionPane.showMessageDialog(null, "Ruta no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
