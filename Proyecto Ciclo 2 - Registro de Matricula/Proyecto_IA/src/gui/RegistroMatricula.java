package gui;

import arreglos.*;
import clases.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RegistroMatricula extends JDialog implements ItemListener, ActionListener, MouseListener {
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<Integer> cboNumMatricula;
	private JComboBox<Integer> cboCodigoAlumno;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTextField txtAlumno;
	private JLabel lblNewLabel_3;
	private JComboBox<Integer> cboCodigoCurso;
	private JTextField txtCurso;
	private JLabel lblNewLabel_4;
	private JTable tblMatricula;
	private DefaultTableModel modelo;
	private JTextField txtEstadoAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroMatricula dialog = new RegistroMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroMatricula() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Registro de Matricula");
		setBounds(100, 100, 802, 514);
		getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("N\u00B0 de Matr\u00EDcula:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 22, 136, 15);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("C\u00F3digo del alumno:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 57, 136, 15);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Estado:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 122, 136, 15);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("C\u00F3digo de curso:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 157, 136, 15);
		getContentPane().add(lblNewLabel_4);
		
		cboNumMatricula = new JComboBox<Integer>();
		cboNumMatricula.addItemListener(this);
		cboNumMatricula.setSelectedIndex(-1);
		cboNumMatricula.setEnabled(false);
		cboNumMatricula.setBounds(156, 22, 152, 21);
		getContentPane().add(cboNumMatricula);
		
		cboCodigoAlumno = new JComboBox<Integer>();
		cboCodigoAlumno.addItemListener(this);
		cboCodigoAlumno.setSelectedIndex(-1);
		cboCodigoAlumno.setEnabled(false);
		cboCodigoAlumno.setBounds(156, 55, 152, 21);
		getContentPane().add(cboCodigoAlumno);
		
		txtAlumno = new JTextField();
		txtAlumno.setText("");
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
		txtAlumno.setBounds(10, 91, 298, 19);
		getContentPane().add(txtAlumno);
		
		cboCodigoCurso = new JComboBox<Integer>();
		cboCodigoCurso.addItemListener(this);
		
		txtEstadoAlumno = new JTextField();
		txtEstadoAlumno.setText("");
		txtEstadoAlumno.setEditable(false);
		txtEstadoAlumno.setColumns(10);
		txtEstadoAlumno.setBounds(156, 121, 152, 19);
		getContentPane().add(txtEstadoAlumno);
		cboCodigoCurso.setSelectedIndex(-1);
		cboCodigoCurso.setEnabled(false);
		cboCodigoCurso.setBounds(156, 155, 152, 21);
		getContentPane().add(cboCodigoCurso);
		
		txtCurso = new JTextField();
		txtCurso.setText("");
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(10, 191, 298, 19);
		getContentPane().add(txtCurso);
		
		btnAceptar = new JButton("Registrar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(599, 40, 104, 33);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(538, 148, 104, 33);
		getContentPane().add(btnCancelar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionar.setEnabled(true);
		btnAdicionar.setBounds(538, 92, 104, 33);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificar.setEnabled(true);
		btnModificar.setBounds(660, 92, 104, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminar.setEnabled(true);
		btnEliminar.setBounds(660, 148, 104, 33);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 767, 227);
		getContentPane().add(scrollPane);
		
		tblMatricula = new JTable();
		tblMatricula.addMouseListener(this);
		tblMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblMatricula);
		modelo = new DefaultTableModel();
		modelo.addColumn("Num Matr");
		modelo.addColumn("Cod. Alu");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Cod Curso");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		modelo.addColumn("Actvido");
		tblMatricula.setModel(modelo);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(RegistroMatricula.class.getResource("/imagenes/fondoframes.jpg")));
		lblNewLabel_5.setBounds(0, 0, 786, 475);
		getContentPane().add(lblNewLabel_5);
		
		ajustarColumnas();
		listar();
		deshabilitarTodo();
	}
	
	//DECLARACIÓN GLOBAL
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
	private JLabel lblNewLabel_5;
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigoCurso) {
			itemStateChangedCboCodigoCurso(e);
		}
		if (e.getSource() == cboCodigoAlumno) {
			itemStateChangedCboCodigoAlumno(e);
		}
		if (e.getSource() == cboNumMatricula) {
			itemStateChangedCboNumMatricula(e);
		}
	}
	protected void itemStateChangedCboNumMatricula(ItemEvent e) {
		try {
			int numMatricula = leerNumeroMatricula();
			Matricula buscado = am.buscar(numMatricula);
			cboCodigoAlumno.setSelectedItem(buscado.getCodigoAlumno());
			cboCodigoCurso.setSelectedItem(buscado.getCodigoCurso());
			tblMatricula.setRowSelectionInterval(cboNumMatricula.getSelectedIndex(), cboNumMatricula.getSelectedIndex());
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboCodigoAlumno(ItemEvent e) {
		try {
			int codAlumno = leerCodigoAlumno();
			Alumno buscado = aa.buscar(codAlumno);
			txtAlumno.setText(buscado.getNombres() + " " + buscado.getApellidos());
			txtEstadoAlumno.setText(nombreEstado(buscado.getEstado()));
		} catch (Exception error) {
			
		}
	}
	protected void itemStateChangedCboCodigoCurso(ItemEvent e) {
		try {
			int codCurso = leerCodigoCurso();
			Curso buscado = ac.buscar(codCurso);
			txtCurso.setText(buscado.getAsignatura());
		} catch (Exception error) {
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int numMatricula = leerNumeroMatricula();
			try {
				int codAlumno = leerCodigoAlumno();
				try {
					int codCurso = leerCodigoCurso();
					if (!btnAdicionar.isEnabled()) {
						if (aa.buscar(codAlumno).getEstado() == 0) {
							Matricula nuevo = new Matricula(numMatricula, codAlumno, codCurso, FechaHora.fechaActual(), FechaHora.horaActual());
							aa.buscar(codAlumno).setEstado(1);
							aa.ActualizarArchivo();
							am.adicionar(nuevo);
							listar();
							mensaje("Nueva matrícula añadida exitosamente");
							deshabilitarTodo();
						} else {
							error("No es posible completar la acción, el alumno ya se encuentra matriculado", cboCodigoAlumno);
						}
					} else if (!btnModificar.isEnabled()) {
							Matricula buscado = am.buscar(numMatricula);
							buscado.setCodigoCurso(codCurso);
							am.ActualizarArchivo();
							listar();
							mensaje("Matrícula modificada exitosamente");
							deshabilitarTodo();
					}
				} catch (Exception error) {
					error("Inserte un código de curso", cboCodigoCurso);
				}
			} catch (Exception error) {
				error("Inserte un código de alumno", cboCodigoAlumno);
			}
		} catch (Exception error) {
			error("Seleccione un número de matrícula", cboNumMatricula);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		limpiar();
		habilitar(false, true, false, false, true, false, true, true, false, true, false);
		cboNumMatricula.addItem(am.codigoCorrelativo());
		cboNumMatricula.setSelectedIndex(am.tamaño());
		cboCodigoAlumno.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (!btnAdicionar.isEnabled()) deshabilitarTodo();
		habilitar(true, false, false, false, true, false, true, true, true, false, false);
		cboNumMatricula.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int numMatricula = leerNumeroMatricula();
			int codAlumno = leerCodigoAlumno();
			Matricula buscado = am.buscar(numMatricula);
			if (aa.buscar(codAlumno).getEstado() == 1) {
				if (confirmar() == 0) {
					am.eliminar(buscado);
					aa.buscar(codAlumno).setEstado(0);
					aa.ActualizarArchivo();
					listar();
					mensaje("Matrícula eliminada exitosamente");
					deshabilitarTodo();
				}
			} else {
				error("No es posible eliminar la matrícula, el alumno se encuentra retirado", cboNumMatricula);
			}
		} catch (Exception error) {
			error("Seleccione un número de matrícula", cboNumMatricula);
		}
	}
	void habilitar(boolean numMatricula, boolean codigoAlumno, boolean alumno, boolean estadoAlumno, boolean codigoCurso,
			boolean curso, boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar) {
		cboNumMatricula.setEnabled(numMatricula);
		cboCodigoAlumno.setEnabled(codigoAlumno);
		txtAlumno.setEditable(alumno);
		txtEstadoAlumno.setEditable(estadoAlumno);
		cboCodigoCurso.setEnabled(codigoCurso);
		txtCurso.setEditable(curso);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnAdicionar.setEnabled(adicionar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}
	void deshabilitarTodo() {
		listarCboNumMatricula();
		listarCboCodAlumno();
		listarCboCodCurso();
		habilitar(false, false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}
	void limpiar() {
		cboNumMatricula.setSelectedIndex(-1);
		cboCodigoAlumno.setSelectedIndex(-1);
		txtAlumno.setText("");
		txtEstadoAlumno.setText("");
		cboCodigoCurso.setSelectedIndex(-1);
		txtCurso.setText("");
	}
	void listarCboNumMatricula() {
		cboNumMatricula.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboNumMatricula.addItem(am.obtener(i).getNumeroMatricula());
		}
	}
	void listarCboCodAlumno() {
		cboCodigoAlumno.removeAllItems();
		for (int i = 0; i < aa.tamaño(); i++) {
			cboCodigoAlumno.addItem(aa.obtener(i).getCodAlumno());
		}
	}
	void listarCboCodCurso() {
		cboCodigoCurso.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigoCurso.addItem(ac.obtener(i).getCodCurso());
		}
	}
	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblMatricula.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth()*5);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth()*5);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth()*1);
		modeloColuma.getColumn(5).setPreferredWidth(scrollPane.getWidth()*7);
		modeloColuma.getColumn(6).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(7).setPreferredWidth(scrollPane.getWidth()*2);
		modeloColuma.getColumn(8).setPreferredWidth(scrollPane.getWidth()*1);
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < am.tamaño(); i++) {
			Object[] fila = {
					am.obtener(i).getNumeroMatricula(),
					am.obtener(i).getCodigoAlumno(),
					aa.buscar(am.obtener(i).getCodigoAlumno()).getNombres(),
					aa.buscar(am.obtener(i).getCodigoAlumno()).getApellidos(),
					am.obtener(i).getCodigoCurso(),
					ac.buscar(am.obtener(i).getCodigoCurso()).getAsignatura(),
					am.obtener(i).getFecha(),
					am.obtener(i).getHora(),
					activo(aa.buscar(am.obtener(i).getCodigoAlumno()).getEstado())
			};
			modelo.addRow(fila);
		}
	}
	int leerNumeroMatricula() {
		return Integer.parseInt(cboNumMatricula.getSelectedItem().toString());
	}
	int leerCodigoAlumno() {
		return Integer.parseInt(cboCodigoAlumno.getSelectedItem().toString());
	}
	String leerAlumno() {
		return txtAlumno.getText().trim().toUpperCase();
	}
	String leerEstadoAlumno() {
		return txtEstadoAlumno.getText();
	}
	String nombreEstado(int i) {
		switch (i) {
		case 0: return "REGISTRADO";
		case 1: return "MATRICULADO";
		case 2: return "RETIRADO";
		default:return null;
		}
	}
	String activo(int i) {
		return i == 1 ? "Sí" : "No";
	}
	int leerCodigoCurso() {
		return Integer.parseInt(cboCodigoCurso.getSelectedItem().toString());
	}
	String leerCurso() {
		return txtCurso.getText().trim().toUpperCase();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s,"", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}
	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"¿Estás seguro que deseas eliminar esta matricula?\n"
				+ "Alumno: " + leerAlumno() + "\n" + "Curso: " + leerCurso(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblMatricula) {
			mouseClickedTblMatricula(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblMatricula(MouseEvent e) {
		if (btnAdicionar.isEnabled()) {
			try {
				Matricula buscado = am.obtener(tblMatricula.getSelectedRow());
				cboNumMatricula.setSelectedIndex(tblMatricula.getSelectedRow());
				cboCodigoAlumno.setSelectedItem(buscado.getCodigoAlumno());
				cboCodigoCurso.setSelectedItem(buscado.getCodigoCurso());
			} catch (Exception error) {
				
			}
		}
	}
}
