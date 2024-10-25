package br.com.screenmatch.arquivoUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFileWriter {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void escreverJson(String caminhoArquivo, List<?> objetos) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write(gson.toJson(objetos));
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}