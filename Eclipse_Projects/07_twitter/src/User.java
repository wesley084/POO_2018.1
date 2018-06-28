
public class User {
	String nomeUser;
	int naoLidos;
	Repositorio<Tweet> timeLine;
	Repositorio<Tweet> myTweets;
	Repositorio<String> seguidores;
	Repositorio<String> seguidos;
	
	public User(String _nomeUser) {
		this.nomeUser = _nomeUser;
		this.naoLidos = 0;
		this.timeLine = new Repositorio<Tweet>("tweet");
		this.myTweets = new Repositorio<Tweet>("tweet");
		this.seguidores = new Repositorio<String>("user");
		this.seguidos = new Repositorio<String>("user");
	}
	
	@Override
	public String toString() {
		String saida = this.nomeUser + "\n  seguidos [ ";
		for (String segd : this.seguidos.getAll())
			saida += segd + " ";
		saida += "] \n  seguindo [ ";
		for (String seg : this.seguidores.getAll())
			saida += seg + " ";
		return saida + "]";
	}
}
