package Testes;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Classes.CPU;
import Classes.EscalonadorLongoPrazo;
import Classes.FilasDeProcesso;
import Classes.GerenteDeProcessos;
import Classes.OrdenadorDeLista;
import Classes.Processo;

public class Testes {
	FilasDeProcesso filasProcesso;
	GerenteDeProcessos gerenteProcesso;
	CPU cpu;
	
	
	/*
	 * - PROCESSOS SÃO CRIADOS COM PRIORIDADE DE 0-6;
	 * - 0 É A MAIOR PRIORIDADE;
	 */
	@Test
	public void testeGerarProcessosNovos() {

		FilasDeProcesso filasProcesso = new FilasDeProcesso();

		System.out.println("Quantidade de processos gerados: " + filasProcesso.filaProcessoNovo.size() + "\n");
		for (Processo p : filasProcesso.filaProcessoNovo) {
			p.exibirDadosProcesso();
		}
	}

	// PROCESSOS SÃO GERADOS E ORGANIZADOS NA FILA DE NOVO PELA PRIORIDADE, DEPOIS
	// POR TAMANHO;
	@Test
	public void testeOrdenarPorMaiorPrioridadeEMenorTamanho() {

		List<Processo> filaNovo = new ArrayList<Processo>();

		for (int i = 0; i < 10; i++) {
			filaNovo.add(new Processo());
		}

		OrdenadorDeLista.ordenarPorMaiorPrioridadeEMenorTamanho(filaNovo);

		System.out.println("Quantidade de processos gerados: " + filaNovo.size() + "\n");
		for (Processo p : filaNovo) {
			p.exibirDadosProcesso();
		}

	}

	// O ESCALONADOR DE LONGO PRAZO MOVE OS PROCESSOS DA FILA DE NOVO PARA FILA DE
	// PRONTO
	@Test
	public void testeMoverDaFilaDeNovoParaFilaDePronto() {

		FilasDeProcesso filasProcesso = new FilasDeProcesso();
		EscalonadorLongoPrazo escalonadorLongoPrazo = new EscalonadorLongoPrazo(filasProcesso);

		System.out.println("TAMANHO DA FILA NOVO ANTES DE MOVER: " + filasProcesso.filaProcessoNovo.size());
		System.out.println("TAMANHO DA FILA PRONTO ANTES DE MOVER: " + filasProcesso.filaProcessoPronto.size());

		escalonadorLongoPrazo.moverProcessosDaFilaDeNovoParaFilaPronto();

		System.out.println("TAMANHO DA FILA NOVO DEPOIS DE MOVER: " + filasProcesso.filaProcessoNovo.size());
		System.out.println("TAMANHO DA FILA PRONTO DEPOIS DE MOVER: " + filasProcesso.filaProcessoPronto.size() + "\n");

		for (Processo p : filasProcesso.filaProcessoPronto) {
			p.exibirDadosProcesso();
		}
	}

	@Test
	public void testarExecucaoProcesso() {

		filasProcesso = new FilasDeProcesso();
		gerenteProcesso = new GerenteDeProcessos(filasProcesso);
		cpu = new CPU(gerenteProcesso);

		executarProcessos(5);

		System.out.println("QUANTIDADE DE PROCESSOS TERMINADOS:" + filasProcesso.filaProcessoTerminado.size() + "\n");
		for (Processo p : filasProcesso.filaProcessoTerminado) {
			p.exibirDadosProcesso();
		}

		System.out.println("QUANTIDADE DE PROCESSOS RESTANTES:" + filasProcesso.filaProcessoPronto.size() + "\n");
		for (Processo p : filasProcesso.filaProcessoPronto) {
			p.exibirDadosProcesso();
			System.out.println("TEMPO NA LISTA PRONTO: " + p.calcularTempoNaListaPronto(System.nanoTime()) + "\n");
		}
		
		filasProcesso.adicionarProcessosNaFilaDeNovos();
		gerenteProcesso.escalonadorLongoPrazo.moverProcessosDaFilaDeNovoParaFilaPronto();
		gerenteProcesso.verificarSeTemProcessoPostergado();
		
		System.out.println("APÓS A CHEGADA DE NOVOS PROCESSOS E AJUSTAR A PRIORIDADE: " + filasProcesso.filaProcessoPronto.size() + "\n");
		for (Processo p : filasProcesso.filaProcessoPronto) {
			p.exibirDadosProcesso();
		}
		
		executarProcessos(2);
		
	}
	
	public void executarProcessos(int contador) {
		
		while (contador > 0) {
			gerenteProcesso.escalonadorLongoPrazo.moverProcessosDaFilaDeNovoParaFilaPronto();

			Processo processo = gerenteProcesso.escalonadorCurtoPrazo.obterPrimeiroProcessoDaListaPronto();
			
			cpu.executarProcesso(processo);

			gerenteProcesso.escalonadorCurtoPrazo.moverProcessoDeExecutandoParaFilaTerminado();

			contador--;
		}
	}
	

}
