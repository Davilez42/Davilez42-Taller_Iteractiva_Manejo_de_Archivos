import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Archivos {
    public String leerArchivo() {
        File archivo = new File("Prueba_Texto.txt");
        String contenido = "";
        if (archivo.isFile()) {
            
            try {
                FileReader leer = new FileReader(archivo);
                BufferedReader buffer = new BufferedReader(leer);
                String linea_actual = buffer.readLine();
                while (linea_actual != null) {
                    StringTokenizer token = new StringTokenizer(linea_actual, " ");
                    int tam= token.countTokens();
                    for (int i = 0; i < tam; i++) {
                        if(i+1 == tam){
                            contenido += token.nextToken() + "\n";
                        }
                        else{
                            contenido += token.nextToken() + "@";
                        }
                        
                    }
                    linea_actual = buffer.readLine();
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return contenido;
    }
}
