package frsf.cidisi.exercise.tpia2016.search;

import java.util.ArrayList;


import frsf.cidisi.exercise.tpia2016.modelo.grafo.*;
import frsf.cidisi.exercise.tpia2016.modelo.nodos.*;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AgentePerception extends Perception {
	
	ArrayList<Ascensor> ascensoresBLoqueados;
	ArrayList<Escalera> escalerasBloqueadas;
	ArrayList<Pasillo> pasillosBloqueados;
	
 

    public  AgentePerception() {
    	ascensoresBLoqueados=new ArrayList<Ascensor>();
    	escalerasBloqueadas=new ArrayList<Escalera>();
    	pasillosBloqueados=new ArrayList<Pasillo>();
    }

    public AgentePerception(Agent agent, Environment environment) {
        super(agent, environment);
        initPerception(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
        
       // Agente agent = (Agente) agentIn;
        Universidad environment = (Universidad) environmentIn;
        EstadoAmbiente environmentState =  environment.getEnvironmentState();
       
        Habitacion posicionActual = environmentState.getPosicion_agente();
        
        ArrayList<Habitacion> adyacentes = new ArrayList<Habitacion>();
        
        //Obtengo los adyacentes a la posicion
        adyacentes = environmentState.getMapa_ambiente().getHabitacionesAdyacentes(posicionActual.getIdHabitacion());
    
        // De todos mis adyacentes obtengo las clase
        // y pregunto si esta bloqueado en caso de ser escalera o pasillo
        // y pregunto si el beep esta prendido en el ascensor
        
        for(Habitacion h: adyacentes){
        	if(h.getClass().getSimpleName().equals("Pasillo")){
    			Pasillo p=(Pasillo)h;
    			if(p.isBloqueado()){
    				p.setBloqueado(true);
    				pasillosBloqueados.add(p);
    			}
    		}
    		
    			if(h.getClass().getSimpleName().equals("Ascensor")){
    				Ascensor asc=(Ascensor)h;
    				if(asc.isPitido()){
    					asc.setPitido(true);
    					ascensoresBLoqueados.add(asc);
    				} 					
    			}
    		
    				if(h.getClass().getSimpleName().equals("Escalera")){
    					Escalera esc=(Escalera)h;
    					if(esc.isBloqueada()){
    						esc.setBloqueada(true);
        					escalerasBloqueadas.add(esc);
    					}
					}
		}
    }


	@Override
	public String toString() {
		String str = "AgentePerception [pasillos bloqueados= ";
		for(Habitacion h: this.getPasillosBloqueados()){
		 str+=h.getIdHabitacion()+" "+h.getDescripcion()+ " " + h.getNivel();
		}
		str+=", escaleras bloqueadas=";
		for(Habitacion h: this.getEscalerasBloqueadas()){
			 str+=h.getIdHabitacion()+" "+h.getDescripcion()+ " " + h.getNivel();
		}
		str+=", Ascensores Bloqueados=";
		for(Habitacion h: this.getAscensoresBLoqueados()){
			 str+=h.getIdHabitacion()+" "+h.getDescripcion()+ " " + h.getNivel();
		}
		str+=" ]";
		return str;
	}

	public ArrayList<Ascensor> getAscensoresBLoqueados() {
		return ascensoresBLoqueados;
	}

	public void setAscensoresBLoqueados(ArrayList<Ascensor> ascensoresBLoqueados) {
		this.ascensoresBLoqueados = ascensoresBLoqueados;
	}

	public ArrayList<Escalera> getEscalerasBloqueadas() {
		return escalerasBloqueadas;
	}

	public void setEscalerasBloqueadas(ArrayList<Escalera> escalerasBloqueadas) {
		this.escalerasBloqueadas = escalerasBloqueadas;
	}

	public ArrayList<Pasillo> getPasillosBloqueados() {
		return pasillosBloqueados;
	}

	public void setPasillosBloqueados(ArrayList<Pasillo> pasillosBloqueados) {
		this.pasillosBloqueados = pasillosBloqueados;
	}
	
	public Habitacion getPasilloBloqueado(Habitacion pasillo) {
		for(Habitacion p: this.pasillosBloqueados){
			if(p.getIdHabitacion().equals(pasillo.getDescripcion())){
				return p;
			}
		}
		return null;
	}

	public Habitacion getEscaleraBloqueada(Habitacion escalera) {
		for(Habitacion p: this.escalerasBloqueadas){
			if(p.getIdHabitacion().equals(escalera.getDescripcion())){
				return p;
			}
		}
		return null;
	}
	
	public Habitacion getAscensorBloqueado(Habitacion ascensor) {
		for(Habitacion p: this.ascensoresBLoqueados){
			if(p.getIdHabitacion().equals(ascensor.getDescripcion())){
				return p;
			}
		}
		return null;
	}



}
