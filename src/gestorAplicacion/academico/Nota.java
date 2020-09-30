package gestorAplicacion.academico;

import gestorAplicacion.perfiles.Estudiante;

public class Nota {
	private float calificacion;
	private String observacion;
	private Estudiante estudiante;
	private Asignatura asignatura;
	
	
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
