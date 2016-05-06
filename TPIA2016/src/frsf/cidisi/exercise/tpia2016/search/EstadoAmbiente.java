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
    private boolean falla;

	public EstadoAmbiente(Edificio mapa) {
    	setMapa_ambiente(mapa); 	
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    
    public void initState() {	
    	posicion_agente.setIdHabitacion("ingreso1"); 
    	falla=false;  	
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
        
        str += "Falla: ";
        str += falla;
        return str;
    }

	public Edificio getMapa_ambiente() {
		return mapa_ambiente;
	}

	public void setMapa_ambiente(Edificio mapa_ambiente) {
		this.mapa_ambiente = mapa_ambiente;
	}

	public Habitacion getPosicion_agente() {
		return posicion_agente;
	}

	public void setPosicion_agente(Habitacion posicion_agente) {
		this.posicion_agente = posicion_agente;
	}

	public boolean isFalla() {
		return falla;
	}

	public void setFalla(boolean falla) {
		this.falla = falla;
	}
}

