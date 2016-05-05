package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;

public class Universidad extends Environment {

    public Universidad(Edificio edificio) {
        // Create the environment state
        this.environmentState = new EstadoAmbiente(edificio);
    }

    public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  AgentePerception getPercept() {
        // Create a new perception to return
         AgentePerception perception = new AgentePerception();
		
		//TODO : Set the perceptions sensors
        
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        EstadoAmbiente envState =
                this.getEnvironmentState();

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
