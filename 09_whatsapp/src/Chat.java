abstract interface Chat {
	abstract boolean enviarZap(Zap _zap);
	abstract boolean addMembro(User _vitima);
	abstract String getChatId();
	abstract String getUltimosZaps(int num);
	abstract int getNumDeZaps();
}