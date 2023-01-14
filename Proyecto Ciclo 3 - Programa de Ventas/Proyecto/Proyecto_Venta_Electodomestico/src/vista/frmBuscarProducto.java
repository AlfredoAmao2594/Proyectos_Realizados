package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionProducto;
import model.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmBuscarProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDetalle;
	private JTextField txtMarca;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	
	public int codProducto;
	
	GestionProducto gestionProducto = new GestionProducto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmBuscarProducto dialog = new frmBuscarProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmBuscarProducto() {
		setTitle("Buscar Producto");
		setBounds(100, 100, 514, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDetalle = new JLabel("Detalle Producto:");
			lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblDetalle.setBounds(23, 22, 110, 14);
			contentPanel.add(lblDetalle);
		}
		{
			JLabel lblMarca = new JLabel("Marca de Producto:");
			lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblMarca.setBounds(23, 53, 138, 14);
			contentPanel.add(lblMarca);
		}
		{
			txtDetalle = new JTextField();
			txtDetalle.setBounds(175, 19, 171, 20);
			contentPanel.add(txtDetalle);
			txtDetalle.setColumns(10);
		}
		{
			txtMarca = new JTextField();
			txtMarca.setColumns(10);
			txtMarca.setBounds(175, 50, 171, 20);
			contentPanel.add(txtMarca);
		}
		{
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBuscar(e);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnBuscar.setBounds(375, 22, 89, 23);
			contentPanel.add(btnBuscar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 92, 478, 161);
			contentPanel.add(scrollPane);
			{
				tblTabla = new JTable();
				scrollPane.setViewportView(tblTabla);
				
				modelo = new DefaultTableModel();
				modelo.addColumn("id_producto");
				modelo.addColumn("Detalle");
				modelo.addColumn("Marca");
				modelo.addColumn("Precio"); 
				modelo.addColumn("Proveedor");
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
	
	void listar(Producto busProducto) {
		modelo.setRowCount(0);
		ArrayList<Producto> listaProduto= gestionProducto.buscarProductoPorFiltro(busProducto); 
		for (int i=0; i<listaProduto.size(); i++) {
			Object[] fila = {   listaProduto.get(i).getId_producto(),
								listaProduto.get(i).getDetalle(),
								listaProduto.get(i).getMarca(),
								listaProduto.get(i).getPrecio(),
								listaProduto.get(i).getId_proveedor(),
													
			};
			modelo.addRow(fila);
		}
	}
	
	String leerDetalle() {
		return txtDetalle.getText();
	}
	
	String leerMarca() {
		return txtMarca.getText();
	}

	protected void actionPerformedCancelButton(ActionEvent e) {
		this.dispose();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		Producto objBusProducto= new Producto();
		objBusProducto.setDetalle(leerDetalle());
		objBusProducto.setMarca(leerMarca());
	
		listar(objBusProducto);
	}
	protected void actionPerformedOkButton(ActionEvent e) {
		
		if (tblTabla.getRowCount()>0){ 
			
			int filaSeleccionada= tblTabla.getSelectedRow();
			if (filaSeleccionada==-1){
				mensaje("Debe de selecionar un registro");
			}else{
				codProducto= (int)tblTabla.getValueAt(filaSeleccionada, 0) ;
				this.dispose();
			}
			
		}  else{
			mensaje("No hay filas para seleccionar");
		}
	}
}
