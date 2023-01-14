package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import utils.MySQLConexion;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class frmReporteTicket extends JInternalFrame {
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmReporteTicket frame = new frmReporteTicket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmReporteTicket() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Reporte de Tickets");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("REPORTE DE TICKETS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(101, 11, 224, 34);
		getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("REPORTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setBounds(165, 56, 89, 34);
		getContentPane().add(btnNewButton);

	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		try {
			
			//Se establece la conexión
			Connection conexion = MySQLConexion.getConexion();
			//Se carga el reporte
			JasperReport reporte = JasperCompileManager.compileReport("src/reporte/reporteTicket.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
			//Se crea un visor
			JRViewer jv = new JRViewer(jasperPrint);
			//Se crea un JDialog
			JDialog jf = new JDialog();
			jf.getContentPane().add(jv);
			jf.validate();
			jf.setModal(true);
			jf.setSize(new Dimension(800, 600)); 
			jf.setLocationRelativeTo(null);  
			jf.setVisible(true);
			
		} catch (Exception e1) {
			System.out.print("mensaje" +e1.getMessage());
		}
	}
}
