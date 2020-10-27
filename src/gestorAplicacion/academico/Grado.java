package gestorAplicacion.academico;
import java.util.*;

import BaseDatos.Serializacion;

import java.io.*;

import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Profesor profesor_encargado;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	private static ArrayList<Grado> grados = new ArrayList<Grado>();
	
	//Scanner
	//Scanner reader = new Scanner(System.in);
	//Constructor
	public Grado(String id, Profesor lider){
		this.setId(id);
		this.setProfesor_encargado(lider);
		grados.add(this);
		Serializacion.base_datos();
	}
	public Grado(String id){
		this.setId(id);
		this.profesor_encargado=null;
		grados.add(this);
		Serializacion.base_datos();
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
	
	public static ArrayList<Grado> getGrados() {
		return grados;
	}
	public static void setGrados(ArrayList<Grado> grados) {
		Grado.grados = grados;
	} 
	
	//Metodos
	public void agregarEstudiante(Estudiante nene){
		estudiantes.add(nene);
		nene.setGrado(this);
	}
	public void agregarAsignatura(Asignatura asi) {
		asignaturas.add(asi);
		//asi.agregarGrado(this);
	}
	public void cambiarProfesor(Profesor profe) {
		this.setProfesor_encargado(profe);
	}
	public void elimarAsignatura(Asignatura asi, String index) {
		
	}
	public void eliminarEstudiante(Estudiante nene, String index) {
		
	}
	public String estudiantesInscritos() {
		Collections.sort(estudiantes, new Comparator <Estudiante>() {
			   public int compare(Estudiante obj1, Estudiante obj2) {
			      return obj1.getApellido().compareTo(obj2.getApellido());
			   }
			});
		String sal="";
		for(Estudiante temp: estudiantes) {
			sal+=temp.getDNI()+": "+temp.getApellido()+" "+temp.getNombre()+"\n";
		}
		return sal;
	}
	public String asignaturasDelGrado() {
		String sal="";
		for(Asignatura temp: asignaturas) {
			sal+=temp.getNombre()+"\n";
		}
		return sal;
	}
	
	public String toString() {
		String salida = "";
		if(this.getProfesor_encargado() != null) {
			salida = "Nombre del grado:" + this.getId()+"\n"
					+"Profesor encargado: "+this.getProfesor_encargado();
		}else {
			salida = "Nombre del grado:" + this.getId();
		}
		return salida;
	}
	//Funcionalidades Especiales
	
	
	public String cuadro_Honor(){
		String sal="";
		if(estudiantes.size()>0) {
			Collections.sort(estudiantes, new Comparator <Estudiante>() {
				   public int compare(Estudiante obj1, Estudiante obj2) {
				      return new Float (obj2.getPromedio()).compareTo(obj1.getPromedio());
				   }
				});
			
			if(estudiantes.size()%2==0) {
				for(int i=0;i<estudiantes.size()/4;i++){
				    sal+=estudiantes.get(i).getPromedio()+" "+
				    		estudiantes.get(i).getNombre()+" "+
				    		estudiantes.get(i).getApellido()
				    		+"\n";
				}
			}
			else {
				for(int i=0;i<estudiantes.size()/3;i++){
					sal+=estudiantes.get(i).getPromedio()+" "+
				    		estudiantes.get(i).getNombre()+" "+
				    		estudiantes.get(i).getApellido()
				    		+"\n";
				}
			}
		}else {
			sal="No tenemos estudiantes en este grado";
		}
		return sal;
		
		
	}
	
	public void reporte_notas_individual(int dn) {
		//this.estudiantesInscritos();
		//System.out.println("Ingrese un DNI: ");
		//int dn = reader.nextInt();
		for(Estudiante temp: estudiantes){
		    if(dn == temp.getDNI()) {
		    	temp.misNotas();
		    }
		}
		
		
	}
	
	public float promedio_grado() {
		float promG = 0;
		
		for(Estudiante temp: estudiantes){
		    promG += temp.getPromedio();
		}
		return promG/this.estudiantes.size();
	}

	public String cuadro_superacion() {
		Collections.sort(estudiantes, new Comparator <Estudiante>() {
			   public int compare(Estudiante obj1, Estudiante obj2) {
			      return new Float (obj2.getPromedio()).compareTo(obj1.getPromedio());
			   }
			});
		String sal ="";
		for(Estudiante temp: estudiantes){
			    if(temp.isAyuda() == true && temp.getPromedio()>=3.0&&temp.porcentaje_periodo()==true) {
			    	sal+=temp.getPromedio()+" "+
				    		temp.getNombre()+" "+
				    		temp.getApellido()
				    		+"\n";
			    }
		}
		return sal;
	}
	
	public String prevencion_bajo_rendimiento() {
		String sal="";
		for(Estudiante temp: estudiantes){
			temp.promedio_general();
			if(temp.getPromedio() >= 0.5 && temp.getPromedio() < 1.0 && temp.avance_periodo()>=40 && temp.avance_periodo()<=60) {
				temp.setAyuda(true);
				sal +="El estudiante "+temp.getNombre()+" "+
						temp.getApellido()+" "+temp.getDNI()+" necesita ayuda pedagogica"+"\n";
			}
		
		}
		return sal;
	}
}
