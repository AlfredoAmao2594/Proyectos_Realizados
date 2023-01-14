package gui;

import arreglos.*;
import clases.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ConsultaAlumno extends JDialog implements ActionListener {
	private JButton btnConsultar;
	private JTextArea txtResultado;
	private JComboBox cboCodigo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultaAlumno dialog = new ConsultaAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaAlumno() {
		setTitle("Consulta de Alumno");
		setBounds(100, 100, 500, 436);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo de alumno:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 36, 122, 14);
		getContentPane().add(lblNewLabel);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(334, 32, 109, 23);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 466, 298);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
		
		cboCodigo = new JComboBox();
		cboCodigo.setBounds(142, 33, 94, 23);
		getContentPane().add(cboCodigo);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConsultaAlumno.class.getResource("/imagenes/fondoframes.jpg")));
		lblNewLabel_1.setBounds(0, 0, 484, 397);
		getContentPane().add(lblNewLabel_1);
		
		listarCboCodigo();
	}
	
	//declaracion global
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();
	ArregloMatriculas am = new ArregloMatriculas();
	private JLabel lblNewLabel_1;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		try {
			txtResultado.setText("");
			listar();
			cboCodigo.requestFocus();
		}
		catch (Exception error) {
			mensaje("Seleccione un código de alumno");
		}
	}
	//imprimir	
	void imprimir(){
		imprimir("");
	}
	
	
	//metodo Listar
	void listar() {
		Alumno x = aa.buscar(leerCodigo());
		imprimir("CÓDIGO               : " + x.getCodAlumno());
		imprimir("NOMBRES              : " + x.getNombres());
		imprimir("APELLIDOS            : " + x.getApellidos());
		imprimir("DNI                  : " + x.getDni());
		imprimir("EDAD                 : " + x.getEdad());
		imprimir("CELULAR              : " + x.getCelular());
		imprimir("ESTADO               : " + nombreEstado(x.getEstado()));
		imprimir();
		if (x.getEstado() != 0) {
			Matricula m = am.buscarCod(leerCodigo());
			Curso c = ac.buscar(m.getCodigoCurso());
			imprimir("ASIGNATURA           : " + c.getAsignatura());
			imprimir("CICLO                : " + nombreCiclo(c.getCiclo()));
			imprimir("CANTIDAD DE CRÉDITOS : " + c.getCreditos());
			imprimir("HORAS                : " + c.getHoras());
		}
	}
	
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < aa.tamaño(); i++) {
			cboCodigo.addItem(aa.obtener(i).getCodAlumno());
		}
		cboCodigo.setSelectedIndex(-1);
	}
	String nombreEstado(int i) {
		switch (i) {
			case 0: return "REGISTRADO";
			case 1: return "MATRICULADO";
			case 2: return "RETIRADO";
			default:return null;
		}
	}
	String nombreCiclo(int i) {
		switch (i) {
			case 0: return "PRIMERO";
			case 1: return "SEGUNDO";
			case 2: return "TERCERO";
			case 3: return "CUARTO";
			case 4: return "QUINTO";
			case 5: return "SEXTO";
			default:return null;
		}
	}
	void imprimir(String s){
		txtResultado.append(s + "\n"); 
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//otros metodos
	public int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
}
