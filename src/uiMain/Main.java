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
		
		Profesor p1 = new Profesor (12, "p1", "p11", 95, "ciencias", "p11@unal");
		Grado g1 = new Grado ("quinto", p1);
		Estudiante e1 = new Estudiante(1, "d", "g", 10, "ac", g1);
		
		// esto va al final del main, es la exportación de los datos creados
		
		ArrayList<Estudiante> estudiantes = new ArrayList<>();
		ArrayList<Profesor> profesores = new ArrayList<>();
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		ArrayList<Grado> grados = new ArrayList<>();
		
		try {
			ObjectOutputStream guardar_estudiantes = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Estudiantes.txt"));
			guardar_estudiantes.writeObject(Estudiante.getEstudiantes());
			guardar_estudiantes.close();
			
			ObjectOutputStream guardar_profesores = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Profesores.txt"));
			//guardar_profesores.writeObject(Profesor.getProfesores());
			guardar_profesores.close();
			
			ObjectOutputStream guardar_asignaturas = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Asignaturas.txt"));
			//guardar_asignaturas.writeObject(Asignatura.getAsignaturas());
			guardar_asignaturas.close();
			
			ObjectOutputStream guardar_grados = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ASUS\\Desktop\\Serializar\\Grados.txt"));
			//guardar_grados.writeObject(Grado.getGrados());
			guardar_grados.close();
			
			ObjectInputStream recuperar_estudiantes = new ObjectInputStream(new FileInputStream ("C:\\Users\\ASUS\\Desktop\\Serializar\\Estudiantes.txt"));
			estudiantes = (ArrayList<Estudiante>) recuperar_estudiantes.readObject();
			recuperar_estudiantes.close();
			
			ObjectInputStream recuperar_profesores = new ObjectInputStream(new FileInputStream ("C:\\Users\\ASUS\\Desktop\\Serializar\\Profesores.txt"));
			profesores = (ArrayList<Profesor>) recuperar_profesores.readObject();
			recuperar_profesores.close();
			
			ObjectInputStream recuperar_asignaturas = new ObjectInputStream(new FileInputStream ("C:\\Users\\ASUS\\Desktop\\Serializar\\Asignaturas.txt"));
			asignaturas = (ArrayList<Asignatura>) recuperar_asignaturas.readObject();
			recuperar_asignaturas.close();
			
			ObjectInputStream recuperar_grados = new ObjectInputStream(new FileInputStream ("C:\\Users\\ASUS\\Desktop\\Serializar\\Grados.txt"));
			grados = (ArrayList<Grado>) recuperar_grados.readObject();
			recuperar_grados.close();
			
			
		}catch(Exception e) {
			
		}
		
		System.out.println(estudiantes);
		System.out.println(profesores);
		System.out.println(asignaturas);
		System.out.println(grados);

	}

}
