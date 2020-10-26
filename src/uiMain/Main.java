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
		System.out.println("Por favor escoja una opci�n para acceder a sus funcionalidades:");
		System.out.println("1. Estudiante");
		System.out.println("2. Profesor");
		System.out.println("3. Grado");
		System.out.println("4. Asignatura");
		System.out.println("5. Salir");
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Serializacion.b2();
		ArrayList<Estudiante> estudiantes = Serializacion.getEstudiantes();
		ArrayList<Profesor> profesores = Serializacion.getProfesores();
		ArrayList<Asignatura> asignaturas = Serializacion.getAsignaturas();
		ArrayList<Grado> grados = Serializacion.getGrados();
		
		int loop = 0;
		while (loop == 0) {

			inicio();
			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			int opcion = reader.nextInt();
			int funcionalidad;

			switch (opcion) {
			case 1:
				System.out.println("1. Crear estudiante\r\n" + "2. Informe de notas individual\r\n"
						+ "3. Mejores 10 estudiantes del colegio\r\n" + "4. Ver informaci�n estudiante\r\n"
						+ "5. Atr�s");
				funcionalidad = reader.nextInt();

				switch (funcionalidad) {
				case 1:
					System.out.print("DNI: ");
					int cedula = reader.nextInt();
					System.out.println("");
					System.out.print("Nombres: ");
					String nombres = reader.next();
					System.out.println("");
					System.out.print("Apellidos: ");
					String apellidos = reader.next();
					System.out.println("");
					System.out.print("Edad: ");
					int edad = reader.nextInt();
					System.out.println("");
					System.out.print("Nombre de acudiente: ");
					String acudiente = reader.next();
					System.out.println("");
					Estudiante e1 = new Estudiante(cedula, nombres, apellidos, edad, acudiente);
					System.out.println("Estudiante creado exitosamente madafaca");
					break;
				case 2:
					if (estudiantes.size() > 0) {
						for (Estudiante e : estudiantes) {
							e.misNotas();
						}
					} else {
						System.out.println(
								"Usted no ha creado estudiantes, por favor vaya a la secci�n de crear estudiantes.");
					}

					break;
				case 3:
					if (estudiantes.size() > 0) {
						Estudiante.mejores_colegio();
					} else {
						System.out.println(
								"Usted no ha creado estudiantes, por favor vaya a la secci�n de crear estudiantes.");
					}
					break;
				case 4:
					if (estudiantes.size() > 0) {
						System.out.print("Ingrese el DNI de un estudiante registrado: ");
						int dni = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> dnis = new ArrayList<>();
						for (Estudiante e : estudiantes) {
							//-----------------------------------------------------------------------------------------------------------
							//System.out.println(e);
							dnis.add(e.getDNI());
							if (e.getDNI() == dni) {
								e.toString();
							}
						}
						if (!dnis.contains(dni)) {
							System.out.println("El estudiante con DNI " + dni + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"Usted no ha creado estudiantes, por favor vaya a la secci�n de crear estudiantes.");
					}

					break;
				case 5:
					break;
				default:
					System.out.println("Ingrese una opci�n v�lida");
					break;
				
				}
				break;
			
			case 2:
				System.out.println("1. Crear profesor\r\n" + "2. Ver informaci�n profesor \r\n" + "3. Atr�s");
				funcionalidad = reader.nextInt();
				switch (funcionalidad) {
				case 1:
					System.out.print("DNI: ");
					int cedula = reader.nextInt();
					System.out.println("");
					System.out.print("Nombres: ");
					String nombres = reader.next();
					System.out.println("");
					System.out.print("Apellidos: ");
					String apellidos = reader.next();
					System.out.println("");
					System.out.print("Edad: ");
					int edad = reader.nextInt();
					System.out.println("");
					System.out.print("T�tulo: ");
					String titulo = reader.next();
					System.out.println("");
					System.out.print("E-mail: ");
					String email = reader.next();
					System.out.println("");
					Profesor p1 = new Profesor(cedula, nombres, apellidos, edad, titulo, email);
					System.out.println("Profesor creado exitosamente");
					break;
				case 2:
					if(profesores.size() > 0) {
						System.out.print("Ingrese el DNI de un profesor registrado: ");
						int dni = reader.nextInt();
						System.out.println("");
						ArrayList<Integer> dnis = new ArrayList<>();
						for (Profesor p : profesores) {
							dnis.add(p.getDNI());
							if (p.getDNI() == dni) {
								p.toString();
							}
						}
						if (!dnis.contains(dni)) {
							System.out.println("El profesor con DNI " + dni + " no se encuentra registrado.");
						}
					}else {
						System.out.println(
								"Usted no ha creado profesores, por favor vaya a la secci�n de crear profesores.");
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Ingrese una opci�n v�lida");
					break;
				}

				break;
			case 3:
				System.out.println("1. Crear grado\r\n" + "2. Crear profesor encargado\r\n" + "3. Cuadro de honor\r\n"
						+ "4. Prevenci�n de bajo rendimiento\r\n" + "5. Cuadro de superacion\r\n"
						+ "6. Ver promedios de los grados\r\n" + "7. Atr�s");
				funcionalidad = reader.nextInt();
				switch (funcionalidad) {
				case 1:
					System.out.print("Ingrese el ID del grado: ");
					String id = reader.next();
					System.out.println("");
					Grado g1 = new Grado(id);
					System.out.println("Grado creado exitosamente");
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
								p.toString();
							}
						}
						if (!dnis.contains(dni)) {
							System.out.println("El profesor con DNI " + dni + " no se encuentra registrado.");
						}
					} else {
						System.out.println(
								"No existen profesores registrados, por favor vaya a la secci�n de crear profesores.");
					}

					break;
				case 3:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						String idg = reader.next();
						System.out.println("");
						ArrayList<String> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							if (g.getId() == idg) {
								g.cuadro_Honor();
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
				case 4:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						String idg = reader.next();
						System.out.println("");
						ArrayList<String> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							if (g.getId() == idg) {
								g.prevencion_bajo_rendimiento();
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
				case 5:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						String idg = reader.next();
						System.out.println("");
						ArrayList<String> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							if (g.getId() == idg) {
								g.cuadro_superacion();
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
				case 6:
					if (grados.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Ingrese el ID de un grado registrado: ");
						String idg = reader.next();
						System.out.println("");
						ArrayList<String> ids = new ArrayList<>();
						for (Grado g : grados) {
							ids.add(g.getId());
							if (g.getId() == idg) {
								g.promedio_grado();
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
					break;
				default:
					System.out.println("Ingrese una opci�n v�lida");
					break;
				}

				break;
			case 4:
				System.out.println("1. Crear asignatura\r\n" + "2. Crear nota\r\n" + "3. Atr�s");
				funcionalidad = reader.nextInt();
				switch (funcionalidad) {
				case 1:
					System.out.print("Nombre");
					String nombre = reader.next();
					System.out.println("");
					System.out.print("Descripci�n: ");
					String descrip = reader.next();
					System.out.println("");
					System.out.print("N�mero: ");
					byte numero = reader.nextByte();
					System.out.println("");
					Asignatura a1 = new Asignatura(nombre, descrip, numero);
					System.out.println("Asignatura creada exitosamente");
					break;
				case 2:
					if (asignaturas.size() > 0 && estudiantes.size() > 0) {
						System.out.print("Calificaci�n");
						float cal = reader.nextFloat();
						System.out.println("");
						System.out.print("Nombre de la asignatura: ");
						String asignatura = reader.next();
						System.out.println("");
						System.out.print("DNI del estudiante: ");
						int dni = reader.nextByte();
						System.out.println("");
						Asignatura a2 = null;
						Estudiante e1 = null;

						ArrayList<String> nombres_asign = new ArrayList<>();
						for (Asignatura a : asignaturas) {
							nombres_asign.add(a.getNombre());
							if (a.getNombre() == asignatura) {
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

						if(nombres_asign.contains(asignatura) && dnis.contains(dni)) {
							Nota n1 = new Nota(cal, e1, a2);
							System.out.println("Nota creada exitosamente");
							break;
						}else {
							System.out.println("Asignatura o estudiante ingresado no existe, por vaya ingrese datos existentes.");
							break;
						}
						
					} else {
						System.out.println(
								"No existen asignaturas creadas, por favor vaya a la secci�n de crear asignaturas.");
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Ingrese una opci�n v�lida");
					break;
				}

				break;
			case 5: // SALIR
				loop = -1;
				break;
			}
			//break;
		}

		/*
		 * NOTAS: EN EL MANUAL DE USUARIO ESPECIFICAR QUE ES EL ID DEL GRADO.
		 */

		Profesor p1 = new Profesor(12, "p1", "p11", 95, "ciencias", "p11@unal");
		Grado g1 = new Grado("quinto", p1);
		Asignatura a1 = new Asignatura("esp", "to bien", 5);
		Estudiante e1 = new Estudiante(1, "d", "g", 10, "ac");
		Estudiante e2 = new Estudiante(2, "s", "a", 12, "op");

		/*
		 * System.out.println(estudiantes); System.out.println(profesores);
		 * System.out.println(asignaturas); System.out.println(grados);
		 */
		Serializacion.base_datos();

	}

}
