package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteGuiaMain {

    public static void main(String[] args) throws PrologConnectorException {
        AgenteGuia agent = new AgenteGuia();

        Universidad environment = new Universidad();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
