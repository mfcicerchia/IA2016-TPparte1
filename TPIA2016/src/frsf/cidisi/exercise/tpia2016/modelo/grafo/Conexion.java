package frsf.cidisi.exercise.tpia2016.modelo.grafo;
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
	private String idOrigen;
	private String idDestino;
	private int distancia;
	
	/**
	 * @param idO: identificado de la habitacion ORIGEN
	 * @param idD: identificado de la habitacion DESTINO
	 * @param distancia: representa la distancia entre dos habitaciones
	 */
	public Conexion (String idO, String idD, int distancia){
		this.setIdOrigen(idO);
		this.setIdDestino(idD);
		this.setDistancia(distancia);
	}

	/**
	 * @param idOrigen
	 */
	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}


	public String getIdOrigen() {
		return idOrigen;
	}

	/**
	 * @param idDestino
	 */
	public void setIdDestino(String idDestino) {
		this.idDestino = idDestino;
	}

	public String getIdDestino() {
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
	
	public String toString(){
		return idOrigen+"-"+idDestino+"-"+distancia;
	}
	
    public Conexion clone() {
        return new Conexion(this.getIdOrigen(),this.getIdDestino(),this.getDistancia());
    }
}
