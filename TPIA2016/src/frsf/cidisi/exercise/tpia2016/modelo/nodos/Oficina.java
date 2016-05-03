package frsf.cidisi.exercise.tpia2016.modelo.nodos;

import frsf.cidisi.exercise.tpia2016.modelo.grafo.Habitacion;

public class Oficina extends Habitacion  {
	
		private String descripcion;
		
		public Oficina() {
			super();
		}

		public Oficina(String id, int nivel, String desc) {
			super(id, nivel, desc);
			this.setDescripcion(desc);
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
}