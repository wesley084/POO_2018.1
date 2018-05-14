import java.util.ArrayList;
import java.util.List;

public class Agencia {
	private List<Cliente> clientes;
	
	public Agencia(){
		clientes = new ArrayList<>();
	}

	public boolean addCliente(String cpf){
		for(Cliente c: clientes){
			if(c.getIdCliente().equals(cpf)){
				throw new RuntimeException("CPF já cadastrado");
			}
		}
		
		this.clientes.add(new Cliente(cpf));
		return true;
	}
	
	public boolean abrirNovaConta(String cpf){
		for(Cliente c: clientes){
			if(c.getIdCliente().equals(cpf)){
				c.addConta(new Conta(Conta.ultIdConta++));
				return true;
			}
		}
		
		return false;
	}
	
	public List<Cliente> getClientes(){
		return clientes;
	}
}
