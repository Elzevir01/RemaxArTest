package txt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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
				///////////borrar
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

	public void escribirTxT(String titulo, String descripcion, String precioDolar, String superficieTotal,
			String superficieCubierta, String baños, String aptoProfecional, String pisosPropiedad, String expensas) {

		// String superficieCubierta, String baños,String aptoProfecional,String
		// pisosPropiedad,String expensas;
		try {
			String archivo = System.getProperty("user.dir") + File.separator + "datos" + File.separator + "datos.txt";
			PrintWriter writer = new PrintWriter(archivo, "UTF-8");
			// FileOutputStream writer = new FileOutputStream(archivo, true) ;
			writer.println("#############################################################################");
			writer.println("# " + titulo + "");
			writer.println("# " + descripcion + "");
			writer.println("#---------------------------------------------------------------------------");
			writer.println("# " + precioDolar + "");
			writer.println("# " + superficieTotal + "");
			writer.println("# " + superficieCubierta + "");
			writer.println("# " + baños + "");
			writer.println("# " + aptoProfecional + "");
			writer.println("# " + pisosPropiedad + "");
			writer.println("# " + expensas + "");
			writer.println("#---------------------------------------------------------------------------");

			writer.flush();
			writer.close();

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
