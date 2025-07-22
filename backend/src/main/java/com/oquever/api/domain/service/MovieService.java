package com.oquever.api.domain.service;

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

    @Override
    public Optional<OmdbMovieDTO> findMovieByTitle(String title) {
        geminiClient.generateContent(title);

        return omdbClient.findByTitle(title);
    }
}