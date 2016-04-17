package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentePerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private int existe_obstáculo;
	private int hay_energía_eléctrica;
	private int hay_bip_ascensor;
	private int hay_bloqueo_escalera;
	private int hay_bloqueo_pasillo;
	private int energía_remanente_agente;
	
 

    public  AgentePerception() {
    	//TODO: Complete Method
    }

    public AgentePerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        
        //Agente agent = (Agente) agentIn;
        //Universidad environment = (Universidad) environmentIn;
        //EstadoAmbiente environmentState =
        //        environment.getEnvironmentState();
       
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public int getexiste_obstáculo(){
        return existe_obstáculo;
     }
     public void setexiste_obstáculo(int arg){
        this.existe_obstáculo = arg;
     }
     public int gethay_energía_eléctrica(){
        return hay_energía_eléctrica;
     }
     public void sethay_energía_eléctrica(int arg){
        this.hay_energía_eléctrica = arg;
     }
     public int gethay_bip_ascensor(){
        return hay_bip_ascensor;
     }
     public void sethay_bip_ascensor(int arg){
        this.hay_bip_ascensor = arg;
     }
     public int gethay_bloqueo_escalera(){
        return hay_bloqueo_escalera;
     }
     public void sethay_bloqueo_escalera(int arg){
        this.hay_bloqueo_escalera = arg;
     }
     public int gethay_bloqueo_pasillo(){
        return hay_bloqueo_pasillo;
     }
     public void sethay_bloqueo_pasillo(int arg){
        this.hay_bloqueo_pasillo = arg;
     }
     public int getenergía_remanente_agente(){
        return energía_remanente_agente;
     }
     public void setenergía_remanente_agente(int arg){
        this.energía_remanente_agente = arg;
     }
	
   
}
