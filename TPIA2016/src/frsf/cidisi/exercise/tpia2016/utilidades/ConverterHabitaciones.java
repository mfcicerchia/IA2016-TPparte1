package frsf.cidisi.exercise.tpia2016.utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.exercise.tpia2016.modelo.*;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Conexion;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Ascensor;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Aula;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Baño;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Biblioteca;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Cantina;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Departamento;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Escalera;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Fotocopiadora;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Ingreso;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Laboratorio;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Oficina;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Pasillo;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Taller;

/**
 * @author martin Clase: Esta clase es la encargada de manipular la clase
 *         LectroCSV y crea las instancias de los objetos que conformaran el
 *         grafo
 */
public class ConverterHabitaciones {
	// Lista de Strigs que alojara los datos leidos del archivo
	private List<List<String>> listaDeDatos;

	// Lista auxiliar para imprimir todos los elementos
	private List<String> lista = new ArrayList<String>();

	// Lista de Enlaces y Nodos auxiliares
	private ArrayList<Habitacion> listaDeHabitaciones;
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
	public ConverterHabitaciones(File archivo) throws IOException {
		listaDeHabitaciones = new ArrayList<Habitacion>();

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

	// Recorro la lista hasta el final y pregunto qué categoría es.
	// En función de la categoría creo la instancia del objeto correspondiente 
	// y luego lo agrego a la lista que corresponde
	private void crearComponentesGrafo(){
		
		for (int i = 0; i < listaDeDatos.size(); i++){
			categoria = listaDeDatos.get(i).get(0);	
			
			if(categoria.equals("Aula") || categoria.equals("Aula") ){
				// Creo una instancia de Aula y lo agrego a la lista de Habitaciones
				Habitacion aula = new Aula(listaDeDatos.get(i).get(1),
									       Integer.parseInt(listaDeDatos.get(i).get(2)),
									       listaDeDatos.get(i).get(3));
				//lo agrego a la lista de Habitaciones
				listaDeHabitaciones.add(aula);
			}
			
			if(categoria.equals("Pasillo") || categoria.equals("pasillo")){
				// Creo una instancia de Pasillo y lo agrego a la lista de Habitaciones
				Habitacion pasillo = new Pasillo(listaDeDatos.get(i).get(1),
											  Integer.parseInt(listaDeDatos.get(i).get(2)),
									          listaDeDatos.get(i).get(3),false);
				//lo agrego a la lista de Habitaciones
				listaDeHabitaciones.add(pasillo);
			}
			
			if (categoria.equals("Ascensor")||categoria.equals("ascensor")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion ascensor = new Ascensor(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3),false);
				listaDeHabitaciones.add(ascensor);
				
			}
			
			if(categoria.equals("Baño")|| categoria.equals("baño")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion baño = new Baño(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(baño);
			}
			if(categoria.equals("Departamento") || categoria.equals("departamento")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion departamento = new Departamento(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(departamento);
			}
			
			if(categoria.equals("Fotocopiadora") || categoria.equals("fotocopiadora")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion fotocopiadora = new Fotocopiadora(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(fotocopiadora);
			}
			
			if(categoria.equals("Ingreso") || categoria.equals("ingreso")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion ingreso = new Ingreso(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(ingreso);
			}
			
			if(categoria.equals("Escalera") || categoria.equals("escalera")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion escalera = new Escalera(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3),false);
				listaDeHabitaciones.add(escalera);
			}
			
			if(categoria.equals("Biblioteca") || categoria.equals("biblioteca")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion biblioteca = new Biblioteca(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(biblioteca);
			}
			
			if(categoria.equals("Cantina") || categoria.equals("cantina")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion cantina = new Cantina(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(cantina);
			}
			
			if(categoria.equals("Laboratorio") || categoria.equals("laboratorio")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion laboratorio = new Laboratorio(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(laboratorio);
			}
			
			if(categoria.equals("Oficina") || categoria.equals("oficina")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion oficina = new Oficina(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(oficina);
			}
			
			if(categoria.equals("Taller") || categoria.equals("Taller")){
				//creo una instancia de ascensor y lo agrego a la lista de Habitaciones
				Habitacion taller = new Taller(listaDeDatos.get(i).get(1),
						  						   Integer.parseInt(listaDeDatos.get(i).get(2)),
						  						   listaDeDatos.get(i).get(3));
				listaDeHabitaciones.add(taller);
			}
		}
	}

	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaDeHabitaciones;
	}

	public ArrayList<Conexion> getListaEnlaces() {
		return listaDeConexiones;
	}

	public List<List<String>> getListaDeDatos() {
		return listaDeDatos;
	}

	public List<String> getLista() {
		return lista;
	}

}
