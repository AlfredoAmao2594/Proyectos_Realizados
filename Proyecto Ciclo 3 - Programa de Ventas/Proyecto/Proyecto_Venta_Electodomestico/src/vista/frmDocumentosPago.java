package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionTipoComprobantePago;
import model.TipoComprobantePago;
import model.TipoDocumentoIdentidad;

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

public class frmDocumentosPago extends JInternalFrame {
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private DefaultTableModel modelo;
	
	//varible globales
	GestionTipoComprobantePago gestion = new GestionTipoComprobantePago();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDocumentosPago frame = new frmDocumentosPago();
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
	public frmDocumentosPago() {
		setClosable(true);
		setMaximizable(true);
		setTitle("TIPOS DE DOCUMENTOS DE PAGO");
		setBounds(100, 100, 520, 350);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo de Comprobante :");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(23, 22, 156, 14);
		getContentPane().add(lblCodigo);
		
		lblDescripcion = new JLabel("Descripcion de Comprobante :");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setBounds(23, 60, 182, 14);
		getContentPane().add(lblDescripcion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(229, 19, 171, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(229, 57, 171, 20);
		getContentPane().add(txtDescripcion);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(69, 98, 110, 23);
		getContentPane().add(btnRegistrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(204, 98, 105, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 140, 460, 169);
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
		modelo.addColumn("Codigo");
		modelo.addColumn("Detalle");
		tblTabla.setModel(modelo);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnActualizar(e);
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(342, 98, 105, 23);
		getContentPane().add(btnActualizar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		btnLimpiar.setBounds(431, 18, 50, 41);
		getContentPane().add(btnLimpiar);
		
		listar();

	}
	
	void limpiarCajas(){
		txtCodigo.setText("");
		txtDescripcion.setText("");
		txtCodigo.requestFocus();
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void listar() {
		modelo.setRowCount(0);
		ArrayList<TipoComprobantePago> listaTipoComprobantePago= gestion.listarComprobantePago(); 
		for (int i=0; i<listaTipoComprobantePago.size(); i++) {
			Object[] fila = {   listaTipoComprobantePago.get(i).getCodigo(),
								listaTipoComprobantePago.get(i).getDetalle()};
			System.out.println("ver"+i);
			modelo.addRow(fila);
		}
	}
	
	void navegar(){
		int fila=tblTabla.getSelectedRow();
		txtCodigo.setText("" +tblTabla.getValueAt(fila, 0));
		txtDescripcion.setText("" +tblTabla.getValueAt(fila, 1));
	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	
	String leerDetalle() {
		return txtDescripcion.getText();
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
		TipoComprobantePago objTipComPag = new TipoComprobantePago();
		objTipComPag.setCodigo(leerCodigo());
		objTipComPag.setDetalle(leerDetalle());
		
		int resultado=gestion.registrarComprobantePago(objTipComPag);
		if (resultado==0){
	    	mensaje("Ocurrio algo inesperado");
	    }else{
	    	listar();
	    	limpiarCajas();
	    	mensaje("Información registrada con éxito");
	    }	
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		int ok = confirmar("¿ Desea eliminar el registro ?");
		if (ok == 0) {
		 
			int resultado=gestion.eliminarComprobantePago(leerCodigo());
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
		
		TipoComprobantePago objTipComPag = new TipoComprobantePago();
		
		objTipComPag.setCodigo(leerCodigo());
		objTipComPag.setDetalle(leerDetalle());
			
			int resultado=gestion.actualizarComprobantePago(objTipComPag);
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	mensaje("Información actualizada con éxito");
		    }
	}
	
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiarCajas();
	}
	protected void mouseClickedTblTabla(MouseEvent e) {
		navegar();
	}
	protected void keyReleasedTblTabla(KeyEvent e) {
		navegar();
	}
}
