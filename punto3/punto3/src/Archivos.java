import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Archivos {
    public void escribir_Archivo(String ruta1, String ruta2, String rutaFinal) {
        File archivo_final = new File(rutaFinal);

        if (archivo_final.isDirectory()) {
            System.out.println("existe la ruta");

            File archivo1 = new File(ruta1);
            File archivo2 = new File(ruta2);
            String nombre = obtenerNombre(archivo1.getName()) + "_" + obtenerNombre(archivo2.getName()) + ".txt";
            File nuevo_archivo_Final = new File(rutaFinal + "\\" + nombre);
            try {
                if (!nuevo_archivo_Final.exists()) {
                    nuevo_archivo_Final.createNewFile();
                    insertar_texto(nuevo_archivo_Final, archivo1, archivo2);

                } else {
                    int opc = JOptionPane.showConfirmDialog(null, "El archivo ya existe .Desea Sobrescribirlo?");
                    switch (opc) {
                        case 0:
                            nuevo_archivo_Final.delete();
                            nuevo_archivo_Final.createNewFile();

                            insertar_texto(nuevo_archivo_Final, archivo1, archivo2);
                            break;
                        case 1:
                        System.out.println("1");
                            insertar_texto(nuevo_archivo_Final, archivo1, archivo2);

                            break;

                        default:
                            break;
                    }
                }

            } catch (IOException e) {

                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ruta de Destino no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String obtenerNombre(String nombe) {
        StringTokenizer tokens = new StringTokenizer(nombe, ".");
        return tokens.nextToken();
    }

    public String obtenerContenido(File archivo) {
        String contenido = "";
        try {
            FileReader leer = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(leer);

            String linea_actual = buffer.readLine();
            while (linea_actual != null) {
                contenido += linea_actual + "\n";
                linea_actual = buffer.readLine();
            }
            buffer.close();
            leer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }

    public void insertar_texto(File Archivofinal, File archivo1, File archivo2) {
        String contenido = obtenerContenido(archivo1) + obtenerContenido(archivo2);
        try {
            RandomAccessFile archivo = new RandomAccessFile(Archivofinal, "rw");
            archivo.seek(archivo.length());
            if (archivo.readLine() != null) {
                archivo.writeBytes("\n");
            } else {
                archivo.writeBytes(contenido);
            }
            archivo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
