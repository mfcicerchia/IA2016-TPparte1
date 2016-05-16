package frsf.cidisi.exercise.tpia2016.search;

import java.awt.EventQueue;
import javax.swing.UIManager;

import frsf.cidisi.exercise.tpia2016.interfaz.PanelConfigurar;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					new PanelConfigurar();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}