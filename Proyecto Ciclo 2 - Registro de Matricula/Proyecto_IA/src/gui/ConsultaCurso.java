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

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ConsultaCurso extends JDialog implements ActionListener {
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
			ConsultaCurso dialog = new ConsultaCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaCurso() {
		setTitle("Consuta de Curso");
		setBounds(100, 100, 500, 436);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("C\u00F3digo de curso:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 36, 115, 15);
		getContentPane().add(lblNewLabel);
		
		cboCodigo = new JComboBox();
		cboCodigo.setBounds(135, 34, 137, 21);
		getContentPane().add(cboCodigo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setBounds(349, 31, 97, 23);
		getContentPane().add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 466, 298);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConsultaCurso.class.getResource("/imagenes/fondoframes.jpg")));
		lblNewLabel_1.setBounds(0, 0, 484, 397);
		getContentPane().add(lblNewLabel_1);
		
		listarCboCodigo();
	}
	
	//declaraciones globales
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
		} catch (Exception error) {
			mensaje("Seleccione un código de curso");
		}
	}
	
	//Métodos tipo void (sin parámetros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Curso c = ac.buscar(leerCurso());
		imprimir("CÓDIGO               : " + c.getCodCurso());
		imprimir("ASIGNATURA           : " + c.getAsignatura());
		imprimir("CICLO                : " + nombreCiclo(c.getCiclo()));
		imprimir("CANTIDAD DE CRÉDITOS : " + c.getCreditos());
		imprimir("CANTIDAD DE HORAS    : " + c.getHoras());
		imprimir();
		int x = 0;
		for (int i = 0; i < am.tamaño(); i++) {
			if (am.obtener(i).getCodigoCurso() == c.getCodCurso())
				x++;
		}
		if (x == 0) imprimir("NO HAY ALUMNOS MATRICULADOS");
		else if (x == 1) imprimir("HAY " + x + " ALUMNO MATRICULADO");
		else imprimir("HAY " + x + " ALUMNOS MATRICULADOS");
	}
	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodigo.addItem(ac.obtener(i).getCodCurso());
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
//  Métodos tipo void (con parámetros)
	void imprimir(String s){
		txtResultado.append(s + "\n"); 
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//otros metodos
	public int leerCurso() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}
}
