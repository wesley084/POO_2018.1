import java.util.Scanner;

public class Controller {
	private static Scanner scan;
	//função da preguiça
	static void print(String str) {
		System.out.println(str);
	}
	//principal
	public static void main(String[] args) {
		Sistema system = new Sistema();
		scan = new Scanner(System.in);
		String line;
		
		while(true) {
			try {
				System.out.print(">> ");
				line = scan.nextLine();
				String comandos [] = line.split(" ");
				
				switch(comandos[0]) {
					
					case "addUser":
						system.addUser(comandos[1], comandos[2]);
						print("done");
						break;
					
					case "showUsers":
						print(system.showUsers());
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
