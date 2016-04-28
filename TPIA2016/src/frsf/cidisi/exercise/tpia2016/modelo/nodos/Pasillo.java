package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Pasillo extends Habitacion {

	ArrayList<Habitacion> listaHabitacionesBloqueadas;

	public Pasillo() {
		super();
	}

	public Pasillo(String id, int nivel,String desc) {
		super(id, nivel,desc);
	}

}
