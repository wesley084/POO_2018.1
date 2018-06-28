import java.text.Collator;
import java.util.Arrays;

public class Talk implements Chat{
	Repositorio<Zap> zaps;
	String talkId;
	String membros[] = new String[2];
	
	public Talk(String _user1, String _user2) {
		this.membros[0] = _user1;
		this.membros[1] = _user2;
		Arrays.sort(membros, Collator.getInstance());
		this.talkId = membros[0] +"-"+ membros[1];
		zaps = new Repositorio<Zap>("zap");
	}
	
	@Override
	public boolean enviarZap(Zap _zap) {
		if(!this.membros[0].equals(_zap.userName) && !this.membros[1].equals(_zap.userName))
			throw new RuntimeException("fail: "+_zap.userName+ " nao participa desse talk");
		zaps.add(_zap);
		return true;
	}
	
	@Override
	public boolean addMembro(User _vitima) {
		throw new RuntimeException("fail: voce nao pode adicionar ninguem em chats privados");
	}
	
	@Override
	public boolean leave(String _user) {
		throw new RuntimeException("fail: Voce nao pode sair de um chat privado");
	}
	
	@Override
	public String getChatId() {
		return talkId;
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
	public String getMembrosName() {
		return "[ "+ this.membros[0] + " " + this.membros[1] + " ]";
	}

	@Override
	public int getNumDeZaps() {
		return this.zaps.getAll().size();
	}
}
