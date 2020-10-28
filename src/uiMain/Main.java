package uiMain;

import java.util.*;

import BaseDatos.Serializacion;
import gestorAplicacion.academico.Asignatura;
import gestorAplicacion.academico.Grado;
import gestorAplicacion.academico.Nota;
import gestorAplicacion.perfiles.Estudiante;
import gestorAplicacion.perfiles.Profesor;

public class Main {

	public static void inicio() {
		System.out.println("BIENVENIDO A SYSTOOL V1.1 C5.0");
		System.out.println("Por favor escoja una opción para acceder a sus funcionalidades:");
		System.out.println("1. Estudiante");
		System.out.println("2. Profesor");
		System.out.println("3. Grado");
		System.out.println("4. Asignatura");
		System.out.println("5. Salir");
	}

	//@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Serializacion.b2();
		ArrayList<Estudiante> estudiantes = Serializacion.getEstudiantes();
		ArrayList<Profesor> profesores = Serializacion.getProfesores();
		ArrayList<Asignatura> asignaturas = Serializacion.getAsignaturas();
		ArrayList<Grado> grados = Serializacion.getGrados();

		//int loop = 0;
		//while (loop == 0) {

		inicio();
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int opcion = reader.nextInt();
		int funcionalidad;

		switch (opcion) {
		case 1:
			System.out.println("1. Crear estudiante\r\n" + "2. Informe de notas individual\r\n"
					+ "3. Mejores 10 estudiantes del colegio\r\n" + "4. Ver información estudiante\r\n" + "5. Atrás");
			funcionalidad = reader.nextInt();

			switch (funcionalidad) {
			case 1:
				System.out.print("DNI: ");
				int cedula = reader.nextInt();
				System.out.println("");
				System.out.print("Primer nombre: ");
				String nombres = reader.next();
				System.out.println("");
				System.out.print("Primer apellido: ");
				String apellidos = reader.next();
				System.out.println("");
				System.out.print("Edad: ");
				int edad = reader.nextInt();
				System.out.println("");
				System.out.print("Nombre de acudiente: ");
				String acudiente = reader.next();
				System.out.println("");
				new Estudiante(cedula, nombres, apellidos, edad, acudiente);
				
				System.out.println("Estudiante creado exitosamente.");
				
				break;
			case 2:
				if (estudiantes.size() > 0) {
					System.out.print("Ingrese el DNI de un estudiante registrado: ");
					int dni = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> dnis = new ArrayList<>();
					for (Estudiante e : estudiantes) {
						dnis.add(e.getDNI());
						if (e.getDNI() == dni) {
							System.out.println("Sus notas son: ");
							System.out.println(e.misNotas());
						}
					}
					if (!dnis.contains(dni)) {
						System.out.println("El estudiante con DNI " + dni + " no se encuentra registrado.");
					}
				} else {
					System.out.println(
							"Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes.");
				}

				break;
			case 3:
				if (estudiantes.size() > 9) {
					System.out.println(Estudiante.mejores_colegio());
				} else {
					System.out.println(
							"Usted no ha creado estudiantes o no tiene minimo 10 estudiantes, por favor vaya a la sección de crear estudiantes.");
				}
				break;
			case 4:
				if (estudiantes.size() > 0) {
					System.out.print("Ingrese el DNI de un estudiante registrado: ");
					int dni = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> dnis = new ArrayList<>();
					for (Estudiante e : estudiantes) {
						dnis.add(e.getDNI());
						if (e.getDNI() == dni) {
							e.promedio_general();
							System.out.println(e.toString());
							
						}
					}
					if (!dnis.contains(dni)) {
						System.out.println("El estudiante con DNI " + dni + " no se encuentra registrado.");
					}
				} else {
					System.out.println(
							"Usted no ha creado estudiantes, por favor vaya a la sección de crear estudiantes.");
				}

				break;
			case 5:
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;

			}
			break;

		case 2:
			System.out.println("1. Crear profesor\r\n" + "2. Ver información profesor \r\n" + "3. Atrás");
			funcionalidad = reader.nextInt();
			switch (funcionalidad) {
			case 1:
				System.out.print("DNI: ");
				int cedula = reader.nextInt();
				System.out.println("");
				System.out.print("Primer nombre: ");
				String nombres = reader.next();
				System.out.println("");
				System.out.print("Primer apellido: ");
				String apellidos = reader.next();
				System.out.println("");
				System.out.print("Edad: ");
				int edad = reader.nextInt();
				System.out.println("");
				System.out.print("Título: ");
				String titulo = reader.next();
				System.out.println("");
				System.out.print("E-mail: ");
				String email = reader.next();
				System.out.println("");
				new Profesor(cedula, nombres, apellidos, edad, titulo, email);
				System.out.println("Profesor creado exitosamente");
				break;
			case 2:
				if (profesores.size() > 0) {
					System.out.print("Ingrese el DNI de un profesor registrado: ");
					int dni = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> dnis = new ArrayList<>();
					for (Profesor p : profesores) {
						dnis.add(p.getDNI());
						if (p.getDNI() == dni) {
							System.out.println(p.toString());
						}
					}
					if (!dnis.contains(dni)) {
						System.out.println("El profesor con DNI " + dni + " no se encuentra registrado.");
					}
				} else {
					System.out
							.println("Usted no ha creado profesores, por favor vaya a la sección de crear profesores.");
				}
				break;
			case 3:
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}

			break;
		case 3:
			// ------------AGREGAR "AGREGAR ASIGNATURA" y "VER ASIGNATURAS" ambos con
			// id-----------------------------------------------------------------------------------
			System.out.println("1. Crear grado\r\n" + "2. Crear profesor encargado\r\n" + "3. Agregar estudiante\r\n"
					+ "4. Agregar asignatura\r\n" + "5. Ver información de grado\r\n" + "6. Cuadro de honor\r\n"
					+ "7. Prevención de bajo rendimiento\r\n" + "8. Cuadro de superacion\r\n"
					+ "9. Ver promedios de los grados\r\n" + "10. Atrás");
			funcionalidad = reader.nextInt();
			switch (funcionalidad) {
			case 1:
				System.out.print("Ingrese el ID del grado: ");
				int id = reader.nextInt();
				System.out.println("");
				System.out.print("Ingrese el nombre del grado: ");
				String n = reader.next();
				System.out.println("");
				new Grado(id, n);
				System.out.println("Grado creado exitosamente");
				break;
			case 2:
				if (profesores.size() > 0 && grados.size() > 0) {
					System.out.print("Ingrese el ID del grado: ");
					int idg = reader.nextInt();
					System.out.println("");
					System.out.print("Ingrese el DNI de un profesor registrado: ");
					int dni = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> dnis = new ArrayList<>();
					ArrayList<Integer> ids = new ArrayList<>();
					// Grado gr = null;
					// Profesor pr = null;
					for (Grado g : grados) {
						ids.add(g.getId());
						for (Profesor p : profesores) {
							dnis.add(p.getDNI());
							if (p.getDNI() == dni && g.getId() == idg) {
								g.setProfesor_encargado(p);
								System.out.println("Profesor agregado correctamente.");
							}
						}

					}/*
					System.out.println(dnis);
					System.out.println(ids);
					System.out.println(idg);
					System.out.println(dni);*/
					if (!ids.contains(idg) || !dnis.contains(dni)) {
						System.out.println(
								"Grado o profesor ingreado no existente, por favor vaya a la sección de creaciones");
					}
					/*
					 * System.out.println(pr); for (Grado g:grados) { if (g.getId() == idg) { gr =
					 * g; } } System.out.println(gr);
					 */
					/*
					 * if (gr!=null && pr!=null) { gr.setProfesor_encargado(pr);
					 * System.out.println("Profesor agregado correctamente."); }else { System.out.
					 * println("Grado o profesor no existente, por favor vaya a la sección de creaciones"
					 * ); }
					 */
				} else {
					System.out.println(
							"No existen profesores o grados registrados, por favor vaya a la sección de creaciones.");
				}

				break;
			case 3:
				if (grados.size() > 0 && estudiantes.size() > 0) {
					System.out.print("Ingrese el ID del grado: ");
					int idg = reader.nextInt();
					System.out.println("");
					System.out.print("Ingrese el DNI del estudiante: ");
					int e = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> nombres = new ArrayList<>();
					ArrayList<Integer> est = new ArrayList<>();
					// Grado gr = null;
					// Estudiante e1 = null;
					for (Grado g : grados) {
						nombres.add(g.getId());
						for (Estudiante es : estudiantes) {
							est.add(es.getDNI());
							// NO FUNCIONA
							// IF////////////////////////////////////////////////////////////////////
							if (es.getDNI() == e && g.getId() == idg) {
								g.agregarEstudiante(es);
								System.out.println("Estudiante Matriculado exitosamente");
							}
						}
					} /*
						 * System.out.println(nombres); System.out.println(est);
						 * System.out.println(idg); System.out.println(e);
						 */
					if (!nombres.contains(idg) || !est.contains(e)) {
						System.out.println(
								"Grado o estudiante ingreado no existente, por favor vaya a la sección de creaciones");
					}
					/*
					 * for (Estudiante i: estudiantes) { est.add(i.getDNI()); if (i.getDNI() == e) {
					 * e1 = i; } } if(est.contains(e) && nombres.contains(idg) && gr!=null) {
					 * gr.agregarEstudiante(e1); } }
					 */
				} else {
					System.out.println(
							"No existen estudiantes o grados registrados, por favor vaya a la sección  de creaciones");
					break;
				}
				break;
			case 4: // agg asignatura
				if (grados.size() > 0 && asignaturas.size() > 0) {
					System.out.print("Ingrese el ID del grado: ");
					int id_g = reader.nextInt();
					System.out.println("");
					System.out.print("Ingrese el id de la asignatura: ");
					int id_a = reader.nextInt();
					System.out.println("");
					Grado g = null;
					Asignatura a = null;
					for (Grado i : grados) {
						if (i.getId() == id_g) {
							g = i;
						}
					}
					for (Asignatura i : asignaturas) {
						if (i.getId() == id_a) {
							a = i;
						}
					}
					if (g != null && a != null) {
						g.agregarAsignatura(a);
						System.out.println("Asignatura agregada exitosamente.");
					} else {
						System.out.println("Grado o asignatura ingresada no existe.");
					}

				} else {
					System.out.println(
							"No existen asignaturas o grados registrados, por favor vaya a la sección  de creaciones");
				}
				break;
			case 5: // ver info
				if (grados.size() > 0) {
					System.out.print("Ingrese el ID de un grado registrado: ");
					int dni = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> ids = new ArrayList<>();
					for (Grado e : grados) {
						ids.add(e.getId());
						if (e.getId() == dni) {
							System.out.println(e.toString());
						}
					}
					if (!ids.contains(dni)) {
						System.out.println("El grado con ID " + dni + " no se encuentra registrado.");
					}
				} else {
					System.out.println("Usted no ha creado grados, por favor vaya a la sección de crear estudiantes.");
				}

				break;
			case 6:
				if (grados.size() > 0 && estudiantes.size() > 0) {
					System.out.print("Ingrese el ID de un grado registrado: ");
					int idg = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> ids = new ArrayList<>();
					for (Grado g : grados) {
						ids.add(g.getId());
						if (g.getId() == idg) {
							//System.out.println(g.estudiantesInscritos());
							System.out.println(g.cuadro_Honor());
						}
					}
					if (!ids.contains(idg)) {
						System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
					}
				} else {
					System.out.println(
							"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
				}

				break;
			case 7:
				if (grados.size() > 0 && estudiantes.size() > 0) {
					System.out.print("Ingrese el ID de un grado registrado: ");
					int idg = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> ids = new ArrayList<>();
					for (Grado g : grados) {
						ids.add(g.getId());
						if (g.getId() == idg) {
							System.out.println(g.prevencion_bajo_rendimiento());
						}
					}
					if (!ids.contains(idg)) {
						System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
					}
				} else {
					System.out.println(
							"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
				}
				break;
			case 8:
				if (grados.size() > 0 && estudiantes.size() > 0) {
					System.out.print("Ingrese el ID de un grado registrado: ");
					int idg = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> ids = new ArrayList<>();
					for (Grado g : grados) {
						ids.add(g.getId());
						if (g.getId() == idg) {
							System.out.println(g.cuadro_superacion());
						}
					}
					if (!ids.contains(idg)) {
						System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
					}
				} else {
					System.out.println(
							"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
				}
				break;
			case 9:
				if (grados.size() > 0 && estudiantes.size() > 0) {
					System.out.print("Ingrese el ID de un grado registrado: ");
					int idg = reader.nextInt();
					System.out.println("");
					ArrayList<Integer> ids = new ArrayList<>();
					for (Grado g : grados) {
						ids.add(g.getId());
						if (g.getId() == idg) {
							System.out.println(g.promedio_grado());
						}
					}
					if (!ids.contains(idg)) {
						System.out.println("El grado con DNI " + idg + " no se encuentra registrado.");
					}
				} else {
					System.out.println(
							"No existen grados o estudiantes registrados, por favor vaya a las secciones de creaciones.");
				}
				break;
			case 10:
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}

			break;
		case 4:
			System.out.println("1. Crear asignatura\r\n" + "2. Crear nota\r\n" + "3. Atrás");
			funcionalidad = reader.nextInt();
			switch (funcionalidad) {
			case 1:
				System.out.print("ID: ");
				int id = reader.nextInt();
				System.out.println("");
				System.out.print("Nombre: ");
				String nombre = reader.next();
				System.out.println("");
				System.out.print("Número de notas: ");
				byte numero = reader.nextByte();
				System.out.println("");
				new Asignatura(id, nombre, numero);
				System.out.println("Asignatura creada exitosamente");
				break;
			case 2:
				if (asignaturas.size() > 0 && estudiantes.size() > 0) {
					System.out.print("Calificación: ");
					float cal = reader.nextFloat();
					System.out.println("");
					System.out.print("ID de la asignatura: ");
					int asignatura = reader.nextInt();
					System.out.println("");
					System.out.print("DNI del estudiante: ");
					int dni = reader.nextByte();
					System.out.println("");
					Asignatura a2 = null;
					Estudiante e1 = null;

					ArrayList<Integer> id_asign = new ArrayList<>();
					for (Asignatura a : asignaturas) {
						id_asign.add(a.getId());
						if (a.getId() == asignatura) {
							a2 = a;
						}
					}
					ArrayList<Integer> dnis = new ArrayList<>();
					for (Estudiante e : estudiantes) {
						dnis.add(e.getDNI());
						if (e.getDNI() == dni) {
							e1 = e;
						}
					}

					if (id_asign.contains(asignatura) && dnis.contains(dni)) {
						new Nota(cal, e1, a2);
						System.out.println("Nota creada exitosamente");
						break;
					} else {
						System.out.println(
								"Asignatura o estudiante ingresado no existe, por vaya ingrese datos existentes.");
						break;
					}

				} else {
					System.out.println(
							"No existen asignaturas creadas, por favor vaya a la sección de crear asignaturas.");
				}
				break;
			case 3:
				break;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}

			break;
		case 5: // SALIR
			//loop = -1;
			break;
			}

		//}

		/*
		 * NOTAS: EN EL MANUAL DE USUARIO ESPECIFICAR QUE ES EL ID DEL GRADO. también
		 * decir que sólo se puede ingresar un nombre y un apellido, si se ingresa más
		 * que eso, sale error y cancela proceso.
		 * 
		 */

		// Profesor p1 = new Profesor(12, "p1", "p11", 95, "ciencias", "p11@unal");
		// Grado g1 = new Grado("quinto", p1);
		/*
		 * Asignatura a1 = new Asignatura("esp", "to bien", 5); Estudiante e1 = new
		 * Estudiante(1, "d", "g", 10, "ac"); Estudiante e2 = new Estudiante(2, "s",
		 * "a", 12, "op");
		 * 
		 * Nota n1 = new Nota((float) 4.2, e1, a1);
		 */

		// System.out.println(Serializacion.getEstudiantes().get(0).getNombre());
		System.out.println(estudiantes==Estudiante.getEstudiantes());
		estudiantes = Serializacion.getEstudiantes();
		profesores = Serializacion.getProfesores();
		asignaturas = Serializacion.getAsignaturas();
		grados = Serializacion.getGrados();

		//Serializacion.base_datos();
		
		//System.out.println(estudiantes);
		//System.out.println(profesores);
		//System.out.println(asignaturas);
		//System.out.println(grados);

		// System.out.println(grados.get(0).getProfesor_encargado());
		
		
		/*
		 * for (Grado g: grados) { System.out.println(g.toString()); }
		 */

	}

}
