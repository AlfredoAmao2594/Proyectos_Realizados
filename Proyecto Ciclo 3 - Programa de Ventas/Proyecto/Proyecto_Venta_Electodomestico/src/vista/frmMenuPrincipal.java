package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMenuPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmComprobante;
	private JMenuItem mntmCliente;
	private JMenu mnRegistros;
	private JMenuItem mntmTicket;
	private JMenu mnConsultas;
	private JMenuItem mntmTicketConsulta;
	private JDesktopPane desktopPane;
	private JMenuItem mntmProducto;
	private JMenuItem mntmProveedor;
	private JMenuItem mntmDocumentosIdentidad;
	private JMenuItem mntmCerrar;
	private JMenuItem mntmConsultasProductos;
	private JMenu mnReportes;
	private JMenuItem mntmReporteTickets;
	private JMenuItem mntmGenerarComprobante;
	private JMenuItem mntmConsultaComprobante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					frmMenuPrincipal frame = new frmMenuPrincipal();
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
	public frmMenuPrincipal() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Articulos_Libreria\\src\\iconos\\principal.png"));
		setTitle("SISTEMA DE VENTA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 849,623);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmUsuario(e);
			}
		});
		mntmUsuario.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/producto.png")));
		mnMantenimiento.add(mntmUsuario);
		
		mntmComprobante = new JMenuItem("Comprobante de Pago");
		mntmComprobante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmComprobante(e);
			}
		});
		mntmComprobante.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/documento.png")));
		mnMantenimiento.add(mntmComprobante);
		
		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmCliente(e);
			}
		});
		mntmCliente.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/cliente.png")));
		mnMantenimiento.add(mntmCliente);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmProducto(e);
			}
		});
		mntmProducto.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\producto (2).png"));
		mnMantenimiento.add(mntmProducto);
		
		mntmProveedor = new JMenuItem("Proveedor");
		mntmProveedor.addActionListener(this);
		mntmProveedor.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\proveedor (2).png"));
		mnMantenimiento.add(mntmProveedor);
		
		mntmDocumentosIdentidad = new JMenuItem("Documentos de Identidad");
		mntmDocumentosIdentidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmDocumentos(e);
			}
		});
		mntmDocumentosIdentidad.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\documento (2).png"));
		mnMantenimiento.add(mntmDocumentosIdentidad);
		
		mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmCerrar(e);
			}
		});
		mntmCerrar.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\cancelar.png"));
		mnMantenimiento.add(mntmCerrar);
		
		mnRegistros = new JMenu("Registrar");
		mnRegistros.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/registrar.png")));
		menuBar.add(mnRegistros);
		
		mntmTicket = new JMenuItem("Generar Ticket");
		mntmTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmTicket(e);
			}
		});
		mntmTicket.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/registrar_compra.png")));
		mnRegistros.add(mntmTicket);
		
		mntmGenerarComprobante = new JMenuItem("Generar Comprobante de Pago");
		mntmGenerarComprobante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmGenerarComprobante(e);
			}
		});
		mntmGenerarComprobante.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\registrar_venta.png"));
		mnRegistros.add(mntmGenerarComprobante);
		
		mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/reporte.png")));
		menuBar.add(mnConsultas);
		
		mntmTicketConsulta = new JMenuItem("Consultas de Ticket");
		mntmTicketConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmTicketReporte(e);
			}
		});
		mntmTicketConsulta.setIcon(new ImageIcon(frmMenuPrincipal.class.getResource("/iconos/reporte_compra.png")));
		mnConsultas.add(mntmTicketConsulta);
		
		mntmConsultasProductos = new JMenuItem("Cosultas Productos");
		mntmConsultasProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConsultasProductos(e);
			}
		});
		mntmConsultasProductos.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\igv.png"));
		mnConsultas.add(mntmConsultasProductos);
		
		mntmConsultaComprobante = new JMenuItem("Consulta Comprobante");
		mntmConsultaComprobante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConsultaComprobante(e);
			}
		});
		mntmConsultaComprobante.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\factura.png"));
		mnConsultas.add(mntmConsultaComprobante);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\reporte_venta.png"));
		menuBar.add(mnReportes);
		
		mntmReporteTickets = new JMenuItem("Reporte Tickets");
		mntmReporteTickets.setIcon(new ImageIcon("D:\\informatica y programacion\\CICLO III\\Lenguaje de Programacion I\\Proyecto\\Proyecto_Venta_Electodomestico\\src\\iconos\\reporte_ticket.png"));
		mntmReporteTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmReporteTickets(e);
			}
		});
		mnReportes.add(mntmReporteTickets);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		try {
			desktopPane = new JDesktopPane(){
			Image img = javax.imageio.ImageIO.read(
					new java.net.URL(getClass().getResource("/img/fondo.jfif"),"fondo.jfif")
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
		if(e.getSource()==mntmProveedor) {
			actionPerformedMntmProveedor(e);
		}	
	}
	
	int confirmar(String mensaje) {
		return JOptionPane.showConfirmDialog(this, mensaje, "Alerta", 0, 1, null);
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	protected void actionPerformedMntmProveedor(ActionEvent arg0) {
		frmProveedor dp = new frmProveedor();
		desktopPane.add(dp);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = dp.getSize();
		dp.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		dp.setVisible(true);
	}
	protected void actionPerformedMntmDocumentos(ActionEvent e) {
		frmDocumentosIdentidad tp = new frmDocumentosIdentidad();
		desktopPane.add(tp);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = tp.getSize();
		tp.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		tp.setVisible(true);
	}
	protected void actionPerformedMntmComprobante(ActionEvent e) {
		frmDocumentosPago dp = new frmDocumentosPago();
		desktopPane.add(dp);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = dp.getSize();
		dp.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		dp.setVisible(true);
	}
	protected void actionPerformedMntmProducto(ActionEvent e) {
		frmProducto pr = new frmProducto();
		desktopPane.add(pr);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = pr.getSize();
		pr.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		pr.setVisible(true);
	}
	protected void actionPerformedMntmCliente(ActionEvent e) {
		
		frmCliente cl = new frmCliente();
		desktopPane.add(cl);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = cl.getSize();
		cl.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		cl.setVisible(true);
	}
	protected void actionPerformedMntmUsuario(ActionEvent e) {
		
		frmUsuario us = new frmUsuario();
		desktopPane.add(us);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = us.getSize();
		us.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		us.setVisible(true);
	}
	protected void actionPerformedMntmCerrar(ActionEvent e) {
		
		int ok = confirmar("¿ Desea salir del sistema ?");
		
		if (ok ==0) {
			this.dispose();
		}
		else
		{
			
		}
		
	}
	protected void actionPerformedMntmTicket(ActionEvent e) {
		frmRegistrarTicket us = new frmRegistrarTicket();
		desktopPane.add(us);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = us.getSize();
		us.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		us.setVisible(true);
	}
	protected void actionPerformedMntmTicketReporte(ActionEvent e) {
		
		frmConsultaTicket us = new frmConsultaTicket();
		desktopPane.add(us);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = us.getSize();
		us.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		us.setVisible(true);
	}
	protected void actionPerformedMntmConsultasProductos(ActionEvent e) {
		
		frmConsultaProducto us = new frmConsultaProducto();
		desktopPane.add(us);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = us.getSize();
		us.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		us.setVisible(true);
		
	}
	protected void actionPerformedMntmReporteTickets(ActionEvent e) {
		
		frmReporteTicket us = new frmReporteTicket();
		desktopPane.add(us);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = us.getSize();
		us.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		us.setVisible(true);
	}
	protected void actionPerformedMntmGenerarComprobante(ActionEvent e) {
		
		frmRegistrarComprobante us = new frmRegistrarComprobante();
		desktopPane.add(us);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = us.getSize();
		us.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		us.setVisible(true);
	}
	protected void actionPerformedMntmConsultaComprobante(ActionEvent e) {
		
		frmConsultaComprobante us = new frmConsultaComprobante();
		desktopPane.add(us);
		
		Dimension desktopSize = desktopPane.getSize();
		Dimension FrameSize = us.getSize();
		us.setLocation((desktopSize.width-FrameSize.width)/2,(desktopSize.height-FrameSize.height)/2);
		us.setVisible(true);
		
	}
}
