package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbienteUniversidad extends EnvironmentState {
	
	//TODO: Setup Variables
    //private Other mapaEdificio;
    //private Other posicionActualAgente;
	
    public EstadoAmbienteUniversidad() {
        
        //TODO: Complete Method
    	/*
			// mapaEdificio = initData0;
			// posicionActualAgente = initData1;
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
	
//     public Other getmapaEdificio(){
//        return mapaEdificio;
//     }
//     public void setmapaEdificio(Other arg){
//        mapaEdificio = arg;
//     }
//     public Other getposicionActualAgente(){
//        return posicionActualAgente;
//     }
//     public void setposicionActualAgente(Other arg){
//        posicionActualAgente = arg;
//     }
	

}

