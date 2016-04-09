package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgenteGuiaPerception extends Perception {

	//TODO: Setup Statics
    //public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private int energia;
	private int obstáculo;
	private int pasillo;
	private int ascensor;
	private int escalera;
	
 

    public  AgenteGuiaPerception() {
    	//TODO: Complete Method
    }

    public AgenteGuiaPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        
        //AgenteGuia agent = (AgenteGuia) agentIn;
        //Universidad environment = (Universidad) environmentIn;
        //EstadoAmbienteUniversidad environmentState =
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
	
     public int getenergia(){
        return energia;
     }
     public void setenergia(int arg){
        this.energia = arg;
     }
     public int getobstáculo(){
        return obstáculo;
     }
     public void setobstáculo(int arg){
        this.obstáculo = arg;
     }
     public int getpasillo(){
        return pasillo;
     }
     public void setpasillo(int arg){
        this.pasillo = arg;
     }
     public int getascensor(){
        return ascensor;
     }
     public void setascensor(int arg){
        this.ascensor = arg;
     }
     public int getescalera(){
        return escalera;
     }
     public void setescalera(int arg){
        this.escalera = arg;
     }
	
   
}
