package frsf.cidisi.exercise.tpia2016.search;


import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.state.AgentState;

import java.util.ArrayList;

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
         
         ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();
         
         //Obtengo los adyacentes a la posicion
         adyacentes = this.getEnvironmentState().getMapa_ambiente().getHabitacionesAdyacentes(h.getIdHabitacion());
     
         // De todos mis adyacentes obtengo las clase
         // y pregunto si esta bloqueado en caso de ser escalera o pasillo
         // y pregunto si el beep esta prendido en el ascensor
         
         for(Habitacion ha: adyacentes){
         	if(ha.getClass().getSimpleName().equals("Pasillo")){
     			Pasillo p=(Pasillo)ha;
     			if(p.isBloqueado()){
     				((Pasillo)perception.getPasilloBloqueado(p)).setBloqueado(true);
     			}
     		}
     		else{
     			if(ha.getClass().getSimpleName().equals("Ascensor")){
     				Ascensor asc=(Ascensor)ha;
     				if(asc.isPitido()){
     					((Ascensor)perception.getAscensorBloqueado(asc)).setPitido(true);
     				} 					
     			}
     			else{
     				if(ha.getClass().getSimpleName().equals("Escalera")){
     					Escalera esc=(Escalera)ha;
     					if(esc.isBloqueada()){
     						((Escalera)perception.getEscaleraBloqueada(esc)).setBloqueada(true);
     					}
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
