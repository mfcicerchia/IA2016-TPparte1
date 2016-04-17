package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {
	
	//TODO: Setup Variables
    //private Other mapa_ambiente;
    private int energía_agente;
    //private Other posicion;
    private int costo_actual;
    //private Other habitaciones_visitadas;
	

    public EstadoAgente() {
    
    	//TODO: Complete Method
    	/*
			// mapa_ambiente = initData0;
			// energía_agente = initData1;
			// posicion = initData2;
			// costo_actual = initData3;
			// habitaciones_visitadas = initData4;
        */
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
		
        return null;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method

    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	
//     public Other getmapa_ambiente(){
//        return mapa_ambiente;
//     }
//     public void setmapa_ambiente(Other arg){
//        mapa_ambiente = arg;
//     }
     public int getenergía_agente(){
        return energía_agente;
     }
     public void setenergía_agente(int arg){
        energía_agente = arg;
     }
//     public Other getposicion(){
//        return posicion;
//     }
//     public void setposicion(Other arg){
//        posicion = arg;
//     }
     public int getcosto_actual(){
        return costo_actual;
     }
     public void setcosto_actual(int arg){
        costo_actual = arg;
     }
//     public Other gethabitaciones_visitadas(){
//        return habitaciones_visitadas;
//     }
//     public void sethabitaciones_visitadas(Other arg){
//        habitaciones_visitadas = arg;
//     }
	
}

