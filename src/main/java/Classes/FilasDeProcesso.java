package Classes;

import java.util.ArrayList;
import java.util.List;

public class FilasDeProcesso {
	public List<Processo> filaProcessoNovo;
	public List<Processo> filaProcessoPronto;
	public List<Processo> filaProcessoTerminado;
	public Processo executando;

	public FilasDeProcesso() {
		filaProcessoNovo = new ArrayList<Processo>();
		filaProcessoPronto = new ArrayList<Processo>();
		filaProcessoTerminado = new ArrayList<Processo>();

		criarFilaDeProcessoNovos();
	}

	public void criarFilaDeProcessoNovos() {

		for (int i = 0; i < 5; i++) {
			filaProcessoNovo.add(new Processo());
		}

		OrdenadorDeLista.ordenarPorMaiorPrioridadeEMenorTamanho(filaProcessoNovo);
	}

	public void adicionarProcessosNaFilaDeNovos() {

		filaProcessoNovo.add(new Processo(0));
		filaProcessoNovo.add(new Processo(1));

		OrdenadorDeLista.ordenarPorMaiorPrioridadeEMenorTamanho(filaProcessoNovo);
	}

}
