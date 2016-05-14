package frsf.cidisi.exercise.tpia2016.search;


import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Ascensor;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Escalera;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.Pasillo;

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
		
         Habitacion h = this.getEnvironmentState().getPosicion_agente();
         
 		if(h.getClass()==Pasillo.class){
 			Pasillo p=(Pasillo)h;
 			if(p.isBloqueado()){
 				perception.setHay_bip_ascensor(1);
 			}
 			else{
 				perception.setHay_bip_ascensor(0);
 			}
 		}
 		else{
 			if(h.getClass()==Ascensor.class){
 				Ascensor p=(Ascensor)h;
 				if(p.isPitido()){
 					perception.setHay_bip_ascensor(1);
 				} 
 				else{
 					perception.setHay_bip_ascensor(0);
 				}					
 			}
 			else{
 				if(h.getClass()==Escalera.class){
 					Escalera p=(Escalera)h;
 					if(p.isBloqueada()){
 						perception.setHay_bloqueo_escalera(1);
 					}
 					else{
 						perception.setHay_bloqueo_escalera(0);
 					}
 				}
 			}
 		}
        
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(AgentState state) {
        // TODO: Complete Method     
    	boolean falla=false;
    	EstadoAgente p =(EstadoAgente) state;
        if(p.getEnergía_agente()<0){
        	falla=true;
        }
        return falla;
    }    
}
