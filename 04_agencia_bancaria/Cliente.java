import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String idCliente;
	private List<Conta> contas;
	
	public Cliente(String idCliente){
		this.idCliente = idCliente;
		this.contas    = new ArrayList<>();
		
		this.contas.add(new Conta(Conta.ultIdConta));
		Conta.ultIdConta++;
	}

	public boolean addConta(Conta conta){
		if(conta == null){
			throw new RuntimeException("Ops, conta nula!");
		}
		
		int qtd = 0;
		for(Conta c: contas){
			if(c.isAtiva()){
				qtd++;
			}
		}
		
		if(qtd == 2){
			throw new RuntimeException("Limite de contas ativas estourado!");
		}
		
		this.contas.add(conta);
		return true;
	}
	
	public boolean encerrarConta(int numero){
		for(Conta c : contas){
			if(c.getNumero() == numero){
				if(c.getSaldo() == 0){
					c.encerrar();
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
	
}
