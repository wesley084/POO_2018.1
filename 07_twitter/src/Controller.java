import java.util.Scanner;

public class Controller {
	static UserRep userRep;
	private static Scanner scan;
	
	static void print(String str) {
		System.out.println(str);
	}
	
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String line;
		userRep = new UserRep();
		while(true) {
			try {
				System.out.print("");
				line = scan.nextLine();
				String comandos [] = line.split(" ");
				
				switch(comandos[0]) {
					
					case "nwuser":
						userRep.addUser(comandos[1]);
						print("done");
						break;
					
					case "lauser":
						print(userRep.toString());
						break;
						
					case "seguir":
						userRep.seguir(comandos[1], comandos[2]);
						print("done");
						break;
					
					case "twittar":
						String msg = "";
						for (int i = 2; i < comandos.length; i++) 
							msg += comandos[i] + " ";
						userRep.twittar(comandos[1], msg);
						print("done");
						break;
					
					case "mytweets":
						print(userRep.myTwets(comandos[1]));
						break;
					
					case "timeline":
						print(userRep.timeline(comandos[1]));
						break;
						
					case "unread":
						print(userRep.unread(comandos[1]));
						break;
						
					case "like":
						userRep.like(comandos[1], comandos[2]);
						break;
						
					case "laven":
						
						break;
						
					case "saldo":
						
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