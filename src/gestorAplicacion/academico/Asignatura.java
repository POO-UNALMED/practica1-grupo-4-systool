package gestorAplicacion.academico;
import gestorAplicacion.perfiles.*;
import java.util.ArrayList;

import BaseDatos.Serializacion;

import java.io.*;
//CLASE NECESARIA PARA SABER QUE MATERIAS SE DICTAN EN LOS GRADOS Y QUE ESTUDIANTES LA VEN
public class Asignatura implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	public int numero_notas;
	public float porcentaje_avance;
	private ArrayList <Grado> grados = new ArrayList <Grado>();
	private ArrayList <Profesor> profesores = new ArrayList <Profesor>();
	private ArrayList <Nota> calificaciones = new ArrayList <Nota>();
	private static ArrayList <Asignatura> asignaturas = new ArrayList <Asignatura>();

	public Asignatura (int id, String nombre, String descripcion,int numero) {
		this.setId(id);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setNumero_notas(numero);
		asignaturas.add(this);
		Serializacion.base_datos();
	}
	public Asignatura (int id, String nombre, int numero) {
		this.setId(id);
		this.setNombre(nombre);
		this.setNumero_notas(numero);
		asignaturas.add(this);
		Serializacion.base_datos();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList <Grado> getGrados() {
		return grados;
	}
	public void setGrados(ArrayList <Grado> grados) {
		this.grados = grados;
	}
	public void agregarGrado(Grado g) {
		this.grados.add(g);
	}
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
		
		for (Grado grad:grados) {
			grad.porcentaAsignatura(this);
		}
		return porcentaje_avance;
	}
	
	public void setPorcentaje_avance(float porcentaje_avance) {
		this.porcentaje_avance = porcentaje_avance;
	}
	
	//MÉTODOS
	
	public String toString(){
		return "ID: "+this.getId()+"\n"+
				"Nombre: "+this.getNombre()+"\n"+
				"Descripción: "+this.getDescripcion()+"\n"+
				"Numero de notas: "+this.getNumero_notas()+"\n"+
				"Porcentaje de avance: "+ this.getPorcentaje_avance();
	} 
	
	public void agregarNota(Nota cero) {
		calificaciones.add(cero);
		Serializacion.base_datos();
	}
	public void crearNota(float calif, String observacion, Estudiante studen) {
		Nota x = new Nota(calif,observacion,studen, this);
		agregarNota(x);
		studen.agregarNota(x);
		Serializacion.base_datos();
	}
	public void crearNota(float calif, Estudiante studen) {
		Nota x = new Nota(calif,studen, this);
		agregarNota(x);
		studen.agregarNota(x);
		Serializacion.base_datos();
	}

	
}
