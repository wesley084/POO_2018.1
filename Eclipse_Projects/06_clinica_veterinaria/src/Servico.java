class Servico {
	private String nomeServ;
	private float valorServ;
	
	public Servico(String _nomeServ, float _valorServ) {
		this.nomeServ = _nomeServ;
		this.valorServ = _valorServ;
	}
	
	@Override
	public String toString() {
		return "[" + nomeServ + " " + valorServ + "]";
	}
	
	public String getNomeServ() {
		return nomeServ;
	}
	public void setNomeServ(String nomeServ) {
		this.nomeServ = nomeServ;
	}
	public float getValorServ() {
		return valorServ;
	}
	public void setValorServ(float valorServ) {
		this.valorServ = valorServ;
	}
}
