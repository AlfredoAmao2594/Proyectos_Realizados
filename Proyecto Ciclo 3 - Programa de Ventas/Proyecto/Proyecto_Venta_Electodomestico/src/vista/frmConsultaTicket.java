package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionEstado;
import mantenimientos.GestionTicket;
import model.Estado;
import model.Ticket;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import utils.MySQLConexion;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class frmConsultaTicket extends JInternalFrame {
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	
	private DefaultTableModel modelo;
	
	GestionEstado gestionEstado = new GestionEstado(); 
	GestionTicket gestionTicket = new GestionTicket();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaTicket frame = new frmConsultaTicket();
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
	public frmConsultaTicket() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Reporte de Ticket");
		setBounds(100, 100, 578, 321);
		getContentPane().setLayout(null);
		
		lblEstado = new JLabel("ESTADO :");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(26, 37, 105, 14);
		getContentPane().add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCboEstado(e);
			}
		});
		cboEstado.setBounds(161, 34, 198, 22);
		getContentPane().add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 542, 193);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Numero");
		modelo.addColumn("Fecha");
		modelo.addColumn("ID Producto");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Precio");
		modelo.addColumn("ID Vendedor");
		modelo.addColumn("Cantidad");
		
		tblTabla.setModel(modelo);
		
		llenarCombo();

	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar(ArrayList<Ticket> listaTicket){
		modelo.setRowCount(0);
		
		for (int i=0; i<listaTicket.size(); i++) {
			
			Object[] fila = {   listaTicket.get(i).getNumero_Ticket(),
								listaTicket.get(i).getFechaTick(),
								listaTicket.get(i).getId_producto(),
								listaTicket.get(i).getDetalle_producto(),
								listaTicket.get(i).getPrecio(),
								listaTicket.get(i).getId_vendedor(),
								listaTicket.get(i).getCantidad()
							};
			System.out.println("ver"+i);
			//Agregamos la fila creada con datos al Jtable 
			modelo.addRow(fila);
		}
	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	void llenarCombo(){
		ArrayList<Estado> lista=gestionEstado.listarEstado();

		cboEstado .addItem(new Estado(0,"Seleccione la Estado"));		
		for (Estado objEst : lista) { 
			cboEstado.addItem( new Estado (objEst.getCodEstado(),objEst.getDesEstado()) );
		}
	}

	protected void actionPerformedCboEstado(ActionEvent e) {
		 Estado objEstado = (Estado) cboEstado.getSelectedItem();
	     System.out.println(objEstado.getCodEstado()+ " : " + objEstado.getDesEstado());
				
		ArrayList<Ticket> listaLibros= gestionTicket.listarTicketPorEstado(objEstado.getCodEstado());
		listar(listaLibros);
	}
}
