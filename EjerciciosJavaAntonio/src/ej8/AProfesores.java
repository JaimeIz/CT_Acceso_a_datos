package ej8;

import java.io.Serializable;

public class AProfesores implements Serializable{
	
	private String nombre;
	private double antiguedad;
	
	public AProfesores(String nombre, double antiguedad) {
		
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		
	}

	public String getNombre() {
		
		return nombre;
		
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}

	public double getAntiguedad() {
		
		return antiguedad;
		
	}

	public void setAntiguedad(double antiguedad) {
		
		this.antiguedad = antiguedad;
		
	}

	public String toString() {
		
		return "Profesor [nombre=" + nombre + ", antiguedad=" + antiguedad + "]";
		
	}
	
}
