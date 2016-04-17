package frsf.cidisi.exercise.tpia2016.modelo;

public class Departamento extends Habitacion {
	
	private String deptoTipo;
	public Departamento(int id, int nivel, String dpto) {
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
