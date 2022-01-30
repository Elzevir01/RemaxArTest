package txt;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CrearArchivo {
    public void txt(){
        try {
            String ruta = "/ruta/filename.txt";
            String contenido = "Contenido de ejemplo";
            File file = new File(ruta);
            
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
