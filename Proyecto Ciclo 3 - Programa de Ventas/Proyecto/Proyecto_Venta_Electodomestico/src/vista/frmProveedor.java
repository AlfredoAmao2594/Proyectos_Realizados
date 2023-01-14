package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionProveedor;
import model.Cliente;
import model.Proveedor;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmProveedor extends JInternalFrame {
	private JLabel lblID;
	private JLabel lblRazon;
	private JLabel lblDireccion;
	private JTextField txtID;
	private JTextField txtRazon;
	private JTextField txtDireccion;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JButton btnEliminar;
	private JButton btnNewButton;
	
	private DefaultTableModel modelo;
	
	GestionProveedor gestionProveedor = new GestionProveedor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					frmProveedor frame = new frmProveedor();
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
	public frmProveedor() {
		setMaximizable(true);
		setClosable(true);
		setTitle("Proveedor");
		setBounds(100, 100, 582, 407);
		getContentPane().setLayout(null);
		
		lblID = new JLabel("ID de Proveedor :");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblID.setBounds(23, 23, 112, 14);
		getContentPane().add(lblID);
		
		lblRazon = new JLabel("Razon Social :");
		lblRazon.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRazon.setBounds(23, 48, 112, 14);
		getContentPane().add(lblRazon);
		
		lblDireccion = new JLabel("Direccion :");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(23, 73, 112, 14);
		getContentPane().add(lblDireccion);
		
		txtID = new JTextField();
		txtID.setBounds(145, 20, 226, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtRazon = new JTextField();
		txtRazon.setColumns(10);
		txtRazon.setBounds(145, 45, 226, 20);
		getContentPane().add(txtRazon);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(145, 70, 226, 20);
		getContentPane().add(txtDireccion);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(381, 19, 117, 31);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizar(e);
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(381, 60, 117, 31);
		getContentPane().add(btnActualizar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 173, 533, 193);
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
		modelo.addColumn("Razon Social");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Correo");
		
		tblTabla.setModel(modelo);
		
		lblTelefono = new JLabel("Telefono :");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(23, 104, 112, 14);
		getContentPane().add(lblTelefono);
		
		lblCorreo = new JLabel("Correo :");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreo.setBounds(23, 132, 112, 14);
		getContentPane().add(lblCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(145, 101, 226, 20);
		getContentPane().add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(145, 129, 226, 20);
		getContentPane().add(txtCorreo);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(381, 100, 117, 31);
		getContentPane().add(btnEliminar);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		btnNewButton.setBounds(508, 23, 33, 54);
		getContentPane().add(btnNewButton);
		
		listar();

	}
	
	void limpiarCajas(){
		txtID.setText("");
		txtRazon.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
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
		ArrayList<Proveedor> listaProveedor= gestionProveedor.listarProveedor(); 
		for (int i=0; i<listaProveedor.size(); i++) {
			Object[] fila = {   listaProveedor.get(i).getId_provedor(),
								listaProveedor.get(i).getRazon_social(),
								listaProveedor.get(i).getDireccion(),
								listaProveedor.get(i).getTelefono(),
								listaProveedor.get(i).getCorreo(),
													
			};
			System.out.println("ver"+i);
			modelo.addRow(fila);
		}
	}
	
	void navegar(){
		int fila=tblTabla.getSelectedRow();
		txtID.setText("" +tblTabla.getValueAt(fila, 0));
		txtRazon.setText("" +tblTabla.getValueAt(fila, 1));
		txtDireccion.setText(""+tblTabla.getValueAt(fila, 2));
		txtTelefono.setText(""+tblTabla.getValueAt(fila, 3));
		txtCorreo.setText(""+tblTabla.getValueAt(fila,4));
	}
	
	long leerCodigo() {
		return Long.parseLong(txtID.getText());
	}
	
	String leerRazon() {
		return txtRazon.getText();
	}
	
	String leerDireccion() {
		return txtDireccion.getText();
	}
	
	String leerCorreo() {
		return txtCorreo.getText();
	}
	
	String leerTelefono() {
		return txtTelefono.getText();
	}
	protected void mouseClickedTblTabla(MouseEvent e) {
		navegar();
	}
	protected void keyReleasedTblTabla(KeyEvent e) {
		navegar();
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
		limpiarCajas();
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
		Proveedor objProveedor = new Proveedor();
		objProveedor.setId_provedor(leerCodigo());
		objProveedor.setRazon_social(leerRazon());
		objProveedor.setDireccion(leerDireccion());
		objProveedor.setTelefono(leerTelefono());
		objProveedor.setCorreo(leerCorreo());
		
		int resultado=gestionProveedor.registrarProveedor(objProveedor);
		if (resultado==0){
	    	mensaje("Ocurrio algo inesperado");
	    }else{
	    	listar();
	    	limpiarCajas();
	    	mensaje("Información registrada con éxito");
	    }
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		
		Proveedor objProveedor = new Proveedor();
		
		objProveedor.setId_provedor(leerCodigo());
		objProveedor.setRazon_social(leerRazon());
		objProveedor.setDireccion(leerDireccion());
		objProveedor.setTelefono(leerTelefono());
		objProveedor.setCorreo(leerCorreo());
			
			int resultado=gestionProveedor.actualizarProveedor(objProveedor);
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
		 
			int resultado=gestionProveedor.eliminarProveedor(leerCodigo());
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	limpiarCajas();
		    	mensaje("Información eliminada con éxito");
		    }			
		}	
	}
}
