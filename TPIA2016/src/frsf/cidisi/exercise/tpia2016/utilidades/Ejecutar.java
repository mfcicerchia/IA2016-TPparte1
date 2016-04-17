package frsf.cidisi.exercise.tpia2016.utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import frsf.cidisi.exercise.tpia2016.modelo.*;



/**
 * @author martin
 * Clase Main para Ejecutar las pruebas de carga desde archivos externos.
 * Se invocon los archivos habitaciones.csv y conexiones.csv que estan en 
 * la carpeta archivosCSV en este proyecto. 
 * Se cargan los datos desde ambos archivos y se instancias los objetos 
 * para luego asignarselos al grafo mapa.
 */
public class Ejecutar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Edificio mapa = new Edificio();

		File archivoCSV = new File("archivosCSV" + "\\" + "habitaciones.csv");
		ConverterHabitaciones datosHabitaciones;
		try {
			System.out.println("#################################################################");
			System.out.println("Creando instancias de HABITACIONES: ");
			System.out.println("#################################################################");
			datosHabitaciones = new ConverterHabitaciones(archivoCSV);
			for (int i = 0; i < datosHabitaciones.getListaHabitaciones().size(); i++) {
				System.out.println("Id: "
						+ datosHabitaciones.getListaHabitaciones().get(i)
								.getIdHabitacion()
						+ "  "
						+ "Piso: "
						+ datosHabitaciones.getListaHabitaciones().get(i)
								.getNivel()
						+ "  "
						+ datosHabitaciones.getListaHabitaciones().get(i)
								.getClass().getSimpleName()
						+ "  "
						+ "	Descripcion: "
						+ datosHabitaciones.getListaHabitaciones().get(i)
								.getDescripcion());
			}
			mapa.setListaHabitaciones(datosHabitaciones.getListaHabitaciones());
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		File conexionesCSV = new File("archivosCSV" + "\\" + "conexiones.csv");
		ConverterConexiones datosConexiones;
		try {
			System.out.println("\n#################################################################");
		    System.out.println("Creando instancias de CONEXIONES: ");
		    System.out.println("#################################################################");
			datosConexiones = new ConverterConexiones(conexionesCSV);
			for (int i = 0; i < datosConexiones.getListaConexiones().size(); i++) {
				System.out.println("origen: "
						+ datosConexiones.getListaConexiones().get(i)
								.getIdOrigen()
						+ "  "
						+ "destino: "
						+ datosConexiones.getListaConexiones().get(i)
								.getIdDestino()
						+ "  "
						+ "costo: "
						+ datosConexiones.getListaConexiones().get(i)
								.getDistancia());
			}
			mapa.setListaConexiones(datosConexiones.getListaConexiones());
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		System.out.println("#################################################################");
		System.out.println("Probando algunos metodos: ");
		System.out.println("#################################################################");
		
		ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();
		
//		System.out.println("Id habitacion: "+ mapa.getListaHabitaciones().get(8).getIdHabitacion());
//		System.out.println("Piso donde esta la habitacion:" + mapa.getListaHabitaciones().get(8).getNivel());
//		System.out.println("descripcion " + mapa.getListaHabitaciones().get(8).getDescripcion());
//		adyacentes = mapa.getListaHabitaciones().get(8).getAdyacentes(mapa.getListaHabitaciones(), mapa.getListaConexiones());
		
		
		
		//System.out.println("¿Existe la habitacion con el id 1? --> " + mapa.existeHabitacion(1) + " -- nodos asociados: "+ mapa.cantidadDeHabitacionesAsociadas(1));
		//System.out.println("¿Existe la habitacion con el id 3? --> " + mapa.existeHabitacion(3) + " -- nodos asociados: "+ mapa.cantidadDeHabitacionesAsociadas(3));
		//System.out.println("¿Existe la habitacion con el id 7? --> " + mapa.existeHabitacion(7) + " -- nodos asociados: "+ mapa.cantidadDeHabitacionesAsociadas(7));
		
		System.out.println("¿Existe la habitacion con el id 12? --> " + mapa.existeHabitacion(12) + " -- nodos asociados: "+ mapa.cantidadDeHabitacionesAsociadas(12));
		adyacentes = mapa.getHabitacionToId(12).getAdyacentes(mapa.getListaHabitaciones(),mapa.getListaConexiones());
//		System.out.println("habitaciones adyacentes: " + adyacentes);
		
		System.out.println("los adyacentes a la habitacion 12 son: ");
		for (int i=0; i<adyacentes.size(); i++ ){
			if(adyacentes.get(i)!=null){
				System.out.println("habitacion: " + adyacentes.get(i).getIdHabitacion()+"- Tipo: "+ adyacentes.get(i).getClass().getSimpleName() + " - Descripcion: " + adyacentes.get(i).getDescripcion());	
			}
		}
		
//		System.out.println("Elementos de la lista de adyacentes: "+ adyacentes.size());
//		for(int i=0; i<adyacentes.size(); i++){
//			System.out.println(adyacentes.get(i).getIdHabitacion());
//		}
		
		
		
		
	}
}
