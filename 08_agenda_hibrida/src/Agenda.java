public class Agenda {
	Repositorio<Entry> entries;
	Repositorio<Entry> favoritos;
	
	public Agenda() {
		this.entries = new Repositorio<Entry>("entry");
		this.favoritos = new Repositorio<Entry>("favorito");
	}
	
	boolean addCont(String nome, String [] nums) {
		try {
			this.entries.add(nome, new Contato(nome));
		}catch(Exception e) {
			//nada
		}
		if (nums == null)
			return true;
		Contato cont = (Contato) this.entries.get(nome);
		cont.update(nums);
		return true;
	}
	
	boolean addNote(String ident, String txt) {
		try {
			this.entries.add(ident, new Nota(ident, txt));
		} catch (Exception e) {
			Nota note = (Nota) this.entries.get(ident);
			note.setTxt(note.getTxt() + " " + txt);
		}
		return true;
	}
	
	boolean rmEntry(String ident) {
		this.entries.remove(ident);
		try {
			this.favoritos.remove(ident);
		} catch (Exception e) {
			// faz_nada
		}
		return true;
	}
	
	boolean rmFone(String cont, String ident) {
		Contato contact = (Contato) this.entries.get(cont);
		contact.rmFone(ident);
		return true;
	}
	
	boolean fav (String ident) {
		this.favoritos.add(ident, this.entries.get(ident));
		this.favoritos.get(ident).setFavorited(true);
		this.entries.get(ident).setFavorited(true);
		return true;
	}
	
	boolean desfav(String ident) {
		this.favoritos.remove(ident);
		this.entries.get(ident).setFavorited(false);
		return true;
	}
	
	String lacont() {
		String saida = "";
		for (Entry ent : this.entries.getAll()) 
			if(ent instanceof Contato) 
				saida += ent.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	String lanote() {
		String saida = "";
		for (Entry ent : this.entries.getAll()) 
			if(ent instanceof Nota) 
				saida += ent.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	String lafav() {
		String saida = "";
		for (Entry ent : this.favoritos.getAll()) 
			saida += ent.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
	
	String la() {
		String saida = "";
		for (Entry ent : this.entries.getAll()) 
			saida += ent.toString() + "\n";
		return saida.substring(0, saida.length()-1);
	}
}
