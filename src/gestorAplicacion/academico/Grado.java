package gestorAplicacion.academico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Grado {
	private String id;
	private Profesor profesor_encargado;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	
	//Scanner
	Scanner reader = new Scanner(System.in);
	//Constructor
	Grado(String id, Profesor lider){
		this.setId(id);
		this.setProfesor_encargado(lider);
	}
	Grado(String id){
		this.setId(id);
		this.profesor_encargado=null;
	}
	
	//Getters y Setters
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
	public ArrayList <Estudiante> getEstudiantes() {
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
		Collections.sort(estudiantes, new Comparator <Estudiante>() {
			   public int compare(Estudiante obj1, Estudiante obj2) {
			      return obj1.getApellido().compareTo(obj2.getApellido());
			   }
			});
		for(Estudiante temp: estudiantes) {
			System.out.println(temp.getDNI()+": "+temp.getApellido()+" "+temp.getNombre());
		}
	}
	public void asignaturasDelGrado() {
		for(Asignatura temp: asignaturas) {
			System.out.println(temp.getNombre());
		}
	}

	//Funcionalidades Especiales
	
	
	public void cuadro_Honor(){
		Collections.sort(estudiantes, new Comparator <Estudiante>() {
			   public int compare(Estudiante obj1, Estudiante obj2) {
			      return new Float (obj2.getPromedio()).compareTo(obj1.getPromedio());
			   }
			});
		if(estudiantes.size()%2==0) {
			for(int i=0;i<estudiantes.size()/2;i++){
			    System.out.println(estudiantes.get(i).getPromedio()+" "+
			    		estudiantes.get(i).getNombre()+" "+
			    		estudiantes.get(i).getApellido()
			    		);
			}
		}
		else {
			for(int i=0;i<estudiantes.size()/3;i++){
				System.out.println(estudiantes.get(i).getPromedio()+" "+
			    		estudiantes.get(i).getNombre()+" "+
			    		estudiantes.get(i).getApellido()
			    		);
			}
		}
		
		
		
	}
	
	public void reporte_notas_individual() {
		this.estudiantesInscritos();
		System.out.println("Ingrese un DNI: ");
		int dn = reader.nextInt();
		for(Estudiante temp: estudiantes){
		    if(dn == temp.getDNI()) {
		    	temp.misNotas();
		    }
		}
		
		
	}
	
	public void promedio_grado() {
		float promG = 0;
		
		for(Estudiante temp: estudiantes){
		    promG += temp.getPromedio();
		}
		System.out.println(promG/this.estudiantes.size());
	}

	public void cuadro_superacion() {
		Collections.sort(estudiantes, new Comparator <Estudiante>() {
			   public int compare(Estudiante obj1, Estudiante obj2) {
			      return new Float (obj2.getPromedio()).compareTo(obj1.getPromedio());
			   }
			});
		for(Estudiante temp: estudiantes){
		    if(temp.isAyuda() == true && temp.getPromedio()>=3.0) {
		    	System.out.println(temp.getPromedio()+" "+
			    		temp.getNombre()+" "+
			    		temp.getApellido()
			    		);
		    }
		}
	}
}
