import java.util.ArrayList;

public class Sistema {
	Repositorio<Usuario> usuarios;
	private Usuario currentUser;
	
	public Sistema() {
		this.usuarios = new Repositorio<Usuario>("usuario");
	}
	
	boolean addUser(String username, String password) {
		usuarios.add(username, new Usuario(username, password));
		return true;
	}
	
	String showUsers() {
		String saida = "";
		ArrayList<Usuario> all = usuarios.getAll();
		for (int i = 0; i < all.size(); i++) {
			saida+=all.get(i).getUsuario() + "\n";
		}
		return saida.substring(0,saida.length()-1);
	}

	public Usuario getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Usuario currentUser) {
		this.currentUser = currentUser;
	}
}
