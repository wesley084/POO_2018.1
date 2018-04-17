import java.util.ArrayList;

class Espiral{
	private String nome;
	private int quantidade;
	private float preco;
	
	public Espiral(String nome, int quantidade, float preco) {
		this.setNome(nome);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
	}

	@Override
	public String toString() {
		String saida = "";
		saida += "["+this.nome+ " : "+this.quantidade+" U : "+this.preco+" RS]\n";
		return saida;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}

public class Maquina {
	private float Lucro;
	private float saldoCliente;
	ArrayList<Espiral> espirais;
	private int maxProdutos;
	private int numEspirais;
	
	public Maquina(int numEspirais, int maxProdutos) {
		this.saldoCliente = 0;
		this.Lucro = 0;
		espirais = new ArrayList<Espiral>();
		this.setMaxProdutos(maxProdutos);
		this.setNumEspirais(numEspirais);
	}

	void iniciar(){
		for (int i = 0; i < this.numEspirais; i++)
			espirais.add(new Espiral("-", 0, 0));
	}
	
	boolean inserirDin(float valor) {
		if(valor<0)
			throw new RuntimeException("Fail:Valor negativo nao aceito!");
		this.saldoCliente += valor;
		return true;
	}
	
	String pedirTroco() {
		if(this.saldoCliente <= 0)
			throw new RuntimeException("Fail:Nao possui nenhum saldo na maquina!");
		float troco = this.saldoCliente;
		this.saldoCliente = 0;
		return "Voce recebeu: RS "+troco;
	}
	
	String comprar(int indice) {
		if((indice < 0) || (indice >= espirais.size()))
			throw new RuntimeException("Fail:Indice "+ indice +" nao existe!");
		if(espirais.get(indice).getQuantidade() == 0) 
			throw new RuntimeException("Fail: Espiral sem produtos!");
		if(this.saldoCliente < espirais.get(indice).getPreco())
			throw new RuntimeException("Fail: "+espirais.get(indice).getNome()+" valor: R$ "+espirais.get(indice).getPreco()+" saldo insuficiente");
		espirais.get(indice).setQuantidade(espirais.get(indice).getQuantidade() - 1);
		this.saldoCliente -= espirais.get(indice).getPreco();
		return "Você comprou um(a) " + espirais.get(indice).getNome() + ". Saldo: RS " + this.saldoCliente;
	}
	
	boolean altEspiral(int indice, String prod, int quant, float valor){
		if(quant > this.maxProdutos)
			throw new RuntimeException("Fail:Quantidade maior que maximo permitido!");
		if(valor<0)
			throw new RuntimeException("Fail:Nao sao aceitos produtos de valor negativo!");
		if((indice < 0) || (indice >= espirais.size()))
			throw new RuntimeException("Fail:Indice "+ indice +" nao existe!");
		espirais.set(indice, new Espiral(prod, quant, valor));
		return true;
	}
	
	float mostrarLucro() {
		return this.Lucro;
	}
	
	@Override
	public String toString() {
		String saida = "Saldo: RS " + this.saldoCliente + "\n";
		for (int i = 0; i < espirais.size(); i++) 
			saida += i + " " + espirais.get(i);
		return saida.substring(0, saida.length()-1);
	}
	
	public float getLucro() {
		return Lucro;
	}

	public float getSaldoCliente() {
		return saldoCliente;
	}

	public int getMaxProdutos() {
		return maxProdutos;
	}

	public void setMaxProdutos(int maxProdutos) {
		this.maxProdutos = maxProdutos;
	}

	public int getNumEspirais() {
		return numEspirais;
	}

	public void setNumEspirais(int numEspirais) {
		this.numEspirais = numEspirais;
	}
}
