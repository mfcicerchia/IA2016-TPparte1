package frsf.cidisi.exercise.tpia2016.modelo;

import java.util.ArrayList;

/**
 * @author martin Clase: Edificio Descripcion: esta clase define la estructura
 *         de datos necesaria para representarel grafo que utilizado para
 *         representar el mapa del edificio. Esta compuesto de dos listas:
 *         listaHabitaciones: lista que contiene los objetos (Nodos) de las
 *         habitaciones. listaConexiones: lista con las conexiones entre
 *         habitaciones (Enlaces). Esta lista contiene los ids entre dos
 *         habitaciones y el costo asociado de ir de una habitacion a otra.
 * 
 * 
 */

public class Edificio {
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Conexion> listaConexiones;

	/**
	 * @param habitaciones
	 * @param conexiones
	 */
	public void Edficio(ArrayList<Habitacion> habitaciones,
			ArrayList<Conexion> conexiones) {
		this.setListaHabitaciones(listaHabitaciones);
		this.setListaConexiones(conexiones);
	}

	/**
	 * @param listaHabitaciones
	 */
	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	/**
	 * @param conexiones
	 */
	public void setListaConexiones(ArrayList<Conexion> conexiones) {
		this.listaConexiones = conexiones;
	}

	public ArrayList<Conexion> getListaConexiones() {
		return listaConexiones;
	}
}
