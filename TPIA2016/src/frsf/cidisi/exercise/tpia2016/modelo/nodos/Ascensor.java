package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Ascensor extends Habitacion{
	public boolean pitido;
	
	public Ascensor() {
		super();
	}
	
	/**
	 * @param pitido
	 */
	public Ascensor(String id, int nivel, String desc, int posX, int posY,boolean pitido) {
		super(id, nivel, desc, posX, posY);
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
	
	@Override
	public String toString() {
		return super.toString() + "pitido:" + pitido;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ascensor other = (Ascensor) obj;
		if (this.getDescripcion() == null) {
			if (other.getDescripcion() != null)
				return false;
		} else if (!this.getDescripcion().equals(other.getDescripcion()))
			return false;
		if (this.getIdHabitacion() == null) {
			if (other.getIdHabitacion() != null)
				return false;
		} else if (!this.getIdHabitacion().equals(other.getIdHabitacion()))
			return false;
		if (this.getNivel() != other.getNivel())
			return false;
		if (pitido != other.pitido)
			return false;
		return true;
	}
	
	public Ascensor clone(){
		return new Ascensor(this.getIdHabitacion(),this.getNivel(), this.getDescripcion(),this.getPosicion().x, this.getPosicion().y, this.isPitido());
	}
	
}
