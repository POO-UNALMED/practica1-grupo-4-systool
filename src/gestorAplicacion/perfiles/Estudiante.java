package gestorAplicacion.perfiles;
import gestorAplicacion.academico.*;
import java.util.*;

import BaseDatos.Serializacion;

import java.io.*;

public class Estudiante extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	private String acudiente;
	private float promedio;
	private ArrayList <Nota> notas = new ArrayList <Nota>();
	private HashMap <String,Float> promedios = new HashMap <String,Float>();
	private static ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private Grado grado;
	private boolean ayuda = false;
	
	public Estudiante (int DNI, String nombres, String apellidos, int edad, String acudiente){
		super(DNI, nombres, apellidos, edad);
		this.setAcudiente(acudiente);
		estudiantes.add(this);
		Serializacion.base_datos();
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
	}public void setPromedio(float prom){
		this.promedio = prom;
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
	public static ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public static void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		Estudiante.estudiantes = estudiantes;
	}

	public void agregarNota(Nota cero) {
		this.notas.add(cero);
		Serializacion.base_datos();
		//this.prevencion_bajo_rendimiento();
		
	}
	
	public String misNotas() {
		Collections.sort(notas, new Comparator <Nota>() {
			   public int compare(Nota obj1, Nota obj2) {
			      return obj1.getAsignatura().getNombre().compareTo(obj2.getAsignatura().getNombre());
			   }
			});
		String sal="";
		int comp=0;
		/*for(Nota temp: notas){
			if(comp==0) {
				comp=temp.getAsignatura().getId();
				sal+=temp.getAsignatura().getNombre()+" "+temp.getCalificacion();
			}
			else if (temp.getAsignatura().getId()!=comp) {
				comp=temp.getAsignatura().getId();
				sal+="\n";
				sal+=temp.getAsignatura().getNombre()+" "+temp.getCalificacion();
			}
			else if (temp.getAsignatura().getId()==comp) {
				sal+=" "+temp.getAsignatura();
			}
		}*/
		for(Nota temp:notas) {
			sal+=temp.getAsignatura().getNombre() +" "+temp.getCalificacion()+"\n";
		}
		
		
		return sal;
	}
	
	public float promedio_asignatura(Asignatura asi) {
		float nro_notas = 0;
		int iter=0;
		for(Nota temp: notas){
		    if(temp.getAsignatura()==asi) {
		    	nro_notas+=temp.getCalificacion();
		    	iter++;
		    }
		}
		nro_notas = nro_notas / iter;
		promedios.put(asi.getNombre(), nro_notas);
		Serializacion.base_datos();
		return nro_notas;
	}
	public void promedios() {
		for(Nota temp: notas){
			promedio_asignatura(temp.getAsignatura());
		}
	}
	
	public void promedio_general() {
		float promediog=0;
		promedios();
		if (promedios.size()>0) {
			for (Map.Entry<String, Float> entry : promedios.entrySet()) {
			    promediog+=entry.getValue();
			}
			this.setPromedio(promediog/this.promedios.size());
		}else {
			this.setPromedio(0);
		}
	}
	public Boolean porcentaje_periodo() {
		int x=0,y=0;
		boolean t=false;
		for (Map.Entry<String, Float> entry : promedios.entrySet()) {
		    //.getValue(); .getKey();
			for(Nota temp: notas) {
				if(entry.getKey().equals(temp.getAsignatura().getNombre())) {
					if(temp.getAsignatura().getPorcentaje_avance()==100) {
						t=true;
					}else {
					}t=false;
				}
			}if(t==true) {
				x++;
			}y++;
		}if (y==x) {
			return true;
		}else {
			return false;
		}
	}
	public float avance_asignatura(String asi) {
		float por = 0;
		for(Nota temp: notas) {
			if (temp.getAsignatura().getNombre().equals(asi)){
				por= temp.getAsignatura().getPorcentaje_avance() ;
			}
		}return por;
	}
	public float avance_periodo () {
		short ayuda=0;
		for (Map.Entry<String, Float> entry : promedios.entrySet()) {
			ayuda+=avance_asignatura(entry.getKey());
		}return ayuda/promedios.size();
	}
	public String toString() {
		return "Primer nombre: "+this.getNombre()+"\n"+
				"Primer Apellido: "+this.getApellido()+"\n"+
				"DNI: "+this.getDNI()+"\n"+
				"Edad: "+this.getEdad()+"\n"+
				"Acudiente: "+this.getAcudiente()+"\n"+
				"Promedio: "+this.getPromedio()+"\n"+
				"Grado: "+this.getGrado()
				;
	}
	
	//Metodo Especial
	/*public void prevencion_bajo_rendimiento() {
		this.promedio_general();
		if(this.promedio >= 0.5 && this.promedio < 1.0 && this.avance_periodo()>=40 && this.avance_periodo()<=60) {
			this.ayuda=true;
			System.out.println("El estudiante "+this.getNombre()+" "+
			this.getApellido()+" "+this.getDNI()+" necesita ayuda pedagogica");
		}
		
	}
	*/
	public static String mejores_colegio() {
		Collections.sort(estudiantes, new Comparator <Estudiante>() {
			   public int compare(Estudiante obj1, Estudiante obj2) {
			      return new Float(obj2.getPromedio()).compareTo(obj1.getPromedio());
			   }
			});
		String sal=""
;		for (int i = 0; i < 9; i++) {
			sal+=estudiantes.get(i).toString() + "\n";
		}
		return sal;
	}
	
	
}
