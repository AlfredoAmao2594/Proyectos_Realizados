package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionProveedor;
import model.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmBuscarProveedor extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRazon;
	private DefaultTableModel modelo;
	
	public long codProveedor;
	GestionProveedor gestionProveedor = new GestionProveedor();
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmBuscarProveedor dialog = new frmBuscarProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmBuscarProveedor() {
		setTitle("Buscar Proveedor");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRazon = new JLabel("Razon Social :");
			lblRazon.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblRazon.setBounds(22, 31, 77, 14);
			contentPanel.add(lblRazon);
		}
		{
			txtRazon = new JTextField();
			txtRazon.setBounds(133, 28, 165, 20);
			contentPanel.add(txtRazon);
			txtRazon.setColumns(10);
		}
		{
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBuscar(e);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnBuscar.setBounds(322, 27, 89, 23);
			contentPanel.add(btnBuscar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(22, 67, 402, 150);
			contentPanel.add(scrollPane);
			
			tblTabla = new JTable();
			scrollPane.setViewportView(tblTabla);
			
			modelo = new DefaultTableModel();
			modelo.addColumn("id_proveedor");
			modelo.addColumn("Detalle");
			modelo.addColumn("Marca");
			modelo.addColumn("Telefono"); 
			modelo.addColumn("Correo");
			tblTabla.setModel(modelo);
		}
		{
			JPanel buttonPane = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
			buttonPane.setLayout(fl_buttonPane);
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
	
	void listar(Proveedor busProveedor) {
		modelo.setRowCount(0);
		ArrayList<Proveedor> listaProveedor= gestionProveedor.buscarProveedorPorFiltro(busProveedor); 
		for (int i=0; i<listaProveedor.size(); i++) {
			Object[] fila = {   listaProveedor.get(i).getId_provedor(),
								listaProveedor.get(i).getRazon_social(),
								listaProveedor.get(i).getDireccion(),
								listaProveedor.get(i).getTelefono(),
								listaProveedor.get(i).getCorreo(),
													
			};
			modelo.addRow(fila);
		}
	}
	
	String leerRazon() {
		return txtRazon.getText();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		Proveedor objBusProveedor= new Proveedor();
		objBusProveedor.setRazon_social(leerRazon());
	
		listar(objBusProveedor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	protected void actionPerformedOkButton(ActionEvent e) {
		
		if (tblTabla.getRowCount()>0){ 
			
			int filaSeleccionada= tblTabla.getSelectedRow();
			if (filaSeleccionada==-1){
				mensaje("Debe de selecionar un registro");
			}else{
				codProveedor= (long)tblTabla.getValueAt(filaSeleccionada, 0) ;
				this.dispose();
			}
			
		}  else{
			mensaje("No hay filas para seleccionar");
		}
	}
	protected void actionPerformedCancelButton(ActionEvent e) {
		this.dispose();
	}
}
