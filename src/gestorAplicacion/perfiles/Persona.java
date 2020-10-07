package gestorAplicacion.perfiles;

public abstract class Persona {
	protected int DNI;
	protected String nombres;
	protected String apellidos;
	protected int edad;
	
	protected Persona(){}
	protected Persona(int DNI, String nombres, String apellidos, int edad){
		this.setDNI(DNI);
		this.setNombres(nombres);
		this.setApellidos(apellidos);
		this.setEdad(edad);
	}
	

	public abstract void setDNI(int DNI);
	public abstract  int getDNI();
	public abstract  void setNombres(String nombres);
	public abstract  String getNombres() ;
	public abstract  void setApellidos(String apellidos);
	public abstract  String getApellidos();
	public abstract  void setEdad(int edad);
	public abstract  int getEdad();
	
	
}
