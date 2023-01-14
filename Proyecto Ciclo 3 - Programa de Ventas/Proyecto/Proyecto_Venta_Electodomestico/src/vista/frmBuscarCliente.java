package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCliente;
import model.Cliente;
import model.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBuscarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	
	public long codCliente;
	GestionCliente gestionCliente = new GestionCliente();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmBuscarCliente dialog = new frmBuscarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmBuscarCliente() {
		setTitle("Buscar Cliente");
		setBounds(100, 100, 492, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel(" Nombre de Cliente :");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setBounds(10, 34, 120, 14);
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(152, 31, 226, 20);
			contentPanel.add(txtNombre);
		}
		{
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBuscar(e);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBuscar.setBounds(389, 29, 77, 23);
			contentPanel.add(btnBuscar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 70, 456, 154);
			contentPanel.add(scrollPane);
			
			tblTabla = new JTable();
			scrollPane.setViewportView(tblTabla);
			
			modelo = new DefaultTableModel();
			modelo.addColumn("ID Cliente");
			modelo.addColumn("Nombre");
			modelo.addColumn("Direccion");
			modelo.addColumn("Telefeono");
			tblTabla.setModel(modelo);
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
	
	void listar(Cliente busCliente) {
		modelo.setRowCount(0);
		ArrayList<Cliente>listaCliente = gestionCliente.buscarClientePorFiltro(busCliente);
		for (int i = 0; i<listaCliente.size();i++) {
			Object[] fila = { listaCliente.get(i).getId_cliente(),
					listaCliente.get(i).getNombre_cliente(),
					listaCliente.get(i).getDireccion_cliente(),
					listaCliente.get(i).getTelefono(),
					
			};		
			modelo.addRow(fila);
		}
	}
	
	
	String leerNombre() {
		return txtNombre.getText();
	}
	protected void actionPerformedCancelButton(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedOkButton(ActionEvent e) {
		
		if (tblTabla.getRowCount()>0){ 
			
			int filaSeleccionada= tblTabla.getSelectedRow();
			if (filaSeleccionada==-1){
				mensaje("Debe de selecionar un registro");
			}else{
				codCliente= (long)tblTabla.getValueAt(filaSeleccionada, 0) ;
				this.dispose();
			}
			
		}  else{
			mensaje("No hay filas para seleccionar");
		}
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		Cliente objBusCliente= new Cliente();
	
		objBusCliente.setNombre_cliente(leerNombre());
	
		listar(objBusCliente);
	}
}
