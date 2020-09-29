package gestorAplicacion.academico;

import java.util.ArrayList;
import gestorAplicacion.perfiles.*;

public class Asignatura {
	
	private String nombre;
	private String descripcion;
	public byte numero_notas;
	public float porcentaje_avance;
	private ArrayList <Grado> grados = new ArrayList <Grado>();
	private ArrayList <Profesor> profesores = new ArrayList <Profesor>();
	private ArrayList <Nota> calificaciones = new ArrayList <Nota>();

	public ArrayList <Grado> getGrados() {
		return grados;
	}
	public void setGrados(ArrayList <Grado> grados) {
		this.grados = grados;
	}
	
	//Metodos
	
	public void agregarGrado(Grado grad) {
		grados.add(grad);
		/*Este metodo es para poder asignarle a la lista
		de grados el grado en el que esta la asigantura
		dandosela desde Grado
		*/
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList <Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}
	public ArrayList <Nota> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(ArrayList <Nota> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
}
