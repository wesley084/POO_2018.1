import java.util.Scanner;

public class Controller {
	private static Scanner scan;
	//funcao da preguica
	static void print(String str) {
		System.out.println(str);
	}
	//funcao verifica se tem alguem logado
	static boolean alguemLogado(Sistema sys) {
		if (sys.getCurrentUser() == (null)) {
			print("fail: Nenhum usuario logado!");
			return false;
		} else
			return true;
	}
	//Realizacao do preenchimento inicial do sistema (inicializacao do sistema)
	static void iniciarSistema(Sistema sys){
		sys.addUser("fulano", "123");
		sys.addUser("ciclano", "456");
		sys.addUser("beltrano", "789");
		sys.usuarios.get("fulano").addNote(new Nota ("dogs","comprei oito cachorros"));
		sys.usuarios.get("fulano").addNote(new Nota ("cats","vendi dois gatos"));
		sys.usuarios.get("ciclano").addNote(new Nota ("friends","tenho muitos amigos"));
		sys.usuarios.get("ciclano").addNote(new Nota ("chuva","choveu muito esses dias"));
		sys.usuarios.get("beltrano").addNote(new Nota ("namoro","arrumei uma namorada"));
		sys.usuarios.get("beltrano").addNote(new Nota ("mentira","a nota anterior eh falsa"));
	}
	//principal
	public static void main(String[] args) {
		Sistema system = new Sistema();
		scan = new Scanner(System.in);
		String line;
		//fazer sistema comecar com 3 usuarios e 2 notas cadastradas
		iniciarSistema(system);
		
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
					
					case "login":
						if(system.usuarios.get(comandos[1]).getPassword().equals(comandos[2])) {
							system.setCurrentUser(system.usuarios.get(comandos[1]));
							print("done");
						}
						else
							print("fail: Senha incorreta!");
						break;
						
					case "logout":
						if (alguemLogado(system)) {
							system.setCurrentUser(null);
							print("done");
						}
						break;
						
					case "addNote":
						if(!alguemLogado(system))
							break;
						String txt = "";
						for (int i = 2; i < comandos.length; i++) 
							txt+=comandos[i] + " ";
						system.usuarios.get(system.getCurrentUser().getUsuario()).addNote(new Nota(comandos[1], txt.substring(0, txt.length()-1)));
						print("done");
						break;
						
					case "rmNote":
						if(!alguemLogado(system))
							break;
						system.usuarios.get(system.getCurrentUser().getUsuario()).rmNote(comandos[1]);
						print("done");
						break;
					
					case "showNotes":
						if(!alguemLogado(system))
							break;
						print(system.usuarios.get(system.getCurrentUser().getUsuario()).showNotes());
						break;
						
					case "changePass":
						if(!alguemLogado(system))
							break;
						if(comandos[1].equals(system.getCurrentUser().getPassword())) {
							system.getCurrentUser().setPassword(comandos[2]);
							system.usuarios.remove(system.getCurrentUser().getUsuario());
							system.usuarios.add(system.getCurrentUser().getUsuario(), system.getCurrentUser());
							print("done");
						} else
							print("fail: oldPass errado!");
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
