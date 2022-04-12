package Classes;

public class EscalonadorCurtoPrazo {
	FilasDeProcesso filasProcesso;

	public EscalonadorCurtoPrazo(FilasDeProcesso filasProcesso) {
		this.filasProcesso = filasProcesso;
	}

	
	public Processo obterPrimeiroProcessoDaListaPronto() {

		return filasProcesso.filaProcessoPronto.get(0);
	}
	
	public void moverProcessoDaFilaProntoParaExecutando(Processo processo) {
		filasProcesso.executando = processo;
		filasProcesso.filaProcessoPronto.remove(processo);
	}
	
	public void moverProcessoDeExecutandoParaFilaTerminado() {

		filasProcesso.filaProcessoTerminado.add(filasProcesso.executando);
		filasProcesso.executando = null;
	}
	
	

}
