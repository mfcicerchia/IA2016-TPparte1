package frsf.cidisi.exercise.tpia2016.modelo;

public class Identificador {
	private int numero;
	private int nivel;
	private String descripcion;
	
	Identificador (int id, int nivel, String descipcion){
		this.setNumeroHabitacion(id);
		this.setNivel(nivel);
		this.setDescripcion(descipcion);
	}

	public int getNumeroHabitacion() {
		return numero;
	}

	public void setNumeroHabitacion(int idHabitacion) {
		this.numero = idHabitacion;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
