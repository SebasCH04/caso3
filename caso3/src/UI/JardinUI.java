package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.JardinControlador;
import caso3.Jardin;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class JardinUI extends JFrame {

	private JPanel contentPane;
	private JTextField NombreJardinTXT;
	public JardinControlador jardinControlador = new JardinControlador();
	Jardin NuevoJardin;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JardinUI frame = new JardinUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JardinUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 212, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		NombreJardinTXT = new JTextField();
		NombreJardinTXT.setBounds(46, 46, 105, 28);
		contentPane.add(NombreJardinTXT);
		NombreJardinTXT.setColumns(10);
		
		JLabel NombreJardin = new JLabel("Nombre Jardin");
		NombreJardin.setHorizontalAlignment(SwingConstants.CENTER);
		NombreJardin.setBounds(10, 14, 176, 21);
		contentPane.add(NombreJardin);
		
		JButton CrearJardin = new JButton("Crear Jardin");
		CrearJardin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoJardin = jardinControlador.crearJardin(NombreJardinTXT.getText());
		        new JardinAdministracionUI(NuevoJardin).setVisible(true);
		        new TiempoUI().setVisible(true);
			}
		});
		CrearJardin.setBounds(46, 96, 105, 28);
		contentPane.add(CrearJardin);
	}
}