package manejousuarios;

import java.util.List;
import java.util.Scanner;

import datos.UsuariosJDBC;
import domain.Usuario;

public class ManejoUsuarios {

	public static void main(String[] args) {
		boolean fin = false;
		UsuariosJDBC bd = new UsuariosJDBC(); // Wrapper de la conexion a la base de datos
		Scanner sc = new Scanner(System.in); // Lectura de datos por pantalla

		while (!fin) {
			// Imprimir menú de opciones
			System.out.print("\r\n" + "\r\n" + " _   _                      _           \r\n"
					+ "| | | |                    (_)          \r\n" + "| | | |___ _   _  __ _ _ __ _  ___  ___ \r\n"
					+ "| | | / __| | | |/ _` | '__| |/ _ \\/ __|\r\n"
					+ "| |_| \\__ \\ |_| | (_| | |  | | (_) \\__ \\\r\n"
					+ " \\___/|___/\\__,_|\\__,_|_|  |_|\\___/|___/\r\n"
					+ "                                        \r\n" + "                                        \r\n"
					+ "\r\n" + "");

			System.out.println("1.- Mostrar todos los usuarios");
			System.out.println("2.- Crear usuario nuevo");
			System.out.println("3.- Modificar un usuario existente");
			System.out.println("4.- Borrar un usuario");
			System.out.println("0.- Salir");

			// Leer la opción escogida
			System.out.print("Opción: ");
			int opcion = sc.nextInt();
			System.out.println();

			// Dependiendo de la opción escogida se piden unos datos u otros
			int id_usuario;
			String usuario, password;
			switch (opcion) {
			case 0:
				fin = true;
				System.out.println("* Hasta pronto!");
				break;

			case 1:
				List<Usuario> usuarios = bd.select();
				System.out.println("* Lista con los usuarios:");
				for (Usuario user : usuarios) {
					System.out.println(user);
				}
				break;

			case 2:
				System.out.println("* Usuario nuevo:");
				// Lectura de sus datos
				System.out.print("Nick: ");
				usuario = sc.next();
				System.out.print("Contraseña: ");
				password = sc.next();
				bd.insert(usuario, password);
				System.out.println("* Usuario creado exitosamente");
				break;

			case 3:
				System.out.println("* Usuario a modificar:");
				// Lectura de sus datos
				System.out.print("Id: ");
				id_usuario = sc.nextInt();
				System.out.print("Nick (Nuevo): ");
				usuario = sc.next();
				System.out.print("Contraseña (Nueva): ");
				password = sc.next();
				bd.update(id_usuario, usuario, password);
				System.out.println("* Usuario modificado con éxito");
				break;

			case 4:
				System.out.println("* Usuario a eliminar:");
				// Lectura de sus datos
				System.out.print("Id: ");
				id_usuario = sc.nextInt();
				bd.delete(id_usuario);
				System.out.println("* Usuario borrado exitosamente");
			}
		}
		
		sc.close();

	}

}
