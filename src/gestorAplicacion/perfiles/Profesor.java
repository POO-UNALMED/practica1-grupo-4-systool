package gestorAplicacion.perfiles;
import java.util.ArrayList;
import gestorAplicacion.academico.*;


public class Profesor extends Persona{
	private String titulo_profesional;
	private String email;
	private int telefono;
	private ArrayList<Grado> grado_encargado = new ArrayList<Grado>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getTitulo_profesional() {
		return titulo_profesional;
	}
	public void setTitulo_profesional(String titulo_profesional) {
		this.titulo_profesional = titulo_profesional;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Grado> getGrado_encargado() {
		return grado_encargado;
	}
	public void setGrado_encargado(ArrayList<Grado> grado_encargado) {
		this.grado_encargado = grado_encargado;
	}
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

}
