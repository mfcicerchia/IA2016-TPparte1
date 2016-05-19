package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Escalera extends Habitacion {
	boolean bloqueada;
	public Escalera() {
		super();
	}
	public Escalera(String id, int nivel,String desc,boolean blq,int posX, int posY) {
		super(id, nivel,desc, posX, posY);
		bloqueada=blq;
	}
	public boolean isBloqueada() {
		return bloqueada;
	}
	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}
	
	@Override
	public String toString() {
		return super.toString() + "bloqueada=" + bloqueada+"]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Escalera other = (Escalera) obj;
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
		if (this.isBloqueada() != other.isBloqueada())
			return false;
		return true;
	}
	
	public Escalera clone(){
		return new Escalera(this.getIdHabitacion(),this.getNivel(), this.getDescripcion(), this.isBloqueada(), this.getPosicion().x, this.getPosicion().y);
	}
}
