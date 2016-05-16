package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Edificio;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;


public class AgenteEjecutar {
	/**
	 * @param args
	 * @throws Exception
	 */
	
    public static void ejecutar(Edificio mapa, int energía, Habitacion post,Habitacion dest, int busqueda) {
    	
    	Agente agent = new Agente(mapa, energía, post ,dest);
    	Universidad environment = new Universidad(mapa);
    	
    	SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);       
        simulator.start(busqueda);
    }

}