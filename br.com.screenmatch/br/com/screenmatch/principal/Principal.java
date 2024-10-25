package br.com.screenmatch.principal;

import java.util.ArrayList;

import br.com.screenmatch.calculos.CalculadoraDeTempo;
import br.com.screenmatch.calculos.FiltroRecomendacao;
import br.com.screenmatch.modelos.Episodio;
import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;

public class Principal {


	public static void main(String[] args) {
		Filme meuFilme = new Filme("O poderoso pauzão", 1969);
		meuFilme.setDuracaoEmMinutos(157);
		meuFilme.exibeFichaTecnica();
		meuFilme.avalia(10);
		meuFilme.avalia(5);
		meuFilme.avalia(7);
		System.out.println("Total de avaliações: " + meuFilme.getTotalAvaliacoes());
		System.out.println("Soma das avaliações: " + meuFilme.getSomaDasAvaliacoes());
		System.out.println("Media: " + meuFilme.pegaMedia());
		
		
		Filme outroFilme = new Filme("O rato de botas", 1968);
		outroFilme.setAnoLancamento(1968);
		outroFilme.setDuracaoEmMinutos(181);
		
		Serie lost = new Serie("Lost" , 2014);
		lost.exibeFichaTecnica();
		lost.setTemporadas(10);
		lost.setEpisodiosPorTemporada(15);
		lost.setMinutosPorEpisodio(50);
		System.out.println("duração para maratonar: "+ lost.getDuracaoMinutos());
		
		CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
		calculadora.inclui(meuFilme);
		calculadora.inclui(outroFilme);
		calculadora.inclui(lost);
		System.out.println(calculadora.getTempoTotal());
		
		FiltroRecomendacao filtro = new FiltroRecomendacao();
		filtro.filtra (meuFilme);
		
		Episodio episodio = new Episodio();
		episodio.setNumero(1);
		episodio.setSerie(lost);
		episodio.setTotalVisualizacoes(300);
		filtro.filtra(episodio);
		
		var filmeDoPaulo = new Filme("Dogville", 2003);
		filmeDoPaulo.setDuracaoEmMinutos(200);
		filmeDoPaulo.setAnoLancamento(2003);
		filmeDoPaulo.avalia(10);
		
		ArrayList<Filme> listaDeFilmes = new ArrayList<>();
		listaDeFilmes.add(meuFilme);
		listaDeFilmes.add(outroFilme);
		listaDeFilmes.add(filmeDoPaulo);
		System.out.println("Tamanha da lista: " + listaDeFilmes.size());
		System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
		System.out.println(listaDeFilmes.get(1).toString());

	}

}

