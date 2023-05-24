package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConexion {
	
	public static Connection getConexion(){
		Connection con = null;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver"); //instanciamiento de la clase del driver
		String url= "jdbc:mysql://localhost:3306/solicitudes_ventas";//variable String que contiene los datos del servidor
		String usr= "root";//variable String que contiene el dato del usuario
		String psw= "junio1994";//variable String que contiene el dato del password
		con = DriverManager.getConnection(url,usr,psw);// con este m�todo se establece la conexi�n con el servidor
		} catch(ClassNotFoundException e) {
		System.out.println("Error >> Driver no Instalado!!");
		} catch(SQLException e) {
		System.out.println("Error >> de conexi�n con la BD");
		}
		return con;
		}
	
	public static void closeConexion(Connection con){
		
		try {
			con.close();//Sentencia para cerrar la conexi�n
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al cerrar la conexion");
		}
	}
	
	public static void closeStatement(Statement stmt){
		
		try {
			stmt.close();// sentencia para cerrar el statement
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al cerrar el statement");
		}
	}
	

}
