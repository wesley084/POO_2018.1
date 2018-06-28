public class Sistema {
	static Repositorio<User> users;
	static Repositorio<Chat> chats;
	public Sistema() {
		users = new Repositorio<User>("user");
		chats = new Repositorio<Chat>("chat");
	}
	
	boolean addUser(String _idUser) {
		users.add(_idUser, new User(_idUser));
		return true;
	}
	
	String allUsers() {
		String saida = "[ ";
		for (User user : users.getAll())
			saida += user.getIdUser() + " ";
		return saida + "]";
	}
	
	String ler(String _user, String chat_id) {	
		String saida = chats.get(chat_id).getUltimosZaps( users.get(_user).userChats.get(chat_id).lidas);
		users.get(_user).userChats.get(chat_id).lidas = chats.get(chat_id).getNumDeZaps();
		return saida.substring(0, saida.length()-1);
	}
	
	boolean newGroup(String _userName, String _idGrup) {
		users.get(_userName).userChats.add(_idGrup, new Tupla(_idGrup));
		chats.add(_idGrup, new Grupo (new User(_userName), _idGrup));
		return true;
	}
	
	boolean newTalk(String _user1, String _user2) {
		Talk talk = new Talk(_user1, _user2);
		users.get(_user1);
		users.get(_user2).userChats.add(talk.talkId, new Tupla(talk.talkId));
		users.get(_user1).userChats.add(talk.talkId, new Tupla(talk.talkId));
		chats.add(talk.talkId, talk);
		return true;
	}
	
	boolean invite(String _userAcao, String _userVitima, String _idGrup) {
		users.get(_userAcao).userChats.get(_idGrup); //testa_invitador_esta_no_grupo/se_existem
		users.get(_userVitima).userChats.add(_idGrup, new Tupla(_idGrup));
		chats.get(_idGrup).addMembro(new User(_userVitima));
		return true;
	}
	
	boolean leave(String _idUser, String _idChat) {
		chats.get(_idChat).leave(_idUser);
		users.get(_idUser).userChats.remove(_idChat);
		return true;
	}
	
	boolean zap(String _idUser, String _idChat, String _txt) {
		users.get(_idUser).userChats.get(_idChat); //verifica_se_user_esta_no_chat
		chats.get(_idChat).enviarZap(new Zap(_idUser, _txt,_idChat));
		return true;
	}
	
	String getUserChats(String _idUser){
		return users.get(_idUser).getChatsNames();
	}
	
	String getMembrosChat(String _idChat){
		return chats.get(_idChat).getMembrosName();
	}
	
}
