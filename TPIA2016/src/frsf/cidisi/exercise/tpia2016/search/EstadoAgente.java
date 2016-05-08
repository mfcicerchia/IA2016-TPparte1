package frsf.cidisi.exercise.tpia2016.search;

import java.util.ArrayList;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoAgente extends SearchBasedAgentState {
    private Edificio mapa_ambiente;
    private int energía_agente;
    private Habitacion posicion;
    private ArrayList<Habitacion> habitaciones_visitadas;
	
    public EstadoAgente() {
    	
    }

    public EstadoAgente(Edificio mapa, int energía, Habitacion post, ArrayList<Habitacion> visitadas) {
    	initState(mapa, energía, post,  visitadas);
			
    }
    
    /**
     * This method is optional, and sets the initial state of the agent.
     */
    public void initState(Edificio mapa, int energía, Habitacion post, ArrayList<Habitacion> visitadas) {
    	 // TODO: LISTO
    	
    	 this.mapa_ambiente = mapa;
		 this.energía_agente = energía;
		 this.posicion = post;
		 this.habitaciones_visitadas = visitadas;

    }
    
    @Override
	public void initState() {

		
	}

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
    	
    	ArrayList<Habitacion> habitaciones= new ArrayList<Habitacion>();
    	for(Habitacion h: this.getMapa_ambiente().getListaHabitaciones()){
    		habitaciones.add(h.clone());
    	}
    	
    	ArrayList<Conexion> conexiones= new ArrayList<Conexion>();
    	for(Conexion c: this.getMapa_ambiente().getListaConexiones()){
    		conexiones.add(c.clone());
    	}
    	
    	int energia=this.getEnergía_agente();
    	Habitacion habitacion=this.getPosicion().clone();
    	ArrayList<Habitacion> visitadas= this.getHabitaciones_visitadas();
		
        return new EstadoAgente(new Edificio(habitaciones,conexiones),energia,habitacion,visitadas);
    }
    
    

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
     
        //TODO: Complete Method
    	
    	AgentePerception perception=(AgentePerception)p;
    	Habitacion posicionActual= this.getPosicion();
    	
    	int hay_bip=perception.getHay_bip_ascensor();
    	int hay_bloqueo_escalera=perception.getHay_bloqueo_escalera();
    	int hay_bloqueo_pasillo=perception.getHay_bloqueo_pasillo();
    	
    	if(hay_bip==1){
    		
    		for(Habitacion i: this.mapa_ambiente.getHabitacionesPorID(this.getPosicion().getIdHabitacion())){
    			Ascensor j = (Ascensor)i;
    			j.setPitido(true);
    		}
    	}
    	if(hay_bloqueo_escalera==1){
    		for(Habitacion i: this.mapa_ambiente.getHabitacionesPorID(this.getPosicion().getIdHabitacion())){
    			Escalera j = (Escalera)i;
    			j.setBloqueada(true);;
    		}
    	}
    	if(hay_bloqueo_pasillo==1){	
    		for(Habitacion i: this.mapa_ambiente.getHabitacionesPorID(this.getPosicion().getIdHabitacion())){
    			Pasillo j = (Pasillo)i;
    			j.setBloqueado(true);;
    		}
    	}
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
        
        str += "Visitadas: {";
        for(Habitacion h : habitaciones_visitadas)
        	str+= h.toString() + ", ";
        str = str.substring(0,str.length()-2);
        str += "}\n";
        
        str += "Posición del agente: ";
        str += posicion.toString();
        
        str += "Energia: ";
        str += energía_agente;
        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       //TODO: Complete Method
    	boolean equals=false;
    	EstadoAgente nuevoEstado = (EstadoAgente) obj;
    	
    	Habitacion postActual = this.getPosicion();
    	Habitacion postNueva = nuevoEstado.getPosicion();
    	
    	if(postActual.equals(postNueva) && this.getEnergía_agente()==nuevoEstado.getEnergía_agente()){
    		equals = true;
    	}

    	return equals;
    }
   	
     public Edificio getMapa_ambiente(){
        return mapa_ambiente;
     }
     public void setMapa_ambiente(Edificio arg){
        mapa_ambiente = arg;
     }
     public int getEnergía_agente(){
        return energía_agente;
     }
     public void setEnergía_agente(int arg){
        energía_agente = arg;
     }
     public Habitacion getPosicion(){
        return posicion;
     }
     public void setPosicion(Habitacion arg){
        posicion = arg;
     }
     public ArrayList<Habitacion> getHabitaciones_visitadas(){
        return habitaciones_visitadas;
     }
     public void setHabitaciones_visitadas(ArrayList<Habitacion> arg){
        habitaciones_visitadas = arg;
    }
}

