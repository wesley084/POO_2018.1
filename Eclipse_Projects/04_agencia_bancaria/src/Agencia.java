public class Agencia {
	Repositorio<Cliente> clientes;
	static Cliente currentUser;
	
	public Agencia(){
		this.clientes = new Repositorio<Cliente>("cliente");
		currentUser = null;
	}
	
	@Override
	public String toString() {
		String saida = "";
		for (Cliente cli : this.clientes.getAll()) 
			saida += cli.getIdCliente() + " [ " + cli.toString() + "]\n";
		return saida.substring(0, saida.length()-1);
	}
	
	
	String show(){
		if (currentUser == null)
			throw new RuntimeException("fail: nao ha ninguem logado");
		float saldo = 0;
		String saida = "Cliente: " + currentUser.getIdCliente() + "\n";
		for (Conta con : clientes.get(currentUser.getIdCliente()).contas.getAll()) {
			saida += "Conta: " + con.toString() + "\n";
			saldo += con.getSaldo();
		}
		saida += "Saldo total: RS " + saldo;
		return saida;
	}
	
	String addCliente(String cpf) {
		this.clientes.add(cpf, new Cliente(cpf));
		this.clientes.get(cpf).contas.add(Conta.nextContaId + "", new Conta(Conta.nextContaId));
		Conta.nextContaId++;
		return (Conta.nextContaId-1) + "";
	}
	
	String abrirConta(String idCli) {
		int ativas = 0;
		for (Conta conta : this.clientes.get(idCli).contas.getAll())
			if (conta.isAtiva()) 
				ativas++;
		if (ativas >= 2) 
			throw new RuntimeException("fail: limite de contas ativas excedido");
		this.clientes.get(idCli).contas.add(Conta.nextContaId+"", new Conta(Conta.nextContaId));
		Conta.nextContaId++;
		return Conta.nextContaId-1 + "";
	}
	
	boolean encerrarConta(String idCliente, String numConta) {
		if (this.clientes.get(idCliente).encerrarConta(numConta))
			return true;
		return false;
	}
	
	boolean realizaTransf(String numEnvio, String numReceb, float valor) {
		Conta conta1 = null;
		Conta conta2 = null;
		if (valor < 0)
			throw new RuntimeException("fail: valor negativo nao aceito");
		for (Cliente cli : clientes.getAll())
			for (Conta con : cli.contas.getAll())
				if ((con.getNumero()+"").equals(numEnvio)) 
					conta1 = cli.contas.get(numEnvio);
		for (Cliente cli : clientes.getAll())
			for (Conta con : cli.contas.getAll())
				if ((con.getNumero()+"").equals(numReceb))
					conta2 = cli.contas.get(numReceb);
		if (conta1 == null || conta2 == null) 
			throw new RuntimeException("fail: conta nula invalida");
		if (!conta1.isAtiva()) 
			throw new RuntimeException("fail: conta " + conta1.getNumero() + "inativa");
		if (!conta2.isAtiva()) 
			throw new RuntimeException("fail: conta " + conta2.getNumero() + "inativa");
		if (valor > conta1.getSaldo())
			throw new RuntimeException("fail: valor maior que saldo");
		conta1.transferir(numReceb, -valor);
		conta2.transferir(numEnvio, valor);
		return true;
	}
	
	void login(String idCli) {
		if(currentUser != null)
			throw new RuntimeException("fail: ha alguem logado");
		currentUser = this.clientes.get(idCli);
	}
	
	void logout() {
		if (currentUser == null)
			throw new RuntimeException("fail: nao ha ninguem logado");
		currentUser = null;
	}
	
	String getCurrentUserName() {
		if(currentUser == null)
			throw new RuntimeException("fail: nao ha ninguem logado");
		return currentUser.getIdCliente();
	}
}
