package gui;

import arreglos.*;
import clases.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ReporteAlumnosMatriculaVigente extends JDialog implements ActionListener {
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReporteAlumnosMatriculaVigente dialog = new ReporteAlumnosMatriculaVigente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteAlumnosMatriculaVigente() {
		setTitle("Alumnos con Matricula Vigente");
		setBounds(100, 100, 624, 592);
		getContentPane().setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListar.setBounds(254, 10, 103, 28);
		getContentPane().add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 48, 590, 497);
		getContentPane().add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtResultado);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ReporteAlumnosMatriculaVigente.class.getResource("/imagenes/fondoframes.jpg")));
		lblNewLabel.setBounds(0, 0, 608, 553);
		getContentPane().add(lblNewLabel);
	}
	
	//DECLARACION GLOBAL
	ArregloAlumnos aa = new ArregloAlumnos();
	private JLabel lblNewLabel;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtResultado.setText("");
		for (int i = 0; i < aa.tamaño(); i++) {
			if (aa.obtener(i).getEstado() == 1) {
				imprimir(" CÓDIGO    : " + aa.obtener(i).getCodAlumno());
				imprimir(" NOMBRES   : " + aa.obtener(i).getNombres());
				imprimir(" APELLIDOS : " + aa.obtener(i).getApellidos());
				imprimir(" DNI       : " + aa.obtener(i).getDni());
				imprimir(" EDAD      : " + aa.obtener(i).getEdad());
				imprimir(" CELULAR   : " + aa.obtener(i).getCelular());
				imprimir(" ESTADO    : " + nombreEstado(aa.obtener(i).getEstado()));
				imprimir("-------------------------------------------------------------------------");
			}
		}
	}
	
	String nombreEstado(int i) {
		switch (i) {
		case 0: return "REGISTRADO";
		case 1: return "MATRICULADO";
		case 2: return "RETIRADO";
		default: return null;
		}
	}
	
	void imprimir(String s) {
		txtResultado.append(s + "\n");
	}
}
