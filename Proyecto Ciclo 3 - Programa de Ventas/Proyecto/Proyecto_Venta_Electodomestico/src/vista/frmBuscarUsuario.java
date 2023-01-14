package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionUsuario;
import model.Producto;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmBuscarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtVendedor;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTable tblTabla;
	
	private DefaultTableModel modelo;
	
	public String codUsuario;
	
	GestionUsuario gestionUsuario = new GestionUsuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmBuscarUsuario dialog = new frmBuscarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmBuscarUsuario() {
		setTitle("Buscar Usuario");
		setBounds(100, 100, 510, 349);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("ID Vendedor :");
			lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblId.setBounds(21, 23, 87, 14);
			contentPanel.add(lblId);
		}
		{
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setBounds(21, 48, 87, 14);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblApellido = new JLabel("Apellido :");
			lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblApellido.setBounds(21, 73, 87, 14);
			contentPanel.add(lblApellido);
		}
		{
			txtVendedor = new JTextField();
			txtVendedor.setBounds(118, 20, 250, 20);
			contentPanel.add(txtVendedor);
			txtVendedor.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(118, 45, 250, 20);
			contentPanel.add(txtNombre);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(118, 70, 250, 20);
			contentPanel.add(txtApellido);
		}
		{
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBuscar(e);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnBuscar.setBounds(395, 44, 89, 23);
			contentPanel.add(btnBuscar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 107, 474, 159);
			contentPanel.add(scrollPane);
			{
				tblTabla = new JTable();
				scrollPane.setViewportView(tblTabla);
				
				modelo = new DefaultTableModel();
				modelo.addColumn("id_Usuario");
				modelo.addColumn("Nombres");
				modelo.addColumn("Apellidos");
				modelo.addColumn("DNI"); 
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
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar(Usuario busUsuario) {
		modelo.setRowCount(0);
		ArrayList<Usuario> listaUsuario= gestionUsuario.buscarUsuarioPorFiltro(busUsuario); 
		for (int i=0; i<listaUsuario.size(); i++) {
			Object[] fila = {   listaUsuario.get(i).getId_vendedor(),
								listaUsuario.get(i).getNombre(),
								listaUsuario.get(i).getApellido(),
								listaUsuario.get(i).getDni(),
													
			};
			modelo.addRow(fila);
		}
	}
	
	String leerId() {
		return txtVendedor.getText();
	}
	
	String leerNombre() {
		return txtNombre.getText();
	}
	
	String leerApellidos() {
		return txtApellido.getText();
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
				codUsuario= (String)tblTabla.getValueAt(filaSeleccionada, 0) ;
				this.dispose();
			}
			
		}  else{
			mensaje("No hay filas para seleccionar");
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		Usuario objBusUsuario= new Usuario();
		objBusUsuario.setId_vendedor(leerId());
		objBusUsuario.setNombre(leerNombre());
		objBusUsuario.setApellido(leerApellidos());
	
		listar(objBusUsuario);
	}
}
