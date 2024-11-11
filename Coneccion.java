package trabajo_practico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {
	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/income";
	private static final String Usuario = "root";
	private static final String Contraseña = "AnaPedro215@";
	
	static {
		try {
			Class.forName(Controlador);
			System.out.println("Controlador cargado");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Controlador no cargado");
		}
	}
	

	public Connection conectar() {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(URL, Usuario, Contraseña);
			System.out.println("Conexión cargada");
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println("Conexión no cargada");
		}
		return conexion;
	}
	
}

