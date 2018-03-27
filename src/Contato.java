import java.util.ArrayList;

class Numero{	
	String nIdentificador;
	String nNumero;
	
	public Numero(String identifi, String num) {
		nIdentificador = identifi;
		nNumero = num;
	}

}

public class Contato {
	
	String nome = " ";
	ArrayList<Numero> numeros;
	
	
	public Contato(String name) {
		this.numeros = new ArrayList<Numero>();
		this.nome = name;
	}
	
	String addFone(String _identifi, String _num) {
		if(nome.equals(" "))
			return "fail: contato nao iniciado\n";
		for(int i = 0; i < this.numeros.size(); i++) {
			if(_identifi.equals(this.numeros.get(i).nIdentificador)) {
				return("fail: fone " + _identifi + " ja existe\n");
			}
		}
		this.numeros.add(new Numero(_identifi, _num));
		return "done";
	}

	String rmFone(String _identifi) {
		if(nome.equals(" "))
			return "fail: contato nao iniciado\n";
		for(int i = 0; i < this.numeros.size(); i++)
			if(_identifi.equals(this.numeros.get(i).nIdentificador)) {
				this.numeros.remove(i);
				return "done";
			}
		return("fail: fone " + _identifi + " nao existe\n");
	}
}

class Interface{
	public static void main(String[] args) {
		Contato contact = new Contato(" ");
		
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
					if(contact.nome.equals(" "))
						Poo.print("fail: contato não iniciado\n");
					else {
						System.out.print(contact.nome + " ");
						for(Numero n : contact.numeros) {
							System.out.print("["+n.nIdentificador+":"+n.nNumero+"]");
						}
						Poo.print("");
					}
					break;
				}
				case "init":{
					contact.nome = ui.get(1);
					contact.numeros.clear();
					Poo.print("done");
					break;
				}		
				case "addFone":{
					Poo.print(contact.addFone(ui.get(1), ui.get(2)));
					break;
				}
				case "rmFone":{
					Poo.print(contact.rmFone(ui.get(1)));
					break;
				}
				case "exit":{
					Poo.print("Programa finalizado!");
					System.exit(0);
				}
				//FIM DOS CASOS DE TESTE
				}
				
			}
			catch(Exception e){
				Poo.print(e.getMessage());
			}
		}
		
	}
}
