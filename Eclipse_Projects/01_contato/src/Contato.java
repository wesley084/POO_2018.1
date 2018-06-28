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
				return("fail: fone " + _identifi + " ja existe");
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
		return("fail: fone " + _identifi + " nao existe");
	}
	
	String update(String cont, String[] contatos) {
		if(!cont.equals(this.nome))
			throw new RuntimeException("Contato nao existe!");
		for (int i = 2; i < contatos.length; i++) {
			String [] tupla = contatos[i].split(":");
			for (Numero num : this.numeros)
				if(num.nIdentificador.equals(tupla[0]))
					break;
			this.numeros.add(new Numero(tupla[0], tupla[1]));
		}
		return "done";
	}
	
}

class Interface{
	public static void main(String[] args) {
		Contato contact = new Contato(" ");
		
		while(true){
			String line = Poo.input("Digite um comando: ");
			String[] ui = line.split(" ");
			try {
				switch (ui[0]) {
				case "help":{
					Poo.print("init $nome :: cria o contato\n"
							+ "show :: mostra o contato\n"
							+ "addFone $identificador $numero :: adiciona um numero\n"
							+ "rmFone $identificador :: remove o numero correspondente\n"
							+ "exit :: finaliza o programa\n"
							+ "update :: atualiza contatos \n");
					break;
				}
				case "show":{
					if(contact.nome.equals(" "))
						Poo.print("fail: contato nao iniciado\n");
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
					contact.nome = ui[1];
					contact.numeros.clear();
					Poo.print("done");
					break;
				}		
				case "addFone":{
					Poo.print(contact.addFone(ui[1], ui[2]));
					break;
				}
				case "rmFone":{
					Poo.print(contact.rmFone(ui[1]));
					break;
				}
				case "update":{
					Poo.print(contact.update(ui[1], ui));
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
