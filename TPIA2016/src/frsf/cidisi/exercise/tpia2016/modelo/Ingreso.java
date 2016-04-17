package frsf.cidisi.exercise.tpia2016.modelo;

public class Ingreso extends Habitacion {

	private String ingresoTipo;

	public Ingreso() {
		super();
	}

	public Ingreso(int id, int nivel, String tipoIngreso) {
		super(id, nivel,tipoIngreso);
		this.setIngresoTipo(tipoIngreso);
	}

	public void setIngresoTipo(String ingresoTipo) {
		this.ingresoTipo = ingresoTipo;
	}

	public String getIngresoTipo() {
		return ingresoTipo;
	}

}
