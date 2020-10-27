package gestorAplicacion.academico;
import gestorAplicacion.perfiles.Estudiante;
import java.util.ArrayList;

import BaseDatos.Serializacion;

import java.io.*;

public class Nota implements Serializable{
	private static final long serialVersionUID = 1L;
	private float calificacion;
	private String observacion;
	private Estudiante estudiante;
	private Asignatura asignatura;
	private static ArrayList<Nota> notas = new ArrayList<Nota>();
	
	public Nota(float calif, String observacion, Estudiante studen, Asignatura asigna){
		this.calificacion=calif;
		this.observacion=observacion;
		this.estudiante=studen;
		this.asignatura=asigna;
		studen.agregarNota(this);
		notas.add(this);
		Serializacion.base_datos();
	}
	public Nota(float calif, Estudiante studen, Asignatura asigna){
		this.calificacion=calif;
		this.observacion=null;
		this.estudiante=studen;
		this.asignatura=asigna;
		studen.agregarNota(this);
		notas.add(this);
		Serializacion.base_datos();
	}
	
	
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public static ArrayList<Nota> getNotas() {
		return notas;
	}
	public static void setNotas(ArrayList<Nota> notas) {
		Nota.notas = notas;
	}
	
	/*public Nota agregar_nota(float calif, String observacion, Estudiante studen, Asignatura asigna) {
		Nota nota = new Nota(calif,observacion,studen,asigna);
		return nota;
	}
	public Nota agregar_nota(float calif, Estudiante studen, Asignatura asigna) {
		Nota nota = new Nota(calif,studen,asigna);
		return nota;
	}*/
}
