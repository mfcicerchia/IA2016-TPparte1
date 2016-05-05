package frsf.cidisi.exercise.tpia2016.search;

import frsf.cidisi.faia.state.EnvironmentState;
import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;


/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
	//TODO: Setup Variables
    private Edificio mapa_ambiente;
    private Habitacion posicion_agente;
    private boolean energía_eléctrica;
	
    public EstadoAmbiente(Edificio mapa) {
    	set_mapa_ambiente(mapa); 	
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    
    public void initState() {
    	
    	posicion_agente.setIdHabitacion("ingreso1"); 
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";
 
        str += "Habitaciones: {";
        for(Habitacion h : mapa_ambiente.getListaHabitaciones())
        	str+= h.toString() + ", ";
        str = str.substring(0,str.length()-2);
        str += "}\n";
        
        str += "Conexiones: {";
        for(Conexion h : mapa_ambiente.getListaConexiones())
        	str+= h.toString() + ", ";
        str = str.substring(0,str.length()-2);
        str += "}\n";
        
        str += "Posición del agente: ";
        str += posicion_agente.toString();
        
        str += "Energía eléctrica: ";
        str += energía_eléctrica;
        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public Edificio get_mapa_ambiente(){
        return mapa_ambiente;
     }
     public void set_mapa_ambiente(Edificio arg){
        mapa_ambiente = arg;
     }
     public Habitacion get_posicion_agente(){
        return posicion_agente;
     }
     public void set_posicion_agente(Habitacion arg){
        posicion_agente = arg;
     }
     public boolean get_energía_eléctrica(){
        return energía_eléctrica;
     }
     public void set_energía_eléctrica(boolean arg){
        energía_eléctrica = arg;
     }
}

