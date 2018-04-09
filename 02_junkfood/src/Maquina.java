import java.util.ArrayList;

public class Maquina {
	
}

class Interface{
	public static void main(String[] args) {
		
		while(true){
			String line = Poo.input("Digite um comando: ");
			ArrayList<String> ui = Poo.split(line, " ");
			try {
				switch (ui.get(0)) {
				case "help":{
					Poo.print("init $nome :: cria o contato\n"
							+ "show :: mostra o contato\n"
							+ "addFone $identificador $numero :: adiciona um numero\n"
							+ "rmFone $identificador :: remove o numero correspondente\n"
							+ "exit :: finaliza o programa\n");
					break;
				}
				case "show":{
					
					break;
				}
				case "init":{
					
					break;
				}		
				case "set":{
					
					break;
				}
				case "limpar":{
					
					break;
				}
				case "dinheiro":{
					
					break;
				}
				case "saldo":{
					
					break;
				}
				case "troco":{
					
					break;
				}
				case "comprar":{
					
					break;
				}
				case "exit":{
					Poo.print("Programa finalizado!");
					System.exit(0);
				}
				//FIM DOS CASOS DE TESTE
				default:{
					Poo.print("fail: comando ivalido!");
				}
				}
				
			}
			catch(Exception e){
				Poo.print(e.getMessage());
			}
		}
		
	}
}
