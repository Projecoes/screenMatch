package br.com.screenmatch.service;

import br.com.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.screenmatch.modelos.Titulo;
import br.com.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FilmeApiService {
    private final String chaveApi = "";
    private final Gson gson;

    public FilmeApiService() {
        // Inicializa o objeto Gson com configurações personalizadas:
        // - UPPER_CAMEL_CASE para formatar os nomes dos campos conforme a convenção do OMDB
        // - PrettyPrinting para formatar o JSON de forma legível quando impresso
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
    }

    public Titulo buscarTituloPorNome(String nomeFilme) throws
            IOException, InterruptedException, ErroDeConversaoDeAnoException {
        // Monta a URL de requisição com o nome do filme e a chave da API, substituindo espaços por "+"
        String endereco = "https://www.omdbapi.com/?t=" + nomeFilme.replace(" ", "+") + "&apikey=" + chaveApi;

        // Cria um cliente HTTP para enviar a requisição
        HttpClient client = HttpClient.newHttpClient();

        // Configura a requisição HTTP para o endereço da API com o metodo get
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

        // Envia a requisição e captura a resposta no formato String
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Converte a resposta JSON para um objeto TituloOmdb
        TituloOmdb tituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

        // Constrói e retorna um objeto Titulo a partir do TituloOmdb
        return new Titulo(tituloOmdb);
    }
}


