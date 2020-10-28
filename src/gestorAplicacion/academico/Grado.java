package gestorAplicacion.academico;

import java.util.*;

import BaseDatos.Serializacion;

import java.io.*;

import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;
	private Profesor profesor_encargado;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
	private static ArrayList<Grado> grados = new ArrayList<Grado>();

	// Scanner
	// Scanner reader = new Scanner(System.in);
	// Constructor
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

	// M�TODOS
	public void agregarEstudiante(Estudiante nene) {
		estudiantes.add(nene);
		nene.setGrado(this);
		Serializacion.base_datos();
	}

	public void agregarAsignatura(Asignatura asi) {
		asignaturas.add(asi);
		Serializacion.base_datos();
		// asi.agregarGrado(this);
	}

	public void cambiarProfesor(Profesor profe) {
		this.setProfesor_encargado(profe);
	}

	// ESTE M�TODO RETORNA INFORMACI�N PARCIAL DE LOS ESTUDIANTES MATRICULADOS EN UN GRADO
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

	// ESTE M�TODO RETORNA INFORMACI�N PARCIAL DE LAS ASIGNATURAS DICTADAS EN UN GRADO
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

	// ESTE M�TODO ORGANIZA LA LISTA DE LOS ESTUDIANTES INSCRITOS EN EL GRADO POR SU PROMEDIO (DESCENDENTE) Y DEPENDIENDO DE LA CANTIDAD
	// DE ESTUDIANTES, MUESTRA 1/4 � UN 1/5 DE SU TOTALIDAD (LOS PRIMEROS), ES DECIR, LOS ESTUDIANTES CON EL PROMEDIO M�S ALTO.
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

	// M�TODO QUE RETORNA EL PROMEDIO DEL GRADO A PARTIR DE LA SUMA DE TODOS LOS PROMEDIOS DE SUS ESTUDIANTES Y 
	// DIVIDIRLO POR LA CANTIDAD DE LOS MISMOS.
	public float promedio_grado() {
		float promG = 0;

		for (Estudiante temp : estudiantes) {
			promG += temp.getPromedio();
		}
		return promG / this.estudiantes.size();
	}

	// ESTE M�TODO VERIFICA SI EL PROCENTAJE DE CADA ESTUDIANTE EN UN GRADO ES BAJO EN UN DETERMINADO MOMENTO DEL A�O ESCOLAR
	// E IMPRIME A DICHO ESTUDIANTE QUE CUMPLA ESTO, ES DECIR, MOSTRAR� A LOS ESTUDIANTES QUE VAYAN MAL EN EL PROMEDIO GENERAL
	// PARA AS� SUGERIRLE UNA AYUDA PEDAG�GICA Y LOGRE RECUPERAR O SUBIR DICHO PROMEDIO PARA QUE NO PIERDA EL A�O.
	public String prevencion_bajo_rendimiento() {
		String sal = "";
		for (Estudiante temp : estudiantes) {
			temp.promedio_general();
			if (temp.getPromedio() >= 0.5 && temp.getPromedio() < 1.0 && temp.avance_periodo() >= 40
					&& temp.avance_periodo() <= 60) {
				temp.setAyuda(true);
				sal += "El estudiante " + temp.getNombre() + " " + temp.getApellido() + " " + temp.getDNI()
						+ " necesita ayuda pedagogica" + "\n";
			}

		}
		Serializacion.base_datos();
		return sal;
	}

	// ESTE M�TODO BUSCA E IMPRIME A LOS ESTUDIANTES QUE NECESITARON AYUDA PEDAG�GICA, ES DECIR, QUE IBAN MAL EN UN DETERMINADO 
	// MOMENTO DEL A�O ESCOLAR Y QUE TERMINADO DICHO A�O LOGR� SUBIR EL PROMEDIO Y NO PERDIERON ESE A�O ESCOLAR.
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
