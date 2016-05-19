package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Fotocopiadora extends Habitacion {

	public Fotocopiadora(String id, int nivel,String desc,int posX, int posY) {
		super(id,nivel,desc, posX, posY);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fotocopiadora other = (Fotocopiadora) obj;
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
		return true;
	}
	
	public Fotocopiadora clone(){
		return new Fotocopiadora(this.getIdHabitacion(),this.getNivel(), this.getDescripcion(), this.getPosicion().x, this.getPosicion().y);
	}

}
