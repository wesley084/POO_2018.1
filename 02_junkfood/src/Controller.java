import java.util.Scanner;

public class Controller {
	static Maquina maquina = null;
	private static Scanner scan;
	
	static void print(String str) {
		System.out.println(str);
	}
	
	static int toInt(String num) {
		return Integer.parseInt(num);
	}
	
	static float toFloat(String num) {
		return Float.parseFloat(num);
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
				
				case "help":{
					break;
				}
				case "iniciar":{
					maquina = new Maquina(Integer.parseInt(comandos[1]), toInt(comandos[2]));
					maquina.iniciar();
					print("done");
					break;
				}	
				case "show":{
					if(maquina == null)
						throw new RuntimeException("Fail: Maquina nao iniciada!");
					print(maquina.toString());
					break;
				}	
				case "set":{
					if(comandos.length != 5)
						throw new RuntimeException("Fail: Revise o comando dado!");
					maquina.altEspiral(toInt(comandos[1]), comandos[2], toInt(comandos[3]), toFloat(comandos[4]));
					print("done");
					break;
				}
				case "limpar":{
					maquina.altEspiral(toInt(comandos[1]), "", 0, 0);
					print("done");
					break;
				}
				case "dinheiro":{
					maquina.inserirDin(toFloat(comandos[1]));
					print("done");
					break;
				}
				case "saldo":{
					print("Saldo: RS "+maquina.getSaldoCliente());
					break;
				}
				case "troco":{
					print(maquina.pedirTroco());
					break;
				}
				case "comprar":{
					print(maquina.comprar(toInt(comandos[1])));
					break;
				}
				case "exit":{
					Controller.print("Programa finalizado!");
					System.exit(0);
				}
				//FIM DOS CASOS DE TESTE
				default:{
					Controller.print("Fail: Comando ivalido!");
				}
				}
				
			}
			catch(Exception e){
				Controller.print(e.getMessage());
			}
		}
		
	}

}