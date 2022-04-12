package Classes;

public class Principal {

	public static void main(String[] args) {

		FilasDeProcesso filasProcesso = new FilasDeProcesso();
		GerenteDeProcessos gerenteProcessos = new GerenteDeProcessos(filasProcesso);
		CPU cpu = new CPU(gerenteProcessos);

		int contador = 3;
		while (contador > 0) {

			gerenteProcessos.escalonadorLongoPrazo.moverProcessosDaFilaDeNovoParaFilaPronto();

			Processo processo = gerenteProcessos.escalonadorCurtoPrazo.obterPrimeiroProcessoDaListaPronto();
			cpu.executarProcesso(processo);
			gerenteProcessos.escalonadorCurtoPrazo.moverProcessoDeExecutandoParaFilaTerminado();

			contador--;
		}

		System.out.println("QUANTIDADE DE PROCESSOS TERMINADOS:" + filasProcesso.filaProcessoTerminado.size() + "\n");
		for (Processo p : filasProcesso.filaProcessoTerminado) {
			p.exibirDadosProcesso();
		}

		System.out.println("QUANTIDADE DE PROCESSOS PRONTOS RESTANTES:" + filasProcesso.filaProcessoPronto.size() + "\n");
		for (Processo p : filasProcesso.filaProcessoPronto) {
			p.exibirDadosProcesso();
			System.out.println("TEMPO NA LISTA PRONTO: " + p.calcularTempoNaListaPronto(System.nanoTime()) + "\n");
		}
		
		filasProcesso.adicionarProcessosNaFilaDeNovos();
		gerenteProcessos.escalonadorLongoPrazo.moverProcessosDaFilaDeNovoParaFilaPronto();
		gerenteProcessos.verificarSeTemProcessoPostergado();

		System.out.println("QUANTIDADE DE PROCESSOS PRONTOS APÓS CHEGAR +2: " + filasProcesso.filaProcessoPronto.size() + "\n");
		for (Processo p : filasProcesso.filaProcessoPronto) {
			p.exibirDadosProcesso();
			System.out.println("TEMPO NA LISTA PRONTO: " + p.calcularTempoNaListaPronto(System.nanoTime()) + "\n");
		}
	}
	
	public void exibirProcessosTerminados() {
		
	}

}
