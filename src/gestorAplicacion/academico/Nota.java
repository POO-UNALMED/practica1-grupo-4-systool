package gestorAplicacion.academico;

import gestorAplicacion.perfiles.Estudiante;

public class Nota {
	private float calificacion;
	private String observacion;
	private Estudiante estudiante;
	private Asignatura asignatura;
	
	public Nota(float calif, String observacion, Estudiante studen, Asignatura asigna){
		this.calificacion=calif;
		this.observacion=observacion;
		this.estudiante=studen;
		this.asignatura=asigna;
	}
	public Nota(float calif, Estudiante studen, Asignatura asigna){
		this.calificacion=calif;
		this.observacion=null;
		this.estudiante=studen;
		this.asignatura=asigna;
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
	
	
	
	
	
	
	
	
	
	
}
