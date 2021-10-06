package ej8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AEditor {
	
	private File file;
	private AMiObjectOutputStream entradaEx = null;
	private ObjectOutputStream entradaCrear = null;
	private ObjectInputStream salida = null;

	public AEditor(File file) {
		
		this.file = file;
		
	}
	
	public File getArchivo() {
		
		return file;
		
	}

	public AMiObjectOutputStream getEntradaExistente() {
		
		return entradaEx;
		
	}

	public void setEntradaExistente(AMiObjectOutputStream entradaEx) {
		
		this.entradaEx = entradaEx;
		
	}

	public ObjectOutputStream getEntradaNueva() {
		
		return entradaCrear;
		
	}

	public void setEntradaNueva(ObjectOutputStream entradaCrear) {
		
		this.entradaCrear = entradaCrear;
		
	}

	public ObjectInputStream getSalida() {
		
		return salida;
		
	}

	public void setSalida(ObjectInputStream salida) {
		
		this.salida = salida;
		
	}

	public void EscrituraExiste() {
		
		try {
			
			this.entradaEx = new AMiObjectOutputStream(new FileOutputStream(this.file, true));
			
		} catch (FileNotFoundException e) {	
			
			System.out.println("No se ha encontrado el archivo...");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.out.println("No se han podido escribir los datos...");
			e.printStackTrace();
			
		}
		
	}
	
	public void EscrituraCrear() {

		try {
			
			this.entradaCrear = new ObjectOutputStream(new FileOutputStream(this.file));
			
		} catch (IOException e) {

			System.out.println("No se ha podido crear el archivo...");
			e.printStackTrace();
			
		}
		
	}
	
	public void CrearLector() {
		
		try {
			
			this.salida = new ObjectInputStream(new FileInputStream(this.file));
			
		} catch (FileNotFoundException e) {
			
			System.out.println("No se ha encontrado el archivo...");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			System.out.println("No se ha podido leer el archivo...");
			e.printStackTrace();
			
		}
		
	}
	
	public void CerrarExiste() {
		
		try {
			
			this.entradaEx.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void CerrarCrear() {
	
		try {
			
			this.entradaCrear.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	public void CerrarLector() {
		
		try {
			
			this.salida.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void Escribir(AProfesores ap) {

		if (this.entradaCrear == null) {
			
			try {
				
				this.entradaEx.writeObject(ap);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		} else {
		
			try {
					
				this.entradaCrear.writeObject(ap);
					
			} catch (IOException e) {
					
				e.printStackTrace();
					
			}
			
		}
		
	}
	
	public Object leerObjeto() throws ClassNotFoundException, IOException {
		
		return this.salida.readObject();
		
	}
			
}
