package frsf.cidisi.exercise.tpia2016.utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.interfaz.Principal;
import frsf.cidisi.exercise.tpia2016.modelo.*;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;



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
		Principal ventana;
		
		File archivoCSV = new File("archivosCSV" + "\\" + "habitaciones2.csv");
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
						+ "Clase: "
						+ datosHabitaciones.getListaHabitaciones().get(i)
								.getClass().getSimpleName()
						+ "  "
						+ "	Descripcion: "
						+ datosHabitaciones.getListaHabitaciones().get(i)
								.getDescripcion());
			}
			/**########### se le Asigna al mapa su lista de habitaciones ###########**/
			mapa.setListaHabitaciones(datosHabitaciones.getListaHabitaciones());
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		File conexionesCSV = new File("archivosCSV" + "\\" + "conexiones2.csv");
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
			
			/**########### se le Asigna al mapa su lista de habitaciones ###########**/
			mapa.setListaConexiones(datosConexiones.getListaConexiones());
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		System.out.println("#################################################################");
		System.out.println("Probando algunos metodos: ");
		System.out.println("#################################################################");
		
		ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();
		
		
		System.out.println("¿Existe la habitacion con el id: "+mapa.getHabitacionPorID("ingreso")+" ? --> " + mapa.existeHabitacion("ingreso1") + " -- nodos asociados: "+ mapa.cantidadDeHabitacionesAsociadas("ingreso1"));
		
		System.out.println(mapa.existeHabitacion("ingreso1"));
		
		
		
		adyacentes = mapa.getHabitacionPorIDporNivel("p1-0", 0).getAdyacentes(mapa.getListaHabitaciones(),mapa.getListaConexiones());
		
		
		System.out.println("los adyacentes al nodo: " +mapa.getHabitacionPorID("p1-0").getClass().getSimpleName() +" son: ");
		for (int i=0; i<adyacentes.size(); i++ ){
			if(adyacentes.get(i)!=null){
				System.out.println("habitacion: " + adyacentes.get(i).getIdHabitacion()+"- Tipo: "+ adyacentes.get(i).getClass().getSimpleName() + " - Descripcion: " + adyacentes.get(i).getDescripcion());	
			}
		}
		
		
		
	//	ventana = new Principal(mapa);
		
		/*modificar estos atributos*/

		
		
		
		
		
		/**Probar obtener datos**/
		//		String id="I1";
//		
//		System.out.println("#################################################################");
//		System.out.println("Obtengo las instancias de los Objetos: " + mapa.getHabitacionPorID(id).getClass().getSimpleName());
//		System.out.println("#################################################################");
//		
//		ArrayList<Habitacion> resultado=new ArrayList<Habitacion>();
//		
//		resultado=mapa.getHabitacionesPorID(id);
//		
//		for(int i=0; i<resultado.size(); i++){
//			System.out.println("-> Habitacion: "+ resultado.get(i).getClass().getSimpleName() +
//							   " - id: " + resultado.get(i).getIdHabitacion() + 
//							   " - nivel: " + resultado.get(i).getNivel() +
//							   " - desc: " + resultado.get(i).getDescripcion());	
//		}
		
		
		
	}
}
