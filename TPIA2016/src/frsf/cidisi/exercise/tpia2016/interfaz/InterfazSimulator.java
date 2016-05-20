package frsf.cidisi.exercise.tpia2016.interfaz;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.Timer;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;
import frsf.cidisi.exercise.tpia2016.search.*;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.GoalBasedAgent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;

public class InterfazSimulator extends SearchBasedAgentSimulator {
	
	private boolean terminado;
	private static Timer autoStep;
	private Perception perception;
	private Action action;
	private GoalBasedAgent agent;
	int estrategia;
	String str="";

	public InterfazSimulator(Environment environment, Vector<Agent> agents) {
        super(environment, agents);
    }

    public InterfazSimulator(Environment environment, Agent agent) {
        this(environment, new Vector<Agent>(Arrays.asList(agent)));
        terminado = false;
    }
    
    public void start(int estrategia) {
    	this.estrategia=estrategia;
        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();
        InterfazManager.setSimulator(this);

    }
    
    public int avanzar() {
    	if (this.terminado)
    		return 1;
    	
        agent = (GoalBasedAgent) this.getAgents().firstElement();

    	System.out.println("------------------------------------");
        System.out.println("Sending perception to agent...");
        
        
        if(!(perception==null)){
        	perception = this.getPercept();
	        agent.see(perception);
        }
	        
        
        System.out.println("Perception: " + perception);
        System.out.println("Agent State: " + agent.getAgentState());
        System.out.println("Environment: " + environment);
        System.out.println("Asking the agent for an action...");
        
        action = agent.selectAction(estrategia);

        if (action == null) {
        	this.terminado = true;
        }

        System.out.println("Action returned: " + action);
        System.out.println();
        
        InterfazManager.registrarAccion("" + action);


        this.actionReturned(agent, action);
        
        EstadoAgente agente = (EstadoAgente) agent.getAgentState();
        EstadoAmbiente ambiente = (EstadoAmbiente) environment.getEnvironmentState();
        InterfazManager.registrarPosicion(agente.getPosicion().getDescripcion());
        InterfazManager.registrarEnergia(agente.getEnergía_agente()+"");
        InterfazManager.registrarPosicionObjetivo(agente.getDestino().getDescripcion());
        
        for(Habitacion h: agente.getHabitaciones_visitadas()){
            str+=h.getDescripcion()+"\n";
        }
        InterfazManager.registrarHabitacionesVisitadas(str);

        InterfazManager.registrarExito("El agente está en camino.");
        InterfazManager.registrarPosicionActual(ambiente.getPosicion_agente().getDescripcion());
        if(perception != null){
        	InterfazManager.registrarPercepcion(perception.toString());	
        }
        InterfazManager.dibujarAgente(agente.getPosicion().getPosicion(),agente.getPosicion().getNivel());
        if (this.agentSucceeded(action) || this.agentFailed(agent.getAgentState()) ) {
        	this.terminado = true;
        }
        return 0;
    }
    
    public void terminar() {
        if (this.agentSucceeded(action)) {
            System.out.println("Agent has reached the goal!");
            InterfazManager.registrarExito("El agente a llegado al destino.");
        } else {
            System.out.println("ERROR: The simulation has finished, but the agent has not reached his goal.");
        }
        System.out.println();
        this.environment.close();
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
    }
	
}
