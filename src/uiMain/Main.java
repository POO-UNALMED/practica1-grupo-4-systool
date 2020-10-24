package uiMain;

import java.io.*;
import java.util.*;

import gestorAplicacion.academico.Asignatura;
import gestorAplicacion.academico.Grado;
import gestorAplicacion.academico.Nota;
import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Main {

	/*
	 * public static void inicio() {
	 * System.out.println("BIENVENIDO A SYSTOOL V1.1 C5.0"); System.out.
	 * println("Por favor escoja una opción para acceder a sus funcionalidades:");
	 * System.out.println("1. Estudiante"); System.out.println("2. Profesor");
	 * System.out.println("3. Grado"); System.out.println("4. Asignatura");
	 * System.out.println("5. Salir"); }
	 */

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<Estudiante> estudiantes = new ArrayList<>();
		ArrayList<Profesor> profesores = new ArrayList<>();
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		ArrayList<Grado> grados = new ArrayList<>();
		//ArrayList<> notas = new ArrayList<>();

		/*
		 * int loop = 0; while (loop == 0) {
		 * 
		 * inicio(); Scanner reader = new Scanner(System.in); int opcion =
		 * reader.nextInt(); int funcionalidad;
		 * 
		 * switch (opcion) { case 1: System.out.println("1. Crear estudiante\r\n" +
		 * "2. Informe de notas individual\r\n" +
		 * "3. Mejores 10 estudiantes del colegio\r\n" +
		 * "4. Ver información estudiante\r\n" + "5. Atrás"); funcionalidad =
		 * reader.nextInt();
		 * 
		 * switch (funcionalidad) { case 1: System.out.print("DNI: "); int cedula =
		 * reader.nextInt(); System.out.println(""); System.out.print("Nombres: ");
		 * String nombres = reader.next(); System.out.println("");
		 * System.out.print("Apellidos: "); String apellidos = reader.next();
		 * System.out.println(""); System.out.print("Edad: "); int edad =
		 * reader.nextInt(); System.out.println("");
		 * System.out.print("Nombre de acudiente: "); String acudiente = reader.next();
		 * System.out.println(""); Estudiante e1 = new Estudiante(cedula, nombres,
		 * apellidos, edad, acudiente);
		 * System.out.println("Estudiante creado exitosamente madafaca"); break; case 2:
		 * if (estudiantes.size() > 0) { for (Estudiante e : estudiantes) {
		 * e.misNotas(); } } else { System.out.println(
		 * "Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes."
		 * ); }
		 * 
		 * break; case 3: if (estudiantes.size() > 0) { Estudiante.mejores_colegio(); }
		 * else { System.out.println(
		 * "Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes."
		 * ); } break; case 4:
		 * System.out.print("Ingrese el DNI de un estudiante registrado: "); int dni =
		 * reader.nextInt(); System.out.println(""); ArrayList<Integer> dnis = new
		 * ArrayList<>(); for (Estudiante e : estudiantes) { dnis.add(e.getDNI()); if
		 * (e.getDNI() == dni) { e.toString(); } } if (!dnis.contains(dni)) {
		 * System.out.println("El estudiante con DNI " + dni +
		 * " no se encuentra registrado."); } break; case 5: break; } default:
		 * System.out.println("Ingrese una opción válida"); break; case 2:
		 * System.out.println("1. Crear profesor\r\n" +
		 * "2. Ver información profesor \r\n" + "3. Atrás"); funcionalidad =
		 * reader.nextInt(); switch (funcionalidad) { case 1: System.out.print("DNI: ");
		 * int cedula = reader.nextInt(); System.out.println("");
		 * System.out.print("Nombres: "); String nombres = reader.next();
		 * System.out.println(""); System.out.print("Apellidos: "); String apellidos =
		 * reader.next(); System.out.println(""); System.out.print("Edad: "); int edad =
		 * reader.nextInt(); System.out.println(""); System.out.print("Título: ");
		 * String titulo = reader.next(); System.out.println("");
		 * System.out.print("E-mail: "); String email = reader.next();
		 * System.out.println(""); Profesor p1 = new Profesor(cedula, nombres,
		 * apellidos, edad, titulo, email);
		 * System.out.println("Profesor creado exitosamente"); break; case 2:
		 * System.out.print("Ingrese el DNI de un profesor registrado: "); int dni =
		 * reader.nextInt(); System.out.println(""); ArrayList<Integer> dnis = new
		 * ArrayList<>(); for (Profesor p : profesores) { dnis.add(p.getDNI()); if
		 * (p.getDNI() == dni) { p.toString(); } } if (!dnis.contains(dni)) {
		 * System.out.println("El profesor con DNI " + dni +
		 * " no se encuentra registrado."); } break; case 3: break; default:
		 * System.out.println("Ingrese una opción válida"); break; }
		 * 
		 * break; case 3: System.out.println("1. Crear grado\r\n" +
		 * "2. Crear profesor encargado\r\n" + "3. Cuadro de honor\r\n" +
		 * "4. Prevención de bajo rendimiento\r\n" + "5. Cuadro de superacion\r\n" +
		 * "6. Ver promedios de los grados" + "7. Atrás"); funcionalidad =
		 * reader.nextInt(); switch (funcionalidad) { case 1:
		 * System.out.print("Ingrese el ID del grado: "); String id = reader.next();
		 * System.out.println(""); Grado g1 = new Grado(id);
		 * System.out.println("Grado creado exitosamente"); break; case 2: if
		 * (profesores.size() > 0) {
		 * System.out.print("Ingrese el DNI de un profesor registrado: "); int dni =
		 * reader.nextInt(); System.out.println(""); ArrayList<Integer> dnis = new
		 * ArrayList<>(); for (Profesor p : profesores) { dnis.add(p.getDNI()); if
		 * (p.getDNI() == dni) { p.toString(); } } if (!dnis.contains(dni)) {
		 * System.out.println("El profesor con DNI " + dni +
		 * " no se encuentra registrado."); } } else { System.out.println(
		 * "No existen profesores registrados, por favor vaya a la sección de crear profesores."
		 * ); }
		 * 
		 * break; case 3: if (grados.size() > 0 && estudiantes.size() > 0) {
		 * System.out.print("Ingrese el ID de un grado registrado: "); String idg =
		 * reader.next(); System.out.println(""); ArrayList<String> ids = new
		 * ArrayList<>(); for (Grado g : grados) { ids.add(g.getId()); if (g.getId() ==
		 * idg) { g.cuadro_Honor(); } } if (!ids.contains(idg)) {
		 * System.out.println("El grado con DNI " + idg +
		 * " no se encuentra registrado."); } } else { System.out.println(
		 * "No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones."
		 * ); }
		 * 
		 * break; case 4: if (grados.size() > 0 && estudiantes.size() > 0) {
		 * System.out.print("Ingrese el ID de un grado registrado: "); String idg =
		 * reader.next(); System.out.println(""); ArrayList<String> ids = new
		 * ArrayList<>(); for (Grado g : grados) { ids.add(g.getId()); if (g.getId() ==
		 * idg) { g.prevencion_bajo_rendimiento(); } } if (!ids.contains(idg)) {
		 * System.out.println("El grado con DNI " + idg +
		 * " no se encuentra registrado."); } } else { System.out.println(
		 * "No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones."
		 * ); } break; case 5: if (grados.size() > 0 && estudiantes.size() > 0) {
		 * System.out.print("Ingrese el ID de un grado registrado: "); String idg =
		 * reader.next(); System.out.println(""); ArrayList<String> ids = new
		 * ArrayList<>(); for (Grado g : grados) { ids.add(g.getId()); if (g.getId() ==
		 * idg) { g.cuadro_superacion(); } } if (!ids.contains(idg)) {
		 * System.out.println("El grado con DNI " + idg +
		 * " no se encuentra registrado."); } } else { System.out.println(
		 * "No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones."
		 * ); } break; case 6: if (grados.size() > 0 && estudiantes.size() > 0) {
		 * System.out.print("Ingrese el ID de un grado registrado: "); String idg =
		 * reader.next(); System.out.println(""); ArrayList<String> ids = new
		 * ArrayList<>(); for (Grado g : grados) { ids.add(g.getId()); if (g.getId() ==
		 * idg) { g.promedio_grado(); } } if (!ids.contains(idg)) {
		 * System.out.println("El grado con DNI " + idg +
		 * " no se encuentra registrado."); } } else { System.out.println(
		 * "No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones."
		 * ); } break; case 7: break; default:
		 * System.out.println("Ingrese una opción válida"); break; }
		 * 
		 * break; case 4: System.out.println("1. Crear asignatura\r\n" +
		 * "2. Crear nota\r\n" + "3. Atrás"); funcionalidad = reader.nextInt(); switch
		 * (funcionalidad) { case 1: System.out.print("Nombre"); String nombre =
		 * reader.next(); System.out.println(""); System.out.print("Descripción: ");
		 * String descrip = reader.next(); System.out.println("");
		 * System.out.print("Número: "); byte numero = reader.nextByte();
		 * System.out.println(""); Asignatura a1 = new Asignatura(nombre, descrip,
		 * numero); System.out.println("Asignatura creada exitosamente"); break; case 2:
		 * if(asignaturas.size() > 0) { System.out.print("Calificación"); float cal =
		 * reader.nextFloat(); System.out.println("");
		 * System.out.print("Nombre de la asignatura: "); String asignatura =
		 * reader.next(); System.out.println("");
		 * System.out.print("DNI del estudiante: "); int dni = reader.nextByte();
		 * System.out.println(""); Asignatura a2 = null; Estudiante e1 = null; for
		 * (Asignatura a: asignaturas) { if(a.getNombre() == asignatura) { a2 = a; }
		 * }for (Estudiante e: estudiantes) { if(e.getDNI() == dni) { e1 = e; } } Nota
		 * n1 = new Nota(cal, e1, a2); System.out.println("Nota creada exitosamente");
		 * }else { System.out.println(
		 * "No existen asignaturas creadas, por favor vaya a la sección de crear asignaturas."
		 * ); } break; case 3: break; default:
		 * System.out.println("Ingrese una opción válida"); break; }
		 * 
		 * break; case 5: // SALIR loop = -1; break;
		 * 
		 * } break; }
		 */

		/*
		 * NOTAS: EN EL MANUAL DE USUARIO ESPECIFICAR QUE ES EL ID DEL GRADO. REVISAR
		 * TOODO OTRA VEZ Y VER SI COMETÍ ERRORES XD
		 * 
		 */

		Profesor p1 = new Profesor(12, "p1", "p11", 95, "ciencias", "p11@unal");
		Grado g1 = new Grado("quinto", p1);
		Asignatura a1 = new Asignatura("mat", "to bien", 5);
		Estudiante e1 = new Estudiante(1, "d", "g", 10, "ac");

		// esto va al final del main, es la exportación de los datos creados
		
		try {
			System.out.println(Estudiante.getEstudiantes());
			ObjectOutputStream guardar_estudiantes = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Estudiantes.txt"));
			guardar_estudiantes.writeObject(Estudiante.getEstudiantes());
			guardar_estudiantes.close();
			
			System.out.println(Profesor.getProfesores());
			ObjectOutputStream guardar_profesores = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Profesores.txt"));
			guardar_profesores.writeObject(Profesor.getProfesores());
			guardar_profesores.close();

			System.out.println(Asignatura.getAsignaturas());
			ObjectOutputStream guardar_asignaturas = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Asignaturas.txt"));
			guardar_asignaturas.writeObject(Asignatura.getAsignaturas());
			guardar_asignaturas.close();
			
			System.out.println(Grado.getGrados());
			ObjectOutputStream guardar_grados = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Grados.txt"));
			guardar_grados.writeObject(Grado.getGrados());
			guardar_grados.close();

			//----------------------------------------------------------------------------------------
			
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

		} catch (ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

		System.out.println(estudiantes);
		System.out.println(profesores);
		System.out.println(asignaturas);
		System.out.println(grados);
		

	}

}
