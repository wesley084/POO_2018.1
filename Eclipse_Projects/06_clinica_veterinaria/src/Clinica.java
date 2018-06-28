public class Clinica {
	Repositorio<Cliente> allClientes;
	Repositorio<Animal> allAnimais;
	Repositorio<Servico> allServicos;
	Repositorio<Venda> allVendas;
	private int nextAniId;
	private int nextVendaId;

	public Clinica() {
		allClientes = new Repositorio<Cliente>("cliente");
		allAnimais = new Repositorio<Animal>("animal");
		allServicos = new Repositorio<Servico>("servico");
		allVendas = new Repositorio<Venda>("venda");
		this.nextAniId = 1;
		this.nextVendaId = 0;
	}

	boolean nwCli (String _id, String _nome) {
		allClientes.add(_id, new Cliente(_id, _nome));
		return true;
	}
	
	String lsCli (String _cliId) {
		String saida = "cli vader: " + allClientes.get(_cliId).getNomeCli() + " ";
		for (Animal ani : allAnimais.getAll()) 
			saida += ani.toString();
		return saida;
	}
	
	String showCli() {
		String saida = "";
		for (int i = 0; i < allClientes.getAll().size(); i++)
			saida += "cli " + allClientes.getAll().get(i).toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	
	boolean nwAni (String _nomeCLi, String _nomeAni, String _especie) {
		allClientes.get(_nomeCLi).animais.add(_nomeAni, new Animal(nextAniId, _nomeAni, _especie));
		allAnimais.add(nextAniId+"", new Animal(nextAniId, _nomeAni, _especie));
		nextAniId++;
		return true;
	}
	
	String laAni() {
		String saida = "";
		for (int i = 0; i < allAnimais.getAll().size(); i++)
			saida += allAnimais.getAll().get(i).toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	boolean nwSer(String _nomeSer, float _preco) {
		allServicos.add(_nomeSer, new Servico(_nomeSer, _preco));
		return true;
	}
	
	String laSer() {
		String saida = "";
		for (Servico ser : allServicos.getAll()) 
			saida += ser.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	boolean nwVen (String _idCli, String _idAni, String _idSer) {
		allClientes.get(_idCli).animais.get(_idAni);
		allServicos.get(_idSer);
		allVendas.add(nextVendaId+"", new Venda(nextVendaId, _idCli, _idAni, _idSer));
		nextVendaId++;
		return true;
	}
	
	float saldo() {
		float sald = 0.0f;
		for (Venda ven : allVendas.getAll()) {
			sald += allServicos.get(ven.getIdServ()).getValorServ();
		}
		return sald;
	}
	
	String laVen() {
		String saida = "";
		for (Venda ven : allVendas.getAll()) 
			saida += ven.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	public int getNextAnilId() {
		return nextAniId;
	}
	
	public int getNextVendaId() {
		return nextVendaId;
	}
}