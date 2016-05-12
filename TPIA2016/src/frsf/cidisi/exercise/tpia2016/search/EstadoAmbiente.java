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


	public EstadoAmbiente(Edificio mapa) {
    	setMapa_ambiente(mapa); 	
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    
    public void initState() {	
    	posicion_agente = mapa_ambiente.getHabitacionPorID("ingreso1"); 	
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
        
        return str;
    }
 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoAmbiente other = (EstadoAmbiente) obj;
		if (mapa_ambiente == null) {
			if (other.mapa_ambiente != null)
				return false;
		} 
		else{ 
			if (!mapa_ambiente.equals(other.mapa_ambiente)){
				return false;
			}
			else{
				if(mapa_ambiente.getListaHabitaciones().size()==other.getMapa_ambiente().getListaHabitaciones().size() 
						&& mapa_ambiente.getListaConexiones().size()==other.getMapa_ambiente().getListaConexiones().size()){
					
					int cuenta_h =0, cuenta_c=0;
					for(Habitacion i: mapa_ambiente.getListaHabitaciones()){
						if(other.getMapa_ambiente().getListaHabitaciones().contains(i)){
							cuenta_h++;
						}
					}
					for(Conexion i: mapa_ambiente.getListaConexiones()){
						if(other.getMapa_ambiente().getListaConexiones().contains(i)){
							cuenta_c++;
						}
					}
					if(cuenta_h!=mapa_ambiente.getListaHabitaciones().size()  && cuenta_c!=mapa_ambiente.getListaConexiones().size()){
						return false;
					}
				}
				else{
					return false;
				}
			}			
		}
		if (posicion_agente == null) {
			if (other.getPosicion_agente() != null)
				return false;
		} 
		else if (!posicion_agente.equals(other.getPosicion_agente()))
			return false;
		return true;
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
}

