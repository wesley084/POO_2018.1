public class Animal {
	private int idAni;
	private String nomeAni;
	private String especieAni;
	
	public Animal(int _id, String _nome, String _especie) {
		this.idAni = _id;
		this.nomeAni = _nome;
		this.especieAni = _especie;	
	}

	@Override
	public String toString() {
		String saida = "["+ getIdAni() +":"+ getNome()  +":"+ getEspecie() +"]";
		return saida;
	}
	
	
	public int getIdAni() {
		return idAni;
	}
	public String getNome() {
		return nomeAni;
	}
	public String getEspecie() {
		return especieAni;
	}
	public void setNome(String nome) {
		this.nomeAni = nome;
	}
}
