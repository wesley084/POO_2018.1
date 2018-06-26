public class Conta {
	static int nextContaId = 1000;
	private float saldo;
	private int numero;
	private Repositorio<Operacao> extrato;
	private boolean ativa;
	
	public Conta(int numero){
		this.numero = numero;
		this.saldo = 0;
		this.extrato = new Repositorio<Operacao>("operacao");
		this.ativa = true;
	}

	@Override
	public String toString() {
		return this.numero + ", Saldo: RS " + this.saldo + " Ativa: " + isAtiva();
	}
	
	boolean depositar(float valor){
		if (!isAtiva()) 
			throw new RuntimeException("fail: conta inativa");
		if(Agencia.currentUser == null)
			throw new RuntimeException("fail: nao ha ninguem logado");
		if (valor<0)
			throw new RuntimeException("fail: valor negativo nao aceito");
		saldo += valor;
		extrato.add(new Operacao("deposito", valor, this.saldo));
		return true;
	}
	
	boolean sacar(float valor){
		if (!isAtiva()) 
			throw new RuntimeException("fail: conta inativa");
		if(Agencia.currentUser == null)
			throw new RuntimeException("fail: nao ha ninguem logado");
		if (valor < 0)
			throw new RuntimeException("fail: valor negativo nao aceito");
		if (valor > saldo)
			throw new RuntimeException("fail: valor maior que saldo");
		saldo -= valor;
		extrato.add(new Operacao("saque", -valor, this.saldo));
		return true;
	}
	
	String gerarExtrato() {
		if (!isAtiva()) 
			throw new RuntimeException("fail: conta inativa");
		String saida = "Conta: " + this.numero + "\n";
		for (Operacao op : extrato.getAll())
			saida += "Operacao: " + op.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	boolean transferir(String numConTrans, float valor){
		if (!isAtiva()) 
			throw new RuntimeException("fail: conta inativa");
		if(Agencia.currentUser == null)
			throw new RuntimeException("fail: nao ha ninguem logado");
		this.saldo += valor;
		this.extrato.add(new Operacao("transferencia com " + numConTrans, valor, this.saldo));
		
		return true;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public float getSaldo() {
		return saldo;
	}

	public Repositorio<Operacao> getExtrato() {
		return extrato;
	}
	
}
