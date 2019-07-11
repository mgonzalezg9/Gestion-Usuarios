package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Usuario;

public class UsuariosJDBC {
	// TODO Atributos de clase
	private final String SQL_INSERT = "INSERT INTO USUARIO(usuario, password) VALUES (?,?)";
	private final String SQL_UPDATE = "UPDATE USUARIO SET usuario=?, password=? WHERE id_usuario=?";
	private final String SQL_DELETE = "DELETE FROM USUARIO WHERE id_usuario=?";
	private final String SQL_SELECT = "SELECT * FROM USUARIO ORDER BY id_usuario";

	// Atributos
	private Connection userConn;

	// Constructores
	public UsuariosJDBC() {
		userConn = Conexion.getConnection();
	}

	public UsuariosJDBC(Connection c) {
		userConn = c;
	}

	public int insert(String usuario, String password) {
		PreparedStatement stmt = null;
		int rows = 0;

		try {
			if (userConn.isClosed()) {
				userConn = Conexion.getConnection();
			}
			stmt = userConn.prepareStatement(SQL_INSERT);
			int index = 1;
			stmt.setString(index++, usuario);
			stmt.setString(index++, password);
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(userConn);
		}

		return rows;
	}

	public int update(int id_usuario, String usuario, String password) {
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			if (userConn.isClosed()) {
				userConn = Conexion.getConnection();
			}
			stmt = userConn.prepareStatement(SQL_UPDATE);
			int index = 1;
			stmt.setInt(index++, id_usuario);
			stmt.setString(index++, usuario);
			stmt.setString(index++, password);
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(userConn);
		}

		return rows;
	}

	public int delete(int id_usuario) {
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			if (userConn.isClosed()) {
				userConn = Conexion.getConnection();
			}
			stmt = userConn.prepareStatement(SQL_DELETE);
			int index = 1;
			stmt.setInt(index++, id_usuario);
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(userConn);
		}

		return rows;
	}

	public List<Usuario> select() {
		PreparedStatement stmt = null;
		LinkedList<Usuario> usuarios = new LinkedList<>();
		ResultSet rs = null;
		
		try {
			if (userConn.isClosed()) {
				userConn = Conexion.getConnection();
			}
			stmt = userConn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			// Cada fila se añade a la lista de usuarios
			while (rs.next()) {
				usuarios.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.close(stmt);
			Conexion.close(rs);
			Conexion.close(userConn);
		}

		return usuarios;
	}

}
