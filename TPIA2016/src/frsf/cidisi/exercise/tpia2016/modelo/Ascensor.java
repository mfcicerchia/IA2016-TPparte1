package frsf.cidisi.exercise.tpia2016.modelo;

public class Ascensor extends Habitacion{
	public Ascensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	boolean pitido;
	
	/**
	 * @param pitido
	 */
	public Ascensor(int id, int nivel, boolean pitido) {
		super(id, nivel);
		this.setPitido(pitido);
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
