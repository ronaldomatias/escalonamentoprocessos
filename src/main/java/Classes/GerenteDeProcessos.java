package Classes;


public class GerenteDeProcessos {
	public EscalonadorCurtoPrazo escalonadorCurtoPrazo;
	public EscalonadorLongoPrazo escalonadorLongoPrazo;
	public FilasDeProcesso filasProcesso;
	
	public GerenteDeProcessos(FilasDeProcesso filasProcesso) {
		this.filasProcesso = filasProcesso;
		
		escalonadorCurtoPrazo = new EscalonadorCurtoPrazo(filasProcesso);
		escalonadorLongoPrazo = new EscalonadorLongoPrazo(filasProcesso);
	}
	

	public void verificarSeTemProcessoPostergado() {
		
		for(Processo processo : filasProcesso.filaProcessoPronto) {
			if (processo.calcularTempoNaListaPronto(System.nanoTime()) > 10000000) {
				processo.setPrioridade(processo.getPrioridade()-1);
				processo.setInicioNaListaPronto(System.nanoTime());
			}
		}
		
		OrdenadorDeLista.ordenarPorMaiorPrioridadeEMenorTamanho(filasProcesso.filaProcessoPronto);
	}


	
	
}
