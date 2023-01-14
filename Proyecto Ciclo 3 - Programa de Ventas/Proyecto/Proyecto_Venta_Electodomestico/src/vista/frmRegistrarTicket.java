package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import mantenimientos.GestionEstado;
import mantenimientos.GestionProducto;
import mantenimientos.GestionTicket;
import mantenimientos.GestionUsuario;
import model.Estado;
import model.Producto;
import model.Proveedor;
import model.Ticket;
import model.Usuario;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class frmRegistrarTicket extends JInternalFrame {
	private JLabel lblNumero;
	private JLabel lblFecha;
	private JLabel lblIdProducto;
	private JLabel lblDetalleDeProducto;
	private JLabel lblPrecio;
	private JLabel lblVendedor;
	private JLabel lblCantidad;
	private JTextField txtNumero;
	private JTextField txtFecha;
	private JTextField txtProducto;
	private JTextField txtPrecio;
	private JTextField txtDetalle;
	private JTextField txtVendedor;
	private JTextField txtCantidad;
	private JComboBox cboEstado;
	private JButton btnRegistrar;
	private JButton btnBuscarProducto;
	private JButton btnVendedor;
	private JButton btnLimpiar;
	
	GestionTicket gestionTicket = new GestionTicket();
	GestionUsuario gestionUsario = new GestionUsuario();
	GestionProducto gestionProducto = new GestionProducto();
	GestionEstado gestionEstado = new GestionEstado();
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistrarTicket frame = new frmRegistrarTicket();
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
	public frmRegistrarTicket() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		setTitle("Ticket");
		setBounds(100, 100, 678, 453);
		getContentPane().setLayout(null);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\registrar.png"));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(242, 378, 160, 34);
		getContentPane().add(btnRegistrar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 167, 615, 202);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(161, 153, 151, 20);
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(22, 156, 77, 14);
		panel.add(lblCantidad);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(346, 156, 52, 14);
		panel.add(lblEstado);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(430, 152, 151, 22);
		panel.add(cboEstado);
		
		lblVendedor = new JLabel("Vendedor :");
		lblVendedor.setBounds(22, 114, 77, 14);
		panel.add(lblVendedor);
		lblVendedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtVendedor = new JTextField();
		txtVendedor.setBounds(161, 111, 151, 20);
		panel.add(txtVendedor);
		txtVendedor.setColumns(10);
		
		btnVendedor = new JButton("Buscar Vendedor");
		btnVendedor.setBorderPainted(false);
		btnVendedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVendedor.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVendedor.setBounds(371, 104, 172, 34);
		panel.add(btnVendedor);
		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnVendedor(e);
			}
		});
		btnVendedor.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\buscar.png"));
		
		lblDetalleDeProducto = new JLabel("Detalle de Producto :");
		lblDetalleDeProducto.setBounds(22, 72, 141, 14);
		panel.add(lblDetalleDeProducto);
		lblDetalleDeProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(161, 69, 151, 20);
		panel.add(txtDetalle);
		txtDetalle.setColumns(10);
		
		lblIdProducto = new JLabel("ID de Producto :");
		lblIdProducto.setBounds(22, 30, 141, 14);
		panel.add(lblIdProducto);
		lblIdProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtProducto = new JTextField();
		txtProducto.setBounds(161, 27, 151, 20);
		panel.add(txtProducto);
		txtProducto.setColumns(10);
		
		lblPrecio = new JLabel("Precio :");
		lblPrecio.setBounds(346, 72, 62, 14);
		panel.add(lblPrecio);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(430, 69, 151, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.setBorderPainted(false);
		btnBuscarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscarProducto.setBounds(371, 20, 172, 34);
		panel.add(btnBuscarProducto);
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscarProducto(e);
			}
		});
		btnBuscarProducto.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\buscar.png"));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos Ticket", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(21, 100, 615, 56);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNumero = new JLabel("Numero de Ticket :");
		lblNumero.setBounds(10, 21, 141, 14);
		panel_1.add(lblNumero);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNumero = new JTextField();
		txtNumero.setBounds(149, 18, 151, 20);
		panel_1.add(txtNumero);
		txtNumero.setEditable(false);
		txtNumero.setColumns(10);
		
		lblFecha = new JLabel("Fecha de Ticket :");
		lblFecha.setBounds(310, 21, 141, 14);
		panel_1.add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtFecha = new JTextField();
		txtFecha.setBounds(434, 18, 151, 20);
		panel_1.add(txtFecha);
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		
		btnLimpiar = new JButton("");
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setBounds(568, 378, 62, 34);
		getContentPane().add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(58, 22, 530, 56);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblTitulo = new JLabel("TICKET");
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 15, 510, 21);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTitulo);
		
		inicializarDatosBoleta();
		llenarCombo();

	}
	
	void llenarCombo(){
		ArrayList<Estado> lista=gestionEstado.listarEstado();

		cboEstado .addItem(new Estado(0,"Seleccione la Estado"));		
		for (Estado objEst : lista) { 
			cboEstado.addItem( new Estado (objEst.getCodEstado(),objEst.getDesEstado()) );
		}
	}

	void limpiarCajas(){
		txtProducto.setText("");
		txtDetalle.setText("");
		txtPrecio.setText("");
		txtVendedor.setText("");
		txtCantidad.setText("");
		cboEstado.setSelectedIndex(0);
		txtProducto.requestFocus();
	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	int leerNumero() {
		return Integer.parseInt(txtNumero.getText());
	}
	
	String obtenerFecha() {
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	int leerIdProducto() {
		return Integer.parseInt(txtProducto.getText());
	}
	
	String leerDetalle() {
		return txtDetalle.getText();
	}
	
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
	String leerIdVendedor() {
		return txtVendedor.getText();
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarCajas();
	}
	protected void actionPerformedBtnBuscarProducto(ActionEvent e) {
		
		frmBuscarProducto d = new frmBuscarProducto();
		d.setModal(true);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
		
		System.out.println("codCliente "+ d.codProducto);
		
		if (d.codProducto!=0){
			
			Producto objProducto = gestionProducto.obtenerProducto(d.codProducto);
			txtProducto.setText(objProducto.getId_producto()+"");
			txtDetalle.setText(objProducto.getDetalle() +" ");
			txtPrecio.setText(objProducto.getPrecio() + "");
			
		}
	}
	protected void actionPerformedBtnVendedor(ActionEvent e) {
		
		frmBuscarUsuario d = new frmBuscarUsuario();
		d.setModal(true);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
		
		System.out.println("codUsuario "+ d.codUsuario);
		
		if (d.codUsuario!=""){
			
			Usuario objUsuario= gestionUsario.obtenerUsuario(d.codUsuario);
			txtVendedor.setText(objUsuario.getId_vendedor()+"");
		}
	}
	void limpiarFormulario(){
		
		limpiarCajas();
		
		inicializarDatosBoleta();
	}
	
	void inicializarDatosBoleta(){
		txtNumero.setText(obtenerNumTicket());
		txtFecha.setText(obtenerFecha());
	}
	
	private String obtenerNumTicket() {		
		// TODO Auto-generated method stub
		return gestionTicket.generarNumeroTicket();
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		if (txtProducto.getText().equals("")){
			mensaje("Debe de identificar a un producto"); 
			return;
		}	

		if (txtProducto.getText().equals("")){
			mensaje("Debe de identificar a un usuario"); 
			return;
		}
		Ticket ticket = new Ticket();
		ticket.setNumero_Ticket(txtNumero.getText()); 
		ticket.setFechaTick(txtFecha.getText());
		ticket.setId_producto(Integer.parseInt(txtProducto.getText()));
		ticket.setDetalle_producto(txtDetalle.getText());
		ticket.setPrecio(Double.parseDouble(txtPrecio.getText()));
		ticket.setId_vendedor(txtVendedor.getText());
		ticket.setCantidad(Integer.parseInt(txtCantidad.getText()));
		ticket.setEstado(cboEstado.getSelectedIndex());
		
		int ok = confirmar("¿ Esta seguro de generar Ticket ?");
		if (ok == 0) {
			GestionTicket gestionTicket = new GestionTicket();
			int estado=gestionTicket.registrarTicket(ticket);
			
			if (estado==0) 
				mensaje("Sucedio algo inesperado al momento de registrar ticket");
			else{
				mensaje("Registro exitoso");
				limpiarFormulario();
			}
		}	
	}
}
