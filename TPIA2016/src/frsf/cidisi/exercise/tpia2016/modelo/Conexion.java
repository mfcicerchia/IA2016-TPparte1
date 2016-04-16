package frsf.cidisi.exercise.tpia2016.modelo;
/**
 * @author martin
 * Clase: Conexion
 * Descripcion: clase que representa un Enlace entre dos habitaciones (Enlace entre nodos del grafo mapa).
 * sus atributos son:
 * 		idOrigen: identificador de la habitacion origen
 * 		idDestino: identificado de la habitacion destino
 * 		distancia: costo de ir de una habitacion a la otra
 * 
 * Nota: si existe una Conexion entre habitaciones suponemos 
 * que la movilidad es bilateral: idO<->idD == idD<->idO 
 */
public class Conexion {
	private int idOrigen;
	private int idDestino;
	private int distancia;
	
	/**
	 * @param idO: identificado de la habitacion ORIGEN
	 * @param idD: identificado de la habitacion DESTINO
	 * @param distancia: representa la distancia entre dos habitaciones
	 */
	public Conexion (int idO, int idD, int distancia){
		this.setIdOrigen(idO);
		this.setIdDestino(idD);
		this.setDistancia(distancia);
	}

	/**
	 * @param idOrigen
	 */
	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}


	public int getIdOrigen() {
		return idOrigen;
	}

	/**
	 * @param idDestino
	 */
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public int getIdDestino() {
		return idDestino;
	}

	/**
	 * @param distancia
	 */
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getDistancia() {
		return distancia;
	}

}
