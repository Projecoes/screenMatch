package br.com.screenmatch.modelos;

public class Titulo {
	private String nome;
	private int anoLancamento;
	private boolean incluidoNoPlano;
	private double somaDasAvaliacoes;
	private int totalAvaliacoes;
	private int duracaoMinutos;
	
	public int getTotalAvaliacoes() {
		return totalAvaliacoes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoDeLancamento) {
		this.anoLancamento = anoDeLancamento;
	}

	public int getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public void setDuracaoEmMinutos(int duracaoEmMinutos) {
		this.duracaoMinutos = duracaoEmMinutos;
	}

	public double getSomaDasAvaliacoes() {
		return somaDasAvaliacoes;
	}
	
	public void exibeFichaTecnica() {
		System.out.println("Nome do Filme: " + nome);
		System.out.println("Ano de lançamento: " + anoLancamento);
	}

	public void avalia(double nota) {
		somaDasAvaliacoes += nota;
		totalAvaliacoes ++;
	}
	
	public double pegaMedia() {
		return somaDasAvaliacoes / totalAvaliacoes;
	}

	public boolean isIncluidoNoPlano() {
		return incluidoNoPlano;
	}

	public void setIncluidoNoPlano(boolean incluidoNoPlano) {
		this.incluidoNoPlano = incluidoNoPlano;
	}

}
