import java.util.ArrayList;
import java.util.List;

public class Conta {
	public static int ultIdConta = 1;
	
	private float saldo;
	private int numero;
	private List<Operacao> extrato;
	private boolean ativa;
	
	public Conta(int numero){
		this.numero  = numero;
		this.saldo   = 0;
		this.extrato = new ArrayList<>();
		this.ativa   = true;
	}
	
	public boolean depositar(float valor){
		if(valor <= 0){
			return false;
		}
		
		this.saldo += valor;
		this.extrato.add(new Operacao("deposito", valor, saldo));
		return true;
	}
	
	public boolean sacar(float valor){
		if(valor <= 0){
			throw new RuntimeException("Valor negativo");
		}
		
		if(valor > saldo){
			throw new RuntimeException("Tentativa de saque maior do que o saldo!");
		}
		
		this.saldo -= valor;
		this.extrato.add(new Operacao("saque", valor, saldo));
		return true;
	}
	
	public boolean transferir(Conta other, float valor){
		if(!other.isAtiva()){
			throw new RuntimeException("A conta destino está inativa!");
		}
		
		if(this.sacar(valor)){
			other.depositar(valor);
			return true;
		}
		
		return false;
	}
	
	public void encerrar(){
		this.ativa = false;
	}
	
	public float getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public List<Operacao> getExtrato() {
		return extrato;
	}

	public boolean isAtiva() {
		return ativa;
	}
	
	public String toString(){
		return numero + " - " + saldo + " - " + extrato + " - "+ ativa;
	}
}