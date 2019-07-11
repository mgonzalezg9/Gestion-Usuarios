package domain;

public class Usuario {
	private int id_usuario;
	private String usuario, password;

	public Usuario(int id_usuario, String usuario, String password) {
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.password = password;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public String getPassword() {
		return password;
	}

	public String getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " {" + "id = " + id_usuario + ", usuario = " + usuario + ", password = "
				+ password + "}";
	}
}
