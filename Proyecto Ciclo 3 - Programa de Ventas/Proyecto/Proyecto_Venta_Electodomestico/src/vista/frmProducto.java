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
import mantenimientos.GestionProveedor;
import model.Producto;
import model.Proveedor;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmProducto extends JInternalFrame {
	private JLabel lblIDProducto;
	private JLabel lblDetalle;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblIDProveedor;
	private JTextField txtID;
	private JTextField txtDetalle;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JTextField txtIDProveedor;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	
	private DefaultTableModel modelo;
	
	GestionProducto gestionProducto = new GestionProducto();
	GestionProveedor gestionProveedor = new GestionProveedor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProducto frame = new frmProducto();
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
	public frmProducto() {
		setMaximizable(true);
		setClosable(true);
		setTitle("PRODUCTO");
		setBounds(100, 100, 558, 397);
		getContentPane().setLayout(null);
		
		lblIDProducto = new JLabel("ID Producto :");
		lblIDProducto.setBounds(10, 25, 96, 14);
		lblIDProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblIDProducto);
		
		lblDetalle = new JLabel("Detalle de Producto :");
		lblDetalle.setBounds(10, 61, 128, 14);
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblDetalle);
		
		lblMarca = new JLabel("Marca de Producto :");
		lblMarca.setBounds(10, 93, 128, 14);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblMarca);
		
		lblPrecio = new JLabel("Precio de Producto :");
		lblPrecio.setBounds(10, 132, 128, 14);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblPrecio);
		
		lblIDProveedor = new JLabel("ID Proveedor :");
		lblIDProveedor.setBounds(277, 132, 128, 14);
		lblIDProveedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblIDProveedor);
		
		txtID = new JTextField();
		txtID.setBounds(158, 22, 129, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(158, 58, 361, 20);
		getContentPane().add(txtDetalle);
		txtDetalle.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(158, 90, 361, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(157, 129, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtIDProveedor = new JTextField();
		txtIDProveedor.setBounds(388, 129, 96, 20);
		getContentPane().add(txtIDProveedor);
		txtIDProveedor.setColumns(10);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setBounds(297, 11, 108, 33);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizar(e);
			}
		});
		btnActualizar.setBounds(411, 11, 108, 33);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnActualizar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 465, 189);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keyReleasedTblTabla(e);
			}
		});
		tblTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedTblTabla(e);
			}
		});
		scrollPane.setViewportView(tblTabla);
		tblTabla.setFillsViewportHeight(true);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Detalle");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");
		modelo.addColumn("id_proveedor");
		
		tblTabla.setModel(modelo);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\cancelar.png"));
		btnEliminar.setBounds(494, 185, 38, 59);
		getContentPane().add(btnEliminar);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\buscar.png"));
		btnBuscar.setBounds(494, 117, 38, 45);
		getContentPane().add(btnBuscar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		btnLimpiar.setBounds(494, 255, 38, 59);
		getContentPane().add(btnLimpiar);
		
		listar();

	}
	void limpiarCajas(){
		txtID.setText("");
		txtDetalle.setText("");
		txtMarca.setText("");
		txtPrecio.setText("");
		txtIDProveedor.setText("");
		txtID.requestFocus();
	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar() {
		modelo.setRowCount(0);
		ArrayList<Producto> listaProducto= gestionProducto.listarProducto(); 
		for (int i=0; i<listaProducto.size(); i++) {
			Object[] fila = {   listaProducto.get(i).getId_producto(),
								listaProducto.get(i).getDetalle(),
								listaProducto.get(i).getMarca(),
								listaProducto.get(i).getPrecio(),
								listaProducto.get(i).getId_proveedor(),
													
			};
			System.out.println("ver"+i);
			modelo.addRow(fila);
		}
	}
	
	void navegar(){
		int fila=tblTabla.getSelectedRow();
		txtID.setText("" +tblTabla.getValueAt(fila, 0));
		txtDetalle.setText("" +tblTabla.getValueAt(fila, 1));
		txtMarca.setText(""+tblTabla.getValueAt(fila, 2));
		txtPrecio.setText(""+tblTabla.getValueAt(fila, 3));
		txtIDProveedor.setText(""+tblTabla.getValueAt(fila,4));
	}
	
	int leerId() {
		return Integer.parseInt(txtID.getText());
	}
	
	String leerDetalle() {
		return txtDetalle.getText();
	}
	
	String leerMarca() {
		return txtMarca.getText();
	}
	
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
	long leerId_proveedor() {
		return Long.parseLong(txtIDProveedor.getText());
	}
	
	protected void mouseClickedTblTabla(MouseEvent e) {
		navegar();
	}
	protected void keyReleasedTblTabla(KeyEvent e) {
		navegar();
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarCajas();
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {		
		Producto objProducto = new Producto();
		objProducto.setId_producto(leerId());
		objProducto.setDetalle(leerDetalle());
		objProducto.setMarca(leerMarca());
		objProducto.setPrecio(leerPrecio());
		objProducto.setId_proveedor(leerId_proveedor());
		
		int resultado=gestionProducto.registrarProducto(objProducto);
		if (resultado==0){
	    	mensaje("Ocurrio algo inesperado");
	    }else{
	    	listar();
	    	limpiarCajas();
	    	mensaje("Información registrada con éxito");
	    }
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		
		Producto objProducto = new Producto();
		objProducto.setId_producto(leerId());
		objProducto.setDetalle(leerDetalle());
		objProducto.setMarca(leerMarca());
		objProducto.setPrecio(leerPrecio());
		objProducto.setId_proveedor(leerId_proveedor());
			
			int resultado=gestionProducto.actualizarProducto(objProducto);
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	mensaje("Información actualizada con éxito");
		    }
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int ok = confirmar("¿ Desea eliminar el registro ?");
		if (ok == 0) {
		 
			int resultado=gestionProducto.eliminarProducto(leerId());
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	limpiarCajas();
		    	mensaje("Información eliminada con éxito");
		    }			
		}	
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		
		frmBuscarProveedor d = new frmBuscarProveedor();
		d.setModal(true);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
		
		System.out.println("codCliente "+ d.codProveedor);
		
		if (d.codProveedor!=0){
			
			Proveedor objProveedor = gestionProveedor.obtenerProveedor(d.codProveedor);
			txtIDProveedor.setText(objProveedor.getId_provedor()+"");
			
		}
	}
}
