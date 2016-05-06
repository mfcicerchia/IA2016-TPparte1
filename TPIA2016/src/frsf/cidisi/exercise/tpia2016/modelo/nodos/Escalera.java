package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Escalera extends Habitacion {
	boolean bloqueada;
	public Escalera() {
		super();
	}
	public Escalera(String id, int nivel,String desc,boolean blq) {
		super(id, nivel,desc);
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
		return super.toString() + "bloqueada=" + bloqueada;
	}
}
