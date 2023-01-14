package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCliente;
import mantenimientos.GestionTipoDocumentoIdentidad;
import model.Cliente;
import model.TipoDocumentoIdentidad;
import model.Usuario;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmCliente extends JInternalFrame {
	private JLabel lblIDcliente;
	private JLabel lblTipoDoc;
	private JLabel lblDireccion;
	private JLabel lblNombre;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JComboBox cboTipo;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	
	private DefaultTableModel modelo;
	
	//VARIABLE GLOBAL
	GestionCliente gestionCliente = new GestionCliente();
	GestionTipoDocumentoIdentidad gestionTipo = new GestionTipoDocumentoIdentidad();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCliente frame = new frmCliente();
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
	public frmCliente() {
		setMaximizable(true);
		setClosable(true);
		setTitle("CLIENTE");
		setBounds(100, 100, 553, 393);
		getContentPane().setLayout(null);
		
		lblIDcliente = new JLabel("ID de Cliente :");
		lblIDcliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIDcliente.setBounds(22, 22, 134, 14);
		getContentPane().add(lblIDcliente);
		
		lblTipoDoc = new JLabel("Tipo de Documento ID :");
		lblTipoDoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDoc.setBounds(22, 47, 146, 14);
		getContentPane().add(lblTipoDoc);
		
		lblDireccion = new JLabel("Direccion :");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(22, 113, 90, 14);
		getContentPane().add(lblDireccion);
		
		lblNombre = new JLabel("Nombre o Razon Social :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(22, 82, 146, 14);
		getContentPane().add(lblNombre);
		
		txtID = new JTextField();
		txtID.setBounds(186, 19, 189, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(186, 76, 341, 20);
		getContentPane().add(txtNombre);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(186, 107, 341, 20);
		getContentPane().add(txtDireccion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 182, 392, 172);
		getContentPane().add(scrollPane);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(412, 22, 101, 35);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizar(e);
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnActualizar.setBounds(412, 182, 101, 35);
		getContentPane().add(btnActualizar);
		
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
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("TIPO_DOC");
		modelo.addColumn("Razon Social");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Correo");
		
		tblTabla.setModel(modelo);
		
		cboTipo = new JComboBox();
		cboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCboTipo(e);
			}
		});
		cboTipo.setBounds(186, 46, 189, 22);
		getContentPane().add(cboTipo);
		
		lblTelefono = new JLabel("Telefono :");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(22, 141, 90, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(122, 138, 134, 20);
		getContentPane().add(txtTelefono);
		
		lblCorreo = new JLabel("Correo :");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreo.setBounds(285, 141, 90, 14);
		getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(355, 138, 134, 20);
		getContentPane().add(txtCorreo);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\cancelar.png"));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEliminar.setBounds(436, 226, 53, 53);
		getContentPane().add(btnEliminar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLimpiar.setBounds(436, 290, 53, 53);
		getContentPane().add(btnLimpiar);
		
		llenarCombo();		
		listar();

	}
	void limpiarCajas(){
		txtID.setText("");
		cboTipo.setSelectedItem("");	
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtID.requestFocus();
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar() {
		modelo.setRowCount(0);
		ArrayList<Cliente> listaCliente= gestionCliente.listarClientes(); 
		for (int i=0; i<listaCliente.size(); i++) {
			Object[] fila = {   listaCliente.get(i).getId_cliente(),
								listaCliente.get(i).getCodigo_doc(),
								listaCliente.get(i).getNombre_cliente(),
								listaCliente.get(i).getDireccion_cliente(),
								listaCliente.get(i).getTelefono(),
								listaCliente.get(i).getCorreo()						
			};
			System.out.println("ver"+i);
			modelo.addRow(fila);
		}
	}
	
	void navegar(){
		int fila=tblTabla.getSelectedRow();
		txtID.setText("" +tblTabla.getValueAt(fila, 0));
		cboTipo.setSelectedItem("" +tblTabla.getValueAt(fila, 1));
		txtNombre.setText(""+tblTabla.getValueAt(fila,2));
		txtDireccion.setText(""+tblTabla.getValueAt(fila, 3));
		txtTelefono.setText(""+tblTabla.getValueAt(fila, 4));
		txtCorreo.setText(""+tblTabla.getValueAt(fila,5));
	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	long leerId() {
		return Long.parseLong(txtID.getText());
	}
	
	String leerNombre() {
		return txtNombre.getText();
	}
	
	String leerDireccion() {
		return txtDireccion.getText();
	}
	
	String leerCorreo() {
		return txtCorreo.getText();
	}
	
	String leerTelefono(){
		return txtTelefono.getText();
	}
	
	int tipoDocumento() {
		return cboTipo.getSelectedIndex();
	}
	
	
	void llenarCombo(){
		//Creamos la lista para obtener los registro de la tabla
		ArrayList<TipoDocumentoIdentidad> lista=gestionTipo.listarTipoDocumentoIdentidad();
		//Llenamos el comboBox cboTipo con los valores de la lista
		cboTipo.addItem(new TipoDocumentoIdentidad(0,""));	
		for (TipoDocumentoIdentidad objTip : lista) { 
			cboTipo.addItem( new TipoDocumentoIdentidad(objTip.getCodigo(),objTip.getDetalle()));
		}
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		Cliente objCliente = new Cliente();
		objCliente.setId_cliente(leerId());
		objCliente.setCodigo_doc(tipoDocumento());
		objCliente.setNombre_cliente(leerNombre());
		objCliente.setDireccion_cliente(leerDireccion());
		objCliente.setTelefono(leerTelefono());
		objCliente.setCorreo(leerCorreo());
		
		int resultado=gestionCliente.registrarCliente(objCliente);
		if (resultado==0){
	    	mensaje("Ocurrio algo inesperado");
	    }else{
	    	listar();
	    	limpiarCajas();
	    	mensaje("Información registrada con éxito");
	    }
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarCajas();
	}
	protected void actionPerformedCboTipo(ActionEvent e) {
		
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		int ok = confirmar("¿ Desea eliminar el registro ?");
		if (ok == 0) {
		 
			int resultado=gestionCliente.eliminarCliente(leerId());
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	limpiarCajas();
		    	mensaje("Información eliminada con éxito");
		    }			
		}	
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		
		Cliente objCliente = new Cliente();
		
		objCliente.setId_cliente(leerId());
		objCliente.setCodigo_doc(tipoDocumento());
		objCliente.setNombre_cliente(leerNombre());
		objCliente.setDireccion_cliente(leerDireccion());
		objCliente.setTelefono(leerTelefono());
		objCliente.setCorreo(leerCorreo());
			
			int resultado=gestionCliente.actualizarCliente(objCliente);
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	mensaje("Información actualizada con éxito");
		    }
	}
	protected void mouseClickedTblTabla(MouseEvent e) {
		navegar();
	}
	protected void keyReleasedTblTabla(KeyEvent e) {
		navegar();
	}
}
