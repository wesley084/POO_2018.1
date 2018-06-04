public class Usuario{
	private String Usuario;
	private String password;
	Repositorio<Nota> notas;
	
	public Usuario(String user, String pass) {
		this.Usuario = user;
		this.password = pass;
		this.notas = new Repositorio<Nota>("notas");
	}
	
	boolean addNote(Nota nota) {
		notas.add(nota.getTitulo(), nota);
		return true;
	}
	
	boolean rmNote(String tit) {
		notas.remove(tit);
		return true;
	}
	
	//gets and sets
	public String getPassword() {
		return password;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
}