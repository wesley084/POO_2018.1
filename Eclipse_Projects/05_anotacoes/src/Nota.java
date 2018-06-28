public class Nota {
	private String titulo;
	private String texto;
	
	public Nota(String tit, String tex){
		this.titulo = tit;
		this.texto = tex;
	}
	
	public String toString() {
		return "["+this.titulo+" : "+this.texto+"]";
	}
	
	//gets and sets
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}