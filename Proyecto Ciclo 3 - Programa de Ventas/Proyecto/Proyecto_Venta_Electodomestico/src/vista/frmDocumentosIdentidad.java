package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionTipoDocumentoIdentidad;
import model.TipoDocumentoIdentidad;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class frmDocumentosIdentidad extends JInternalFrame {
	private JLabel lblCodigo;
	private JLabel lblDescripcion;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JButton btnActualizar;

	//Variable Global
	GestionTipoDocumentoIdentidad gestion = new GestionTipoDocumentoIdentidad();
	private JButton btnLimpiar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDocumentosIdentidad frame = new frmDocumentosIdentidad();
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
	public frmDocumentosIdentidad() {
		setMaximizable(true);
		setClosable(true);
		setTitle("DOCUMENTOS DE IDENTIDAD");
		setBounds(100, 100, 492, 350);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo de Documento :");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(24, 24, 185, 14);
		getContentPane().add(lblCodigo);
		
		lblDescripcion = new JLabel("Descripcion de Comprobante :");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescripcion.setBounds(24, 49, 185, 14);
		getContentPane().add(lblDescripcion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(219, 21, 191, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(219, 46, 191, 20);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRegistrar(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(40, 91, 106, 29);
		getContentPane().add(btnRegistrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(176, 91, 106, 29);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 456, 169);
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
		btnActualizar.setBounds(312, 94, 106, 29);
		getContentPane().add(btnActualizar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnLimpiar(e);
			}
		});
		btnLimpiar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\limpiar.png"));
		btnLimpiar.setBounds(420, 20, 46, 43);
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
		ArrayList<TipoDocumentoIdentidad> listaTipoDocumentoIdentidad= gestion.listarTipoDocumentoIdentidad(); 
		for (int i=0; i<listaTipoDocumentoIdentidad.size(); i++) {
			Object[] fila = {   listaTipoDocumentoIdentidad.get(i).getCodigo(),
								listaTipoDocumentoIdentidad.get(i).getDetalle()};
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
	
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		
		TipoDocumentoIdentidad objTipDocIde = new TipoDocumentoIdentidad();
		
		objTipDocIde.setCodigo(leerCodigo());
		objTipDocIde.setDetalle(leerDetalle());
			
			int resultado=gestion.actualizarDocumentoIdentidad(objTipDocIde);
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	mensaje("Información actualizada con éxito");
		    }
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		
			TipoDocumentoIdentidad objTipDocIde = new TipoDocumentoIdentidad();
			objTipDocIde.setCodigo(leerCodigo());
			objTipDocIde.setDetalle(leerDetalle());
			
			int resultado=gestion.registrarDocumentoIdentidad(objTipDocIde);
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
		 
			int resultado=gestion.eliminarDocumentoIdentidad(leerCodigo());
			if (resultado==0){
		    	mensaje("Ocurrio algo inesperado");
		    }else{
		    	listar();
		    	limpiarCajas();
		    	mensaje("Información eliminada con éxito");
		    }			
		}	
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
}
