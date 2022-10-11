package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.json.simple.parser.ParseException;

import caso3.Etapas;
import caso3.Jardin;
import caso3.Plantas;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class JardinAdministracionUI extends JFrame {

	private JPanel contentPane;
	private JTextField NombrePlantaTXT;
	private JTable table = new JTable();
	Jardin jardinGlobal = new Jardin();
	DefaultTableModel dtm = new DefaultTableModel(0, 0);
	DefaultTableModel dtmEtapas = new DefaultTableModel(0, 0);
	DefaultTableModel dtmEtapasPlanta = new DefaultTableModel(0, 0);
	private JTextField PlantaSeleccionadaTXT;
	private JTable table_1;
	private int plantaSeleccionada = 0;
	private JTable table_2;
	
	public JardinAdministracionUI(Jardin jardin) {
		
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane2 = new JScrollPane();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1178, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String header[] = new String[] { "Nombre", "Tamaño", "Salud",
	            "Meses", "Estado", "Agua", "Abono", "Sol", "URL"};
		dtm.setColumnIdentifiers(header);
		
		String header1[] = new String[] { "Nombre", "DuracionEnMeses", "CrecePorcentaje", "URL"};
		dtmEtapas.setColumnIdentifiers(header1);
		
		dtmEtapasPlanta.setColumnIdentifiers(header1);
		ImageIcon image = new ImageIcon("C:\\Users\\sebas\\eclipse-workspace\\caso3\\src\\assets\\almacigo");
		JLabel img_planta = new JLabel(image);
		
		table.setModel(dtm);
		scrollPane.setBounds(143, 69, 438, 635);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	plantaSeleccionada = table.getSelectedRow();
	        	if(plantaSeleccionada >= 0) {
	        		ImageIcon images = new ImageIcon(table.getValueAt(table.getSelectedRow(), 8).toString());
	        		img_planta.setIcon(images);
	        		 PlantaSeleccionadaTXT.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	        	}
	           
	        }
	    });
		
		JLabel NombreJardinTXT = new JLabel("");
		NombreJardinTXT.setFont(new Font("Tahoma", Font.BOLD, 20));
		NombreJardinTXT.setHorizontalAlignment(SwingConstants.CENTER);
		NombreJardinTXT.setBounds(10, 11, 1142, 25);
		contentPane.add(NombreJardinTXT);
		NombreJardinTXT.setText(jardin.getNombreJardin());
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 47, 123, 657);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton AgregarPlantaBTN = new JButton("Agregar Planta");
		AgregarPlantaBTN.setBounds(10, 70, 105, 23);
		panel.add(AgregarPlantaBTN);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(39, 11, 46, 14);
		panel.add(lblNewLabel);
		
		NombrePlantaTXT = new JTextField();
		NombrePlantaTXT.setBounds(10, 36, 105, 23);
		panel.add(NombrePlantaTXT);
		NombrePlantaTXT.setColumns(10);
		
		JLabel PlantaSeleccionadaLBL = new JLabel("Planta Seleccionada:");
		PlantaSeleccionadaLBL.setFont(new Font("Tahoma", Font.BOLD, 10));
		PlantaSeleccionadaLBL.setHorizontalAlignment(SwingConstants.CENTER);
		PlantaSeleccionadaLBL.setBounds(0, 355, 123, 23);
		panel.add(PlantaSeleccionadaLBL);
		
		PlantaSeleccionadaTXT = new JTextField();
		PlantaSeleccionadaTXT.setHorizontalAlignment(SwingConstants.CENTER);
		PlantaSeleccionadaTXT.setBounds(10, 389, 105, 23);
		panel.add(PlantaSeleccionadaTXT);
		PlantaSeleccionadaTXT.setColumns(10);
		
		JButton btnCicloVida = new JButton("Ciclo Vida");
		btnCicloVida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarTablaEtapas();
				ActualizarEtapasPlanta();
			}
			
		});
		btnCicloVida.setBounds(10, 423, 103, 21);
		panel.add(btnCicloVida);
		
		
		
		img_planta.setBounds(0, 502, 123, 88);
		
		panel.add(img_planta);
		
		JButton btnRegar = new JButton("Regar");
		btnRegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jardin.RegarPlantas();
				jardinGlobal = jardin;
				ActualizarTabla();
			}
		});
		
		btnRegar.setBounds(10, 182, 103, 23);
		panel.add(btnRegar);
		
		JButton btnAbonarPlantas = new JButton("Abonar");
		btnAbonarPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jardin.AbonarPlantas();
				jardinGlobal = jardin;
				ActualizarTabla();
			}
		});
		btnAbonarPlantas.setBounds(10, 217, 103, 23);
		panel.add(btnAbonarPlantas);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActualizarTabla();
			}
		});
		btnActualizar.setBounds(10, 255, 105, 23);
		panel.add(btnActualizar);
		
		table_1 = new JTable();
		table_1.setBounds(637, 69, 471, 123);
		table_1.setModel(dtmEtapas);
		scrollPane2.setBounds(637, 69, 471, 141);
		scrollPane2.setViewportView(table_1);
		contentPane.add(scrollPane2);
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	if(table_1.getSelectedRow() >= 0) {
	        		boolean encontrada = false;
		        	String nombre = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
		        	String URL = table_1.getValueAt(table_1.getSelectedRow(), 3).toString();
		        	
	        		for(int i = 0; i < jardin.Plantas.get(plantaSeleccionada).getCicloVida().size(); i++) {
	        			if(jardin.Plantas.get(plantaSeleccionada).getCicloVida().get(i).getNombre() == nombre) {
	        				encontrada = true;
	        			}
	        		}
	        		
	        		if(!encontrada) {
	        			Etapas nuevaEtapa = new Etapas();
			        	nuevaEtapa.setNombre(nombre);
			        	nuevaEtapa.setURL(URL);
			        	jardin.Plantas.get(plantaSeleccionada).agregaEtapa(nuevaEtapa);
			        	jardinGlobal = jardin;
			        	ActualizarEtapasPlanta();
	        		}
	        		
	        	}
	        	
	        }
	    });
		
		table_2 = new JTable();
		table_2.setBounds(637, 257, 471, 141);
		table_2.setModel(dtmEtapasPlanta);
		contentPane.add(table_2);
		
		JLabel lblNewLabel_1 = new JLabel("Ciclos de vida");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(637, 46, 123, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lista de Plantas");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(143, 46, 123, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ciclos de Vida de la Planta Seleccionada");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(637, 232, 471, 14);
		contentPane.add(lblNewLabel_2);
		
		
		AgregarPlantaBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plantas nuevaPlanta = new Plantas(NombrePlantaTXT.getText());
				jardin.AgregarPlanta(nuevaPlanta);
				jardinGlobal = jardin;
				ActualizarTabla();
				jardin.ControlTiempo();
			}
		});
	}
	
	
	public void ActualizarTabla() {
		dtm.setRowCount(0);
		for (int i = 0; i < jardinGlobal.Plantas.size(); i++) {
			dtm.addRow(new Object[] { jardinGlobal.Plantas.get(i).getNombre(), jardinGlobal.Plantas.get(i).getEtapaActual().getNombre(), jardinGlobal.Plantas.get(i).getSalud(),
					jardinGlobal.Plantas.get(i).getEdad(), jardinGlobal.Plantas.get(i).getEstado(), jardinGlobal.Plantas.get(i).getPorcentajeAgua(),
					jardinGlobal.Plantas.get(i).getPorcentajeAbono(), jardinGlobal.Plantas.get(i).getPorcentajeSol(), jardinGlobal.Plantas.get(i).getEtapaActual().getURL()});
		}
	}
	
	public void ActualizarEtapasPlanta() {
		dtmEtapasPlanta.setRowCount(0);
		ArrayList<Etapas> CicloPlanta = jardinGlobal.Plantas.get(plantaSeleccionada).getCicloVida();
		for (int i = 0; i < CicloPlanta.size(); i++) {
			dtmEtapasPlanta.addRow(new Object[] { CicloPlanta.get(i).getNombre(), CicloPlanta.get(i).getDuracionMeses(), CicloPlanta.get(i).getCrecePorcentaje(),
					CicloPlanta.get(i).getURL()});
		}
	}
	
	public void ActualizarTablaEtapas() {
		dtmEtapas.setRowCount(0);
		Etapas etapas = new Etapas();
		ArrayList<Etapas> etapasList = etapas.leerCilosVida();
		for (int i = 0; i < etapasList.size(); i++) {
			dtmEtapas.addRow(new Object[] { etapasList.get(i).getNombre(), etapasList.get(i).getDuracionMeses(), etapasList.get(i).getCrecePorcentaje(),
					etapasList.get(i).getURL()});
		}
	}
}
