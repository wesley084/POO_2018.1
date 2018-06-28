import java.util.Scanner;

public class Controller {
	static Agencia agencia;
	private static Scanner scan;
	
	static void print(String str) {
		System.out.println(str);
	}
	
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String line;
		agencia = new Agencia();
		while(true) {
			try {
				System.out.print("");
				line = scan.nextLine();
				String comandos [] = line.split(" ");
				
				switch(comandos[0]) {
					
					case "login":
						agencia.login(comandos[1]);
						print("done");
						break;
					
					case "logout":
						agencia.logout();
						print("done");
						break;
						
					case "addCliente":
						print("done: conta "+ agencia.addCliente(comandos[1]) + " foi adicionada a " + comandos[1]);
						break;
					
					case "showAll":
						print(agencia.toString());
						break;
						
					case "abrirConta":
						print("done: conta " + agencia.abrirConta(comandos[1]) + " adicionada a " + comandos[1]);
						break;
						
					case "encerrarConta":
						agencia.encerrarConta(comandos[1], comandos[2]);
						print("done");
						break;
						
					case "show":
						print(agencia.show());
						break;
						
					case "deposito":
						agencia.clientes.get(agencia.getCurrentUserName()).contas.get(comandos[1]).depositar(Float.parseFloat(comandos[2]));
						print("done");
						break;
					
					case "saque":
						agencia.clientes.get(agencia.getCurrentUserName()).contas.get(comandos[1]).sacar(Float.parseFloat(comandos[2]));
						print("done");
						break;	
					
					case "saldo":
						print("Saldo: RS " + agencia.clientes.get(agencia.getCurrentUserName()).contas.get(comandos[1]).getSaldo());
						break;	
						
					case "extrato":
						print(agencia.clientes.get(agencia.getCurrentUserName()).contas.get(comandos[1]).gerarExtrato());
						break;	
						
					case "transf":
						agencia.realizaTransf(comandos[1], comandos[2], Float.parseFloat(comandos[3]));
						print("done");
						break;
					
					case "init":
						agencia.addCliente("pedro");
						agencia.addCliente("jose");
						agencia.abrirConta("pedro");
						agencia.encerrarConta("pedro", "1000");
						agencia.abrirConta("pedro");
						agencia.abrirConta("jose");
						agencia.login("pedro");
						agencia.clientes.get("pedro").contas.get("1002").depositar(300);
						agencia.clientes.get("pedro").contas.get("1002").sacar(100);
						agencia.logout();
						agencia.login("jose");
						agencia.clientes.get("jose").contas.get("1001").depositar(200);
						agencia.clientes.get("jose").contas.get("1001").depositar(100);
						agencia.realizaTransf("1001", "1002", 80);
						agencia.logout();
						print("done");
						break;
						
					case "exit":
						print("Programa finalizado!");
						System.exit(0);
						break;
						
					default:
						print("Comando nao reconhecido!");
				}
			}
			catch(Exception e){
				print(e.getMessage());
			}
		}
	}

}