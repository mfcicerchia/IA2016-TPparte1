package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentePerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private int existe_obst�culo;
	private int hay_energ�a_el�ctrica;
	private int hay_bip_ascensor;
	private int hay_bloqueo_escalera;
	private int hay_bloqueo_pasillo;
	private int energ�a_remanente_agente;
	
 

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
	
     public int getexiste_obst�culo(){
        return existe_obst�culo;
     }
     public void setexiste_obst�culo(int arg){
        this.existe_obst�culo = arg;
     }
     public int gethay_energ�a_el�ctrica(){
        return hay_energ�a_el�ctrica;
     }
     public void sethay_energ�a_el�ctrica(int arg){
        this.hay_energ�a_el�ctrica = arg;
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
     public int getenerg�a_remanente_agente(){
        return energ�a_remanente_agente;
     }
     public void setenerg�a_remanente_agente(int arg){
        this.energ�a_remanente_agente = arg;
     }
	
   
}
