package frsf.cidisi.exercise.tpia2016.modelo;

public class Ascensor extends Habitacion{
	public Ascensor() {
		super();
	}
	boolean pitido;
	
	/**
	 * @param pitido
	 */
	public Ascensor(int id, int nivel, String desc) {
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


}
