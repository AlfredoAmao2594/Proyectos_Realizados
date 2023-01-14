package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionUsuario;
import model.TipoComprobantePago;
import model.Usuario;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmUsuario extends JInternalFrame {
	private JLabel lblIDUsuario;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDniDeVendedor;
	private JTextField txtUsuario;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JButton btnRegistra;
	private JButton btnActualizar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	
	//variable global
	GestionUsuario gestion = new GestionUsuario();
	private JButton btnLimpiar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUsuario frame = new frmUsuario();
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
	public frmUsuario() {
		setMaximizable(true);
		setClosable(true);
		setTitle("Usuario");
		setBounds(100, 100, 488, 359);
		getContentPane().setLayout(null);
		
		lblIDUsuario = new JLabel("Id del Usuario :");
		lblIDUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIDUsuario.setBounds(10, 21, 88, 14);
		getContentPane().add(lblIDUsuario);
		
		lblNombre = new JLabel("Nombres :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 46, 88, 14);
		getContentPane().add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(10, 71, 88, 14);
		getContentPane().add(lblApellidos);
		
		lblDniDeVendedor = new JLabel("DNI de Vendedor :");
		lblDniDeVendedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDniDeVendedor.setBounds(10, 96, 125, 14);
		getContentPane().add(lblDniDeVendedor);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(124, 18, 107, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(124, 43, 228, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(124, 68, 228, 20);
		getContentPane().add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(124, 93, 228, 20);
		getContentPane().add(txtDni);
		
		btnRegistra = new JButton("REGISTRAR");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistra(e);
			}
		});
		btnRegistra.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistra.setBounds(355, 17, 107, 23);
		getContentPane().add(btnRegistra);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizar(e);
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(355, 46, 107, 23);
		getContentPane().add(btnActualizar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 452, 190);
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
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo de Usuario");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("DNI");
		tblTabla.setModel(modelo);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		btnLimpiar.setBounds(380, 78, 57, 39);
		getContentPane().add(btnLimpiar);
		
		listar();
		
	}
	
	void limpiarCajas(){
		txtUsuario.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtUsuario.requestFocus();
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar() {
		modelo.setRowCount(0);
		ArrayList<Usuario> listaUsuario= gestion.listarUsuario(); 
		for (int i=0; i<listaUsuario.size(); i++) {
			Object[] fila = {   listaUsuario.get(i).getId_vendedor(),
								listaUsuario.get(i).getNombre(),
								listaUsuario.get(i).getApellido(),
								listaUsuario.get(i).getDni()

			};
			System.out.println("ver"+i);
			modelo.addRow(fila);
		}
	}
	
	void navegar(){
		int fila=tblTabla.getSelectedRow();
		txtUsuario.setText("" +tblTabla.getValueAt(fila, 0));
		txtNombres.setText("" +tblTabla.getValueAt(fila, 1));
		txtApellidos.setText(""+tblTabla.getValueAt(fila, 2));
		txtDni.setText(""+tblTabla.getValueAt(fila, 3));
	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	String leerCodigo() {
		return txtUsuario.getText();
	}

	String leerNombres() {
		return txtNombres.getText();
	}
	
	String leerApellidos() {
		return txtApellidos.getText();
	}
	
	String leerDni() {
		return txtDni.getText();
	}
	
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarCajas();
	}
	protected void actionPerformedBtnRegistra(ActionEvent e) {
		
		Usuario objUsuario = new Usuario();
		objUsuario.setId_vendedor(leerCodigo());
		objUsuario.setNombre(leerNombres());
		objUsuario.setApellido(leerApellidos());
		objUsuario.setDni(leerDni());
		
		int resultado=gestion.registrarUsuario(objUsuario);
		if (resultado==0){
	    	mensaje("Ocurrio algo inesperado");
	    }else{
	    	listar();
	    	limpiarCajas();
	    	mensaje("Información registrada con éxito");
	    }
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		
		Usuario objUsuario = new Usuario();
		
		objUsuario.setId_vendedor(leerCodigo());
		objUsuario.setNombre(leerNombres());
		objUsuario.setApellido(leerApellidos());
		objUsuario.setDni(leerDni());
			
			int resultado=gestion.actualizarUsuario(objUsuario);
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
