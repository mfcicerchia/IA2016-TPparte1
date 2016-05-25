
package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.exercise.tpia2016.utilidades.CargarPlanos;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteMain {
	
	/**
     * @param args
	 * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        
    	//Se cargan los planos del edificio en el atributo edificio
    	CargarPlanos mapaInformation = new CargarPlanos();
    	CargarPlanos mapaInformation2 = new CargarPlanos();
    	Edificio edificio = mapaInformation.getMapa();
    	Edificio edificio2 = mapaInformation2.getMapa();
    	// Se crea la ventana principal y desde aca se da el OK 
    	// para que inicie la simulacion
    	
    	//// Principal ventana = new Principal(edificio);
    	
    	
    	// Setear el estado del agente y del ambiente con los datos 
    	// ya cargados
    	Agente agent = new Agente(edificio, 1000, edificio.getHabitacionPorID("ingreso1"), edificio.getHabitacionPorID("ofc1-3"));
        Universidad environment = new Universidad(edificio2);

        final SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);
        simulator.start(1);
    }

}
