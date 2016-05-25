package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Pasillo extends Habitacion {

	boolean bloqueado;

	public Pasillo() {
		super();
	}

	/**
	 * @param id: identificador del Objeto Pasillo
	 * @param nivel: identifica a que nivel pertenece
	 * @param desc: es una descripcion del objeto (puede ser info del estado o general)
	 * @param bloqueado: representa si un pasillo esta o no bloqueado
	 * @param post: 
	 */
	public Pasillo(String id, int nivel, String desc,int posX, int posY, boolean bloqueado) {
		super(id, nivel, desc, posX, posY);
		this.bloqueado = bloqueado;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	@Override
	public String toString() {
		return super.toString() + "bloqueado:" + bloqueado ;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasillo other = (Pasillo) obj;
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
		if (this.isBloqueado() != other.isBloqueado())
			return false;

		return true;
	}
	
	public Pasillo clone(){
		return new Pasillo (this.getIdHabitacion(),this.getNivel(), this.getDescripcion(), this.getPosicion().x, this.getPosicion().y,this.isBloqueado());
	}

}
