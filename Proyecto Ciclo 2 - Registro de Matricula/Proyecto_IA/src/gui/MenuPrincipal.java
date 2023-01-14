package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;

public class MenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmMantAlumno;
	private JMenuItem mntmMantCurso;
	private JMenuItem mntmRegRetiro;
	private JMenuItem mntmRegMatricula;
	private JMenuItem mntmConsAlumno;
	private JMenuItem mntmConsCurso;
	private JMenuItem mntmConsMatricula;
	private JMenuItem mntmConsRetiro;
	private JMenuItem mntmAlumMatPendiente;
	private JMenuItem mntmAlumMatVigente;
	private JMenuItem mntmAlumMatCurso;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setLocationRelativeTo(null);
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 700);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setMnemonic('M');
		menuBar.add(mnMantenimiento);
		
		mntmMantAlumno = new JMenuItem("Alumno");
		mntmMantAlumno.addActionListener(this);
		mnMantenimiento.add(mntmMantAlumno);
		
		mntmMantCurso = new JMenuItem("Curso");
		mntmMantCurso.addActionListener(this);
		mnMantenimiento.add(mntmMantCurso);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setMnemonic('R');
		menuBar.add(mnRegistro);
		
		mntmRegMatricula = new JMenuItem("Matricula");
		mntmRegMatricula.addActionListener(this);
		mnRegistro.add(mntmRegMatricula);
		
		mntmRegRetiro = new JMenuItem("Retiro");
		mntmRegRetiro.addActionListener(this);
		mnRegistro.add(mntmRegRetiro);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setMnemonic('C');
		menuBar.add(mnConsulta);
		
		mntmConsAlumno = new JMenuItem("Alumno");
		mntmConsAlumno.addActionListener(this);
		mnConsulta.add(mntmConsAlumno);
		
		mntmConsCurso = new JMenuItem("Curso");
		mntmConsCurso.addActionListener(this);
		mnConsulta.add(mntmConsCurso);
		
		mntmConsMatricula = new JMenuItem("Matricula");
		mntmConsMatricula.addActionListener(this);
		mnConsulta.add(mntmConsMatricula);
		
		mntmConsRetiro = 
				new JMenuItem("Retiro");
		mntmConsRetiro.addActionListener(this);
		mnConsulta.add(mntmConsRetiro);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setMnemonic('p');
		menuBar.add(mnReporte);
		
		mntmAlumMatPendiente = new JMenuItem("Alumnos con matricula pendiente");
		mntmAlumMatPendiente.addActionListener(this);
		mnReporte.add(mntmAlumMatPendiente);
		
		mntmAlumMatVigente = new JMenuItem("Alumnos con matricula vigente");
		mntmAlumMatVigente.addActionListener(this);
		mnReporte.add(mntmAlumMatVigente);
		
		mntmAlumMatCurso = new JMenuItem("Alumnos matriculados por curso");
		mntmAlumMatCurso.addActionListener(this);
		mnReporte.add(mntmAlumMatCurso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		try {
			desktopPane = new JDesktopPane(){
			Image img = javax.imageio.ImageIO.read(
					new java.net.URL(getClass().getResource("/imagenes/fondoframes.jpg"),"fondoframes.jpg")
					);
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(img !=null) g.drawImage(img, 0,0,this.getWidth(),this.getHeight(),this);
				else g.drawString("Image not found",100,100);
			}
		};
		}catch (IOException e) {
			e.printStackTrace();
		}

		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmAlumMatCurso) {
			actionPerformedMntmAlumMatCurso(e);
		}
		if (e.getSource() == mntmAlumMatVigente) {
			actionPerformedMntmAlumMatVigente(e);
		}
		if (e.getSource() == mntmAlumMatPendiente) {
			actionPerformedMntmAlumMatPendiente(e);
		}
		if (e.getSource() == mntmConsRetiro) {
			actionPerformedMntmConsRetiro(e);
		}
		if (e.getSource() == mntmConsMatricula) {
			actionPerformedMntmConsMatricula(e);
		}
		if (e.getSource() == mntmConsCurso) {
			actionPerformedMntmConsCurso(e);
		}
		if (e.getSource() == mntmConsAlumno) {
			actionPerformedMntmConsAlumno(e);
		}
		if (e.getSource() == mntmRegRetiro) {
			actionPerformedMntmRegRetiro(e);
		}
		if (e.getSource() == mntmRegMatricula) {
			actionPerformedMntmRegMatricula(e);
		}
		if (e.getSource() == mntmMantCurso) {
			actionPerformedMntmMantCurso(e);
		}
		if (e.getSource() == mntmMantAlumno) {
			actionPerformedMntmMantAlumno(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		int valor = JOptionPane.showOptionDialog(null, "¿Desea cerrar el programa?","Confirmar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		if (valor == 0) System.exit(0);
	}
	protected void actionPerformedMntmMantAlumno(ActionEvent e) {
		MantenimientoAlumno mantAlumno = new MantenimientoAlumno();
		mantAlumno.setModal(true);
		mantAlumno.setLocationRelativeTo(this);
		mantAlumno.setVisible(true);
	}
	protected void actionPerformedMntmMantCurso(ActionEvent e) {
		MantenimientoCurso mantCurso = new MantenimientoCurso();
		mantCurso.setModal(true);
		mantCurso.setLocationRelativeTo(this);
		mantCurso.setVisible(true);
	}
	
	protected void actionPerformedMntmRegMatricula(ActionEvent e) {
		RegistroMatricula regMatricula = new RegistroMatricula();
		regMatricula.setModal(true);
		regMatricula.setLocationRelativeTo(this);
		regMatricula.setVisible(true);
	}
	
	protected void actionPerformedMntmRegRetiro(ActionEvent e) {
		RegistroRetiro regRetiro = new RegistroRetiro();
		regRetiro.setModal(true);
		regRetiro.setLocationRelativeTo(this);
		regRetiro.setVisible(true);
	}
	
	protected void actionPerformedMntmConsAlumno(ActionEvent e) {
		ConsultaAlumno consultaAlumno = new ConsultaAlumno();
		consultaAlumno.setModal(true);
		consultaAlumno.setLocationRelativeTo(this);
		consultaAlumno.setVisible(true);
	}
	
	protected void actionPerformedMntmConsCurso(ActionEvent e) {
		ConsultaCurso consultaCurso = new ConsultaCurso();
		consultaCurso.setModal(true);
		consultaCurso.setLocationRelativeTo(this);
		consultaCurso.setVisible(true);
	}
	
	protected void actionPerformedMntmConsMatricula(ActionEvent e) {
		ConsultaMatricula consultaMatricula = new ConsultaMatricula();
		consultaMatricula.setModal(true);
		consultaMatricula.setLocationRelativeTo(this);
		consultaMatricula.setVisible(true);
	}
	
	protected void actionPerformedMntmConsRetiro(ActionEvent e) {
		ConsultaRetiro consultaRetiro = new ConsultaRetiro();
		consultaRetiro.setModal(true);
		consultaRetiro.setLocationRelativeTo(this);
		consultaRetiro.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumMatPendiente(ActionEvent e) {
		ReporteAlumnosMatriculaPendente pendiente = new ReporteAlumnosMatriculaPendente();
		pendiente.setModal(true);
		pendiente.setLocationRelativeTo(this);
		pendiente.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumMatVigente(ActionEvent e) {
		ReporteAlumnosMatriculaVigente vigente = new ReporteAlumnosMatriculaVigente();
		vigente.setModal(true);
		vigente.setLocationRelativeTo(this);
		vigente.setVisible(true);
	}
	
	protected void actionPerformedMntmAlumMatCurso(ActionEvent e) {
		ReporteMatriculadosporCurso curso = new ReporteMatriculadosporCurso();
		curso.setModal(true);
		curso.setLocationRelativeTo(this);
		curso.setVisible(true);
	}
}
