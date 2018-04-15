import java.util.Scanner;

public class Controller {
	static Sistema system = null;
	private static Scanner scan;
	
	static void print(String str) {
		System.out.println(str);
	}
	
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String line;
		
		while(true) {
			try {
				System.out.print(">> ");
				line = scan.nextLine();
				String comandos [] = line.split(" ");
				
				switch(comandos[0]) {
					
					case "init":
						system = new Sistema(Float.parseFloat(comandos[1]));
						print("done");
						break;
					
					case "nwcli":
						if (comandos.length<3)
							throw new RuntimeException("Fail: Insira todos os dados!");
						String nome = "";
						for (int i = 2; i < comandos.length; i++) {
							nome += comandos[i] + " ";
						}
						if(system.cadCliente(comandos[1], nome.substring(0, nome.length()-1)))
							print("done");
						break;
					
					case "lacli":
						print(system.listaClientes());
						break;
					
					case "lscli":
						print(system.showTran(comandos[1]));
						break;
					
					case "matar":
						if(system.matar(comandos[1]))
							print("done");
						break;
						
					case "emprestar":
						if(system.emprestar(comandos[1], Float.parseFloat(comandos[2])))
							print("done");
						break;
					
					case "receber":
						if(system.receber(comandos[1], Float.parseFloat(comandos[2])))
							print("done");
						break;
						
					case "latran":
						print(system.listTran());
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
