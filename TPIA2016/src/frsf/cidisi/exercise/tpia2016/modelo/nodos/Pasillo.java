package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Pasillo extends Habitacion {


	boolean bloqueado;
	int posicion_bloqueada;

	public Pasillo() {
		super();
	}

	/**
	 * @param id: identificador del Objeto Pasillo
	 * @param nivel: identifica a que nivel pertenece
	 * @param desc: es una descripcion del objeto (puede ser info del estado o general)
	 * @param bloqueado_: 
	 * @param post
	 */
	public Pasillo(String id, int nivel, String desc, boolean bloqueado,
			int post) {
		super(id, nivel, desc);
		this.bloqueado = bloqueado;
		posicion_bloqueada = post;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getPosicion_bloqueada() {
		return posicion_bloqueada;
	}

	public void setPosicion_bloqueada(int posicion_bloqueada) {
		this.posicion_bloqueada = posicion_bloqueada;
	}

	@Override
	public String toString() {
		return super.toString() + "bloqueado=" + bloqueado
				+ ", posicion_bloqueada=" + posicion_bloqueada + "]";
	}

}
