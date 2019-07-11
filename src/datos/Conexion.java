package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class Conexion {
	// Constantes
	private static final String JDBC_URL = "jdbc:mysql://localhost/sga?useSSL=false";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "admin";

	// Métodos de acceso a la base de datos
	public static Connection getConnection() throws SQLException {
		// FIXME Puede no funcionar a priori
		try {
			// Se crea y registra el nuevo driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			System.err.println("Fallo en la carga del driver");
		}

		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
