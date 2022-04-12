package Classes;

import java.util.Random;

public class Processo implements Comparable<Processo> {
	private int identificador;
	private int prioridade;
	private int tamanho;
	private long turnAround;
	private long inicioNaListaPronto;
	private EstadoDoProcesso estado;

	public Processo() {
		this.identificador = hashCode();
		this.prioridade = new Random().nextInt(6);
		this.estado = EstadoDoProcesso.NOVO;
		this.tamanho = new Random().nextInt(100000);
	}

	public Processo(int prioridade) {
		this.identificador = hashCode();
		this.prioridade = prioridade;
		this.estado = EstadoDoProcesso.NOVO;
		this.tamanho = new Random().nextInt(100000);
	}

	public long calcularTempoNaListaPronto(long tempoAtual) {
		
		return (tempoAtual - inicioNaListaPronto);
	}
	
	
	public void setInformacoesDeSaida(long turnAround, EstadoDoProcesso estado) {
		this.estado = estado;
		this.turnAround = turnAround;
	}

	
	
	public void exibirDadosProcesso() {
		System.out.println("ID: " + this.getIdentificador());
		System.out.println("PRIORIDADE: " + this.getPrioridade());
		System.out.println("TAMANHO: " + this.getTamanho());
		System.out.println("TURNAROUND: " + this.getTurnAround());
		System.out.println("ESTADO: " + this.getEstado());
		System.out.println();
	}
	
	
	
	@Override
	public int compareTo(Processo outro) {
		int resultado = this.getPrioridade() - outro.getPrioridade();
		if (resultado == 0) {
			resultado = this.getTamanho() - outro.getTamanho();
		}

		return resultado;
	}
	
	
	public long getInicioNaListaPronto() {
		return inicioNaListaPronto;
	}

	public void setInicioNaListaPronto(long inicioNaListaPronto) {
		this.inicioNaListaPronto = inicioNaListaPronto;
	}

	public long getTurnAround() {
		return turnAround;
	}

	public void setTurnAround(long turnAround) {
		this.turnAround = turnAround;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public EstadoDoProcesso getEstado() {
		return estado;
	}

	public void setEstado(EstadoDoProcesso estado) {
		this.estado = estado;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}
