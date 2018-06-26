import java.util.Scanner;

public class Controller {
	static Clinica clinica;
	private static Scanner scan;
	
	static void print(String str) {
		System.out.println(str);
	}
	
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String line;
		clinica = new Clinica();
		while(true) {
			try {
				System.out.print("");
				line = scan.nextLine();
				String comandos [] = line.split(" ");
				
				switch(comandos[0]) {
						
					case "nwcli":
						String nome = "";
						for (int i = 2; i < comandos.length; i++)
							nome += comandos[i] + " ";
						clinica.nwCli(comandos[1], nome.substring(0,nome.length()-1));
						print("done");
						break;
					
					case "lacli":
						print(clinica.showCli());
						break;
						
					case "lscli":
						print(clinica.lsCli(comandos[1]));
						break;
					
					case "nwani":
						clinica.nwAni(comandos[1], comandos[2], comandos[3]);
						print("done");
						break;
					
					case "laani":
						print(clinica.laAni());
						break;
					
					case "nwser":
						clinica.nwSer(comandos[1], Float.parseFloat(comandos[2]));
						print("done");
						break;
						
					case "laser":
						print(clinica.laSer());
						break;
						
					case "nwven":
						clinica.nwVen(comandos[1], comandos[2], comandos[3]);
						print("done");
						break;
						
					case "laven":
						print(clinica.laVen());
						break;
						
					case "saldo":
						print("Saldo R$ " + clinica.saldo());
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
