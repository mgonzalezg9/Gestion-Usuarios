package datos;

import java.sql.Connection;
import java.util.List;

import domain.Usuario;

public class UsuariosJDBC {
	// TODO Atributos de clase
	private static final String SQL_INSERT = "";
	private static final String SQL_UPDATE = "";
	private static final String SQL_DELETE = "";
	private static final String SQL_SELECT = "";
	
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
		// TODO
		
		return 0;
	}
	
	public int update(int id_usuario, String usuario, String password) {
		// TODO
		
		return 0;
	}
	
	public int delete(int id_usuario) {
		// TODO
		
		return 0;
	}
	
	public List<Usuario> select() {
		// TODO
		
		return null;
	}
	
	
	
}
