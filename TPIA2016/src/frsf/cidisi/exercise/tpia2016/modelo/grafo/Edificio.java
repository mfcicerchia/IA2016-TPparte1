package frsf.cidisi.exercise.tpia2016.modelo.grafo;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;

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

	public Edificio(){
		
	}

	/**
	 * @param habitaciones
	 * @param conexiones
	 */
	public  Edificio(ArrayList<Habitacion> habitaciones,ArrayList<Conexion> conexiones) {
		this.setListaHabitaciones(habitaciones);
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
	
	public boolean existeHabitacion(String id) {

		boolean flag1 = false;
		boolean flag2 = false;

		for (int i = 0; i < this.getListaConexiones().size(); i++) {
			if (this.getListaConexiones().get(i).getIdOrigen().equals(id)
					|| this.getListaConexiones().get(i).getIdDestino().equals(id)) {
				flag1 = true;
				
			}
		}
		
		for (int i = 0; i < this.getListaHabitaciones().size(); i++) {
			if (this.getListaHabitaciones().get(i).getIdHabitacion().equals(id)){
				flag2 = true;
			}
		}
			
		return (flag1 && flag2);
	}
	
	public int cantidadDeHabitacionesAsociadas(String id) {
		int contador = 0;
		for (int i = 0; i < this.getListaConexiones().size(); i++) {
			if (this.getListaConexiones().get(i).getIdOrigen().equals( id)
					|| this.getListaConexiones().get(i).getIdDestino().equals(id)) {
				contador++;
			}
		}
		return contador;
	}
	
	public ArrayList<Habitacion> getHabitacionesPorID(String id){
		ArrayList<Habitacion> resultado = new ArrayList<Habitacion>();
		
		if(existeHabitacion(id)){

			for(int i=0; i<this.getListaHabitaciones().size(); i++){
				if(this.getListaHabitaciones().get(i).getIdHabitacion().equals(id)){
					resultado.add(this.getListaHabitaciones().get(i));
				}
			}
		}
		return resultado;
		
	}
	
	public Habitacion getHabitacionPorID(String id){
		
		//if(existeHabitacion(id)){/
			for(Habitacion h: this.getListaHabitaciones()){
				if(h.getIdHabitacion().equals(id)){
					return h;			
				}
			}
		//}
		return null;
	}
	
	public Habitacion getHabitacionPorIDporNivel(String id, int nivel){
		//if(existeHabitacion(id)){
			for(int i=0; i<this.getListaHabitaciones().size(); i++){
				if(this.getListaHabitaciones().get(i).getIdHabitacion().equals(id) && this.getListaHabitaciones().get(i).getNivel() == nivel){
					return this.getListaHabitaciones().get(i);
				}
			}
		//}
		return null;
	}
	
	public ArrayList<Habitacion> getHabitacionesAdyacentes(String identificador){
	
		ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();
	 
		
		for(Conexion c: this.listaConexiones){
			if(c.getIdOrigen().equals(identificador)){
				if(!(adyacentes.contains(this.getHabitacionPorID(c.getIdDestino())))){
					adyacentes.add(this.getHabitacionPorID(c.getIdDestino()));
				}
					
			}
		}
		
//		for(Conexion c: this.listaConexiones){
//			if(c.getIdDestino().equals(identificador)){
//				if(!(adyacentes.contains(this.getHabitacionPorID(c.getIdDestino())))){
//					adyacentes.add(this.getHabitacionPorID(c.getIdOrigen()));	
//				}
//				
//			}
//		}

		return adyacentes;
	}

	public int getCosto(Habitacion h1, Habitacion h2){
		int costo=0;
		
		for(Conexion c: this.getListaConexiones()){
			if(h1.getIdHabitacion().equals(c.getIdOrigen())&& h2.getIdHabitacion().equals(c.getIdDestino())
					|| h1.getIdHabitacion().equals(c.getIdDestino())&& h2.getIdHabitacion().equals(c.getIdOrigen())){
				costo=c.getDistancia();
			}
		}
		return costo;
	}
	
	public ArrayList<Aula> getAulas(){
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		
		for(Habitacion h: this.getListaHabitaciones()){
			if(h.getClass().getSimpleName().equals("Aula")){
				aulas.add((Aula) h);
			}
		}
		
		return aulas;
	}
	
	public ArrayList<Pasillo> getPasillos(){
		ArrayList<Pasillo> pasillos = new ArrayList<Pasillo>();
		
		for(Habitacion h: this.getListaHabitaciones()){
			if(h.getClass().getSimpleName().equals("Pasillo")){
				pasillos.add((Pasillo) h);
			}
		}
		
		return pasillos;
	}
	
	public ArrayList<Escalera> getEscaleras(){
		ArrayList<Escalera> escaleras = new ArrayList<Escalera>();
		
		for(Habitacion e: this.getListaHabitaciones()){
			if(e.getClass().getSimpleName().equals("Escalera")){
				escaleras.add((Escalera) e);
			}
		}
		return escaleras;
	}
	
	public boolean isAdyacente(Habitacion posicionActual, Habitacion posicionRecibida) {
		
		ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();
		adyacentes = this.getHabitacionesAdyacentes(posicionActual.getIdHabitacion());
		
		if(adyacentes!=null){
			if(adyacentes.contains(posicionRecibida)){
				return true;
			}
			return false;
		}
		
		return false;
	}
}
