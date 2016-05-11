package frsf.cidisi.exercise.tpia2016.modelo.grafo;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.search.EstadoAgente;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * @author martin Clase: Habitacion Descripcion: Representa un nodo del grafo
 *         mapaEdificio. Es una super-clase de los subtipos de habitaciones.
 *         Contiene los atributos comunes de las habitaciones: atributo:
 *         idHabitacion atributo: nivel
 * 
 */
public abstract class Habitacion {

	// Identificador id; /implementar luego/

	@Override
	public String toString() {
		return "Habitacion [idHabitacion=" + idHabitacion + ", nivel=" + nivel + ", descripcion=" + descripcion + "]";
	}

	private String idHabitacion;
	private int nivel;
	private String descripcion;

	public Habitacion() {

	}

	// /**
	// * @param id
	// * @param nivel
	// * @param desc
	// */
	// public Habitacion(int id, int nivel, String desc) {
	// this.id = new Identificador(id, nivel, desc);
	// }

	public Habitacion(String id, int nivel, String desc) {
		this.setIdHabitacion(id);
		this.setNivel(nivel);
		this.setDescripcion(desc);
	}

	public String getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(String idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	/**
	 * @param habitaciones
	 * @param conexiones
	 * @return devuelve una lista de las habitaciones adyacentes al nodo actual
	 */
	public ArrayList<Habitacion> getAdyacentes(
			ArrayList<Habitacion> habitaciones, ArrayList<Conexion> conexiones) {
		ArrayList<Habitacion> habitacionesAdyacentes = new ArrayList<Habitacion>();

		// si existe el id de la habitacion en la lista de conexiones, entonces:
		// la recorro
		if (existeHabitacion(conexiones)) {
			// recorro la lista de conexiones
			for (int i = 0; i < conexiones.size(); i++) {
				// si el idHabitacion es igual al Origen
				if (this.getIdHabitacion().equals(conexiones.get(i).getIdOrigen())) {
					// Recupero el objeto Destino y lo agrego a la lista de
					// adyacentes
					habitacionesAdyacentes.add(recuperarHabitacionAdyacente(
							conexiones.get(i).getIdDestino(), habitaciones));
				}
				// si el idHabitacion es igual al Destino
				if (this.getIdHabitacion().equals(conexiones.get(i).getIdDestino())) {
					// Recupero el objeto Origen y lo agrego a la lista de
					// adyacentes
					habitacionesAdyacentes.add(recuperarHabitacionAdyacente(
							conexiones.get(i).getIdOrigen(), habitaciones));
				}
			}
		} else {
			System.out
					.println("No Existe la habitacion en la lista de conexiones");
		}

		// devuelvo la lista de habitaciones adyacentes
		return habitacionesAdyacentes;
	}

	/**
	 * @param conexiones
	 * @return devuelve verdadero si la habitacion existe en algun objeto de la
	 *         lista de conexiones ya sea origen o destino devuelve falso si no
	 *         pertenece
	 */
	private boolean existeHabitacion(ArrayList<Conexion> conexiones) {
		// revisar este metodo que no esta pasando
		int position = 0;
		while (position < conexiones.size()) {
			if (this.getIdHabitacion().equals(conexiones.get(position)
					.getIdOrigen()) 
					|| this.getIdHabitacion().equals(conexiones.get(position)
							.getIdDestino())) {
				return true;
			} else {
				position++;
			}
		}
		return false;
	}

	private Habitacion recuperarHabitacionAdyacente(String idHabitacionDestino,
			ArrayList<Habitacion> habitaciones) {
		for (int i = 0; i < habitaciones.size(); i++) {
			if (idHabitacionDestino.equals(habitaciones.get(i).getIdHabitacion())   ) {
				return habitaciones.get(i);
			}
		}
		return null;
	}

	@Override
	public abstract boolean equals(Object obj);
    public abstract Habitacion clone();
    
    
}
