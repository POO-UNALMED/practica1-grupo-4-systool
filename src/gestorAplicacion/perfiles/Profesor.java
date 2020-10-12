package gestorAplicacion.perfiles;
import java.util.ArrayList;
import gestorAplicacion.academico.*;


public class Profesor extends Persona{
	private String titulo_profesional;
	private String email;
	private Grado grado_encargado;
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	
	public Profesor (int DNI, String nombres, String apellidos, int edad, String titulo,
			String email, Grado grado){
		super(DNI, nombres, apellidos, edad);
		this.setTitulo_profesional(titulo);
		this.setEmail(email);
		this.setGrado_encargado(grado);
	}
	public Profesor (int DNI, String nombres, String apellidos, int edad, String titulo,
			String email){
		super(DNI, nombres, apellidos, edad);
		this.setTitulo_profesional(titulo);
		this.setEmail(email);
	}
	
	public  void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public  String getNombre() {
		return nombre;
	}
	public  void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public  String getApellido() {
		return apellido;
	}
	public void setDNI(int DNI) {
		this.DNI=DNI;
	}
	public  int getDNI() {
		return DNI;
	}
	public  void setEdad(int edad) {
		this.edad=edad;
	}
	public  int getEdad() {
		return edad;
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
	public Grado getGrado_encargado() {
		return grado_encargado;
	}
	public void setGrado_encargado(Grado grado_encargado) {
		this.grado_encargado = grado_encargado;
	}
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	//Metodos
	public void agregarAsignatura(Asignatura asig) {
		this.asignaturas.add(asig);
	}
	public void cambiar_grado(Grado grado) {
		this.setGrado_encargado(grado);
	}
	public String toString() {
		return this.getNombre()+"\n"+
				this.getApellido()+"\n"+
				this.getDNI()+"\n"+
				this.getEdad()+"\n"+
				this.getTitulo_profesional()+"\n"+
				this.getEmail()
				;
	}
	
	
	
}
