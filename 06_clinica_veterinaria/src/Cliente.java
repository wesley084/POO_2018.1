class Cliente {
	private String idCli = "";
	private String nomeCli = "";
	Repositorio<Animal> animais;
	
	public Cliente(String id, String nome) {
		this.idCli = id;
		this.nomeCli = nome;
		animais = new Repositorio<Animal>("animal");
	}
	
	@Override
	public String toString() {
		String saida = idCli + " : " + nomeCli;
		return saida;
	}
	
	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}	
}