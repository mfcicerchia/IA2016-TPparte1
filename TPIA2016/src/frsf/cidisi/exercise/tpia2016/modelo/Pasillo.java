package frsf.cidisi.exercise.tpia2016.modelo;

import java.util.ArrayList;

public class Pasillo extends Habitacion {

	ArrayList<Habitacion> listaHabitacionesBloqueadas;

	public Pasillo() {
		super();
	}

	public Pasillo(int id, int nivel,String desc) {
		super(id, nivel,desc);
	}

}
