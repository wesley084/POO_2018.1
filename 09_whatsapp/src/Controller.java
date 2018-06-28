import java.util.Scanner;

public class Controller {
	static Sistema system;
	private static Scanner scan;
	
	static void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		String line;
		system = new Sistema();
		print("Digite um comendo ou help: \n>>");
		while(true) {
			try {
				line = scan.nextLine();
				String comandos [] = line.split(" ");
				
				switch(comandos[0]) {
					
					case "addUser":
						system.addUser(comandos[1]);
						print("done");
						break;
					
					case "allUsers":
						print(system.allUsers());
						break;
						
					case "newTalk":
						system.newTalk(comandos[1], comandos[2]);
						print("done");
						break;
					
					case "notify":
						print(system.users.get(comandos[1]).notifica());
						break;
					
					case "newGroup":
						system.newGroup(comandos[1], comandos[2]);
						print("done");
						break;
						
					case "invite":
						system.invite(comandos[1], comandos[2], comandos[3]);
						print("done");
						break;
						
					case "leave":
						system.leave(comandos[1], comandos[2]);
						print("done");
						break;
					
					case "ler":
						print(system.ler(comandos[1], comandos[2]));
						break;
						
					case "zap":
						String txt = "";
						for (int i = 3; i < comandos.length; i++)
							txt += comandos[i] + " ";
						system.zap(comandos[1], comandos[2], txt.substring(0, txt.length()-1)); 
						print("done");  //uso_substring_pra_remover_ultimo_espaco_em_txt_apenas_estetica_de_exibicao
						break;
						
					case "chats":
						print(system.getUserChats(comandos[1]));
						break;
					
					case "users":
						print(system.getMembrosChat(comandos[1]));
						break;
						
					case "exit":
						print("Programa finalizado!");
						System.exit(0);
						break;
						
					case "help":
						print("* addUser _username");
						print("* allUsers");
						print("* newTalk _user1 _user2");
						print("* notify _username");
						print("* newGroup _username _groupname");
						print("* invite _user1 _user2 _grupId");
						print("* leave _username _chatname");
						print("* ler _username _chatId");
						print("* zap _username _chatId _zap");
						print("* chats _username");
						print("* users _chatId");
						print("* exit");
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
