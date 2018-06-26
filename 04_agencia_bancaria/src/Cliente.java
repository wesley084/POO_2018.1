
public class Cliente {
	private String idCliente;
	Repositorio<Conta> contas;
	
	public Cliente(String idCliente){
		this.idCliente = idCliente;
		this.contas = new Repositorio<Conta>("");
	}
	
	@Override
	public String toString() {
		String saida = "";
		for (Conta con : this.contas.getAll()) 
			saida += con.getNumero() + " ";
		return saida;
	}
	
	boolean encerrarConta(String numero) {
		this.contas.get(numero); //teste_existe
		int ativas = 0;
		for (Conta conta : this.contas.getAll())
			if (conta.isAtiva()) 
				ativas++;
		if (ativas == 1)
			throw new RuntimeException("fail: voce precisa ter pelo menos uma conta ativa");
		if (!this.contas.get(numero).isAtiva()) 
			throw new RuntimeException("fail: conta ja inativa");
		if (this.contas.get(numero).getSaldo() != 0)
			throw new RuntimeException("fail: so contas com saldo ZERO podem ser encerradas");
		this.contas.get(numero).setAtiva(false);
		return true;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	
}
