package br.com.screenmatch.calculos;

public class FiltroRecomendacao {
	
	public void filtra(Classificavel classificavel) {
		if(classificavel.getClassificacao() >= 4) {
			System.out.println("Está nos preferidos da TROPA");
		}else if(classificavel.getClassificacao() >= 2){
			System.out.println("Bem classificado");
		}else {
			System.out.println("Adicione na lista para nao assistir depois");
		}
	}

}
