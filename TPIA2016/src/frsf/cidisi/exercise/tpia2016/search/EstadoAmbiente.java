package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
	//TODO: Setup Variables
    //private Other mapa_ambiente;
    //private Other posicion_agente;
    private boolean energ�a_el�ctrica;
	
    public EstadoAmbiente() {
        
        //TODO: Complete Method
    	/*
			// mapa_ambiente = initData0;
			// posicion_agente = initData1;
			// energ�a_el�ctrica = initData2;
        */
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //TODO: Complete Method
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
//     public Other getmapa_ambiente(){
//        return mapa_ambiente;
//     }
//     public void setmapa_ambiente(Other arg){
//        mapa_ambiente = arg;
//     }
//     public Other getposicion_agente(){
//        return posicion_agente;
//     }
//     public void setposicion_agente(Other arg){
//        posicion_agente = arg;
//     }
     public boolean getenerg�a_el�ctrica(){
        return energ�a_el�ctrica;
     }
     public void setenerg�a_el�ctrica(boolean arg){
        energ�a_el�ctrica = arg;
     }
	

}

