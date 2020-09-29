package gestorAplicacion.perfiles;

public class Persona {
	private int DNI;
	private String nombres;
	private String apellidos;
	private int edad;
	
	Persona(){}
	Persona(int DNI, String nombres, String apellidos, int edad){
		this.setDNI(DNI);
		this.setNombres(nombres);
		this.setApellidos(apellidos);
		this.setEdad(edad);
	}
	public void setDNI(int DNI) {
		this.DNI = DNI;
	}
	public int getDNI() {
		return DNI;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getNombres() {
		return nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getEdad() {
		return edad;
	}
}
