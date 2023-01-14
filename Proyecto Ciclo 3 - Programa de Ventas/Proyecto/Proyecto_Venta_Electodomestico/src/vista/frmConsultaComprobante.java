package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionTicket;
import mantenimientos.GestionVenta;
import model.ComprobantePagoCab;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConsultaComprobante extends JInternalFrame {
	private JPanel panel;
	private JLabel lblTitulo;
	private JLabel lblNumero;
	private JLabel lblFechaDeFactura;
	private JTextField txtNumero;
	private JTextField txtFecha;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	
	private DefaultTableModel modelo;
	public int numCompPagoCab;
	
	GestionVenta gestionVenta = new GestionVenta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaComprobante frame = new frmConsultaComprobante();
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
	public frmConsultaComprobante() {
		setTitle("Consultar Comprobante");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 551, 349);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(10, 11, 515, 42);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTitulo = new JLabel("CONSULTAR COMPROBANTE");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 515, 42);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel.add(lblTitulo);
		
		lblNumero = new JLabel("Numero de Factura :");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumero.setBounds(10, 78, 140, 14);
		getContentPane().add(lblNumero);
		
		lblFechaDeFactura = new JLabel("Fecha de Factura :");
		lblFechaDeFactura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaDeFactura.setBounds(10, 103, 140, 14);
		getContentPane().add(lblFechaDeFactura);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(160, 76, 235, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(160, 101, 235, 20);
		getContentPane().add(txtFecha);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\buscar.png"));
		btnBuscar.setBounds(405, 75, 120, 42);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 515, 168);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Numero");
		modelo.addColumn("Fecha");
		modelo.addColumn("Codigo Comp");
		modelo.addColumn("Id Cliente");
		modelo.addColumn("Base Imponible");
		modelo.addColumn("IGV");
		modelo.addColumn("Total");
		
		tblTabla.setModel(modelo);

	}
	
	void listar(ComprobantePagoCab busFactura) {
		modelo.setRowCount(0);
		ArrayList<ComprobantePagoCab>listaFactura = gestionVenta.buscarComprobantePorFiltro(busFactura);
		for(int i=0; i<listaFactura.size();i++){
			Object[] fila = {
					listaFactura.get(i).getNumeroFactura(),
					listaFactura.get(i).getFechaFact(),
					listaFactura.get(i).getCodigo_comp(),
					listaFactura.get(i).getIdCliente(),
					listaFactura.get(i).getBaseImponible(),
					listaFactura.get(i).getIgv(),
					listaFactura.get(i).getTotalCompro(),
			};
			modelo.addRow(fila);
		}
	}
	
	String leerNumero() {
		return txtNumero.getText();
	}
	
	String leerFecha() {
		return txtFecha.getText();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		ComprobantePagoCab comprobante = new ComprobantePagoCab();
		
		comprobante.setNumeroFactura(leerNumero());
		comprobante.setFechaFact(leerFecha());
		
		listar(comprobante);
	}
}
