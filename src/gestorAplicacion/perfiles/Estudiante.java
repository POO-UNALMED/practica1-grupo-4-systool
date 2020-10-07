package gestorAplicacion.perfiles;
import gestorAplicacion.academico.*;
import java.util.ArrayList;

public class Estudiante extends Persona{
	private String acudiente;
	private float promedio;
	private ArrayList <Nota> notas = new ArrayList <Nota>();
	private Grado grado;
	
	Estudiante(){
		super();
	}
	Estudiante (int DNI, String nombres, String apellidos, int edad, String acudiente, 
			ArrayList <Nota> notas, Grado grado){
		super(DNI, nombres, apellidos, edad);
		this.setAcudiente(acudiente);
	}
	
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
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
	
	private void promedio(ArrayList <Nota> notas) {
		int nro_notas = notas.size();
		for (float i = 0; i < nro_notas; i++) {
			this.promedio += i;
		}
		this.promedio = this.promedio / nro_notas;
	}
	
}
