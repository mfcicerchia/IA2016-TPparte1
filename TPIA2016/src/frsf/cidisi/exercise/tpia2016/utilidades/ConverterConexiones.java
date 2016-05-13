package frsf.cidisi.exercise.tpia2016.utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import frsf.cidisi.exercise.tpia2016.modelo.grafo.Conexion;

/**
 * @author martin Clase: Esta clase es la encargada de manipular la clase
 *         LectroCSV y crea las instancias de los objetos que conformaran el
 *         grafo
 */
public class ConverterConexiones {
	// Lista de Strigs que alojara los datos leidos del archivo
	private List<List<String>> listaDeDatos;

	// Lista auxiliar para imprimir todos los elementos
	private List<String> lista = new ArrayList<String>();

	// Lista de Enlaces
	private ArrayList<Conexion> listaDeConexiones;

	// Variables auxiliares para crear las intancias de los objetos
	String categoria;

	/**
	 * Constructor
	 * 
	 * @param archivo
	 *            : recive como parametro un archivo
	 * @throws IOException
	 */
	public ConverterConexiones(File archivo) throws IOException {
		listaDeConexiones = new ArrayList<Conexion>();

		// metodo que toma como parametro el archivo y lo trata para crear los
		// objetos
		inicializarConvertidor(archivo);
		crearComponentesGrafo();

	}

	/**
	 * Metodo que genera una lista de String donde cada elemento será utilizado
	 * para generar las instancias de los Nodos y Enlaces
	 * 
	 * @param archivo
	 * @throws IOException
	 */
	private void inicializarConvertidor(File archivo) throws IOException {

		LectorCSV lector = new LectorCSV(archivo);
		listaDeDatos = lector.leerArchivo();

		// Tomo cada elemento obtenido con el lector y lo copio a una lista
		// auxiliar
		for (int i = 0; i < listaDeDatos.size(); i++) {
			for (int j = 0; j < listaDeDatos.get(i).size(); j++) {
				lista.add(listaDeDatos.get(i).get(j));
			}
		}
	}

	// Recorro la lista hasta y creo la instancia del
	// objeto correspondiente y luego lo agrego a la lista de conexiones
	private void crearComponentesGrafo() {

		for (int i = 0; i < listaDeDatos.size(); i++) {
			// categoria = listaDeDatos.get(i).get(0);

			// creo una instancia de Conexion y lo agrego a la lista de enlaces
			Conexion enlace = new Conexion(listaDeDatos.get(i).get(0), 
										   listaDeDatos.get(i).get(1),
										   Integer.parseInt(listaDeDatos.get(i).get(2)));
			// lo agrego a la ista de enlaces
			listaDeConexiones.add(enlace);
		}
	}

	public ArrayList<Conexion> getListaConexiones() {
		return listaDeConexiones;
	}

	public List<List<String>> getListaDeDatos() {
		return listaDeDatos;
	}

	public List<String> getLista() {
		return lista;
	}

}
