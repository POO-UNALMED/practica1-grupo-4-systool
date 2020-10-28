package BaseDatos;

import java.io.*;
import java.util.ArrayList;

import gestorAplicacion.academico.Asignatura;
import gestorAplicacion.academico.Grado;
import gestorAplicacion.academico.Nota;
import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Serializacion {

	private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
	private static ArrayList<Profesor> profesores = new ArrayList<>();
	private static ArrayList<Asignatura> asignaturas = new ArrayList<>();
	private static ArrayList<Grado> grados = new ArrayList<>();
	private static ArrayList<Nota> notas = new ArrayList<>();
	
	public Serializacion() {};

	public static ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		Serializacion.estudiantes = estudiantes;
	}

	public static ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public static void setProfesores(ArrayList<Profesor> profesores) {
		Serializacion.profesores = profesores;
	}

	public static ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public static void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		Serializacion.asignaturas = asignaturas;
	}

	public static ArrayList<Grado> getGrados() {
		return grados;
	}

	public static void setGrados(ArrayList<Grado> grados) {
		Serializacion.grados = grados;
	}

	public static ArrayList<Nota> getNotas() {
		return notas;
	}

	public static void setNotas(ArrayList<Nota> notas) {
		Serializacion.notas = notas;
	}

	@SuppressWarnings("unchecked")
	/*El metodo base de datos se encarga de guardar los objetos, los cuales seran serealziados
	 */
	
	public static void base_datos() {
		try {
			File archivo = new File("");

			ObjectOutputStream guardar_estudiantes = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Estudiantes.txt"));
			
			//ArrayList<Estudiante> temp_e = Estudiante.getEstudiantes();
			//temp_e.addAll(estudiantes);
			//Estudiante.setEstudiantes(temp_e);
			guardar_estudiantes.writeObject(Estudiante.getEstudiantes());
			guardar_estudiantes.close();

			ObjectOutputStream guardar_profesores = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Profesores.txt"));
			
			//ArrayList<Profesor> temp_p = Profesor.getProfesores();
			//temp_p.addAll(profesores);
			//Profesor.setProfesores(temp_p);
			guardar_profesores.writeObject(Profesor.getProfesores());
			guardar_profesores.close();

			ObjectOutputStream guardar_asignaturas = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Asignaturas.txt"));
			//ArrayList<Asignatura> temp_a = Asignatura.getAsignaturas();
			//temp_a.addAll(asignaturas);
			//Asignatura.setAsignaturas(temp_a);
			guardar_asignaturas.writeObject(Asignatura.getAsignaturas());
			guardar_asignaturas.close();

			ObjectOutputStream guardar_grados = new ObjectOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Grados.txt"));
			//ArrayList<Grado> temp_g = Grado.getGrados();
			//temp_g.addAll(grados);
			//Grado.setGrados(temp_g);
			guardar_grados.writeObject(Grado.getGrados());
			guardar_grados.close();

			// ----------------------------------------------------------------------------------------

			/*
			 * ObjectInputStream recuperar_estudiantes = new ObjectInputStream( new
			 * FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Estudiantes.txt"));
			 * estudiantes = (ArrayList<Estudiante>) recuperar_estudiantes.readObject();
			 * recuperar_estudiantes.close();
			 * 
			 * ObjectInputStream recuperar_profesores = new ObjectInputStream( new
			 * FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Profesores.txt"));
			 * profesores = (ArrayList<Profesor>) recuperar_profesores.readObject();
			 * recuperar_profesores.close();
			 * 
			 * ObjectInputStream recuperar_asignaturas = new ObjectInputStream( new
			 * FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Asignaturas.txt"));
			 * asignaturas = (ArrayList<Asignatura>) recuperar_asignaturas.readObject();
			 * recuperar_asignaturas.close();
			 * 
			 * ObjectInputStream recuperar_grados = new ObjectInputStream( new
			 * FileInputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Grados.txt")); grados
			 * = (ArrayList<Grado>) recuperar_grados.readObject(); recuperar_grados.close();
			 */

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	/*Es metodo b2 es el encargado de recuperar los datos serealizados en los correspondientes archivos de cada 
	 * tipo de objeto
	 * 
	 */
	public static void b2() {
		File archivo = new File("");
		try {
			
			ObjectInputStream recuperar_profesores = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Profesores.txt"));
			profesores = (ArrayList<Profesor>) recuperar_profesores.readObject();
			ArrayList<Profesor> temp_p = Profesor.getProfesores();
			temp_p.addAll(profesores);
			Profesor.setProfesores(temp_p);
			recuperar_profesores.close();
			
			
			ObjectInputStream recuperar_estudiantes = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Estudiantes.txt"));
			estudiantes = (ArrayList<Estudiante>) recuperar_estudiantes.readObject();
			ArrayList<Estudiante> temp_e = Estudiante.getEstudiantes();
			temp_e.addAll(estudiantes);
			Estudiante.setEstudiantes(temp_e);
			recuperar_estudiantes.close();

			ObjectInputStream recuperar_asignaturas = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Asignaturas.txt"));
			asignaturas = (ArrayList<Asignatura>) recuperar_asignaturas.readObject();
			ArrayList<Asignatura> temp_a = Asignatura.getAsignaturas();
			temp_a.addAll(asignaturas);
			Asignatura.setAsignaturas(temp_a);
			recuperar_asignaturas.close();

			ObjectInputStream recuperar_grados = new ObjectInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\src\\BaseDatos\\temp\\Grados.txt"));
			grados = (ArrayList<Grado>) recuperar_grados.readObject();
			ArrayList<Grado> temp_g = Grado.getGrados();
			temp_g.addAll(grados);
			Grado.setGrados(temp_g);
			recuperar_grados.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
