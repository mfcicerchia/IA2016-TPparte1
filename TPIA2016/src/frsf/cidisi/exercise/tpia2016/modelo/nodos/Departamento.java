package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Departamento extends Habitacion {
	
	private String deptoTipo;
	public Departamento(String id, int nivel, String dpto) {
		super(id,nivel,dpto);
		this.setDeptoTipo(dpto);
	}
	public String getDeptoTipo() {
		return deptoTipo;
	}
	public void setDeptoTipo(String deptoTipo) {
		this.deptoTipo = deptoTipo;
	}

}
