package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Ascensor extends Habitacion{

	public Ascensor() {
		super();
	}
	boolean pitido;
	
	/**
	 * @param pitido
	 */
	public Ascensor(String id, int nivel, String desc) {
		super(id, nivel, desc);
		//this.setPitido(pitido);
	}
	/**
	 * @param pitido
	 */
	public void setPitido(boolean pitido) {
		this.pitido = pitido;
	}
	
	public boolean isPitido() {
		return pitido;
	}
	
	@Override
	public String toString() {
		return super.toString() + "pitido=" + pitido;
	}
	
}
