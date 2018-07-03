class Numero{	
	String nIdentificador;
	String nNumero;
	
	public Numero(String identifi, String num) {
		nIdentificador = identifi;
		nNumero = num;
	}

}

public class Contato implements Entry{
	String nome = "";
	boolean favorited;
	Repositorio<Numero> numeros;
	
	public Contato(String name) {
		this.numeros = new Repositorio<Numero>("numero");
		this.nome = name;
		this.favorited = false;
	}
	
	@Override
	public String toString() {
		String saida = "";
		if (favorited)
			saida += "@ ";
		else
			saida += "- ";
		saida += "C " + this.nome;
		for (Numero num : this.numeros.getAll()) {
			saida += " [" + num.nIdentificador + ":" + num.nNumero + "]";
		}
		return saida;
	}
	
	boolean update(String[] contatos) {
		for (int i = 2; i < contatos.length; i++) {
			String [] tupla = contatos[i].split(":");
			try {
				this.numeros.add(tupla[0], new Numero(tupla[0], tupla[1]));
			}catch(Exception e){
				//nada_a_fazer
			}
		}
		return true;
	}
	
	boolean addFone(String _ident, String _num) {
		numeros.add(_ident, new Numero(_ident, _num));
		return true;
	}
	
	boolean rmFone(String _ident) {
		this.numeros.remove(_ident);
		return true;
	}
	
	@Override
	public String getId() {
		return this.nome;
	}
	@Override
	public void setId(String id) {
		this.nome = id;
	}
	@Override
	public boolean isFavorited() {
		return this.favorited;
	}
	@Override
	public void setFavorited(boolean value) {
		this.favorited = value;	
	}
}


