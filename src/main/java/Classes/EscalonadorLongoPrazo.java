package Classes;

public class EscalonadorLongoPrazo {
	FilasDeProcesso filasProcesso;

	public EscalonadorLongoPrazo(FilasDeProcesso filasProcesso) {
		this.filasProcesso = filasProcesso;
	}

	public void moverProcessosDaFilaDeNovoParaFilaPronto() {

		while (filasProcesso.filaProcessoNovo.size() > 0) {

			Processo processo = filasProcesso.filaProcessoNovo.get(0);
			processo.setInicioNaListaPronto(System.nanoTime());
			processo.setEstado(EstadoDoProcesso.PRONTO);
			
			filasProcesso.filaProcessoPronto.add(processo);
			filasProcesso.filaProcessoNovo.remove(processo);
		}
		
		OrdenadorDeLista.ordenarPorMaiorPrioridadeEMenorTamanho(filasProcesso.filaProcessoPronto);
	}

}
