public class Venda {
	private int idVen;
	private String idCli;
	private String idAni;
	private String idSer;

	public Venda(int _idVen, String _idCli, String _idAni, String _idSer) {
		this.idVen = _idVen;
		this.idCli = _idCli;
		this.idAni = _idAni;
		this.idSer = _idSer;
	}
	
	@Override
	public String toString() {
		return "[" + idVen + " " + idCli + " "+ idAni +" "+ idSer + "]";
	}
	
	public String getIdCli() {
		return idCli;
	}

	public String getIdAni() {
		return idAni;
	}

	public String getIdServ() {
		return idSer;
	}

	public int getIdVen() {
		return idVen;
	}
}
