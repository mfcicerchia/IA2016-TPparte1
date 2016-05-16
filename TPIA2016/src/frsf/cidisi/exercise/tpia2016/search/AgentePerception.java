package frsf.cidisi.exercise.tpia2016.search;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentePerception extends Perception {

    public static int UNKNOWN_PERCEPTION = -1;   
	private int hay_bip_ascensor;
	private int hay_bloqueo_escalera;
	private int hay_bloqueo_pasillo;
	
 

    public  AgentePerception() {
    	hay_bip_ascensor=UNKNOWN_PERCEPTION;
    	hay_bloqueo_escalera=UNKNOWN_PERCEPTION;
    	hay_bloqueo_pasillo=UNKNOWN_PERCEPTION;	
    }

    public AgentePerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
        
       // Agente agent = (Agente) agentIn;
        Universidad environment = (Universidad) environmentIn;
        EstadoAmbiente environmentState =  environment.getEnvironmentState();
       
        Habitacion posicionActual = environmentState.getPosicion_agente();
        
        ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();
        
        //Obtengo los adyacentes a la posicion
        adyacentes = environmentState.getMapa_ambiente().getHabitacionesAdyacentes(posicionActual.getIdHabitacion());
    
        // De todos mis adyacentes obtengo las clase
        // y pregunto si esta bloqueado en caso de ser escalera o pasillo
        // y pregunto si el beep esta prendido en el ascensor
        for(Habitacion adyacente: adyacentes){
        	if(adyacente.getClass().getSimpleName().equals("Pasillo")){
    			Pasillo p=(Pasillo)adyacente;
    			if(p.isBloqueado()){
    				hay_bloqueo_pasillo=1;
    			}
    			else{
    				hay_bloqueo_pasillo=0;
    			}
    		}
    		else{
    			if(adyacente.getClass().getSimpleName().equals("Ascensor")){
    				Ascensor asc=(Ascensor)adyacente;
    				if(asc.isPitido()){
    					hay_bip_ascensor=1;
    				} 
    				else{
    					hay_bip_ascensor=0;
    				}					
    			}
    			else{
    				if(adyacente.getClass().getSimpleName().equals("Escalera")){
    					Escalera esc=(Escalera)adyacente;
    					if(esc.isBloqueada()){
    						hay_bloqueo_escalera=1;
    					}
    					else{
    						hay_bloqueo_escalera=0;
						}
					}
				}
			}

		}

    }
    
    @Override
	public String toString() {
		return "AgentePerception [hay_bip_ascensor="
				+ hay_bip_ascensor + ", hay_bloqueo_escalera=" + hay_bloqueo_escalera + ", hay_bloqueo_pasillo="
				+ hay_bloqueo_pasillo + "]";
	}

	public int getHay_bip_ascensor() {
		return hay_bip_ascensor;
	}

	public void setHay_bip_ascensor(int hay_bip_ascensor) {
		this.hay_bip_ascensor = hay_bip_ascensor;
	}

	public int getHay_bloqueo_escalera() {
		return hay_bloqueo_escalera;
	}

	public void setHay_bloqueo_escalera(int hay_bloqueo_escalera) {
		this.hay_bloqueo_escalera = hay_bloqueo_escalera;
	}

	public int getHay_bloqueo_pasillo() {
		return hay_bloqueo_pasillo;
	}

	public void setHay_bloqueo_pasillo(int hay_bloqueo_pasillo) {
		this.hay_bloqueo_pasillo = hay_bloqueo_pasillo;
	}
}
