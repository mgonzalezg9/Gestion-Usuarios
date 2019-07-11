package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {
	// TODO Atributos de clase
	private final static String JDBC_STRING;
	private final static String JDBC_URL;
	private final static String JDBC_USER;
	private final static String JDBC_PASS;

	// Métodos de acceso a la base de datos
	public static Connection getConnection() {
		// TODO
		
		return null;
	}

	public static void close(ResultSet rs) {
		// TODO
	}

	public static void close(PreparedStatement ps) {
		// TODO
	}
	
	public static void close(Connection c) {
		// TODO
	}
}
