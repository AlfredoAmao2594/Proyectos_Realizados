package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoginProyecto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtid;
	private JTextField txtpass;
	private JButton btnIngresar;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProyecto frame = new LoginProyecto();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginProyecto() {
		setTitle("Sistema de Registro ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("BIENVENIDO");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD, 20));
		lblNewLabel.setBounds(111, 11, 148, 55);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(56, 77, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(56, 102, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		txtid.setBounds(149, 77, 96, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		btnIngresar.addActionListener(this);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(149, 99, 96, 20);
		contentPane.add(txtpass);
		
		btnIngresar.setBounds(124, 151, 96, 23);
		contentPane.add(btnIngresar);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LoginProyecto.class.getResource("/imagenes/seguridad.jpg")));
		lblNewLabel_3.setBounds(0, 0, 376, 209);
		contentPane.add(lblNewLabel_3);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		char [] clave = ((JPasswordField) txtpass).getPassword();
		String Contraseña = new String(clave);
		
		if (txtid.getText().equals("Cibertec")&& Contraseña.equals("2022")){
			dispose();
			JOptionPane.showMessageDialog(null,"Bienvenido","Ingresaste al Sistema",JOptionPane.INFORMATION_MESSAGE);
			MenuPrincipal p = new MenuPrincipal();
			p.setExtendedState(MAXIMIZED_BOTH);
			p.setVisible(true);
			}
			else {
			JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
			txtid.setText("");
			txtpass.setText("");
			txtid.requestFocus();
			
		}
		
	}
}
