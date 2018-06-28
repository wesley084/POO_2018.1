
public class Tweet {
	String idTweet;
	String userName;
	String msg;
	Repositorio<String> likes;
	
	public Tweet(String _idTweet, String _userName, String _msg) {
		this.idTweet = _idTweet;
		this.userName = _userName;
		this.msg = _msg;
		likes = new Repositorio<String>("user");
	}
	
	@Override
	public String toString() {
		String saida = idTweet + " " + userName + ": " + msg + " { ";
		for (String like : likes.getAll())
			saida += like + " ";
		return saida + "}";
	}
}
