import java.util.ArrayList;

class Cliente {
	String idCli = "";
	String nomeCli ="";
	boolean vivo = true;
	float saldoCli = 0.0f;
	
	public Cliente(String id, String nome) {
		idCli = id;
		nomeCli = nome;
	}
	
	@Override
	public String toString() {
		String saida = idCli + ":" + nomeCli + ":" + saldoCli;
		return saida;
	}
}

class Transacao {
	
	int idTran;
	String idCli;
	float valorTran; 
	
	public Transacao(int id, String nome, float valor) {
		idTran = id;
		idCli = nome;
		valorTran = valor;
	}
	
	@Override
	public String toString() {
		String saida = "id:" + idTran + " [" + idCli + " "+ valorTran + "]";
		return saida;
	}
}

class Sistema {
	public static int nextId = 0;
	public static float caixa = 0.0f;
	public static ArrayList<Cliente> clientes;
	public static ArrayList<Transacao> transacoes;
	
	public Sistema(float valor) {
		caixa = valor;
		clientes = new ArrayList<Cliente>();
		transacoes = new ArrayList<Transacao>();
	}
	
	public boolean cadCliente(String id, String nome) {
		for (Cliente cli : clientes) {
			if(cli.idCli.equals(id))
				throw new RuntimeException("Fail: Cliente já existe!");
		}
		clientes.add(new Cliente(id, nome));
		return true;	
	}	
	
	public String listaClientes(){
		String saida = "";
		for (Cliente cliente : clientes) {
			saida += cliente.toString() + "\n";
		}
		if(saida.equals(""))
			saida = "Fail: Nenhum cliente cadastrado!\n";
		return saida.substring(0, saida.length()-1);
	}
	
	public String showTran(String cliId){
		String saida = "";
		for (Transacao tran : transacoes) {
			if(cliId.equals(tran.idCli))
				saida += tran.toString() + "\n";
		}
		if(saida.equals(""))
			saida = "Fail: Nenhuma transacao encontrada!\n";
		return saida.substring(0, saida.length()-1);
	}
	
	public boolean matar(String cliId) {
		for (int i = 0; i < clientes.size(); i++) {
			if(cliId.equals(clientes.get(i).idCli))
				clientes.remove(i);
			else
				throw new RuntimeException("Fail:Cliente "+ cliId +" nao encontrado!");
		}
		for (int i = transacoes.size()-1; i >= 0 ; i--) {
			if(cliId.equals(transacoes.get(i).idCli))
				transacoes.remove(i);
		}
		return true;
	}
	
	public boolean emprestar(String cliId, float valor) {
		if(valor<=0)
			throw new RuntimeException("Fail: Valor invalido!");
		if(cliId.equals(valor>caixa))
			throw new RuntimeException("Fail: Fundos insuficientes!");
		for (int i = 0; i < clientes.size(); i++) {
			if(cliId.equals(clientes.get(i).idCli)) {
				transacoes.add(new Transacao(nextId, cliId, (valor-(2*valor))));
				nextId ++;
				caixa -= valor;
				clientes.get(i).saldoCli -= valor;
				return true;
			}
		}
		throw new RuntimeException("Fail: Cliente "+ cliId +" nao encontrado!");
	}
	
	public boolean receber(String cliId, float valor) {
		if(valor<=0)
			throw new RuntimeException("Fail: Valor invalido!");
		for (int i = 0; i < clientes.size(); i++) {
			if(cliId.equals(clientes.get(i).idCli)) {
				if((valor + clientes.get(i).saldoCli)>0)
					throw new RuntimeException("Fail: Valor maior que divida!");
				transacoes.add(new Transacao(nextId, cliId, valor));
				nextId ++;
				caixa += valor;
				clientes.get(i).saldoCli += valor;
				return true;
			}
		}	
		throw new RuntimeException("Fail: Cliente "+ cliId +" nao encontrado!");
	}
	
	public String listTran() {
		String saida = "";
		for (Transacao tran : transacoes) {
			saida += tran.toString() + "\n";
		}
		if(saida.equals(""))
			saida = "Fail: Nenhuma transacao realizada!\n";
		return saida.substring(0, saida.length()-1);
	}
}
