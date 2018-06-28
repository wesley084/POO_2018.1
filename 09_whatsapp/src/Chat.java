abstract interface Chat {
	abstract boolean enviarZap(Zap _zap);
	abstract boolean addMembro(User _vitima);
	abstract boolean leave(String _user);
	abstract String getChatId();
	abstract String getUltimosZaps(int num);
	abstract String getMembrosName();
	abstract int getNumDeZaps();
}
