
public class Operacao {
	private String descricao;
	private float valor;
	private float saldoParcial;
	
	public Operacao(String descricao, float valor, float saldoParcial){
		this.descricao = descricao;
		this.valor = valor;
		this.saldoParcial = saldoParcial;
	}

	@Override
	public String toString() {
		return this.descricao + ", valor: RS " + this.valor + "  saldo: RS " + this.saldoParcial; 
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getSaldoParcial() {
		return saldoParcial;
	}
	
	
}
