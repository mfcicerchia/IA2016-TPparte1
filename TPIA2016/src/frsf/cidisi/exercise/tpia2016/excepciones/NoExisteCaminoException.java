package frsf.cidisi.exercise.tpia2016.excepciones;


public class NoExisteCaminoException extends Exception{

	public NoExisteCaminoException() {
		super("No existe el camino para llegar al destino");
	}
}