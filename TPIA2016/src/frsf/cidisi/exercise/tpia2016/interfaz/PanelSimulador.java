package frsf.cidisi.exercise.tpia2016.interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JToolBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;


public class PanelSimulador {

	private JFrame frame;
//	public JMapPane mapa;
//	public JLogPane logPanel;
	private JTable table;
	private JToggleButton tglbtnPlay;
	private JTextField txtDist;
	private JTextField txtBotin;
	private JTextField txtCoins;
	private JTextField txtRubies;
	private JTextField txtRings;
	private JTextField txtDiams;
	private JTextField txtNecks;
	private JTextField txtContainer;
	private JLabel lblEscenario;
	private JButton btnNext;
	
	/**
	 * Create the application.
	 */
	public PanelSimulador(int escenario, String estrategia) {
		initialize();
		frame.setVisible(true);
		lblEscenario.setText("Escenario "+escenario+". "+estrategia);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setTitle("TP IA - Simulación de Búsqueda");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Datos del arquelogo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][]"));
		
		JLabel lblDistanciaRecorrida = new JLabel("Distancia recorrida:");
		panel_2.add(lblDistanciaRecorrida, "cell 0 0,alignx trailing");
		
		txtDist = new JTextField();
		txtDist.setEditable(false);
		txtDist.setText("0");
		panel_2.add(txtDist, "flowx,cell 1 0,growx");
		txtDist.setColumns(10);
		
		JLabel lblBotin = new JLabel("Botin:");
		panel_2.add(lblBotin, "cell 2 0,alignx trailing");
		
		txtBotin = new JTextField();
		txtBotin.setEditable(false);
		txtBotin.setText("0");
		panel_2.add(txtBotin, "cell 3 0,growx");
		txtBotin.setColumns(10);
		
		JLabel lblMonedasTomadas = new JLabel("Monedas tomadas:");
		panel_2.add(lblMonedasTomadas, "cell 0 1,alignx trailing");
		
		txtCoins = new JTextField();
		txtCoins.setEditable(false);
		txtCoins.setText("0");
		panel_2.add(txtCoins, "cell 1 1,growx");
		txtCoins.setColumns(10);
		
		JLabel lblRubesTomados = new JLabel("Rubíes tomados:");
		panel_2.add(lblRubesTomados, "cell 2 1,alignx trailing");
		
		txtRubies = new JTextField();
		txtRubies.setEditable(false);
		txtRubies.setText("0");
		panel_2.add(txtRubies, "cell 3 1,growx");
		txtRubies.setColumns(10);
		
		JLabel lblAnillosTomados = new JLabel("Anillos tomados:");
		panel_2.add(lblAnillosTomados, "cell 0 2,alignx trailing");
		
		txtRings = new JTextField();
		txtRings.setEditable(false);
		txtRings.setText("0");
		panel_2.add(txtRings, "cell 1 2,growx");
		txtRings.setColumns(10);
		
		JLabel lblDiamantesTomados = new JLabel("Diamantes tomados:");
		panel_2.add(lblDiamantesTomados, "cell 2 2,alignx trailing");
		
		txtDiams = new JTextField();
		txtDiams.setEditable(false);
		txtDiams.setText("0");
		panel_2.add(txtDiams, "cell 3 2,growx");
		txtDiams.setColumns(10);
		
		JLabel lblColgantesTomados = new JLabel("Colgantes tomados:");
		panel_2.add(lblColgantesTomados, "cell 0 3,alignx trailing");
		
		txtNecks = new JTextField();
		txtNecks.setEditable(false);
		txtNecks.setText("0");
		panel_2.add(txtNecks, "cell 1 3,growx");
		txtNecks.setColumns(10);
		
		JLabel lblCapacidadRestante = new JLabel("Capacidad restante:");
		panel_2.add(lblCapacidadRestante, "cell 2 3,alignx trailing");
		
		txtContainer = new JTextField();
		txtContainer.setEditable(false);
		txtContainer.setText("0 de 450");
		panel_2.add(txtContainer, "cell 3 3,growx");
		txtContainer.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Datos del ambiente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ARAGAEY", null, null, null, null, null},
				{"ASE", null, null, null, null, null},
				{"BRESOL", null, null, null, null, null},
				{"BULOVOE", null, null, null, null, null},
				{"CABE", null, null, null, null, null},
				{"CENEDE", null, null, null, null, null},
				{"ERGINTONE", null, null, null, null, null},
				{"ICAEDUR", null, null, null, null, null},
				{"MIXOCU", null, null, null, null, null},
				{"PEREGAEY", null, null, null, null, null},
				{"VINIZAILE", null, null, null, null, null},
			},
			new String[] {
				"Ciudad", "Monedas", "Rubies", "Anillos", "Diamantes", "Colgantes"
			}
		));
		scrollPane.setViewportView(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		panel.add(toolBar, BorderLayout.NORTH);
		
		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("res/ui/next.png"));
		btnNext.setToolTipText("Realizar próxima acción.");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazManager.avanzar();
			}
		});
		
		tglbtnPlay = new JToggleButton("");
		tglbtnPlay.setIcon(new ImageIcon("res/ui/play.png"));
		tglbtnPlay.setToolTipText("Iniciar/Pausar ejecución.");
		tglbtnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfazManager.setAutoStep(tglbtnPlay.isSelected());
				if (tglbtnPlay.isSelected()) {
					btnNext.setEnabled(false);
					tglbtnPlay.setIcon(new ImageIcon("res/ui/pause.png"));
				} else {
					btnNext.setEnabled(true);
					tglbtnPlay.setIcon(new ImageIcon("res/ui/play.png"));
				}
			}
		});
		toolBar.add(tglbtnPlay);
		toolBar.add(btnNext);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		JButton btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon("res/ui/new.png"));
		btnNew.setToolTipText("Comenzar nuevo escenario.");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(frame,
						"¿Está seguro de iniciar una nueva simulación? Se perderá el escenario actual.",
						"Advertencia", dialogButton);
				if(dialogResult==JOptionPane.YES_OPTION)
					InterfazManager.mostrarConfigurador();
			}
		});
		toolBar.add(btnNew);
		
		lblEscenario = new JLabel("");
		toolBar.add(lblEscenario);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
//		mapa = new JMapPane();
//		panel_1.add(mapa, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Acciones realizadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
//		logPanel = new JLogPane();
//		panel_5.add(logPanel, BorderLayout.CENTER);
	}
	
	public void actualizarDatos(int dist, int botin, double cont) {
		txtDist.setText(""+dist);
		txtBotin.setText(""+botin);
		DecimalFormat df = new DecimalFormat("#.00");
		txtContainer.setText(""+df.format(cont)+" de 450");
	}
	
	public void actualizarInventario(int[] botin) {
//		txtCoins.setText(""+botin[Tesoro.MONEDA]);
//		txtRubies.setText(""+botin[Tesoro.RUBI]);
//		txtRings.setText(""+botin[Tesoro.ANILLO]);
//		txtDiams.setText(""+botin[Tesoro.DIAMANTE]);
//		txtNecks.setText(""+botin[Tesoro.COLGANTE]);
	}
	
	public void actualizarIsla(int[][] tesoros) {
		for (int i=0; i<11; i++)
			for (int j=0; j<tesoros[i].length; j++)
				table.getModel().setValueAt(tesoros[i][j], i, j+1);
	}
	
	public void terminar() {
		btnNext.setEnabled(false);
		tglbtnPlay.setEnabled(false);
		tglbtnPlay.setSelected(false);
		tglbtnPlay.setIcon(new ImageIcon("res/ui/play.png"));
	}
	
	public void cerrar() {
		frame.setVisible(false);
		frame.dispose();
	}

}
