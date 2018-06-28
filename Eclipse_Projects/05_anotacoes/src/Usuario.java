public class Usuario{
	private String Usuario;
	private String password;
	Repositorio<Nota> notas;
	
	public Usuario(String user, String pass) {
		this.Usuario = user;
		this.password = pass;
		this.notas = new Repositorio<Nota>("nota");
	}
	
	void addNote(Nota nota) {
		notas.add(nota.getTitulo(), nota);
	}
	
	void rmNote(String tit) {
		notas.remove(tit);
	}
	
	String showNotes() {
		String saida = "";
		for (int i = 0; i < notas.getAll().size(); i++) {
			saida += notas.getAll().get(i).getTitulo() + " : " + notas.getAll().get(i).getTexto() + "\n";
		}
		return saida.substring(0, saida.length()-1);
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