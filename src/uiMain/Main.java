package uiMain;

import java.io.*;
import java.util.*;

import gestorAplicacion.academico.Asignatura;
import gestorAplicacion.academico.Grado;
import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		System.out.println("BIENVENIDO A SYSTOOL V1.1 C5.0");
		System.out.println("Por favor escoja una opción para acceder a sus funcionalidades:");
		System.out.println("1. Estudiante");
		System.out.println("2. Profesor");
		System.out.println("3. Grado");
		System.out.println("4. Asignatura");
		System.out.println("5. Salir");

		Scanner reader = new Scanner(System.in);
		int opcion = reader.nextInt();
		int funcionalidad;
		
		
		switch (opcion) {
		case 1:
			System.out.println("1. Crear estudiante\r\n" + "2. Informe de notas individual\r\n"
					+ "3. Mejores 10 estudiantes del colegio\r\n" + "4. Ver información estudiante\r\n" + "5. Atrás");
			funcionalidad = reader.nextInt();
			
			switch (funcionalidad) {
			case 1:
				int cedula = reader.nextInt();
				String nombres = reader.next();
				String apellidos = reader.next();
				int edad = reader.nextInt();
				String acudiente = reader.next();
				Estudiante e1 = new Estudiante(cedula, nombres, apellidos, edad, acudiente);
				break;
			case 2:
				
				break;
			case 3:

				break;
			case 4:

				break;
			}

			break;
		case 2:
			System.out.println("1. Crear profesor\r\n" + 
					"2. Crear nota (analizar)\r\n" + 
					"3. Ver información profesor ");
			funcionalidad = reader.nextInt();
			switch (funcionalidad) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			}
			break;
		case 3:
			System.out.println("1. Crear grado\r\n" + 
					"2. Crear profesor encargado\r\n" + 
					"3. Cuadro de honor\r\n" + 
					"4. Prevención de bajo rendimiento\r\n" + 
					"5. Cuadro de superacion\r\n" + 
					"6. Ver promedios de los grados");
			funcionalidad = reader.nextInt();
			switch (funcionalidad) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			}
			
			break;
		case 4:
			System.out.println("1.Crear asignatura\r\n" + 
					"2.Crear asignatura");
			funcionalidad = reader.nextInt();
			switch (funcionalidad) {
			case 1:

				break;
			case 2:

				break;
			}
			
			break;
		case 5:
			//SALIR
			break;

		}

		
		
		
		
		
		
		
		Profesor p1 = new Profesor(12, "p1", "p11", 95, "ciencias", "p11@unal");
		Grado g1 = new Grado("quinto", p1);
		Estudiante e1 = new Estudiante(1, "d", "g", 10, "ac");

		// esto va al final del main, es la exportación de los datos creados

		ArrayList<Estudiante> estudiantes = new ArrayList<>();
		ArrayList<Profesor> profesores = new ArrayList<>();
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		ArrayList<Grado> grados = new ArrayList<>();

		try {
			ObjectOutputStream guardar_estudiantes = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Estudiantes.txt"));
			guardar_estudiantes.writeObject(Estudiante.getEstudiantes());
			guardar_estudiantes.close();

			ObjectOutputStream guardar_profesores = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Profesores.txt"));
			// guardar_profesores.writeObject(Profesor.getProfesores());
			guardar_profesores.close();

			ObjectOutputStream guardar_asignaturas = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Asignaturas.txt"));
			// guardar_asignaturas.writeObject(Asignatura.getAsignaturas());
			guardar_asignaturas.close();

			ObjectOutputStream guardar_grados = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Grados.txt"));
			// guardar_grados.writeObject(Grado.getGrados());
			guardar_grados.close();

			ObjectInputStream recuperar_estudiantes = new ObjectInputStream(
					new FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Estudiantes.txt"));
			estudiantes = (ArrayList<Estudiante>) recuperar_estudiantes.readObject();
			recuperar_estudiantes.close();

			ObjectInputStream recuperar_profesores = new ObjectInputStream(
					new FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Profesores.txt"));
			profesores = (ArrayList<Profesor>) recuperar_profesores.readObject();
			recuperar_profesores.close();

			ObjectInputStream recuperar_asignaturas = new ObjectInputStream(
					new FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Asignaturas.txt"));
			asignaturas = (ArrayList<Asignatura>) recuperar_asignaturas.readObject();
			recuperar_asignaturas.close();

			ObjectInputStream recuperar_grados = new ObjectInputStream(
					new FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Grados.txt"));
			grados = (ArrayList<Grado>) recuperar_grados.readObject();
			recuperar_grados.close();

		} catch (Exception e) {

		}

		System.out.println(estudiantes);
		System.out.println(profesores);
		System.out.println(asignaturas);
		System.out.println(grados);

	}

}
