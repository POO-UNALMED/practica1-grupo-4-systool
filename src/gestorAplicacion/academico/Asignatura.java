package gestorAplicacion.academico;

import java.util.ArrayList;

public class Asignatura {
	
	
	private ArrayList<Grado> grados = new ArrayList<Grado>();

	public ArrayList<Grado> getGrados() {
		return grados;
	}

	public void setGrados(ArrayList<Grado> grados) {
		this.grados = grados;
	}
	
	
	
	
	
	
	//Metodos
	
	public void agregarGrado(Grado grad) {
		grados.add(grad);
		/*Este metodo es para poder asignarle a la lista
		de grados el grado en el que esta la asigantura
		dandosela desde Grado
		*/
	}
	
}
