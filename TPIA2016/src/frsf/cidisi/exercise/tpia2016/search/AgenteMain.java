package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteMain {

    public static void main(String[] args) throws PrologConnectorException {
        Agente agent = new Agente();

        Universidad environment = new Universidad();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
