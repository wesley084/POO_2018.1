public class Grupo implements Chat{
	Repositorio<Zap> zaps;
	Repositorio<User> membros;
	String grupId;
	
	public Grupo(User _user, String _grupId) {
		this.zaps = new Repositorio<Zap>("zap");
		this.membros = new Repositorio<User>("membro");
		this.membros.add(_user.getIdUser(), _user);
		this.grupId = _grupId;
	}
	
	@Override
	public boolean enviarZap(Zap _zap) {
		this.membros.get(_zap.userName); //teste_se_eh_membro
		zaps.add(_zap);
		return true;
	}
	
	@Override
	public boolean leave(String _user) {
		membros.remove(_user);
		return true;
	}
	
	@Override
	public boolean addMembro(User _vitima) {
		this.membros.add(_vitima.getIdUser(), _vitima);
		return true;
	}
	
	@Override
	public String getChatId() {
		return grupId;
	}
	
	@Override
	public String getUltimosZaps(int numLidas) {
		String saida = "";
		int numMsgs = zaps.getAll().size();
		if (numMsgs < 1)
			return "nenhuma nova msg";
		for (int i = numMsgs-1; i > numLidas-1; i--) {
			saida += "[" + zaps.getAll().get(i).userName 
					+": " + zaps.getAll().get(i).msg + "]\n";
		}
		return saida;
	}
	
	@Override
	public int getNumDeZaps() {
		return this.zaps.getAll().size();
	}
	
	@Override
	public String getMembrosName() {
		String saida = "[ ";
		for (User user : this.membros.getAll()) 
			saida += user.getIdUser() + " ";
		return saida + "]";
	}
}
