public class Nota implements Entry{
	String identify = "";
	String txt = "";
	boolean favorited;
	
	public Nota(String ident, String texto) {
		this.identify = ident;
		this.favorited = false;
		this.txt = texto;
	}
	
	@Override
	public String toString() {
		String saida = "";
		if(isFavorited())
			saida += "@ N " + this.identify + " (" + this.txt + ")";
		else
			saida += "+ N " + this.identify + " (" + this.txt + ")";
		return saida;
	}
	
	@Override
	public String getId() {
		return identify;
	}
	@Override
	public void setId(String id) {
		this.identify = id;	
	}
	@Override
	public boolean isFavorited() {
		return this.favorited;
	}
	@Override
	public void setFavorited(boolean value) {
		this.favorited = value;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
}
