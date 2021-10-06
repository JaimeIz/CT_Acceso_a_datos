package ej8;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main8 {

	public static void main(String[] args) {

		File fichero = new File("antiguedad.dat_obj.dat.");
		AEditor ae = new AEditor(fichero);
		boolean continuar = true;
		Scanner s = new Scanner(System.in);
		ArrayList<AProfesores> lista = new ArrayList<AProfesores>();

		while (continuar) {

			System.out.println("Indica el nombre del profesor a añadir:");
			String nombre = s.next();

			System.out.println("Indica la antiguedad del profesor a añadir");
			double antiguedad = s.nextDouble();

			lista.add(new AProfesores(nombre, antiguedad));

			System.out.println("Quieres añadir otro profesor? s/n");
			String confirmar = s.next();

			if (confirmar.equalsIgnoreCase("n")) {

				continuar = false;

			}

		}

		if (fichero.exists() && fichero.isFile()) {

			ae.EscrituraExiste();

			for (AProfesores prof : lista) {

				ae.Escribir(prof);

			}

			ae.CerrarExiste();

		} else {

			ae.EscrituraCrear();

			for (AProfesores prof : lista) {

				ae.Escribir(prof);

			}

			ae.CerrarCrear();

		}

		ae.CrearLector();
		try {

			while (true) {

				System.out.println(ae.getSalida().readObject());

			}

		} catch (EOFException e) {

			e.printStackTrace();
			System.out.println("Fin del fichero");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		ae.CerrarLector();

	}

}
