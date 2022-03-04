package txt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class PrintText {

	public void crearTxt() {
		try {
			String carpeta = System.getProperty("user.dir") + File.separator + "datos";
			File directorio = new File(carpeta);
			File file = new File(carpeta + File.separator + "datos.txt");
			/////SI EL DIRECTORIO EXISTE/////
			if (!directorio.exists()) {
				directorio.mkdir();
			} else if (directorio.mkdirs()) {
				System.out.println("ya creado directorio datos");
			} else {
				System.out.println("Error al crear directorio 'datos'");
			}

			if (!file.exists()) {
				file.createNewFile();
			} else if (file.exists()) {
				file.delete();
				file.createNewFile();
				System.out.println("ya creado datos.txt");
			} else {
				System.out.println("Error al crear datos.txt");
			}

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void escribirTextos(String texto) {
		FileWriter fw = null;
		String direccion = System.getProperty("user.dir") + File.separator + "datos" + File.separator + "datos.txt";

		try {
			fw = new FileWriter(direccion, true);

			fw.write("\n" + texto);
		}

		catch (Exception e) {
			System.out.println("Error de escritura del fichero:" + e.getMessage());
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar el fichero: " + e.toString());
			}
		}
	}
}
