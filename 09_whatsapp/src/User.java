public class User {
	private String idUser;
	Repositorio<Tupla> chats;
	public User(String _idUser) {
		this.setIdUser(_idUser);
		this.chats = new Repositorio<Tupla>("chat");
	}
	
	String notifica() {
		String saida = "[ ";
		for (Tupla tupla : this.chats.getAll()) {
			int sizeChat = 0;
			Chat chat = Sistema.chats.get(tupla.chatId);
			
			if (chat instanceof Grupo) {
				Grupo g = (Grupo) (chat);
				sizeChat = g.zaps.getAll().size();
				for (Zap zap : g.zaps.getAll()) 
					if(zap.userName == this.idUser)
						if(sizeChat > 0)
							sizeChat--;	
			}
			if (chat instanceof Talk) {
				Talk t = (Talk) (chat) ;
				sizeChat = t.zaps.getAll().size();
				for (Zap zap : t.zaps.getAll()) 
					if(zap.userName == this.idUser)
						if(sizeChat > 0)
							sizeChat--;	
			}
			saida += tupla.chatId + "("+ (sizeChat - tupla.lidas) +") ";
		}
		return saida + "]";
	}
	
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
}

