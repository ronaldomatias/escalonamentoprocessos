package Classes;

public class CPU {
	GerenteDeProcessos gerenteProcessos;

	public CPU (GerenteDeProcessos gerenteProcessos) {
		this.gerenteProcessos = gerenteProcessos;
	}

	
	public void executarProcesso(Processo processo) {
		
		processo.setEstado(EstadoDoProcesso.EXECUTANDO);
		gerenteProcessos.escalonadorCurtoPrazo.moverProcessoDaFilaProntoParaExecutando(processo);
		
		//EXECU��O DA OPERA��O DO PROCESSO E MARCA��O DO TEMPO DE EXECU��O (TURNAROUND)
		long inicioTurnAround = System.nanoTime();
		for (int i = 0; i < processo.getTamanho(); i++) {
			int operacao = i * processo.getTamanho();
		}
		long fimTurnAround = System.nanoTime();

		//ATUALIZAR SITUA��O DO PROCESSO: ATRIBUIR TURNAROUND E ATUALIZAR O ESTADO
		processo.setInformacoesDeSaida(fimTurnAround - inicioTurnAround, EstadoDoProcesso.TERMINADO);
		
	}
	
	
	
	
}
