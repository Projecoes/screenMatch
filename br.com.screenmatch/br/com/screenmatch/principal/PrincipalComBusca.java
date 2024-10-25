package br.com.screenmatch.principal;

import br.com.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.screenmatch.modelos.Titulo;
import br.com.screenmatch.service.FilmeApiService;
import br.com.screenmatch.arquivoUtil.JsonFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        FilmeApiService filmeApiService = new FilmeApiService();

        while (true) {
            System.out.println("Digite o nome do filme para busca: ");
            String busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                // Tenta buscar o título do filme com base no nome digitado pelo usuário
                Titulo titulo = filmeApiService.buscarTituloPorNome(busca);

                // Exibe o título convertido no console, indicando que a busca foi bem-sucedida
                System.out.println("Título convertido: " + titulo);

                // Adiciona o título à lista de títulos coletados
                titulos.add(titulo);

            } catch (IllegalArgumentException | ErroDeConversaoDeAnoException e) {
                // Captura e trata exceções que possam ocorrer durante a busca ou conversão do título
                System.out.println("Erro ao buscar ou converter o título: " + e.getMessage());
                // IllegalArgumentException pode ocorrer se o endereço da API for inválido
                // ErroDeConversaoDeAnoException pode ocorrer caso haja falha na conversão do ano do título
            }
            System.out.println(titulos);
            JsonFileWriter.escreverJson("filmes.json", titulos);
            System.out.println("Finalizou corretamente");
        }
    }
}
