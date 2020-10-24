package gestorAplicacion.perfiles;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	protected int DNI;
	protected String nombre;
	protected String apellido;
	protected int edad;
	
	protected Persona(){}
	protected Persona(int DNI, String nombre, String apellido, int edad){
		this.setDNI(DNI);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEdad(edad);
	}
	

	public abstract void setDNI(int DNI);
	public abstract  int getDNI();
	public abstract  void setNombre(String nombre);
	public abstract  String getNombre() ;
	public abstract  void setApellido(String apellido);
	public abstract  String getApellido();
	public abstract  void setEdad(int edad);
	public abstract  int getEdad();
	
	public abstract String toString();
}
