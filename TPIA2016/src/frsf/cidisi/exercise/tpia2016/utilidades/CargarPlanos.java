package frsf.cidisi.exercise.tpia2016.utilidades;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class CargarPlanos {

	Edificio mapa = new Edificio();

	/**
	 * @param args
	 * @throws IOException
	 */
	public CargarPlanos() throws Exception {

		File archivoCSV = new File("archivosCSV" + "\\" + "habitaciones2.csv");
		ConverterHabitaciones datosHabitaciones;
		try {
			System.out
					.println("#################################################################");
			System.out.println("Creando instancias de HABITACIONES: ");
			System.out
					.println("#################################################################");

			// Esperar que el usuario presione enter para continuar...
//			System.out.println("Pulsa \'intro\' para continuar");
//			System.in.read();

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
			/**
			 * ########### se le Asigna al mapa su lista de habitaciones
			 * ###########
			 **/
			mapa.setListaHabitaciones(datosHabitaciones.getListaHabitaciones());

		} catch (IOException e) {

			e.printStackTrace();
		}

//		System.out.println("Pulsa \'intro\' para continuar");
//		System.in.read();

		File conexionesCSV = new File("archivosCSV" + "\\" + "conexiones2.csv");
		ConverterConexiones datosConexiones;
		try {
			System.out
					.println("\n#################################################################");
			System.out.println("Creando instancias de CONEXIONES: ");
			System.out
					.println("#################################################################");
			datosConexiones = new ConverterConexiones(conexionesCSV);

			// Esperar que el usuario presione enter para continuar...
//			System.out.println("Pulsa \'intro\' para continuar");
//			System.in.read();

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

			/**
			 * ########### se le Asigna al mapa su lista de habitaciones
			 * ###########
			 **/
			mapa.setListaConexiones(datosConexiones.getListaConexiones());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void ejecutarPrueba() throws IOException {
		System.out
				.println("#################################################################");
		System.out.println("Probando algunos metodos: ");
		System.out
				.println("#################################################################");

		ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();

		// Esperar que el usuario presione enter para continuar...
//		System.out.println("Pulsa \'intro\' para continuar");
//		System.in.read();
//		System.in.read();

		System.out.println("¿Existe la habitacion con el id: "
				+ mapa.getHabitacionPorID("ingreso1").getIdHabitacion()
				+ " ? --> " + mapa.existeHabitacion("ingreso1")
				+ " -- nodos asociados: "
				+ mapa.cantidadDeHabitacionesAsociadas("ingreso1"));

		System.out.println(mapa.existeHabitacion("ingreso1"));

		adyacentes = mapa.getHabitacionPorIDporNivel("p1-0", 0).getAdyacentes(
				mapa.getListaHabitaciones(), mapa.getListaConexiones());

		System.out.println("los adyacentes al nodo: "
				+ mapa.getHabitacionPorID("p1-0").getClass().getSimpleName()
				+ " son: ");
		for (int i = 0; i < adyacentes.size(); i++) {
			if (adyacentes.get(i) != null) {
				System.out.println("habitacion: "
						+ adyacentes.get(i).getIdHabitacion() + "- Tipo: "
						+ adyacentes.get(i).getClass().getSimpleName()
						+ " - Descripcion: "
						+ adyacentes.get(i).getDescripcion());
			}
		}

		ArrayList<Habitacion> habs = mapa.getHabitacionesPorID("esc3");
		for (int i = 0; i < habs.size(); i++) {
			System.out.println(habs.get(i).getIdHabitacion() + " "
					+ habs.get(i).getNivel() + " "
					+ habs.get(i).getDescripcion());
		}
	}
	
	public Edificio getMapa(){
		return this.mapa;
	}

}
