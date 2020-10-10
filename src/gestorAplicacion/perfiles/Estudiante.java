package gestorAplicacion.perfiles;
import gestorAplicacion.academico.*;
import java.util.ArrayList;

public class Estudiante extends Persona{
	private String nombre;
	private String apellido;
	private int DNI;
	private int edad;
	private String acudiente;
	private float promedio;
	private ArrayList <Nota> notas = new ArrayList <Nota>();
	private Grado grado;
	private boolean ayuda = false;
	
	Estudiante(){
		super();
	}
	Estudiante (int DNI, String nombres, String apellidos, int edad, String acudiente, 
			ArrayList <Nota> notas, Grado grado){
		super(DNI, nombres, apellidos, edad);
		this.setAcudiente(acudiente);
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
	
	
	
	public void setAcudiente(String acudiente) {
		this.acudiente = acudiente;
	}
	public String getAcudiente() {
		return acudiente;
	}
	public float getPromedio() {
		return promedio;
	}
	public void setNotas(ArrayList <Nota> notas){
		this.notas = notas;
	}
	public ArrayList <Nota> getNotas (){
		return notas;
	}
	public void setGrado (Grado grado) {
		this.grado = grado;
	}
	public Grado getGrado () {
		return grado;
	}
	public boolean isAyuda() {
		return ayuda;
	}
	public void setAyuda(boolean ayuda) {
		this.ayuda = ayuda;
	}
	
	
	public void agregarNota(Nota cero) {
		this.notas.add(cero);
		this.prevencion_bajo_rendimiento();
		
	}
	
	public void misNotas() {
		for(Nota temp: notas){
		    System.out.println(temp.getAsignatura()+" "+temp.getCalificacion());
		}
	}
	
	public void promedio() {
		int nro_notas = this.notas.size();
		for (float i = 0; i < nro_notas; i++) {
			this.promedio += i;
		}
		this.promedio = this.promedio / nro_notas;
	}
	
	public String toString() {
		return this.getNombre()+"\n"+
				this.getApellido()+"\n"+
				this.getDNI()+"\n"+
				this.getEdad()+"\n"+
				this.getAcudiente()+"\n"+
				this.getPromedio()+"\n"+
				this.getGrado()
				;
	}
	
	//Metodo Especial
	public void prevencion_bajo_rendimiento() {
		this.promedio();
		if(this.promedio >= 2.5 && this.promedio < 3.0) {
			this.ayuda=true;
			System.out.println("El estudiante "+this.getNombre()+" "+
			this.getApellido()+" "+this.getDNI()+" necesita ayuda pedagogica");
		}
		
	}
	
	
	
	
}
