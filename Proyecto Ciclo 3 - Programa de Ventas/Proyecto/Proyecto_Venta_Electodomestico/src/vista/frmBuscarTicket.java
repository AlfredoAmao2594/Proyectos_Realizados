package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCliente;
import mantenimientos.GestionTicket;
import model.Cliente;
import model.Ticket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBuscarTicket extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumero;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	public String codTicket;
	GestionTicket gestionTicket = new GestionTicket();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmBuscarTicket dialog = new frmBuscarTicket();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmBuscarTicket() {
		setTitle("Buscar Ticket");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNumero = new JLabel("Numero de Ticket :");
			lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNumero.setBounds(10, 29, 123, 14);
			contentPanel.add(lblNumero);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setBounds(141, 27, 173, 20);
			contentPanel.add(txtNumero);
			txtNumero.setColumns(10);
		}
		{
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBuscar(e);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBuscar.setBounds(335, 26, 89, 23);
			contentPanel.add(btnBuscar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 66, 414, 151);
			contentPanel.add(scrollPane);
			{
				tblTabla = new JTable();
				scrollPane.setViewportView(tblTabla);
				
				modelo = new DefaultTableModel();
				modelo.addColumn("Numero");
				modelo.addColumn("Fecha");
				modelo.addColumn("ID Producto");
				modelo.addColumn("Detalle");
				modelo.addColumn("Precio");
				modelo.addColumn("Cantidad");
				tblTabla.setModel(modelo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedOkButton(e);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedCancelButton(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar(Ticket busTicket) {
		modelo.setRowCount(0);
		ArrayList<Ticket>listaTicket = gestionTicket.buscarTicketPorFiltro(busTicket);
		for (int i = 0; i<listaTicket.size();i++) {
			Object[] fila = { listaTicket.get(i).getNumero_Ticket(),
					listaTicket.get(i).getFechaTick(),
					listaTicket.get(i).getId_producto(),
					listaTicket.get(i).getDetalle_producto(),
					listaTicket.get(i).getPrecio(),
					listaTicket.get(i).getCantidad(),
					
			};		
			modelo.addRow(fila);
		}
	}
	
	String leerNumero() {
		return txtNumero.getText();
	}

	protected void actionPerformedCancelButton(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		Ticket objBusTicket= new Ticket();
		
		objBusTicket.setNumero_Ticket(leerNumero());
	
		listar(objBusTicket);
	}
	protected void actionPerformedOkButton(ActionEvent e) {
		
		if (tblTabla.getRowCount()>0){ 
			
		int filaSeleccionada= tblTabla.getSelectedRow();
		if (filaSeleccionada==-1){
				mensaje("Debe de selecionar un registro");
			}else{
				codTicket= (String)tblTabla.getValueAt(filaSeleccionada, 0) ;
				this.dispose();
			}
			
		}  else{
			mensaje("No hay filas para seleccionar");
		}
	}
}
