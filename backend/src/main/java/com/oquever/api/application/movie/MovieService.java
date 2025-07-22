package com.oquever.api.application.movie;

import com.oquever.api.domain.port.MoviePort;

import java.util.Optional;
import com.oquever.api.infrastructure.client.OmdbClient;
import com.oquever.api.infrastructure.client.dto.OmdbMovieDTO;
import com.oquever.api.infrastructure.client.GeminiClient;

import org.springframework.stereotype.Service;

@Service
public class MovieService implements MoviePort {

    private final OmdbClient omdbClient;
    private final GeminiClient geminiClient;

    public MovieService(OmdbClient omdbClient, GeminiClient geminiClient) {
        this.omdbClient = omdbClient;
        this.geminiClient = geminiClient;
    }

    // TODO:
    // mudar o parametro para um array de types de filme
    // adicionar um parametro opcional para a pessoa informar o que ela tem ideia de
    // assistir
    // criar camada de repository para salvar nosql
    // Criar pesquisa para buscar informações filtradas

    @Override
    public Optional<OmdbMovieDTO> findMovieByTitle(String title) {
        geminiClient.generateContent(title);

        // mandar os filmes para o cache
        // garantir a estrutura do retorno para a camada da controller
        // mandar para o nosql

        return omdbClient.findByTitle(title);
    }
}