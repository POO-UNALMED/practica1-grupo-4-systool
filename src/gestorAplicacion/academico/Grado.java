package gestorAplicacion.academico;

import java.util.*;

import BaseDatos.Serializacion;

import java.io.*;

import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;
//CLASE NECESARIA PARA SABER EN QUE GRUPO ESTAN LOS ESTUDIANTES Y LAS MATERIAS QUE VEN
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;
	private Profesor profesor_encargado;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	private static ArrayList<Grado> grados = new ArrayList<Grado>();

	public Grado(int id, String nombre, Profesor lider) {
		this.setId(id);
		this.setNombre(nombre);
		this.setProfesor_encargado(lider);
		grados.add(this);
		Serializacion.base_datos();
	}

	public Grado(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
		this.profesor_encargado = null;
		grados.add(this);
		Serializacion.base_datos();
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor_encargado() {
		return profesor_encargado;
	}

	public void setProfesor_encargado(Profesor profesor_encargado) {
		this.profesor_encargado = profesor_encargado;
		Serializacion.base_datos();
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

	public static ArrayList<Grado> getGrados() {
		return grados;
	}

	public static void setGrados(ArrayList<Grado> grados) {
		Grado.grados = grados;
	}

	// MÉTODOS
	public float porcentaAsignatura(Asignatura idasi) {
		float cont1=0;
		float cont2=0;
		for (Estudiante est: estudiantes) {
			for (Nota temp: est.getNotas()) {
				if(temp.getAsignatura()==idasi) {
					cont1++;
				}
			}if (cont1>cont2) {
				cont2=cont1;
				cont1=0;
			}
			
		}
		float porcentaje_avance_nota=100/idasi.numero_notas;
		float porcentaje_avance=porcentaje_avance_nota*cont2;
		idasi.setPorcentaje_avance(porcentaje_avance);
		return porcentaje_avance;
	}
	public void agregarEstudiante(Estudiante nene) {
		estudiantes.add(nene);
		nene.setGrado(this);
		Serializacion.base_datos();
	}

	public void agregarAsignatura(Asignatura asi) {
		asignaturas.add(asi);
		asi.agregarGrado(this);
		Serializacion.base_datos();
		// asi.agregarGrado(this);
	}

	public void cambiarProfesor(Profesor profe) {
		this.setProfesor_encargado(profe);
	}

	// ESTE MÉTODO RETORNA INFORMACIÓN PARCIAL DE LOS ESTUDIANTES MATRICULADOS EN UN GRADO
	public String estudiantesInscritos() {
		Collections.sort(estudiantes, new Comparator<Estudiante>() {
			public int compare(Estudiante obj1, Estudiante obj2) {
				return obj1.getApellido().compareTo(obj2.getApellido());
			}
		});
		String sal = "";
		for (Estudiante temp : estudiantes) {
			sal += temp.getDNI() + ": " + temp.getApellido() + " " + temp.getNombre() + "\n";
		}
		return sal;
	}

	// ESTE MÉTODO RETORNA INFORMACIÓN PARCIAL DE LAS ASIGNATURAS DICTADAS EN UN GRADO
	public String asignaturasDelGrado() {
		String sal = "";
		for (Asignatura temp : asignaturas) {
			sal += temp.getNombre() + "\n";
		}
		return sal;
	}

	public String toString() {
		String salida = "";
		if (this.getProfesor_encargado() != null) {
			salida = "ID del grado:" + this.getId() + "\n" + "Nombre del grado:" + this.getNombre() + "\n"
					+ "Profesor encargado: {" + this.getProfesor_encargado() + "}" + "\n" + "Asignaturas: {"
					+ this.asignaturasDelGrado() + "}";
		} else {
			salida = "ID del grado:" + this.getId() + "\n" + "Nombre del grado:" + this.getNombre() + "\n"
					+ "Asignaturas: {" + this.asignaturasDelGrado() + "}";
		}
		return salida;
	}
	// ------------------------------------------ FUNCIONALIDADES ESPECIALES ------------------------------------------

	
	public String cuadro_Honor() {
		String sal = "";
		for (Estudiante temp : this.estudiantes) {
			temp.promedio_general();
			System.out.println(temp.toString());
		}
		if (this.estudiantes.size() > 0) {
			Collections.sort(estudiantes, new Comparator<Estudiante>() {
				public int compare(Estudiante obj1, Estudiante obj2) {
					return new Float(obj2.getPromedio()).compareTo(obj1.getPromedio());
				}
			});

			if (this.estudiantes.size() % 2 == 0) {
				for (int i = 0; i < this.estudiantes.size() / 4; i++) {
					sal += estudiantes.get(i).getPromedio() + " " + estudiantes.get(i).getNombre() + " "
							+ estudiantes.get(i).getApellido() + "\n";
				}
			} else {
				for (int i = 0; i < this.estudiantes.size() / 3; i++) {
					sal += estudiantes.get(i).getPromedio() + " " + estudiantes.get(i).getNombre() + " "
							+ estudiantes.get(i).getApellido() + "\n";
				}
			}
		} else {
			sal = "No tenemos estudiantes en este grado";
		}
		return sal;

	}

	public void reporte_notas_individual(int dn) {
		for (Estudiante temp : estudiantes) {
			if (dn == temp.getDNI()) {
				temp.misNotas();
			}
		}

	}

	
	public float promedio_grado() {
		float promG = 0;

		for (Estudiante temp : estudiantes) {
			promG += temp.getPromedio();
		}
		return promG / this.estudiantes.size();
	}

	// ESTE MÉTODO BUSCA E IMPRIME A LOS ESTUDIANTES QUE NECESITARON AYUDA PEDAGÓGICA, ES DECIR, QUE IBAN MAL EN UN DETERMINADO 
	// MOMENTO DEL AÑO ESCOLAR Y QUE TERMINADO DICHO AÑO LOGRÓ SUBIR EL PROMEDIO Y NO PERDIERON ESE AÑO ESCOLAR.
	public String cuadro_superacion() {
		Collections.sort(estudiantes, new Comparator<Estudiante>() {
			public int compare(Estudiante obj1, Estudiante obj2) {
				return new Float(obj2.getPromedio()).compareTo(obj1.getPromedio());
			}
		});
		String sal = "";
		for (Estudiante temp : estudiantes) {
			if (temp.isAyuda() == true && temp.getPromedio() >= 3.0 && temp.porcentaje_periodo() == true) {
				sal += temp.getPromedio() + " " + temp.getNombre() + " " + temp.getApellido() + "\n";
			}
		}
		return sal;
	}
}
