package gestorAplicacion.perfiles;
import gestorAplicacion.academico.*;
import java.util.ArrayList;

public class Estudiante extends Persona{
	private String acudiente;
	private String direccion;
	private int telefono;
	private float promedio;
	private ArrayList <Nota> notas = new ArrayList <Nota>();
	private Grado grado;
	
	Estudiante(){
		super();
	}
	Estudiante (String acudiente, String direccion, int telefono, float promedio, ArrayList <Nota> notas, Grado grado){
		this.setAcudiente(acudiente);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
	}
	
	public void setAcudiente(String acudiente) {
		this.acudiente = acudiente;
	}
	public String getAcudiente() {
		return acudiente;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getTelefono() {
		return telefono;
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
