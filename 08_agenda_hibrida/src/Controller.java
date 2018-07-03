import java.util.Scanner;

public class Controller {
	static Agenda agenda;
	private static Scanner scan;
	
	static void print(String str) {
		System.out.println(str);
	}
	
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String line;
		agenda = new Agenda();
		while(true) {
			try {
				System.out.print(">> ");
				line = scan.nextLine();
				String comandos [] = line.split(" ");
				
				switch(comandos[0]) {
					
					case "init":

						break;
					
					case "addContato":
						if (agenda.addCont(comandos[1], comandos))
							print("done");
						break;
					
					case "addNote":
						String txt = "";
						for (int i = 2; i < comandos.length; i++)
							txt += comandos + " ";
						if(agenda.addNote(comandos[1], txt.substring(0, txt.length()-1)))
							print("done");
						break;
					
					case "rmContato":
						if (agenda.rmEntry(comandos[1]))
							print("done");
						break;
						
					case "rmNote":
						if (agenda.rmEntry(comandos[1]))
							print("done");
						break;
						
					case "fav":
						if(agenda.fav(comandos[1]))
							print("done");
						break;	
						
					case "desfav":
						if(agenda.desfav(comandos[1]))
							print("done");
						break;	

					case "lacont":
						print(agenda.lacont());
						break;	
						
					case "lanote":
						print(agenda.lanote());
						break;	
						
					case "lafav":
						print(agenda.lafav());
						break;
						
					case "la":
						print(agenda.la());
						break;
					
					case "rmFone":
						agenda.rmFone(comandos[1], comandos[2]);
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