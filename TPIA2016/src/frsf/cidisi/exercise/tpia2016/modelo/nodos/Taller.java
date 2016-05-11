package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Taller extends Habitacion {
	
	public Taller() {
		super();
	}

	public Taller(String id, int nivel, String desc) {
		super(id, nivel, desc);
		this.setDescripcion(desc);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taller other = (Taller) obj;
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
	
	public Taller clone(){
		return new Taller (this.getIdHabitacion(),this.getNivel(), this.getDescripcion());
	}
}
