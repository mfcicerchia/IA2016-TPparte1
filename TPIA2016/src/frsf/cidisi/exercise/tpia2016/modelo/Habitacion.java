package frsf.cidisi.exercise.tpia2016.modelo;

import java.util.ArrayList;

/**
 * @author martin Clase: Habitacion Descripcion: Representa un nodo del grafo
 *         mapaEdificio. Es una super-clase de los subtipos de habitaciones.
 *         Contiene los atributos comunes de las habitaciones: atributo:
 *         idHabitacion atributo: nivel
 * 
 */
public class Habitacion {

	private int idHabitacion;
	private int nivel;

	/**
	 * @param id
	 * @param nivel
	 */
	public Habitacion(int id, int nivel) {
		this.setIdHabitacion(id);
		this.setNivel(nivel);
	}

	public Habitacion() {

	}

	/**
	 * @param idHabitacion
	 */
	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public int getIdHabitacion() {
		return idHabitacion;
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
				if (this.getIdHabitacion() == conexiones.get(i).getIdOrigen()) {
					// Recupero el objeto Destino y lo agrego a la lista de
					// adyacentes
					habitacionesAdyacentes.add(recuperarHabitacionAdyacente(
							conexiones.get(i).getIdDestino(), habitaciones));
				}
				// si el idHabitacion es igual al Destino
				if (this.getIdHabitacion() == conexiones.get(i).getIdDestino()) {
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
		int position = 0;
		while (position < conexiones.size()) {
			if (this.getIdHabitacion() == conexiones.get(position)
					.getIdOrigen()
					|| this.getIdHabitacion() == conexiones.get(position)
							.getIdDestino()) {
				return true;
			} else {
				position++;
			}
		}
		return false;
	}

	private Habitacion recuperarHabitacionAdyacente(int idHabitacionDestino,
			ArrayList<Habitacion> habitaciones) {
		for (int i = 0; i < habitaciones.size(); i++) {
			if (idHabitacionDestino == habitaciones.get(i).getIdHabitacion()) {
				return habitaciones.get(i);
			}
		}
		return null;
	}
}
