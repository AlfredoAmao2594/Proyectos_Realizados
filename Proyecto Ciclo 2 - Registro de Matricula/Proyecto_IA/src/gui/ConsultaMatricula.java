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
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ConsultaMatricula extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JComboBox cboCodigo;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultaMatricula dialog = new ConsultaMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaMatricula() {
		setTitle("Consultar Matricula");
		setBounds(100, 100, 500, 436);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("N\u00FAmero de matr\u00EDcula:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 38, 143, 15);
		getContentPane().add(lblNewLabel);
		
		cboCodigo = new JComboBox();
		cboCodigo.setSelectedIndex(-1);
		cboCodigo.setBounds(166, 36, 115, 21);
		getContentPane().add(cboCodigo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setBounds(353, 34, 97, 23);
		getContentPane().add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 466, 298);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConsultaMatricula.class.getResource("/imagenes/fondoframes.jpg")));
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
			imprimir("Seleccione un número de matrícula");
		}
	}
	
	void imprimir(){
		imprimir("");
	}
	//metodo Listar
	void listar() {
		Matricula m = am.buscar(leerCodigo());
		Alumno x = aa.buscar(m.getCodigoAlumno());
		Curso c = ac.buscar(m.getCodigoCurso());
		imprimir("CÓDIGO        : " + m.getNumeroMatricula());
		switch(x.getEstado()) {
		case 0: imprimir("ESTADO        : REGISTRADO");break;
		case 1: imprimir("ESTADO        : MATRICULADO");break;
		default:imprimir("ESTADO        : RETIRADO");
		}
		imprimir("");
		imprimir("COD. ALUMNO   : " + x.getCodAlumno());
		imprimir("NOMBRES       : " + x.getNombres());
		imprimir("APELLIDOS     : " + x.getApellidos());
		imprimir("DNI           : " + x.getDni());
		imprimir("EDAD          : " + x.getEdad());
		imprimir("CELULAR       : " + x.getCelular());
		imprimir("");
		imprimir("COD. CURSO    : " + c.getCodCurso());
		imprimir("ASIGNATURA    : " + c.getAsignatura());
		imprimir("CICLO         : " + nombreCiclo(c.getCiclo()));
		imprimir("CRÉDITOS      : " + c.getCreditos());
		imprimir("HORAS         : " + c.getHoras());
	}
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboCodigo.addItem(am.obtener(i).getNumeroMatricula());
		}
		cboCodigo.setSelectedIndex(-1);
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
	public int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
}
