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
    private int energ�a_agente;
    private Habitacion posicionActual;
    private Habitacion posicionDestino;
    private ArrayList<Habitacion> habitaciones_visitadas;
  

    

	public EstadoAgente() {
    	
    }

    public EstadoAgente(Edificio mapa, int energ�a, Habitacion posicionInicial,Habitacion posicionDestino) {
    	initState(mapa, energ�a, posicionInicial,posicionDestino);
			
    }
    
    public EstadoAgente(Edificio mapa, int energ�a, Habitacion post,Habitacion destino, ArrayList<Habitacion> visitadas) {
    	initState(mapa, energ�a, post,destino);
		habitaciones_visitadas=visitadas;
    }
    
    /**
     * This method is optional, and sets the initial state of the agent.
     */
    public void initState(Edificio mapa, int energ�a, Habitacion posicionActual,Habitacion posicionDestino) {
    	 // TODO: LISTO
    	
    	 this.mapa_ambiente = mapa;
		 this.energ�a_agente = energ�a;
		 this.posicionActual = posicionActual;
		 this.posicionDestino=posicionDestino;

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
    	
    	int energia=this.getEnerg�a_agente();
    	Habitacion habitacion=this.getPosicion().clone();
    	Habitacion destino=this.getDestino().clone();
    	ArrayList<Habitacion> visitadas= this.getHabitaciones_visitadas();
		
        return new EstadoAgente(new Edificio(habitaciones,conexiones),energia,habitacion,destino,visitadas);
    }
    
    

    public Habitacion getDestino() {
		return posicionDestino;
	}

	public void setDestino(Habitacion destino) {
		this.posicionDestino = destino;
	}

	/**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
     
        //TODO: LISTO - UpdateState
    	
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
        
        if(habitaciones_visitadas!=null){
        	 str += "Visitadas: {";
             for(Habitacion h : habitaciones_visitadas)
             	str+= h.toString() + ", ";
             str = str.substring(0,str.length()-2);
             str += "}\n";
        }
       
        
        str += "Posici�n del agente: ";
        str += posicionActual.toString();
        
        str += "Destino: ";
        str += destino.toString();
        
        str += "Energia: ";
        str += energ�a_agente;
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
		EstadoAgente other = (EstadoAgente) obj;
		if (energ�a_agente != other.energ�a_agente)
			return false;
		if (habitaciones_visitadas == null) {
			if (other.habitaciones_visitadas != null)
				return false;
		} 
		else if (!habitaciones_visitadas.equals(other.habitaciones_visitadas))
			return false;
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
					if(cuenta_h==mapa_ambiente.getListaHabitaciones().size()  && cuenta_c==mapa_ambiente.getListaConexiones().size()){
						return false;
					}
				}
				else{
					return false;
				}
			}			
		}
		if (posicionActual == null) {
			if (other.posicionActual != null)
				return false;
		} 
		else if (!posicionActual.equals(other.posicionActual))
			return false;
		return true;
	}
    
    
   	
     public Edificio getMapa_ambiente(){
        return mapa_ambiente;
     }
     public void setMapa_ambiente(Edificio arg){
        mapa_ambiente = arg;
     }
     public int getEnerg�a_agente(){
        return energ�a_agente;
     }
     public void setEnerg�a_agente(int arg){
        energ�a_agente = arg;
     }
     public Habitacion getPosicion(){
        return this.posicionActual;
     }
     public void setPosicion(Habitacion arg){
        this.posicionActual = arg;
     }
     public ArrayList<Habitacion> getHabitaciones_visitadas(){
        return habitaciones_visitadas;
     }
     public void setHabitaciones_visitadas(ArrayList<Habitacion> arg){
        habitaciones_visitadas = arg;
    }
 	
     public Habitacion getPosicionDestino() {
 		return posicionDestino;
 	}

 	public void setPosicionObjetivo(Habitacion posicionDestino) {
 		this.posicionDestino = posicionDestino;
 	}
}

