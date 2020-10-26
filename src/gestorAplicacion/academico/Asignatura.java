package gestorAplicacion.academico;
import gestorAplicacion.perfiles.*;
import java.util.ArrayList;
import java.io.*;

public class Asignatura implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	public int numero_notas;
	public float porcentaje_avance;
	//private ArrayList <Grado> grados = new ArrayList <Grado>();
	private ArrayList <Profesor> profesores = new ArrayList <Profesor>();
	private ArrayList <Nota> calificaciones = new ArrayList <Nota>();
	private static ArrayList <Asignatura> asignaturas = new ArrayList <Asignatura>();

	public Asignatura (String nombre, String descripcion,int numero) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setNumero_notas(numero);
		asignaturas.add(this);
	}
/*
	public ArrayList <Grado> getGrados() {
		return grados;
	}
	public void setGrados(ArrayList <Grado> grados) {
		this.grados = grados;
	}*/
	public int getNumero_notas() {
		return numero_notas;
	}
	public void setNumero_notas(int numer) {
		this.numero_notas=numer;
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
	
	public static ArrayList <Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public static void setAsignaturas(ArrayList <Asignatura> asignaturas) {
		Asignatura.asignaturas = asignaturas;
	}
	
	
	public float getPorcentaje_avance() {
		float porcentaje_avance_nota=100/numero_notas;
		porcentaje_avance=porcentaje_avance_nota*calificaciones.size();
		return porcentaje_avance;
	}
	public void setPorcentaje_avance(float porcentaje_avance) {
		this.porcentaje_avance = porcentaje_avance;
	}
	//Metodos
	
	public String toString(){
		return "Nombre: "+this.getNombre()+"\n"+
				"Descripción: "+this.getDescripcion()+"\n"+
				"Numero de notas: "+this.getNumero_notas()+"\n"+
				"Porcentaje de avance: "+this.getPorcentaje_avance();
		
	}
	
	
	
	
	/*public void agregarGrado(Grado grad) {
		grados.add(grad);
			/*Este metodo es para poder asignarle a la lista
			de grados el grado en el que esta la asigantura
			dandosela desde Grado
			*/
	//}
	public void agregarNota(Nota cero) {
		calificaciones.add(cero);
			/*Este metodo es para poder asignarle a la lista
			de grados el grado en el que esta la asigantura
			dandosela desde Grado
			*/
	}public void crearNota(float calif, String observacion, Estudiante studen) {
		Nota x = new Nota(calif,observacion,studen, this);
		agregarNota(x);
		studen.agregarNota(x);
	}public void crearNota(float calif, Estudiante studen) {
		Nota x = new Nota(calif,studen, this);
		agregarNota(x);
		studen.agregarNota(x);
	}

	
}
