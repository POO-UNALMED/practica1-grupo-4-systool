package gestorAplicacion.perfiles;
import java.util.ArrayList;
import gestorAplicacion.academico.*;


public class Profesor extends Persona{
	private String nombre;
	private String apellido;
	private int DNI;
	private int edad;
	private String titulo_profesional;
	private String email;
	private ArrayList<Grado> grado_encargado = new ArrayList<Grado>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	
	
	public  void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public  String getNombre() {
		return nombre;
	}
	public  void setApellidos(String apellidos);
	public  String getApellidos();
	public void setDNI(int DNI) {
		this.DNI=DNI;
	}
	public  int getDNI() {
		return DNI;
	}
	public  void setEdad(int edad);
	public  int getEdad();
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
