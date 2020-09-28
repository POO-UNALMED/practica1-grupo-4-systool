package gestorAplicacion.academico;
import java.util.ArrayList;
import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Grado {
	private String id;
	private Profesor profesor_encargado;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	
	//Constructor
	Grado(String id, Profesor lider){
		this.setId(id);
		this.setProfesor_encargado(lider);
	}
	
	
	//Getters y Setters de los atributos.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Profesor getProfesor_encargado() {
		return profesor_encargado;
	}
	public void setProfesor_encargado(Profesor profesor_encargado) {
		this.profesor_encargado = profesor_encargado;
	}
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	//Metodos
	public void agregarEstudiante(Estudiante nene){
		estudiantes.add(nene);
		nene.setGrado(this);
	}
	public void agregarAsignatura(Asignatura asi) {
		asignaturas.add(asi);
		asi.agregarGrado(this);
	}
	public void cambiarProfesor(Profesor profe) {
		this.setProfesor_encargado(profe);
	}
	public void elimarAsignatura(Asignatura asi, String index) {
		
	}
	public void eliminarEstudiante(Estudiante nene, String index) {
		
	}
	public void estudiantesInscritos() {
		for(int i=0;i<estudiantes.size();i++) {
			System.out.println(estudiantes.get(i).getNombre()+" "+estudiantes.get(i).getApellido());
		}
	}
	public void asignaturasDelGrado() {
		for(int i=0;i<asignaturas.size();i++) {
			System.out.println(asignaturas.get(i).getNombre();
		}
	}
	
	
	
	
	
	
}
