import java.util.ArrayList;

public class Sistema {
	Repositorio<Usuario> usuarios;
	
	public Sistema() {
		this.usuarios = new Repositorio<Usuario>("usuarios");
	}
	
	boolean addUser(String username, String password) {
		usuarios.add(new Usuario(username, password));
		return true;
	}
	
	String showUsers() {
		String saida = "";
		ArrayList<Usuario> all = usuarios.getAll();
		for (int i = 0; i < all.size(); i++) {
			saida+=all.get(i).getUsuario();
		}
		return saida;
	}
}