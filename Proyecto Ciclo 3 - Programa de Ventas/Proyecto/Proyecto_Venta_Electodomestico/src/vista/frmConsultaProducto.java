package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionProducto;
import model.Producto;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmConsultaProducto extends JInternalFrame {
	private JLabel lblDetalle;
	private JLabel lblMarca;
	private JTextField txtDetalle;
	private JTextField txtMarca;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	
	
	private DefaultTableModel modelo;
	public int codProducto;
	
	GestionProducto gestionProducto = new GestionProducto();
	private JTable tblTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultaProducto frame = new frmConsultaProducto();
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
	public frmConsultaProducto() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Consultar Producto");
		setBounds(100, 100, 536, 343);
		getContentPane().setLayout(null);
		
		lblDetalle = new JLabel("Detalle de Producto :");
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDetalle.setBounds(30, 30, 127, 14);
		getContentPane().add(lblDetalle);
		
		lblMarca = new JLabel("Marca de Producto :");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMarca.setBounds(30, 65, 127, 14);
		getContentPane().add(lblMarca);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(179, 27, 222, 20);
		getContentPane().add(txtDetalle);
		txtDetalle.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(179, 62, 222, 20);
		getContentPane().add(txtMarca);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\buscar.png"));
		btnBuscar.setBounds(435, 30, 56, 41);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 500, 199);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Detalle");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");
		modelo.addColumn("id_proveedor");
		
		tblTabla.setModel(modelo);

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
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		Producto objBusProducto= new Producto();
		objBusProducto.setDetalle(leerDetalle());
		objBusProducto.setMarca(leerMarca());
	
		listar(objBusProducto);
	}
}
