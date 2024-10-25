package br.com.screenmatch.modelos;

import br.com.screenmatch.exception.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {
	private String nome;
	private int anoLancamento;
	private boolean incluidoNoPlano;
	private double somaDasAvaliacoes;
	private int totalAvaliacoes;
	private int duracaoMinutos;

	public Titulo(String nome, int anoLancamento) {
		this.nome = nome;
		this.anoLancamento = anoLancamento;
	}

	public Titulo(TituloOmdb meuTituloOmbdb) {
		this.nome = meuTituloOmbdb.title();
		if(meuTituloOmbdb.year().length() > 4 ){
			throw new ErroDeConversaoDeAnoException("Nao consegui converter o ano pois tem mais de 4 caracteres");
		}
		this.anoLancamento = Integer.valueOf(meuTituloOmbdb.year());
		this.duracaoMinutos = Integer.valueOf(meuTituloOmbdb.runtime().substring(0,3));
	}

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

	@Override
	public int compareTo(Titulo outroTitulo) {
		return this.getNome().compareTo(outroTitulo.getNome());
	}

	@Override
	public String toString() {
		return "nome = " + nome  +
				", anoLancamento = " + anoLancamento +
				", duração em minutos = " + duracaoMinutos;
	}
}
