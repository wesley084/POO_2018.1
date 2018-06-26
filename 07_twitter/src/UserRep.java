
public class UserRep {
	private Repositorio<User> allUsers;
	
	public UserRep() {
		this.allUsers = new Repositorio<User>("user");
	}
	
	@Override
	public String toString() {
		String saida = "";
		for (User user : this.allUsers.getAll())
			saida += user.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	boolean addUser(String _nomeUser) {
		this.allUsers.add(_nomeUser, new User(_nomeUser));
		return true;
	}
	
	String laUser() {
		String saida = "";
		for (User user : this.allUsers.getAll()) 
			saida += user.toString();
		return saida;
	}
	
	boolean seguir(String _user1, String _user2) {
			this.allUsers.get(_user2); //testar_se_user2_existe_antes_de_adicionar_em_user1
			this.allUsers.get(_user1).seguidos.add(_user2, _user2);
			this.allUsers.get(_user2).seguidores.add(_user1, _user1);
			return true;
	}
	
	boolean notificarTweet(String _destinatario, Tweet _tweet) {
		this.allUsers.get(_destinatario).timeLine.add(_tweet.idTweet, _tweet);
		this.allUsers.get(_destinatario).naoLidos++;
		return true;
	}
	
	boolean twittar(String _userName, String _msg) {
		String _id = TweetManager.gerarTweetId();
		this.allUsers.get(_userName).myTweets.add(_id, new Tweet(_id, _userName, _msg));
		for (String seguidor : allUsers.get(_userName).seguidores.getAll())
			notificarTweet(seguidor, new Tweet(_id, _userName, _msg));  // colocando_na_TL_dos_seguidores
		return true;
	}
	
	String myTwets(String _userName) {
		String saida = "";
		for (Tweet twt : this.allUsers.get(_userName).myTweets.getAll())
			saida = twt.toString() + "\n" + saida;
		if(saida.equals(""))
			return "Nenhum tweet em myTweets de " + _userName;
		return saida.substring(0, saida.length()-1);
	}
	
	String timeline (String _userName) {
		String saida = "";
		for (Tweet twt : this.allUsers.get(_userName).timeLine.getAll())
			saida = twt.toString() + "\n" + saida;
		allUsers.get(_userName).naoLidos = 0;
		if(saida.equals(""))
			return "Nenhum tweet na TimeLine de " + _userName;
		return saida.substring(0, saida.length()-1);
	}
	
	String unread(String _userName) {
		String saida = "";
		if (allUsers.get(_userName).naoLidos == 0)
			return "Nenhum novo Tweet " + _userName;
		int i = allUsers.get(_userName).timeLine.getAll().size() - allUsers.get(_userName).naoLidos;  //def_a_part_n_lida
		for (i=i+0; i < allUsers.get(_userName).timeLine.getAll().size(); i++)
			saida = allUsers.get(_userName).timeLine.getAll().get(i).toString() + "\n" + saida;  //colocando_em_primeiro_o_last
		allUsers.get(_userName).naoLidos = 0;
		return saida.substring(0, saida.length()-1);
	}
	
	boolean like(String _curtidor, String _idTweet) {
		Tweet tweet = allUsers.get(_curtidor).timeLine.get(_idTweet);
		allUsers.get(tweet.userName).myTweets.get(_idTweet).likes.add(_curtidor);
		for (String _userN : allUsers.get(tweet.userName).seguidores.getAll())
			allUsers.get(_userN).timeLine.get(_idTweet).likes.add(_curtidor);
		return true;
	}
	
}
