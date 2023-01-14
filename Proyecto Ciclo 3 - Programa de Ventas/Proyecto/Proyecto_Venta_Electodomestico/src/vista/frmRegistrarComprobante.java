package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCliente;
import mantenimientos.GestionTicket;
import mantenimientos.GestionTipoComprobantePago;
import mantenimientos.GestionVenta;
import model.Cliente;
import model.ComprobantePagoCab;
import model.ComprobantePagoDetalle;
import model.Estado;
import model.Proveedor;
import model.Ticket;
import model.TipoComprobantePago;
import model.Usuario;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class frmRegistrarComprobante extends JInternalFrame {
	private JPanel panel;
	private JLabel lblTitulo;
	private JPanel panel_1;
	private JLabel lblNumero;
	private JLabel lblNumero_1;
	private JLabel lblTipo;
	private JTextField txtNumero;
	private JTextField txtFecha;
	private JComboBox cboTipo;
	private JPanel panel_DatosCliente;
	private JLabel lblIdCliente;
	private JLabel lblNombre;
	private JTextField txtID;
	private JTextField txtNombre;
	private JButton btnBuscarCliente;
	private JPanel panel_ticket;
	private JLabel lblNumTicket;
	private JLabel lblIdProducto;
	private JLabel lblDetalle;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JTextField txtNumTicket;
	private JTextField txtIdProducto;
	private JTextField txtDetalle;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JPanel panel_2;
	private JButton btnBuscarTicket;
	private JButton btnAgregar;
	private JButton btnLimpiar;
	private JPanel panel_3;
	private JScrollPane txtS;
	private JButton btnEliminarItem;
	private JPanel panel_4;
	private JLabel lblBase;
	private JLabel lblIgv;
	private JLabel lblImporte;
	private JButton btnRegistrar;
	
	private DefaultTableModel modelo;
	
	GestionVenta gestionVenta = new GestionVenta();
	GestionTipoComprobantePago gestionTipoComprobantePago = new GestionTipoComprobantePago();
	GestionCliente gestionCliente = new GestionCliente();
	GestionTicket gestionTicket = new GestionTicket();
	private JTable tblItem;
	private JTextField txtBase;
	private JTextField txtIGV;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistrarComprobante frame = new frmRegistrarComprobante();
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
	public frmRegistrarComprobante() {
		setTitle("Registro de Comprobante de Venta");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 600, 646);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(28, 11, 535, 46);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTitulo = new JLabel("COMPROBANTE DE PAGO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(10, 11, 515, 24);
		panel.add(lblTitulo);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(22, 76, 283, 115);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNumero = new JLabel("Numero :");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumero.setBounds(10, 11, 69, 14);
		panel_1.add(lblNumero);
		
		lblNumero_1 = new JLabel("Fecha :");
		lblNumero_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumero_1.setBounds(10, 43, 69, 14);
		panel_1.add(lblNumero_1);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(10, 75, 69, 14);
		panel_1.add(lblTipo);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setBounds(89, 9, 161, 20);
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(89, 41, 161, 20);
		panel_1.add(txtFecha);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(89, 72, 161, 22);
		panel_1.add(cboTipo);
		
		panel_DatosCliente = new JPanel();
		panel_DatosCliente.setBorder(new TitledBorder(null, "Datos del Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_DatosCliente.setBounds(315, 76, 248, 115);
		getContentPane().add(panel_DatosCliente);
		panel_DatosCliente.setLayout(null);
		
		lblIdCliente = new JLabel("ID de Cliente :");
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdCliente.setBounds(10, 25, 97, 15);
		panel_DatosCliente.add(lblIdCliente);
		
		lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 51, 97, 15);
		panel_DatosCliente.add(lblNombre);
		
		txtID = new JTextField();
		txtID.setBounds(105, 23, 133, 20);
		panel_DatosCliente.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(105, 49, 133, 20);
		panel_DatosCliente.add(txtNombre);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscarCliente(e);
			}
		});
		btnBuscarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarCliente.setBorderPainted(false);
		btnBuscarCliente.setBorder(null);
		btnBuscarCliente.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\buscar.png"));
		btnBuscarCliente.setBounds(91, 71, 59, 33);
		panel_DatosCliente.add(btnBuscarCliente);
		
		panel_ticket = new JPanel();
		panel_ticket.setBorder(new TitledBorder(null, "Datos de Ticket", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_ticket.setBounds(22, 200, 541, 115);
		getContentPane().add(panel_ticket);
		panel_ticket.setLayout(null);
		
		lblNumTicket = new JLabel("Numero de Ticket :");
		lblNumTicket.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumTicket.setBounds(10, 26, 122, 14);
		panel_ticket.add(lblNumTicket);
		
		lblIdProducto = new JLabel("Id de Producto :");
		lblIdProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdProducto.setBounds(10, 53, 115, 14);
		panel_ticket.add(lblIdProducto);
		
		lblDetalle = new JLabel("Detalle :");
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalle.setBounds(10, 83, 115, 14);
		panel_ticket.add(lblDetalle);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(298, 53, 87, 14);
		panel_ticket.add(lblCantidad);
		
		lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(308, 83, 87, 14);
		panel_ticket.add(lblPrecio);
		
		txtNumTicket = new JTextField();
		txtNumTicket.setEditable(false);
		txtNumTicket.setBounds(135, 24, 141, 20);
		panel_ticket.add(txtNumTicket);
		txtNumTicket.setColumns(10);
		
		txtIdProducto = new JTextField();
		txtIdProducto.setEditable(false);
		txtIdProducto.setColumns(10);
		txtIdProducto.setBounds(135, 53, 141, 20);
		panel_ticket.add(txtIdProducto);
		
		txtDetalle = new JTextField();
		txtDetalle.setEditable(false);
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(135, 83, 141, 20);
		panel_ticket.add(txtDetalle);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(384, 53, 141, 20);
		panel_ticket.add(txtCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(384, 83, 141, 20);
		panel_ticket.add(txtPrecio);
		
		panel_2 = new JPanel();
		panel_2.setBounds(298, 15, 233, 29);
		panel_ticket.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnBuscarTicket = new JButton("");
		btnBuscarTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscarTicket(e);
			}
		});
		btnBuscarTicket.setBorder(null);
		btnBuscarTicket.setBorderPainted(false);
		btnBuscarTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarTicket.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\buscar.png"));
		panel_2.add(btnBuscarTicket);
		
		btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAgregar(e);
			}
		});
		btnAgregar.setBorder(null);
		btnAgregar.setBorderPainted(false);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\documento (2).png"));
		panel_2.add(btnAgregar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setBorder(null);
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		panel_2.add(btnLimpiar);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Items", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_3.setBounds(22, 326, 541, 171);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		txtS = new JScrollPane();
		txtS.setBounds(10, 21, 472, 139);
		panel_3.add(txtS);
		
		tblItem = new JTable();
		txtS.setViewportView(tblItem);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("ID Producto");
		modelo.addColumn("Detalle");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Importe"); 
		tblItem.setModel(modelo);
		
		btnEliminarItem = new JButton("");
		btnEliminarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminarItem(e);
			}
		});
		btnEliminarItem.setBounds(492, 24, 39, 57);
		panel_3.add(btnEliminarItem);
		btnEliminarItem.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\cancelar.png"));
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(22, 508, 541, 50);
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(2, 3, 0, 0));
		
		lblBase = new JLabel("Base Imponible");
		lblBase.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBase.setHorizontalAlignment(SwingConstants.CENTER);
		lblBase.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblBase);
		
		lblIgv = new JLabel("IGV");
		lblIgv.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblIgv.setHorizontalAlignment(SwingConstants.CENTER);
		lblIgv.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblIgv);
		
		lblImporte = new JLabel("Importe Total");
		lblImporte.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblImporte);
		
		txtBase = new JTextField();
		txtBase.setEditable(false);
		panel_4.add(txtBase);
		txtBase.setColumns(10);
		
		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		panel_4.add(txtIGV);
		txtIGV.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		panel_4.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnRegistrar = new JButton("Registrar Comprobante");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\registrar.png"));
		btnRegistrar.setBounds(172, 569, 237, 36);
		getContentPane().add(btnRegistrar);
		
		llenarCombo();
		inicializarDatosFactura();

	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	String leerNumeroComp() {
		return txtNumero.getText();
	}
	
	String obtenerFecha() {
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	long leerIdCliente() {
		return Long.parseLong(txtID.getText());
	}
	
	String leerNombreCliente() {
		return txtNombre.getText();
	}
	
	String leerNumeroTicket() {
		return txtNumTicket.getText();
	}
	
	int leerIdProducto() {
		return Integer.parseInt(txtIdProducto.getText());
	}
	
	String leerDetalleProducto() {
		return txtDetalle.getText();
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
	double leerBase() {
		return Double.parseDouble(txtBase.getText());
	}
	
	void llenarCombo(){
		
		ArrayList<TipoComprobantePago> lista=gestionTipoComprobantePago.listarComprobantePago();

		cboTipo.addItem(new TipoComprobantePago(0, "Selecciona tipo"));		
		for (TipoComprobantePago objTip : lista) { 
			cboTipo.addItem( new TipoComprobantePago(objTip.getCodigo(),objTip.getDetalle()) );
		}
	}
	
	void inicializarDatosFactura(){
		txtNumero.setText(obtenerNumFactura());
		txtFecha.setText(obtenerFecha());
	}
	
	private String obtenerNumFactura() {		
		// TODO Auto-generated method stub
		return gestionVenta.generarNumeroFactura();
	}
	
	String formatoDecimal(double numero ){
		DecimalFormat df = new DecimalFormat("#.00");
	    return df.format(numero);
	}
	
	int tipoComprobante() {
		return cboTipo.getSelectedIndex();
	}
	
	void limpiarItem(){
		txtNumTicket.setText("");
		txtIdProducto.setText("");
		txtDetalle.setText("");
		txtCantidad.setText("");
		txtPrecio.setText("");
		
	}
	
	void limpiarFormulario(){
		
		limpiarItem();
		
		txtID.setText("");
		txtNombre.setText("");
		 
		modelo.setRowCount(0);
		
		inicializarDatosFactura();
		
		txtBase.setText("");
		txtIGV.setText("");
		txtTotal.setText("");
	}
	
	void calcularImportes(double baseImponible, double igv,double importeTotal){
		baseImponible=0;
		igv=0;
		importeTotal=0;
		
		for (int i = 0; i < tblItem.getRowCount() ; i++) { 
			baseImponible=baseImponible + Double.parseDouble(tblItem.getValueAt(i, 5).toString()); 
		}
		igv = baseImponible *0.18;
		importeTotal = baseImponible + igv;
		
		txtBase.setText(""+formatoDecimal(baseImponible));
		txtIGV.setText(""+formatoDecimal(igv));
		txtTotal.setText(""+formatoDecimal(importeTotal));
	}
	int estado=3;
	
	void actualizarEstado() {
		
		ArrayList<Ticket> listaTicket = new ArrayList<Ticket>();
		
		for (int i = 0; i<tblItem.getRowCount();i++) {
			
			Ticket ticket = new Ticket();
			ticket.setNumero_Ticket(tblItem.getValueAt(i, 0).toString());
			ticket.setEstado(estado);
			
			listaTicket.add(ticket);
		}
				
	
			GestionTicket gestionticket = new GestionTicket();
			int estado=gestionticket.actualizarEstadoTicket(listaTicket);
			
			if (estado==0) 
				mensaje("Sucedio al actulizar estado del ticket");
			else{
				mensaje("Ticket atendido");
			}
			
		
	}
	
	protected void actionPerformedBtnBuscarCliente(ActionEvent e) {
		frmBuscarCliente d = new frmBuscarCliente();
		d.setModal(true);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
		
		System.out.println("codCliente "+ d.codCliente);
		
		if (d.codCliente!=0){
			
			Cliente objCliente= gestionCliente.obtenerCliente(d.codCliente);
			txtID.setText(objCliente.getId_cliente()+"");
			txtNombre.setText(objCliente.getNombre_cliente()+"");
		}
	}
	protected void actionPerformedBtnBuscarTicket(ActionEvent e) {
		
		frmBuscarTicket d = new frmBuscarTicket();
		d.setModal(true);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
		
		System.out.println("codTicket "+ d.codTicket);
		
		if (d.codTicket!=""){
			
			Ticket objTick= gestionTicket.obtenerTicket(d.codTicket);
			txtNumTicket.setText(objTick.getNumero_Ticket()+"");
			txtIdProducto.setText(objTick.getId_producto()+"");
			txtDetalle.setText(objTick.getDetalle_producto()+"");
			txtCantidad.setText(objTick.getCantidad()+"");
			txtPrecio.setText(objTick.getPrecio()+"");
			
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		if (txtNumTicket.getText().equals("")){
			mensaje("Ingrese un ticket");
			txtNumTicket.requestFocus();
			return;
		}
		
		String codigo=txtNumTicket.getText();
		int idProducto = Integer.parseInt(txtIdProducto.getText());
		String detalleProducto=txtDetalle.getText();
		int cantidad=Integer.parseInt(txtCantidad.getText());
		double precio=Double.parseDouble(txtPrecio.getText());
		
		double importe=precio*cantidad;
		double base=0;
		double igv=0;
		double importeTotal=0;
		
		Object[] fila={codigo,idProducto,detalleProducto,cantidad,precio,formatoDecimal(importe)};

		modelo.addRow(fila);
		limpiarItem();
	 	calcularImportes(base,igv,importeTotal);
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarItem();
	}
	protected void actionPerformedBtnEliminarItem(ActionEvent e) {
		
		if (tblItem.getRowCount()>=1){
			
			int filaSeleccionada = tblItem.getSelectedRow();
			modelo.removeRow(filaSeleccionada); 
			
			double base=0;
			double igv=0;
			double importeTotal=0;
			calcularImportes(base,igv,importeTotal);
			
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
		if (txtID.getText().equals("")){
			mensaje("Debe de identificar a un cliente"); 
			return;
		}	

		if (tblItem.getRowCount()==0){
			mensaje("Debe ingresar al menos un ticket en la boleta");
			tblItem.requestFocus();
			return;
		}		 
		
		
		ComprobantePagoCab factura = new ComprobantePagoCab();
	
		factura.setNumeroFactura(txtNumero.getText()); 
		factura.setFechaFact(txtFecha.getText());
		factura.setCodigo_comp(tipoComprobante());
		factura.setIdCliente(Long.parseLong(txtID.getText()));
		factura.setBaseImponible(Double.parseDouble(txtBase.getText()));
		factura.setIgv(Double.parseDouble(txtIGV.getText()));
		factura.setTotalCompro(Double.parseDouble(txtTotal.getText()));
		 
	
		 ArrayList<ComprobantePagoDetalle> listaDetalle = new ArrayList<ComprobantePagoDetalle>();
		
		for (int i = 0; i < tblItem.getRowCount() ; i++) {
		
		ComprobantePagoDetalle facturaDetalle = new ComprobantePagoDetalle();
		 facturaDetalle.setNumeroFactura(txtNumero.getText());
		 facturaDetalle.setNumeroTicket(tblItem.getValueAt(i, 0).toString());
		 facturaDetalle.setIdProducto(Integer.parseInt(tblItem.getValueAt(i, 1).toString()));
		 facturaDetalle.setDetalleProducto(tblItem.getValueAt(i, 2).toString());
		 facturaDetalle.setCantidad(Integer.parseInt(tblItem.getValueAt(i, 3).toString()));
		 facturaDetalle.setPrecio(Double.parseDouble(tblItem.getValueAt(i, 4).toString()));
		 facturaDetalle.setImporte(Double.parseDouble(tblItem.getValueAt(i,5).toString()));
		 
		 listaDetalle.add(facturaDetalle);			
		}
		
		int ok = confirmar("¿ Esta seguro de generar factura ?");
		if (ok == 0) {
			GestionVenta gestionVenta = new GestionVenta();
			int estado=gestionVenta.registrarBoleta(factura, listaDetalle);
			
			if (estado==0) 
				mensaje("Sucedio algo inesperado al momento de registrar factura");
			else{
				mensaje("Registro exitoso");
				actualizarEstado();
				limpiarFormulario();
			}
		}	
	}
}
